/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visionarysoftwaresolutions.refillable;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author nathan
 */
public class PoweredUnitTests {
    
    @Test
    public void testPoweredUnit(){
        //Given: A powered unit of no particular association
        PoweredUnit device = new Cooler();
        //When: I want to toggle the power state
        device.togglePower();
        //The Powered Unit should be on
        assertTrue(device.isPowerOn());
        device.togglePower();
        assertFalse(device.isPowerOn());
    }
}