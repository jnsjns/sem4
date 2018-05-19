/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.integration;

/**
 * The unchecked exception when the program can't connect to the database.
 * @author Jonas
 */
public class ItemRegistryException extends Exception {
    
    public ItemRegistryException(String msg){
        super(msg);
    }
    
}
