/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.hogk.sem4.integration;

import se.kth.hogk.sem4.integration.Printer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jonas
 */
public class PrinterTest {

    private PrintStream originalSysOut;
    private ByteArrayOutputStream outContent;
    
    public PrinterTest() {
    }
    
    
    @Before
    public void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
    }
    
    @After
    public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    /**
     * Test of printReceipt method, of class Printer.
     */
    @Test
    public void testPrintReceipt() {
        String stringToPrint = "test";
        Printer instance = new Printer();
        instance.printReceipt(stringToPrint);
        String result = outContent.toString();
        String expResult = "test";
        assertTrue(result.contains(expResult));
    }
    
}
