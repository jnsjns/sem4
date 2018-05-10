
package se.kth.hogk.sem4.integration;

/**
 * The object of items that are stored in the (@link ItemRegistry).
 * @author Jonas
 */
public final class ItemDTO {
    private final int id;
    private final String name;
    private final int price;
    
    public ItemDTO(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public String getName(){
        return this.name;
    }
    
   
    
}
