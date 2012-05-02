package com.visionarysoftwaresolutions.refillable;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class DooredDeviceTests {
    
    @Test
    public void testDooredDeviceOperateDoor(){
    //Given: A doored unit
    DooredUnit device = new Cooler();
    //When: I want to change the door state (open or close) starting from close
    device.operateDoor();
    //Then the door should be open
    assertTrue(device.isDoorOpen());
    //and vice versa
    device.operateDoor();
    assertFalse(device.isDoorOpen());    
            
    }
 
}
