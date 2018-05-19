
package se.kth.hogk.sem4.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all the items available for purchase.
 * @author Jonas
 */
public class ItemRegistry {
    private final List<ItemDTO> items = new ArrayList<>();
    /**
     * Creates all the items when an item registry is created.
     */
    ItemRegistry(){
        addItems();
    }
    
    /**
     * Searches for an item ID in the Item Registry and returns the item if it is
     * found.
     * @param itemId The id of the item searched for
     * @return the item if it is found or null if not found.
     * @throws NoMatchingItemException when the item is not found in registry.
     */
    public ItemDTO getItem(int itemId) throws NoMatchingItemException{
        for(ItemDTO item : items){
            if (item.getId() == itemId){
                return item;
            }
        }
       throw new NoMatchingItemException(itemId);
    }
    
    /**
     * The hard coded items that is added to the item registry upon creation.
     */
    private void addItems(){
        items.add(new ItemDTO(1, "banana", 20));
        items.add(new ItemDTO(2, "tomato", 59));
        items.add(new ItemDTO(3, "orange juice", 15));
        items.add(new ItemDTO(4, "ice cream", 28));
    }
    
    
}
