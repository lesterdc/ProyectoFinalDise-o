/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;
import modelos.Localidad;
import modelos.Usuario;
import modelos.singleton.ConexionBaseDatos;


/**
 *
 * @author jaime
 */
public class ControladorGerente {
    private static final String NAME="Nombre";
    private static final String ERROR="Error a conectar en la base de datos";
    private static final Logger LOGGER=Logger.getLogger(ControladorGerente.class.getName());
    private ControladorGerente(){
        
    }
    
    protected static Connection cn = ConexionBaseDatos.getInstance();
    
    public static DefaultTableModel mostrarUsuarios(){
              String[] cols= new String[]{"Usuario",NAME,"Cargo","Localidad"};
              DefaultTableModel modelo= new DefaultTableModel(null, cols);
              
              //añadir a la base en la tabla usuario el cargo de empleado y poner locaclidad en empleado
              String sql="Select u.username,p.nombre,u.cargo,l.descripcion from usuario u  inner join empleado e on e.empleadoid = u.empleadoid"
                      + " inner join localidad l on e.localid =l.localid inner join persona p on e.personaid = p.personaid";
              try(PreparedStatement us = cn.prepareStatement(sql)){  
              try(ResultSet res = us.executeQuery()){
                  Object[] datos= new Object[4];
                  while(res.next())
                  {
                      for(int i=0; i<4; i++){
                          
                          datos[i]=res.getObject(i+1);
                      }
                      modelo.addRow(datos);
                  }
              }
              }
              catch(SQLException e){
                  LOGGER.log(Level.WARNING,ERROR);
              }
              return modelo;
    }

    
            
    public static void buscarUsuario(String texto) {
        String[] cols = new String[]{"Usuario", NAME,"Cedula","Telefono","Direccion", "Sueldo","Cargo"};
        //Usuario(String nombre, String cedula, String telefono, String direccion, double sueldo) 
        DefaultTableModel modelo = new DefaultTableModel(null, cols);
        
        
            String filtro = "" + texto + "_%";
            String sql = "Select u.username,p.nombre,p.cedula,p.telefono,p.direccion,e.sueldo, u.cargo from usuario u  inner join empleado e on e.empleadoid = u.empleadoid"
                    + " inner join localidad l on e.localid =l.localid inner join persona p on e.personaid = p.personaid where u.username like" + '"' + filtro + '"';
            try(PreparedStatement us = cn.prepareStatement(sql)){
            
            try(ResultSet res = us.executeQuery()){
                Object[] datos = new Object[7];
                while (res.next()) {
                    
                    datos[0] = res.getString("username");
                    datos[1] = res.getString("nombre");
                    datos[2] = res.getString("cedula");
                    datos[3] = res.getString("telefono");
                    datos[4] = res.getString("direccion");
                    datos[5] = res.getString("sueldo");
                    datos[6] = res.getString("cargo");
                    
                    modelo.addRow(datos);
                }  
             
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,ERROR);
        }

    }

     
      public static DefaultTableModel mostrarLocal() {
        
            String[] cols = new String[]{"Numero local", NAME, "Tipo"};
            DefaultTableModel modelo = new DefaultTableModel(null, cols);
            String sql = "Select l.localid, l.nombrelocal ,l.descripcion from localidad l";
            try(PreparedStatement us = cn.prepareStatement(sql)){
            try(ResultSet res = us.executeQuery()){
            Object[] datos = new Object[3];
            while (res.next()) {
                for (int i = 0; i < 3; i++) {
                    
                    datos[i] = res.getObject(i + 1);
                }
                modelo.addRow(datos);
                }
            }
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     
    public static String eliminarLocal(Localidad local) {
        String result ="";
        String sql = "UPDATE localidad SET enabled=? WHERE  nombrelocal =?";
        
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                local.setEnabled(0);
                pst.setString(1, Integer.toString(local.getEnabled()));
                pst.setString(2, (local.getNombreLocal()));
                pst.executeUpdate();
                if (local.getEnabled()== 1) {
                    result = "Local Habilitado con exito, nombre: " + local.getNombreLocal();
                } else if (local.getEnabled()== 0) {
                    result = "Local Eliminado con exito, nombre: " + local.getNombreLocal();
                }
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorGerente.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        return result;
    }
    
    
    public static String actualizarLocal(Localidad local) {
        String result = "Local actualizado, nombre: ";
        String sql = "UPDATE localidad SET nombrelocal=?, descripcion=? WHERE  localid =?";
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                pst.setString(1, local.getNombreLocal());
                pst.setString(2, local.getTipoLocalidad());
                 pst.setString(3, Integer.toString(local.getIdLocal()));
                pst.executeUpdate();
                result =result+local.getNombreLocal();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorGerente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return result;
    }
    
    
    
    public static String ingresarLocal(Localidad local) {
        
        String result = null;
        String sql = "insert into localidad(nombrelocal,descripcion) values(?,?)"; 
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                
                
                pst.setString(1, local.getNombreLocal());
                pst.setString(2, local.getTipoLocalidad());
                pst.executeUpdate();
                cn.close();
                result = "Localidad registrada!" ;}
                catch(NullPointerException e){
                    result="Datos Vacios";
                    LOGGER.log(Level.WARNING,ERROR);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorGerente.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return result;
    }
    
    public static void buscarLocal(String local) {
        String[] cols= new String[]{"Numero local",NAME,"Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(null, cols);
            String filtro = "" + local + "_%";
            String sql = "Select l.localid, l.nombrelocal,l.descripcion where l.nombrelocal like"  + '"' + filtro + '"';
            try(PreparedStatement us = cn.prepareStatement(sql)){
            try(ResultSet res = us.executeQuery()){
            Object[] datos = new Object[3];
            while (res.next()) {
                datos[0] = res.getString("localid");
                datos[1] = res.getString("nombrelocal"); 

                modelo.addRow(datos);
                }
            }
          
                   

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,ERROR);
        }

    }
        public static String asignarAdmi(Usuario u) {
        String result = "";
        String sql = "UPDATE usuario SET isadmin=? WHERE  username =?";
            if (cn != null) {
                try(PreparedStatement pst = cn.prepareStatement(sql)){
                pst.setString(1, Integer.toString(u.isIsAdmin()));
                pst.setString(2, u.getUsuario());
                pst.executeUpdate();
                if (u.isIsAdmin()== 1) {
                    result = "Administrador asignado, nombre: " + u.getUsuario();
                } else {
                    result = "Admin Denegado : " + u.getUsuario();
                }
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorGerente.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            return result;
        }
}
