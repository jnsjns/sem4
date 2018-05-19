/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.controller;

/**
 * The exception when the controller catches an unchecked exception in the integration layer.
 * @author Jonas
 */
public class OperationFailedException extends Exception {

    public OperationFailedException(String msg, Exception cause) {
        super(msg, cause);
    }
    
}
