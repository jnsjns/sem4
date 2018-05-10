
package se.kth.hogk.sem4.model;

/**
 * The order lines of items in the sale, containing name and price.
 * @author Jonas
 */
public final class OrderLine {
    private final String name;
    private final int price;
    
    public OrderLine(String name, int price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPrice(){
        return this.price;
    }
}
