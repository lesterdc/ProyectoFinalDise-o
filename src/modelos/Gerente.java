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
public class Gerente extends Usuario implements IAdministrador {
    private static final Logger LOGGER=Logger.getLogger(Gerente.class.getName());
    private static final String CONS="Implentacion en construccion";
    protected Localidad localidad;
    protected boolean enable;
    
    public Gerente(String nombre, String cedula, String telefono, String direccion, double sueldo) {
        super(nombre, cedula, telefono, direccion, sueldo);
        this.enable=true;
        this.localidad=null;
    }
    
    
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    

    public void consultarUsuario() {
        LOGGER.log(Level.INFO,CONS);
    }

    public void consultarEnvio() {
        LOGGER.log(Level.INFO,CONS);
    }

    public void consultarProducto() {
        LOGGER.log(Level.INFO,CONS);
    }

    public void consultarVenta() {
        LOGGER.log(Level.INFO,CONS);
    }

    @Override
    public void asignarAdministrador(Usuario u) {
        LOGGER.log(Level.INFO,CONS);
    }

    
    
    
    
    
    
}
