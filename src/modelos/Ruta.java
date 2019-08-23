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
public class Ruta {
    
    private LinkedList<Entrega> rutas;
    private boolean enable; 

    public Ruta(List<Entrega> rutas) {
        this.rutas = (LinkedList<Entrega>) rutas;
        this.enable = false;
        
    }
    
     public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Entrega> getRutas() {
        return rutas;
    }

    public void setRutas(List<Entrega> rutas) {
        this.rutas = (LinkedList<Entrega>) rutas;
    }
    
}
