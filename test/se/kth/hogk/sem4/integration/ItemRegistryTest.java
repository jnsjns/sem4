/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.integration;

import se.kth.hogk.sem4.integration.ItemRegistry;
import se.kth.hogk.sem4.integration.ItemDTO;
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
public class ItemRegistryTest {
    
    public ItemRegistryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class ItemRegistry.
     */
    @Test
    public void testGetItem() {
        int itemId = 1;
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = new ItemDTO(1, "banana", 20);
        ItemDTO result = instance.getItem(itemId);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPrice(), result.getPrice());
    }
    
    @Test
    public void testNotExistingGetItem() {
        int itemId = 500;
        ItemRegistry instance = new ItemRegistry();
        ItemDTO result = instance.getItem(itemId);
        assertNull(result);
    }

}
