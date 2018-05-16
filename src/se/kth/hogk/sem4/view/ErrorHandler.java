/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.view;

/**
 *
 * @author Jonas
 */
public class ErrorHandler {
    public void printError(String msg){
        System.out.println(msg);
    }
    
    public void logError(Exception cause){
        System.out.println("DEV ERROR LOG: " + cause);
    }
}
