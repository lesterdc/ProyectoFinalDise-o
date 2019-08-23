/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.login;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.singleton.ConexionBaseDatos;
import vistas.gerente.NewVGerente;
import vistas.jefebodega.VJefeBodega;
import vistas.local.VistaLocal;

/**
 *
 * @author Melanie Banchon
 */

public class ControladorLogin {
    
    protected static Connection cn = ConexionBaseDatos.getInstance();
    static PreparedStatement sentenciapreparada;
    private static final Logger LOGGER=Logger.getLogger(ControladorLogin.class.getName());
    static ResultSet resultado;
    static String sql;
    static VJefeBodega vistajefe = new VJefeBodega();
    static NewVGerente vistaGerente = new NewVGerente();
    static VistaLocal vistaLocales = new VistaLocal();
    private static boolean isAdmin;

    public boolean isIsAdmin() {
        return isAdmin;
    }
    
    public static void buscarUsuarioLogin(String usuario, String contrasena) {
        
        String cargo="";
        LOGGER.log(Level.FINE,"usuario");
        try{
        sql="SELECT u.username,u.passwrd from, u.cargo, u.isadmin FROM usuario u WHERE u.username = '"+ usuario +"'and u.passwrd= '"+ contrasena +"' ";
        sentenciapreparada = cn.prepareStatement(sql);
        resultado = sentenciapreparada.executeQuery();
        if(resultado.next()){
            LOGGER.log(Level.FINE,"Entra");
            cargo = resultado.getString("cargo");
            isAdmin=resultado.getBoolean("isadmin");
            
            if(cargo.equalsIgnoreCase("jefe bodega")){
                
                vistajefe.setVisible(true);
            }
            else if(cargo.equalsIgnoreCase("gerente")){
                 VistaLocal l=new VistaLocal();
                 l.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Implementacion en construccion");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no existente");
        }
        }catch(HeadlessException | SQLException e){
            LOGGER.log(Level.SEVERE,"No se conecto a la base");
        }
        
    }
    
    
    
} 
