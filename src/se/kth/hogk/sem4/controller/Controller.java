package se.kth.hogk.sem4.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.hogk.sem4.integration.ExternalSystemHandler;
import se.kth.hogk.sem4.integration.ItemDTO;
import se.kth.hogk.sem4.integration.ItemRegistry;
import se.kth.hogk.sem4.integration.ItemRegistryException;
import se.kth.hogk.sem4.integration.NoMatchingItemException;
import se.kth.hogk.sem4.integration.Printer;
import se.kth.hogk.sem4.model.Payment;
import se.kth.hogk.sem4.model.Sale;
import se.kth.hogk.sem4.model.SaleObserver;

/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private final ItemRegistry itemRegistry;
    private final ExternalSystemHandler exHandler;
    private final Printer printer;
    private List<SaleObserver> saleObserverList = new ArrayList<>();
    
    public Controller(ExternalSystemHandler exHandler){
        this.exHandler = new ExternalSystemHandler();
        this.printer = exHandler.getPrinter();
        this.itemRegistry = exHandler.getItemRegistry();
    }   
    
    public void addSaleObserver(SaleObserver saleObserver){
        saleObserverList.add(saleObserver);
    }
    
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all information regarding
     * the sale that is now started.
     */
    public void startSale() {
        sale = new Sale();
        sale.addSaleObserver(saleObserverList);
        
    }
    /**
     * Fetches an item with corresponding itemID from the Item Registry and adds
     * it as an order line in the sale.
     * 
     * @param itemId The ID of the scanned item that is added to the sale.
     * @return saleInfo contains a string of the sale that the view can display.
     * @throws NoMatchingItemException when no item is found in database.
     * @throws OperationFailedException when you can't add an item to sale.
     */
    public String addItem(int itemId) throws NoMatchingItemException, OperationFailedException{
        try {
            ItemDTO item = exHandler.getItem(itemId);
            String saleInfo = sale.addItem(item);
            return saleInfo;
        } catch (ItemRegistryException itemRegEx) {
            throw new OperationFailedException("Could not add item to sale", itemRegEx);
        }
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
