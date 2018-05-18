/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas
 */
public class ExternalSystemHandlerTest {
    
    public ExternalSystemHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getItem method, of class ExternalSystemHandler.
     */
    @Test(expected = ItemRegistryException.class)
    public void testFailedConnectionGetItem() throws Exception {
        int itemId = 0;
        ExternalSystemHandler instance = new ExternalSystemHandler();
        ItemDTO result = instance.getItem(itemId);
    }

    
}
