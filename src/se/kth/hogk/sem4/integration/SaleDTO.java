
package se.kth.hogk.sem4.integration;

import java.time.LocalDateTime;
import java.util.List;
import se.kth.hogk.sem4.model.OrderLine;

/**
 * Contains information of sale that receipt needs.
 * @author Jonas
 */
public class SaleDTO {
    private final LocalDateTime saleTime;
    private final List<OrderLine> orderLines;
    private final int totalPrice;
    private final double totalPriceAfterTax;
    
    public SaleDTO(LocalDateTime saleTime, List<OrderLine> orderLines, int totalPrice, double totalPriceAfterTax) {
        this.saleTime = saleTime;
        this.orderLines = orderLines;
        this.totalPrice = totalPrice;
        this.totalPriceAfterTax = totalPriceAfterTax;
    }    

    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalPriceAfterTax() {
        return totalPriceAfterTax;
    }

}
