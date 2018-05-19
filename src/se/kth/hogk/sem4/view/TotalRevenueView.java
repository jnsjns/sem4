/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.view;

import se.kth.hogk.sem4.model.SaleObserver;

/**
 * The display that shows how much revenue has been acquired 
 * since the start of the program
 * @author Jonas
 */
public class TotalRevenueView implements SaleObserver{
    
    private double totalRevenue;

    /**
     * What is updated and printed when notified by an observer
     * @param amountPaid the amount paid that is to be added to the revenue
     * display.
     */
    @Override
    public void update(double amountPaid){
        this.totalRevenue += amountPaid;
        System.out.println("\n#####Revenue Display#####");
        System.out.println("Total revenue is now: " + totalRevenue);
        System.out.println("#########################\n");
    }
}
