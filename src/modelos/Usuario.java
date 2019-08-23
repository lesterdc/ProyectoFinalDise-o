/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 */
public class Usuario extends Empleado{
    private static final Logger LOGGER=Logger.getLogger(Usuario.class.getName());
    protected String user; 
    protected String password;
    protected int isAdmin;
    protected boolean enable;
    
    public Usuario(String nombre, String cedula, String telefono, String direccion, double sueldo) {
        super(nombre, cedula, telefono, direccion, sueldo);
        this.user="none";
        this.password="";
        this.isAdmin=0;
        
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    
    public void login(Usuario user){
        LOGGER.log(Level.INFO,"HACER LOGIN");
        LOGGER.log(Level.INFO,"aqui debemos hacer la conexion a la base ,");
        
        
    }
    
    public void buscarArticulo(){
        LOGGER.log(Level.INFO,"Implementar... ");
        LOGGER.log(Level.INFO,"Los controladores lo tienen implementado ");
       
    }

    public int isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
    
    
    
      
    
     
  
    
    
}
