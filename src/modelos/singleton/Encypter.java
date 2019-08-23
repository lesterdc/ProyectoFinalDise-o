/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.singleton;




/**
 *
 * @author Lesther Carranza
 */
public class Encypter {
    private static final String USER="root";
    private static final String PASS="secret";
    private Encypter(){
        
    } 
    public static String getEncrypterUser(){
        return USER;
    }
    public static String getEncrypterPass(){
        return PASS;
    }
}
