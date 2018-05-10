package se.kth.hogk.sem4.view;

import se.kth.hogk.sem4.controller.Controller;


/**
 * This is a placeholder for the view. It contains only hardcoded calls to the controller.
 */
public class View {
    private Controller contr;
    
    /**
     * Constructs a new view, using the specified controller.
     * 
     * @param contr This controller will be used for all system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Simulates a sample execution containing calls to all system operations.
     */
    public void sampleExecution() {
        System.out.println("Starting sample execution.");
        contr.startSale();
        System.out.println("Scanning first item");
        String saleInfo = contr.addItem(2);
        System.out.println(saleInfo);
        System.out.println("Scanning second item");
        saleInfo = contr.addItem(3);
        System.out.println(saleInfo);
        System.out.println("Scanning third item");
        saleInfo = contr.addItem(1);
        System.out.println(saleInfo);
        System.out.println("Completing sale");
        double totalPrice = contr.completeSale();
        System.out.println("Total price to pay with tax: " + totalPrice);
        contr.enterPaidAmount(200);
    }
}
