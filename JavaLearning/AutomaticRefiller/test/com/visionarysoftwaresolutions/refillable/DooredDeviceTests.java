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
public class DooredDeviceTests {
    
    @Test
    public void testDooredDeviceOperateDoor(){
    //Given: A doored device
    DooredDevice device = new Cooler();
    //When: I want to change the door state (open or close) starting from close
    device.operateDoor();
    //Then the door should be open
    assertTrue(device.isDoorOpen());
    //and vice versa
    device.operateDoor();
    assertFalse(device.isDoorOpen());    
            
    }
 
}
