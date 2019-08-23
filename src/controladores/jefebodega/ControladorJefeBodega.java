/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.jefebodega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelos.Entrega;
import modelos.PeticionAbastecimiento;
import modelos.Repartidor;
import modelos.singleton.ConexionBaseDatos;

/**
 *
 * @author jaime
 */
public class ControladorJefeBodega {

    
    protected ConexionBaseDatos conexion;
    private static final String DIREC="Direccion";
    private static final String ERROR="Error a conectar en la base de datos";
    private static final Logger LOGGER=Logger.getLogger(ControladorJefeBodega.class.getName());
    private static Queue<Repartidor> cola = new LinkedList<>() ;
    protected static Connection cn = ConexionBaseDatos.getInstance();
    
    
    private static void procesomostrar(String sql , DefaultTableModel modelo , int n){
        try(PreparedStatement us=cn.prepareStatement(sql)){
            try(ResultSet res=us.executeQuery()){
            Object[] datos= new Object[n];
            while(res.next())
            {
                for(int i=0; i<n; i++){
                    
                    datos[i]=res.getObject(i+1);
                }
                modelo.addRow(datos);
            }
            }
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,ERROR);
        }
        
    }
    
    
    public static DefaultTableModel mostrarEntregaDomicilio(){
      String[] cols= new String[]{DIREC,"Nro Venta","Nro Cliente"};
       DefaultTableModel modelo= new DefaultTableModel(null, cols);
            String sql="Select e.direccion,ed.venta,v.cliente from entregadomicilio ed inner join entrega e on ed.edid = e.entregaid"
                    + " inner join venta v on ed.venta = v.ventaid";
            procesomostrar(sql,modelo,3);
        return modelo;
    }
    
    
     public static DefaultTableModel mostrarEntregaLocal() {
        String[] cols = new String[]{DIREC, "Nro Pedido"};
        DefaultTableModel modelo = new DefaultTableModel(null, cols);
        
            String sql = "Select e.direccion,ped.pedidoid from entrega e inner join entregalocal el  on e.entregaid = el.elid"
                    + " inner join pedidoabastecimiento ped on el.pedido = ped.pedidoid";
            procesomostrar(sql,modelo,2);
     
        return modelo;
    }
     private static void procesoBuscar(String sql,DefaultTableModel modelo, int n){
         try(PreparedStatement us = cn.prepareStatement(sql)){
            try(ResultSet res = us.executeQuery()){
            Object[] datos = new Object[n];
            while (res.next()) {
                datos[0] = res.getString("direccion");
                datos[1] = res.getString("venta");
                datos[2] = res.getString("cliente");
                modelo.addRow(datos);
            }

            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,ERROR);
        }
         
     }
    public static void buscarEntegaDom(String texto) {
        String[] cols = new String[]{DIREC, "Nro Venta", "Nro Cliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, cols);

            String filtro = "" + texto + "_%";
            String sql = "Select e.direccion,ed.venta,v.cliente from entregadomicilio ed inner join entrega e on ed.edid = e.entregaid"
                    + " inner join venta v on ed.venta = v.ventaid where e.direccion like" + '"' + filtro + '"';
            procesoBuscar(sql,modelo,3);
    
    }
        
    public static void buscarEntregaLocal(String texto) {
        String[] cols = new String[]{DIREC, "Nro Pedido"};
        DefaultTableModel modelo = new DefaultTableModel(null, cols);
            String filtro = "" + texto + "_%";
            String sql = "Select e.direccion,ped.pedidoid from entrega e inner join entregalocal el  on e.entregaid = el.elid"
                    + " inner join pedidoabastecimiento ped on el.pedido = ped.pedidoid where e.direccion like" + '"' + filtro + '"';
            procesoBuscar(sql, modelo, 2);
    }
        
    public static String ingresosEntregaGerenal(String lugar,PreparedStatement pst){
        try{
                pst.setString(1, String.valueOf(Entrega.getIdEntrega()));
                pst.setString(2, String.valueOf(PeticionAbastecimiento.getIdPeticionAbast()));
                pst.executeUpdate();
                return "Entrega a "+lugar+" registrada!" ;}
                catch(NullPointerException e){
                    LOGGER.log(Level.WARNING,"Datos Vacios");
                } catch (SQLException ex) {
            Logger.getLogger(ControladorJefeBodega.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String ingresarEntregaLocal() {
        String result = null;
        String sql = "insert into entregalocal(entrega, pedido) values(?,?)"; 
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJefeBodega.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
        return result;
    
    }
    
    public static String ingresarEntregaDomicilio() {
        String result = null;
        String sql = "insert into entregadominicilio(entrega, venta) values(?,?)"; 
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJefeBodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return result;
    }
    
    public void cargarRepartidores(){
        String sql= "select r.repartidorid, p.nombre,p.cedula,p.telefono,p.direccion,e.sueldo from repartidor r\n" +
        " inner join empleado e on r.empleadoid=e.empleadoid\n" +
        " inner join persona p on e.personaid = p.personaid where disponible=true;";
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                try(ResultSet rs = pst.executeQuery()){
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1));
                    String nombre= rs.getString(2);
                    String cedula = rs.getString(3);
                    String telefono= rs.getString(4);
                    String direc= rs.getString(5);
                    float sueldo = Float.parseFloat(rs.getString(6));
                    Repartidor rep= new Repartidor(nombre,cedula,telefono,direc,sueldo);
                    rep.setId(id);
                    cola.offer(rep);
                }
                cn.close();
                }
          
            } catch (SQLException ex) {
                 Logger.getLogger(ControladorJefeBodega.class.getName()).log(Level.SEVERE, null, ex);
             }
        } 
    }
    
    public static Queue<Repartidor> getCola(){
        return cola;
    }
    
    public static void setCola(Queue<Repartidor> cola){
        ControladorJefeBodega.cola = cola;
    }
        
}
       
    
    
    

