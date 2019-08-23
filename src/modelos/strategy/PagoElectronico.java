/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melanie Banchon 
 */
public class PagoElectronico extends MetodoPago{
    private static final Logger LOGGER=Logger.getLogger(PagoElectronico.class.getName());
    private String metodo="";
    
    @Override
    void generarPago() {
        LOGGER.log(Level.INFO, "Se genero el pago electronico por: {0}", metodo);
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
    
}
