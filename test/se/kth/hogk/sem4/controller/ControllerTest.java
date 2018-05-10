/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.controller;

import se.kth.hogk.sem4.controller.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.hogk.sem4.integration.ExternalSystemHandler;
import se.kth.hogk.sem4.integration.ItemDTO;
import se.kth.hogk.sem4.model.Sale;

/**
 *
 * @author Jonas
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addItem method, of class Controller.
     */
    @Test
    public void testAddItem() {
        int itemId = 1;
        Controller instance = new Controller(new ExternalSystemHandler());
        String expResult = "Sale Information \n" +
                            "Name: banana  Price: 20\n" +
                            "\n" +
                            "Running Total: 20\n";
        instance.startSale();
        String result = instance.addItem(itemId);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testWrongAddItem() {
        int itemId = 8008;
        Controller instance = new Controller(new ExternalSystemHandler());
        String expResult = "Item not found.";
        instance.startSale();
        String result = instance.addItem(itemId);
        assertEquals(expResult, result);    
    }

    /**
     * Test of completeSale method, of class Controller.
     */
    @Test
    public void testCompleteSale() {
        Controller instance = new Controller(new ExternalSystemHandler());
        instance.startSale();
        instance.addItem(3);
        double expResult = 17.25;
        double result = instance.completeSale();
        assertEquals(expResult, result, 0.0);
    }

}
