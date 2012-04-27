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
}
