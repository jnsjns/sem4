
package se.kth.hogk.sem4.model;

import java.time.LocalDateTime;
import java.util.List;
import se.kth.hogk.sem4.integration.SaleDTO;

/**
 * Creates the receipt that is to be printed be the (@link Printer)
 * @author Jonas
 */
public class Receipt {
    private final LocalDateTime saleTime;
    private final List<OrderLine> orderLines;
    private final int payment;
    private final int totalPrice;
    private final double totalPriceAfterTax;
    private final double change;
    
    public Receipt(SaleDTO saleDTO, Payment payment, double change){
        this.saleTime = saleDTO.getSaleTime();
        this.orderLines = saleDTO.getOrderLines();
        this.totalPrice = saleDTO.getTotalPrice();
        this.totalPriceAfterTax = saleDTO.getTotalPriceAfterTax();
        this.payment = payment.getPayment();
        this.change = change;
    }
    
    /**
     * Creates the format of the receipt and stores it in a string.
     * @return the string created.
     */
    public String createPrintableReceipt(){
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n\nThanks for shopping at POS \n\n")
                .append(saleTime + "\n");

        for (OrderLine orderLine : orderLines) {
            stringBuilder.append(orderLine.getName())
                    .append((orderLine.getName().length() <= 8) ? "\t\t"
                                : (orderLine.getName().length() <= 12) ? "\t" : "")
                    .append(orderLine.getPrice())
                    .append("\n");      
        }
        stringBuilder.append("-----------------------\n")
                .append("Total price: " + totalPrice + "\n")
                .append("Total price after tax: " + totalPriceAfterTax + "\n")
                .append("Total paid: " + payment + "\n")
                .append("Change: " + change + "\n");
        return stringBuilder.toString();
    }
}
