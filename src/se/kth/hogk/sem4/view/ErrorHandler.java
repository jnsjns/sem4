/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.view;

/**
 * Prints an error to the display and also logs details in the error log
 * @author Jonas
 */
public class ErrorHandler {
    public void printError(String msg){
        System.out.println(msg);
    }
    /**
     * Logs the error in error log, for now as a console print.
     * @param cause the exception cause, that also might include other causes which are 
     * iterated through.
     */
    public void logError(Exception cause){
        System.out.println("DEV ERROR LOG: " + cause);
        while(cause.getCause() != null){
            System.out.println("DEV ERROR LOG: " + cause.getCause());
            cause = (Exception) cause.getCause();
        }
    }
}
