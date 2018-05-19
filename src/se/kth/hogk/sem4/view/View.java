package se.kth.hogk.sem4.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import se.kth.hogk.sem4.controller.Controller;
import se.kth.hogk.sem4.controller.OperationFailedException;
import se.kth.hogk.sem4.integration.NoMatchingItemException;


/**
 * This is a placeholder for the view. It contains only hard coded calls to the controller.
 */
public class View {
    private final Controller contr;
    private final ErrorHandler errorHandler = new ErrorHandler();
    private List<Integer> inputList = new ArrayList<>();
    
    /**
     * Constructs a new view, using the specified controller. Also adds
     * an observer to the pool of sale observers.
     * 
     * @param contr This controller will be used for all system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
    }
    
    /**
     * Simulates a sample execution containing calls to all system operations.
     * Item id 0 gives a simulated database connection error.
     */
    public void sampleExecution(){
        Collections.addAll(inputList, 5, 2, 3, 0, 1);
        System.out.println("-->Starting sample execution.");
        contr.startSale();       
        System.out.println("-->Scanning items");        
        for (int i = 0; i < inputList.size(); i++) {
            addItem(inputList.get(i));            
        }       
        System.out.println("-->Completing sale");
        System.out.println("Total price to pay with tax: " + contr.completeSale());
        contr.enterPaidAmount(200);
                
        System.out.println("-->NEW SALE<--");
        contr.startSale();  
        addItem(3);
        System.out.println("Total price to pay with tax: " + contr.completeSale());
        contr.enterPaidAmount(50);
    }
    /**
     * Takes an item id to add to the sale, throws exceptions for simulated errors
     * @param itemId the id of the item to be added to the sale
     */
    private void addItem(int itemId){
        try {
            System.out.println(contr.addItem(itemId));
        } catch (OperationFailedException exception) {
            handleException("Could not add item ", exception);
        } catch (NoMatchingItemException noExcistingItem) {
            handleException("Tried to find non existant item, please try again ", noExcistingItem);
        }
    }
    
    /**
     * Method that sends exception data to the error handler class
     * @param msg message to be printed to the user
     * @param cause exception cause to be sent to the dev-log
     */
    private void handleException(String msg, Exception cause){
        errorHandler.printError(msg);
        errorHandler.logError(cause);
    }
}
