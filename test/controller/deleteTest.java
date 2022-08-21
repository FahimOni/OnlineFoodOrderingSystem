/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Hasnayen
 */
public class deleteTest {
    
    public deleteTest() {
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
     * Test of del method, of class delete.
     */
    @Test
    public void testDel() {
        System.out.println("del");
        String id = "3";
        delete instance = new delete();
        boolean expResult = true;
        boolean result = instance.del(id);
        assertEquals(expResult, result);
    }
    
}
