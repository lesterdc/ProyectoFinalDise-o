/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.strategy;

import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Melanie Banchon
 */
public class Pago {
    
    private Currency monto;
    private MetodoPago metodoPago;
    
    public Pago(MetodoPago metodoPago){
        monto = Currency.getInstance(Locale.US);
        this.metodoPago = metodoPago;
    }

    public void generarPago(){
        this.metodoPago.generarPago();
        
    }

    public Currency getMonto() {
        return monto;
    }

    public void setMonto(Currency monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    
}
