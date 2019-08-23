/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author jaime
 */
public class Repartidor extends Empleado{
    
    protected int id; 
    protected Ruta rutaDeEntrega;
    protected int entregasRealizadas; 
    protected boolean isDisponible ; 
    protected boolean enable;
   

    public Repartidor(String nombre, String cedula, String telefono, String direccion, double sueldo) {
        super(nombre, cedula, telefono, direccion, sueldo);
        this.rutaDeEntrega = null;
        this.entregasRealizadas=0;
        this.isDisponible=true;
        this.enable=true;
    }

    public Ruta getRutaDeEntrega() {
        return rutaDeEntrega;
    }

    public void setRutaDeEntrega(Ruta rutaDeEntrega) {
        this.rutaDeEntrega = rutaDeEntrega;
    }
    
    
    public int getEntregasRealizadas() {
        return entregasRealizadas;
    }

    public void setEntregasRealizadas(int entregasRealizadas) {
        this.entregasRealizadas = entregasRealizadas;
    }

    public boolean isIsDisponible() {
        return isDisponible;
    }

    public void setIsDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }
    
    
     public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
