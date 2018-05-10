/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.model;

import se.kth.hogk.sem4.model.Payment;
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
public class PaymentTest {
    
    public PaymentTest() {
    }
      
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateChange method, of class Payment.
     */
    @Test
    public void testCalculateChange() {
        Payment payment = new Payment(100);
        double totalPrice = 25.0;
        double expResult = 75.0;
        double result = payment.calculateChange(totalPrice);
        assertEquals("Subtraction in change calculation failed", expResult, result, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPaymentParameterCalculateChange() {
        Payment payment = new Payment(-100);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePriceCalculateChange() {
        Payment payment = new Payment(100);
        double totalPrice = -25.0;
        payment.calculateChange(totalPrice);
    }
    
}
