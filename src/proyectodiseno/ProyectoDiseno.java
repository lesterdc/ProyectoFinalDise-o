/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiseno;

import modelos.singleton.ConexionBaseDatos;

/**
 *
 * @author jaime
 */
public class ProyectoDiseno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ConexionBaseDatos.getInstance();
       
      
    }
    
}
