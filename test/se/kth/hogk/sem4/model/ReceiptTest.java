/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.model;

import se.kth.hogk.sem4.model.Receipt;
import se.kth.hogk.sem4.model.Payment;
import se.kth.hogk.sem4.model.OrderLine;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.hogk.sem4.integration.ItemDTO;
import se.kth.hogk.sem4.integration.SaleDTO;

/**
 *
 * @author Jonas
 */
public class ReceiptTest {
    
    public ReceiptTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPrintableReceipt method, of class Receipt.
     */
    @Test
    public void testCreatePrintableReceipt() {
        Payment payment = new Payment(100);
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("banana", 20));
        SaleDTO saleDTO = new SaleDTO(LocalDateTime.of(2018, 1, 1, 1, 1), orderLines, 20, 56);
               

        Receipt instance = new Receipt(saleDTO, payment, 56.0);
        String expResult = "\n\nThanks for shopping at POS \n" +
                            "\n" +
                            "2018-01-01T01:01\n" +
                            "banana\t\t20\n" +
                            "-----------------------\n" +
                            "Total price: 20\n" +
                            "Total price after tax: 56.0\n" +
                            "Total paid: 100\n" +
                            "Change: 56.0\n";                  
        String result = instance.createPrintableReceipt();
        assertEquals(expResult, result);
    }
    
}
