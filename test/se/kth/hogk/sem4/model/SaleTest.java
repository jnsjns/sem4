/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.model;

import se.kth.hogk.sem4.model.Sale;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.hogk.sem4.integration.ItemDTO;

/**
 *
 * @author Jonas
 */
public class SaleTest {
    
    public SaleTest() {
    }
       
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItem() {
        Sale instance = new Sale();
        String expResult = "Sale Information \n" +
                            "Name: banana  Price: 20\n" +
                            "\n" +
                            "Running Total: 20\n";
        String result = instance.addItem(new ItemDTO(1, "banana", 20));
        assertEquals(expResult, result);
    }


    /**
     * Test of calculateTax method, of class Sale.
     */
    @Test
    public void testCompleteSale() {

        Sale instance = new Sale();
        instance.addItem(new ItemDTO(1, "banana", 20));
        double expResult = 23;
        double result = instance.completeSale();
        assertEquals(expResult, result, 0.0);
    }

}
