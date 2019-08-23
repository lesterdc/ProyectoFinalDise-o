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
public class PagoEfectivo extends MetodoPago{
    private static final Logger LOGGER=Logger.getLogger(PagoEfectivo.class.getName());
    private double cantidad=0;
    
    @Override
    void generarPago() {
        LOGGER.log(Level.INFO, "Se genero el pago en efectivo por un total de: {0}", cantidad);
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
