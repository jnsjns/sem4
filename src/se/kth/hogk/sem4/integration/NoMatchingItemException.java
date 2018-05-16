/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.integration;

/**
 *
 * @author Jonas
 */
public class NoMatchingItemException extends Exception {
    private int itemId;
    
    public NoMatchingItemException(int itemId){
        super("Could not find any item in the item registry with item Id: " + itemId);
        this.itemId = itemId;
    
}
}
