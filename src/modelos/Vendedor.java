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
public class Vendedor extends Usuario implements IAdministrador{
    private static final Logger LOGGER=Logger.getLogger(Vendedor.class.getName());
    protected Localidad localidad;
    protected boolean enable;
    
    public Vendedor(String nombre, String cedula, String telefono, String direccion, double sueldo) {
        super(nombre, cedula, telefono, direccion, sueldo);
        this.localidad=null;
        this.enable=true;
    }   

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    
    public boolean agregarCliente(Cliente c){
        return false;
        
    }
    public boolean editarCliente(Cliente c){
        return false;
    }
    public void realizarCotizacion(){
        LOGGER.log(Level.INFO,"Cotizacion");
        
    }
    public void editarCotizacion(){
        LOGGER.log(Level.INFO,"Cotizacion editada");
    }
    public void realizarVenta(){
        LOGGER.log(Level.INFO,"Realizar Venta");
    }
    public void consultarEntregaDomicilio(){
        LOGGER.log(Level.INFO,"Domicilio");
    }
    
    public void emitirDocumento(Documento docu){
        LOGGER.log(Level.INFO,"Documento ");
    }

    @Override
    public void asignarAdministrador(Usuario u) {
        LOGGER.log(Level.INFO,"El Vendedor es administrador");
    }
    
}
