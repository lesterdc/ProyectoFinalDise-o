/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 */
public class JefeBodega extends Usuario implements IAdministrador {
    private static final Logger LOGGER=Logger.getLogger(JefeBodega.class.getName());
    protected Localidad localidad; 
    protected boolean enable;
    
    public JefeBodega(String nombre, String cedula, String telefono, String direccion, double sueldo) {
        super(nombre, cedula, telefono, direccion, sueldo);
        this.localidad=null;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    @Override
    public boolean isEnable() {
        return enable;
    }

    @Override
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    public Ruta crearRutaEntrega(LinkedList<Entrega> e){
        return new Ruta(e);
    }
    
    public static void asignarRepartidor(Repartidor r,Ruta ruta) {
            if (r.isDisponible) {
                r.setRutaDeEntrega(ruta);
           
        }
    }

    @Override
    public void asignarAdministrador(Usuario u) {
        LOGGER.log(Level.INFO,"El jefe de bodega es administrador");
        
    }
    
    
}
