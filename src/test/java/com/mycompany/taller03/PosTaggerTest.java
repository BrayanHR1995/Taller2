/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller03;

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
public class PosTaggerTest {
    
    public PosTaggerTest() {
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
     * Test of decomposePhrase method, of class PosTagger.
     */

    
       /**
     * Test of getSentence method, of class PosTagger.
     */

    @Test
    public void testAnalyzePhrase() {
        System.out.println("analyzePhrase");
        String p_sentence = "He is a man";
        PosTagger instance= new PosTagger();
        instance.decomposePhrase();
        instance.comparar(p_sentence);
        
        String expResult = "Voz activa";
        String result = instance.analyzePhrase();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
