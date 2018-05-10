package se.kth.hogk.sem4.controller;

import se.kth.hogk.sem4.integration.ExternalSystemHandler;
import se.kth.hogk.sem4.integration.ItemDTO;
import se.kth.hogk.sem4.integration.ItemRegistry;
import se.kth.hogk.sem4.integration.Printer;
import se.kth.hogk.sem4.model.Payment;
import se.kth.hogk.sem4.model.Sale;

/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private final ItemRegistry itemRegistry;
    private final ExternalSystemHandler exHandler;
    private final Printer printer;
    
    public Controller(ExternalSystemHandler exHandler){
        this.exHandler = new ExternalSystemHandler();
        this.printer = exHandler.getPrinter();
        this.itemRegistry = exHandler.getItemRegistry();
    }
    
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all information regarding
     * the sale that is now started.
     */
    public void startSale() {
        sale = new Sale();
    }
    /**
     * Fetches an item with corresponding itemID from the Item Registry and adds
     * it as an order line in the sale.
     * 
     * @param itemId The ID of the scanned item that is added to the sale.
     * @return saleInfo contains a string of the sale that the view can display.
     */
    public String addItem(int itemId){
        ItemDTO item = itemRegistry.getItem(itemId);
        if(item == null ) return "Item not found.";
        String saleInfo = sale.addItem(item);
        return saleInfo;
    }
    /**
     * Completes the sale after all items has been added to the sale.
     * @return The total price after tax the customer has to pay as a double.
     */
    public double completeSale(){
        return sale.completeSale();
    }
    
    /**
     * The sale is paid for and enables receipt to be printed. Initiates printer class.
     * The sale is logged in external systems.
     * @param paidAmount The amount paid by the customer.
     */
    public void enterPaidAmount(int paidAmount){
        Payment payment = new Payment(paidAmount);
        printer.printReceipt(sale.pay(payment));
        exHandler.logSale(sale.getSaleInfo());
    }
}
