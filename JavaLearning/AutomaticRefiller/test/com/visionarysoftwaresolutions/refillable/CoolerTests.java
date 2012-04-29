package com.visionarysoftwaresolutions.refillable;

import org.junit.*;
import static org.junit.Assert.*;

public class CoolerTests {
    @Test
    public void testCoolerPowerState() {
        //Given: I have a oooler And: It is off
        Cooler odwalla = new Cooler();
        //When: I want to toggle the power state
        odwalla.togglePower();
        //The cooler should be on
        assertTrue(odwalla.isPowerOn());
        odwalla.togglePower();
        assertFalse(odwalla.isPowerOn());
    }
    
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
