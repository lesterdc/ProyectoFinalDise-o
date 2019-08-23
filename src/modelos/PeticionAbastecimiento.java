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
 * @author Melanie Banchon
 */
public class PeticionAbastecimiento {
 
   
    private static int idPeticionAbast;
    private int cantidad;
    private Localidad local;
    private LinkedList<Producto> listaProductos;
    
    
    public PeticionAbastecimiento(int cantidad, Localidad local,List<Producto> listaProductos){
        this.cantidad = cantidad;
        this.local = local;
        this.listaProductos = (LinkedList<Producto>) listaProductos;
    }
    
    public static int getIdPeticionAbast() {
        return idPeticionAbast;
    }

    public static void setIdPeticionAbast(int idPeticionAbast) {
        PeticionAbastecimiento.idPeticionAbast = idPeticionAbast;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Localidad getLocal() {
        return local;
    }

    public void setLocal(Localidad local) {
        this.local = local;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = (LinkedList<Producto>) listaProductos;
    }
    
    
}
