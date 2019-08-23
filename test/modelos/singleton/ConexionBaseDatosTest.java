/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.singleton;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Melanie Banchon
 */
public class ConexionBaseDatosTest {
    
    /**
     * Test del metodo getInstance, de la clase ConexionBaseDatos para verificar
     * si se genera la conexion a la base de datos.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        
        Connection result = ConexionBaseDatos.getInstance();
        assertNull(result);
        System.out.println("La conexion es: "+result);
        
        
    }
}
