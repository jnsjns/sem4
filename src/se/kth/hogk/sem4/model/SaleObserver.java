/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.model;

/**
 * The interface for the sale observers.
 * @author Jonas
 */
public interface SaleObserver {
    void update(double amountPaid);
}
