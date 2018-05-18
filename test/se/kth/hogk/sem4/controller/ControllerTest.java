/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.hogk.sem4.integration.ExternalSystemHandler;
import se.kth.hogk.sem4.integration.NoMatchingItemException;

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
    public void testAddItem() throws NoMatchingItemException, OperationFailedException {
        int itemId = 1;
        Controller instance = new Controller(new ExternalSystemHandler());
        String expResult = 
                            "Name: banana  Price: 20\n" +
                            
                            "Running Total: 20\n";
        instance.startSale();
        String result = instance.addItem(itemId);
        assertEquals(expResult, result);    
    }
    
    @Test(expected = NoMatchingItemException.class)
    public void testWrongAddItem() throws OperationFailedException, NoMatchingItemException {
        int itemId = 8008;
        Controller instance = new Controller(new ExternalSystemHandler());
        instance.startSale();

        String result = instance.addItem(itemId);
    }

    /**
     * Test of completeSale method, of class Controller.
     */
    @Test
    public void testCompleteSale() throws NoMatchingItemException, OperationFailedException {
        Controller instance = new Controller(new ExternalSystemHandler());
        instance.startSale();
        instance.addItem(3);
        double expResult = 17.25;
        double result = instance.completeSale();
        assertEquals(expResult, result, 0.0);
    }

}
