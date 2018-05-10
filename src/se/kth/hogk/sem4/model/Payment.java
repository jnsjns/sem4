
package se.kth.hogk.sem4.model;

/**
 * Handles customer part of the sale, what is paid and what is to be returned to
 *  the customer in form of change.
 * @author Jonas
 */
public class Payment {
    private final int paidAmount;
    
    /**
     * Constructor for payment, makes sure paid amount is not negative.
     * @param paidAmount The amount paid by customer.
     */
    public Payment(int paidAmount){
        if(paidAmount < 0){
            throw new IllegalArgumentException("paidAmount can't be negative");
        }
        this.paidAmount = paidAmount;
    }
    
    public int getPayment(){
        return this.paidAmount;
    }
    /**
     * Calculates the change by subtracting the total price from the paid amount.
     * @param totalPrice The total price to pay for the sale. 
     * @param paidAmount The amount paid by the customer.
     * @return the result of the subtraction.
     */
    public double calculateChange(double totalPrice){
        if(totalPrice < 0 && totalPrice<paidAmount){
            throw new IllegalArgumentException("Total price can't be negative or less than paid amount");
        }
        return (paidAmount - totalPrice);
    }
}
