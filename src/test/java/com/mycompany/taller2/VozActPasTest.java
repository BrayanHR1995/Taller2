/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller2;

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
public class VozActPasTest {
    
    public VozActPasTest() {
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
     * Test of Detectar method, of class VozActPas.
     */
    @Test
    public void testDetectar() throws Exception {
        System.out.println("Detectar");
        String sentence = "Hola";
        VozActPas instance = new VozActPas();
        String expResult = "Pasiva\n";
        String result = instance.Detectar(sentence);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
