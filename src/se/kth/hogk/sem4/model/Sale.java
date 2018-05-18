package se.kth.hogk.sem4.model;

import se.kth.hogk.sem4.integration.ItemDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.hogk.sem4.integration.SaleDTO;

/**
 * Collects all information regarding a particular sale.
 */
public class Sale {
    private final LocalDateTime saleTime;
    private int runningTotal;
    private int itemPrice;
    private double totalPrice;
    private String itemName;
    private String saleInfo;
    private final List<OrderLine> orderLines;
    private List<SaleObserver> saleObservers = new ArrayList<>();
    private static final double TAX_PERCENTAGE = 15;
    
    
    /**
     * Creates a new instance, and records the time it was created. This will be the time recorded
     * on the receipt. A list of order lines is also created.
     */
    public Sale() {
        saleTime = LocalDateTime.now();  
        this.orderLines = new ArrayList<>();
    }
    
    public void addSaleObserver(List<SaleObserver> obs) {
        this.saleObservers.addAll(obs);
    }
        
    /**
     * Saves an item to the sale and updates the <code>runningTotal</code>.
     * @param item The item that is to be added to the sale.
     * @return A string of the current sale information to be displayed by the view
     */
    public String addItem(ItemDTO item){
        itemName = item.getName();
        itemPrice = item.getPrice();
        runningTotal = runningTotal + itemPrice;
        createOrderLine(itemName, itemPrice);
        return saleInfo = buildString();
    }
    
    /**
     * Creates a new order line in the order lines list.
     * @param name The name of the item to be added to the list.
     * @param price The price of the item to be added to the list.
     */
    private void createOrderLine(String name, int price){
        OrderLine orderLine = new OrderLine(name, price);
        orderLines.add(orderLine);
    }
    
    /**
     * Build the string that is sent to view to be displayed. Loops through the
     * list of orders and adds them all to a string.
     * @return a string containing current sale information.
     */  
    private String buildString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(OrderLine orderLine : orderLines){
            stringBuilder.append("Name: ")
                         .append(orderLine.getName())
                         .append("  Price: ")
                         .append(orderLine.getPrice())
                         .append("\n");
        }
        stringBuilder.append("Running Total: ")
                     .append(runningTotal)
                     .append("\n");
        return stringBuilder.toString();         
    }
    
    /**
     * Finalizes the sale. Calculates the tax of the sale.
     * @return A double containing the new price after tax.
     */
    public double completeSale(){    
        totalPrice = calculateTax();
        notifyAllSaleObservers();
        return totalPrice;
    }
    
    /**
     * Multiplies the <code>runningTotal</code> with <code>TAX_PERCENTAGE</code>
     * and returns a new price after tax.
     * @return The result of the multiplication.
     */
    private double calculateTax(){
        return ((double)runningTotal * (1+TAX_PERCENTAGE/100));    
    }
    
    /**
     * Uses a (@link Payment) to calculate change to be given to customer. A (@link Receipt)
     * is created and returned.
     * @param payment the amount paid by the customer.
     * @return A string of the receipt.
     */
    public String pay(Payment payment){
       double change = payment.calculateChange(totalPrice);
       SaleDTO saleDTO = new SaleDTO(saleTime, orderLines, runningTotal, totalPrice);
       Receipt receipt = new Receipt(saleDTO, payment, change);
       return (receipt.createPrintableReceipt());
    }
    
    public void notifyAllSaleObservers(){
        for(SaleObserver saleObserver : saleObservers){
            saleObserver.update(totalPrice);
        }
    }
    
    public LocalDateTime getSaleTime(){
        return this.saleTime;
    }
    public List getOrderLines(){
        return this.orderLines;
    }
    
    public int getTotalPrice(){
        return this.runningTotal;
    }
    
    public double getTotalPriceAfterTax(){
        return this.totalPrice;
    }
    
    public String getSaleInfo(){
        return this.saleInfo;
    }




}
