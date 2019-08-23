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
public class Localidad {

    private int idLocal;
    private String tipoLocalidad;//descripcion
    private String nombreLocal;
    private int enabled;
    private LinkedList<Empleado> listaEmpleados;
    private LinkedList<Producto> listaProductos;

  
    
    public Localidad(String tipoLocalidad, String nombreLocal) {
        this.tipoLocalidad = tipoLocalidad;
        this.nombreLocal = nombreLocal;
        listaEmpleados = new LinkedList();
        listaProductos = new LinkedList();
        this.enabled=1;
    }

     public PeticionAbastecimiento crearPedidoAbastecimiento(int cantidad, Localidad local, List<Producto> lproductos) {
        return new PeticionAbastecimiento(cantidad, local, (LinkedList<Producto>) lproductos);
    }
    
    
     public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getTipoLocalidad() {
        return tipoLocalidad;
    }

    public void setTipoLocalidad(String tipoLocalidad) {
        this.tipoLocalidad = tipoLocalidad;
    }
    
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = (LinkedList<Empleado>) listaEmpleados;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = (LinkedList<Producto>) listaProductos;
    }

}
