package com.visionarysoftwaresolutions.refillable;

import org.junit.*;
import static org.junit.Assert.*;

public class PoweredDooredUnitTests {
    
       @Test
       public void testPoweredDoorUnitTogglePower(){
           //given a powered door unit, of type Cooler
           PoweredDooredUnit device = new Cooler();
           //When I want to change the state of the power (on or off) starting from off
           device.togglePower();
           //Then the power should be off
           assertTrue(device.isPowerOn());
           //and vice versa for turning back on
           device.togglePower();
           assertFalse(device.isPowerOn());
       }
    
       @Test
       public void testPoweredDoorUnitOperateDoor(){
           //given a powered door unit, of type Cooler
           PoweredDooredUnit device = new Cooler();
           //When I want to change the state of door (open or close) starting from closed
           device.operateDoor();
           //The door should open
           assertTrue(device.isDoorOpen());
           //and vice versa
           device.operateDoor();
           assertFalse(device.isDoorOpen());
           
       }
}
