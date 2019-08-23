/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.gerente;

import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import static org.junit.Assert.*;
import vistas.gerente.NewVGerente;
import vistas.local.Locales;

/**
 *
 * @author Melanie Banchon
 */
public class ControladorGerenteTest {
    
    
    /**
     * Test del metodo mostrarUsuarios de la clase ControladorGerente
     * que permite verificar que la base esta ejecutada y que devuelve la 
     * tabla de usuarios para mostrarla en la vista del gerente.
     */
    @Test
    public void testMostrarUsuarios() {
        System.out.println("mostrarUsuarios()");
        DefaultTableModel result = ControladorGerente.mostrarUsuarios();
        assertNotNull(result);
        System.out.println("La base de datos retorna la tabla de usuarios");
          
    }


    /**
     * Test del metodo mostrarLocal de la clase ControladorGerente
     * que permite verificar que la base esta ejecutada y que devuelve la 
     * tabla de locales para mostrarla en la vista de locales.
     */
    @Test
    public void testMostrarLocal() {
        System.out.println("mostrarLocal()");
        DefaultTableModel result = ControladorGerente.mostrarLocal();
        assertNotNull(result);
        System.out.println("La base de datos retorna la tabla de locales");
    }

    /**
     * Test del metodo eliminarLocal de la clase ControladorGerente que permite
     * verificar que se elimina de la base de datos un local de forma logica.
     */
    @Test
    public void testEliminarLocal() {
        System.out.println("eliminarLocal()");
        String expResult = "";
        String result = ControladorGerente.eliminarLocal(Locales.getLocalEliminar());
        assertSame(expResult, result);
        System.out.println("Se realiza el elimado logico del local");
    }

    /**
     * Test del metodo eliminarLocal de la clase ControladorGerente que permite
     * verificar que se actualiza en la base de datos con la informacion propocionada por 
     * el usuario en la vista .
     */
    @Test
    public void testActualizarLocal() {
        System.out.println("actualizarLocal()");
        String expResult = null;
        String result = ControladorGerente.actualizarLocal(Locales.getLocalActualizar());
        assertSame(expResult, result);
        System.out.println("Se realiza la actualizacion del local en la base de datos");
        
    }

    /**
     * Test del metodo ingresarLocal de la clase ControladorGerente que permite
     * verificar que se ingresa en la base de datos con la informacion propocionada por 
     * el usuario en la vista .
     */
    @Test
    public void testIngresarLocal() {
        System.out.println("ingresarLocal()");
        String expResult = "";
        String result = ControladorGerente.ingresarLocal(Locales.getLocalIngresar());
        assertNotSame(expResult, result);
        System.out.println("Se realiza el ingreso del local en la base de datos");
        
    }

    /**
     * Test del metodo asignarAdmin de la clase ControladorGerente que permite
     * verificar que se realizo la asignacion al nuevo administrador
     * en la base de datos con la informacion propocionada por 
     * el usuario en la vista .
     */
    @Test
    public void testAsignarAdmi() {
        System.out.println("asignarAdmi()");
        String expResult = "";
        String result = ControladorGerente.asignarAdmi(NewVGerente.getUsuarioAdmin());
        assertSame(expResult, result);
        System.out.println("Se realiza la asignacion de usuario adminitrador"+NewVGerente.getUsuarioAdmin().getNombre());
        
    }
   
    
    
}
