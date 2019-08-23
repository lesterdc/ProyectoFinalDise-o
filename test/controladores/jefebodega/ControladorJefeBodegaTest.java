/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.jefebodega;

import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import static org.junit.Assert.*;
import vistas.jefebodega.VEntregas;

/**
 *
 * @author Melanie Banchon
 */
public class ControladorJefeBodegaTest {
    
    
    /**
     * Test del metodo mostrarEntregaDomicilio de la clase ControladorJefeBodega
     * que permite verificar que la base esta ejecutada y que devuelve la 
     * tabla de Entrega Domicilio para mostrarla en la vista del jefe de bodega.
     */
    @Test
    public void testMostrarEntregaDomicilio() {
        System.out.println("mostrarEntregaDomicilio()");
        DefaultTableModel result = ControladorJefeBodega.mostrarEntregaDomicilio();
        assertNotNull(result);
        System.out.println("La base de datos retorna la tabla de entregas a domicilio");
    }

    /**
     * Test del metodo mostrarEntregaLocal de la clase ControladorJefeBodega
     * que permite verificar que la base esta ejecutada y que devuelve la 
     * tabla de Entrega Local para mostrarla en la vista del jefe de bodega.
     */
    @Test
    public void testMostrarEntregaLocal() {
        System.out.println("mostrarEntregaLocal()");
        DefaultTableModel result = ControladorJefeBodega.mostrarEntregaLocal();
        assertNotNull(result);
        System.out.println("La base de datos retorna la tabla de entregas a local");
    }

    /**
     * Test del metodo ingresarEntregaLocal de la clase ControladorJefeBodega
     * que permite verificar que se realiza el ingreso de una entrega a local
     * a la base de datos.
     */
    @Test
    public void testIngresarEntregaLocal() {
        System.out.println("ingresarEntregaLocal()");
        String expResult="";
        String result = ControladorJefeBodega.ingresarEntregaLocal();
        assertNotNull(expResult, result);
        System.out.println("Se realiza el ingreso de la entrega a local en la base de datos");
    }

   /**
     * Test del metodo ingresarEntregaDomicilio de la clase ControladorJefeBodega
     * que permite verificar que se realiza el ingreso de una entrega a domicilio
     * a la base de datos.
     */
    @Test
    public void testIngresarEntregaDomicilio() {
        System.out.println("ingresarEntregaDomicilio()");
        String expResult="";
        String result = ControladorJefeBodega.ingresarEntregaDomicilio();
        assertNotSame(expResult, result);
        System.out.println("Se realiza el ingreso de la entrega a domicilio en la base de datos");
    }
    
}
