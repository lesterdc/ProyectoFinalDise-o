/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jaime
 */
public class Venta {
    
    private static int idVenta;
    private LinkedList<Producto> productos;
    private float total;
    private boolean isDomicilio; 
    private Cliente cliente;
    private boolean enable; 

    public Venta(List<Producto> productos, float total, boolean isDomicilio, Cliente cliente) {
        this.productos = (LinkedList<Producto>) productos;
        this.total = total;
        this.isDomicilio = isDomicilio;
        this.cliente = cliente;
        this.enable=true;
    }
    
    public static int getIdVenta() {
        return idVenta;
    }

    /**
     *
     * @param idVenta
     */
    public static void setIdVenta(int idVenta) {
        Venta.idVenta = idVenta;
    }
    
     public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = (LinkedList<Producto>) productos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isIsDomicilio() {
        return isDomicilio;
    }

    public void setIsDomicilio(boolean isDomicilio) {
        this.isDomicilio = isDomicilio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean addProductoaVenta(Producto p){
        return (p!=null) ;
    }
    
    public boolean removeProducto (Producto p){
        return (p==null);
        
    }
    public Factura generarFactura(){
        return null;
    }
    
    
    
}
