package se.kth.hogk.sem4.integration;


/**
 * Handles all the calls to external systems and databases.
 * @author Jonas
 */
public class ExternalSystemHandler {
    private final ItemRegistry itemReg = new ItemRegistry();
    private final Printer printer = new Printer();

    public ItemRegistry getItemRegistry(){
        return itemReg;
    }
    
    public Printer getPrinter(){
        return printer;
    }
    /**
     * Fetches a wanted item from the (@link ItemRegistry)
     * @param itemId the Id of the item searched for.
     * @return the item found.
     * @throws se.kth.hogk.sem4.integration.NoMatchingItemException
     * @throws se.kth.hogk.sem4.integration.ItemRegistryException
     */
    public ItemDTO getItem(int itemId) throws NoMatchingItemException, ItemRegistryException{
        if(itemId == 0){
            throw new ItemRegistryException("Could not connect to database");
        }
        ItemDTO item = itemReg.getItem(itemId);
        return item;
    }
    
    /**
     * Will contain calls to external systems when they are implemented. Does
     * nothing for now.
     * @param saleInfo a string containing the current sale information.
     */
    public void logSale(String saleInfo){
        
    }
    
}
