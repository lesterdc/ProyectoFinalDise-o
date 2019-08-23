/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.singleton;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melanie Banchon 
 */
public class ConexionBaseDatos {
    private static final Logger LOGGER=Logger.getLogger(ConexionBaseDatos.class.getName());
    private static Connection conectar = null;
    private String baseconectar="jdbc:mysql://0.0.0.0:8081/proyecto_diseno2";
    private String secureSSL="?autoReconnect=true&useSSL=false";
    
    private ConexionBaseDatos(){
        try {
            conectar = DriverManager.getConnection(baseconectar+secureSSL,Encypter.getEncrypterUser(),Encypter.getEncrypterPass());
            LOGGER.log(Level.INFO,"La conexion a la base de datos ha sido exitosa");
            
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"Error en conexion");
        }
        
    }
    
    public static Connection getInstance(){
        if(conectar==null){
            conectar = ConexionBaseDatos.getConnection();
        }
        return conectar;
    }
   
    public static Connection getConnection() {
        return conectar;
    }

    public void desconectar() {
        try {
            conectar.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
 