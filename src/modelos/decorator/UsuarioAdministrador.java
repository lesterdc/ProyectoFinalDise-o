/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.decorator;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Producto;
import modelos.Usuario;
import modelos.IAdministrador;

/**
 *
 * @author Melanie Banchon
 */
public class UsuarioAdministrador extends AdministradorDecorador{
    private static final Logger LOGGER=Logger.getLogger(UsuarioAdministrador.class.getName());
    public UsuarioAdministrador(IAdministrador gerente){
        super(gerente);
    }
    
    @Override
    public void asignarAdministrador(Usuario u) {
        gerente.asignarAdministrador(u);
    }
   
   
    public void ingresarStocks(Producto p){
        implementacion();
    }
    
    public void actualizarStocks(){
        implementacion();
    }
    
    public void ingresarPreciosVenta(){
        implementacion();
    }
    
    public void implementacion(){
        LOGGER.log(Level.INFO,"En Implementacion");
    }
}
