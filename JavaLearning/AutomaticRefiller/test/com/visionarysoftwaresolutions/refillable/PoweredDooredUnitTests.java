package com.visionarysoftwaresolutions.refillable;

import org.junit.*;
import static org.junit.Assert.*;

public class PoweredDooredUnitTests {
    
              
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
