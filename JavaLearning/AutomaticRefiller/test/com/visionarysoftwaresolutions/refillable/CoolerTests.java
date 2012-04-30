package com.visionarysoftwaresolutions.refillable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author nathan
 */
public class CoolerTests {
    @Test
    public void testAddBottlesToCooler(){
        //Given a cooler
        Cooler cooler = new Cooler();
        //When I add bottles to the cooler
        cooler.addBottles(5);
        //Then the bottles should be present
        assertTrue(cooler.getBottles() == 5);
    }
    
    public void testRemoveBottlesFromCooler(){
        //Given a cooler, by necessity containing some bottles
        Cooler cooler = new Cooler();
        cooler.currentBottles = 10;
        //When I remove bottles from the cooler
        cooler.removeBottles(5);
        //Then the bottles should not be present
        assertTrue(cooler.getBottles() == 5);
    }

}
