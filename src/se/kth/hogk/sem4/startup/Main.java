package se.kth.hogk.sem4.startup;

import se.kth.hogk.sem4.controller.Controller;
import se.kth.hogk.sem4.integration.ExternalSystemHandler;
import se.kth.hogk.sem4.view.View;

/**
 * Starts the entire application.
 */
public class Main {
    /**
     * @param args The program does not take any command line parameters. 
     */
    public static void main(String[] args) {
        new View(new Controller(new ExternalSystemHandler())).sampleExecution();
    }
}