/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BrayanHR09
 */
public class GuiTest {
    
    public GuiTest() {
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
     * Test of main method, of class Gui.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Gui.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Detectar method, of class Gui.
     */
    @Test
    public void testDetectar() throws Exception {
        System.out.println("Detectar");
        String sentence = "";
        Gui instance = new Gui();
        instance.Detectar(sentence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
