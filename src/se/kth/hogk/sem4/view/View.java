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
    public void sampleExecution(){
        List<Integer> inputList = new ArrayList<>();
        Collections.addAll(inputList, 5, 2, 3, 0, 1);
        System.out.println("-->Starting sample execution.");
        contr.startSale();       
        System.out.println("-->Scanning items");
        
         for (int i = 0; i < inputList.size(); i++) {
            try {
                System.out.println(contr.addItem(inputList.get(i)));
            } catch (OperationFailedException exception) {
                handleException("Could not add item ", exception);
            } catch (NoMatchingItemException noExcistingItem) {
                handleException("Tried to find non existant item, please try again ", noExcistingItem);
            }
        }       
        System.out.println("-->Completing sale");
        double totalPrice = contr.completeSale();
        System.out.println("Total price to pay with tax: " + totalPrice);
        contr.enterPaidAmount(200);
    }
    
    private void handleException(String msg, Exception cause){
        errorHandler.printError(msg);
        errorHandler.logError(cause);
    }
}
