package com.visionarysoftwaresolutions.refillable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class CoolerTests {
	Cooler cooler = new Cooler(100);
	BottleManufacturer collaborator = new BottleManufacturer("tester");
	
	@Before
	public void setup(){
		cooler.setPowerOn(true);
	}
	
	@Test
	public void testSetupCoolerInitialState(){
		//When I create a new cooler
		Cooler cooler = new Cooler(50);
		//It's default state should be correct, capacity to what was passed in, and power off
		assertEquals(50, cooler.getCapacity());
		assertFalse(cooler.isPowerOn());
	}
	
	@Test
	public void testAddSingleBottle(){
		//Given I have an empty cooler with capacity 100
		//And I add a bottle of Monster
		cooler.addBottle("Monster");
		//Then that bottle should be in the cooler
		assertEquals(1, cooler.getBottleCountByBeverage("Monster"));
	}
	
    @Test
    public void testAddMultipleBottlesToCooler(){
    	//Given an empty cooler with capacity 100
        // When I add bottles to the cooler
        cooler.addLocalStock("Monster", 10);
        // Then the bottles should be present
        assertEquals(10, cooler.getBottleCountByBeverage("Monster"));
    }
    
    @Test
    public void testRemoveBottleFromCoolerByBeverage(){
        // Given I have a cooler with some bottles
        cooler.addLocalStock("Monster", 10);
        // When I remove that bottle from the cooler
        cooler.removeBottle("Monster");
        // Then the bottle should not be present
        assertEquals(9, cooler.getBottleCountByBeverage("Monster"));
    }
    
    @Test
    public void testRemoveBottlesFromCoolerByBeverage(){
    	//Given I have a cooler with some bottles
    	cooler.addLocalStock("Monster", 10);
    	cooler.addLocalStock("Rockstar", 15);
    	//When I remove a specified beverage and quantity
    	cooler.removeBottles("Rockstar", 5);
    	//Then the bottles should be removed
    	assertEquals(10, cooler.getBottleCountByBeverage("Rockstar"));
    }
    
    @Test 
    public void testGetTotalBottleCount(){
    	//Given I have a cooler with some stock
    	cooler.addLocalStock("Monster", 10);
    	cooler.addLocalStock("Rockstar", 15);
    	//And I want to know the total number of bottles in the cooler
    	int bottleCount = cooler.getTotalBottleCount();
    	//Then the correct amount should be given
    	assertEquals(25, bottleCount);
    }
    
    @Test
    public void testGetBottlesCountByBeverage(){
        // Given I have a cooler with 10 Monsters and 15 Rockstars
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        // When I want to check the amount of a given drink
        int currentMonsters = cooler.getBottleCountByBeverage("Monster");
        int currentRockstars = cooler.getBottleCountByBeverage("Rockstar");
        // Then the amount of that particular drink should be given
        assertEquals(currentMonsters, 10);
        assertEquals(currentRockstars, 15);
    }
    
    @Test
    public void testGetCapacity(){
    	//Given I have a cooler with predefined physical capacity 100
    	//When I want to check the capacity
    	//Then the correct capacity should be given
    	assertEquals(100, cooler.getCapacity());
    }
    
    @Test
    public void testSetCustomCapacity(){
        // When I want to set a cooler's capacity to a custom level other than its physical capacity
        cooler.setCapacity(80);
        // Then the capacity should be set
        assertEquals(cooler.getCapacity(), 80);
    }
    
    @Test(expected=RuntimeException.class)
    public void testInvalidCapacityVeto(){
    	//Given a cooler with a physical capacity of 100
    	//When I want to set the cooler's capacity to a custom level
    	//And the capacity I try to set is higher that it's physical capacity
    	cooler.setCapacity(120);
    	//That setting should be rejected
    	assertEquals(100, cooler.getCapacity());
    	}
    
    @Test
    public void testGetPercentFull(){
        // Given a cooler with a specified capacity 0f 100
        // And by necessity some stock
    	cooler.addLocalStock("Monster", 10);
    	cooler.addLocalStock("Rockstar", 15);
        //When I ask how full the cooler is
        int percent = cooler.getPercentFull();
        //Then it should return the percent of capacity being used
        assertEquals(25, percent);
     }
    
    @Test
    public void testSetGetBeveragePriceByType(){
        //Given a cooler with some stock
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        //When I want to set the the price for the respective beverages
        cooler.setBeveragePrice("Monster", 2.50);
        cooler.setBeveragePrice("Rockstar", 1.50);
        //Then the price should be set correctly per type
        assertEquals(2.50, cooler.getBeveragePrice("Monster"), .000001);
        assertEquals(1.50, cooler.getBeveragePrice("Rockstar"), .000001);
        }
    
    @Test
    public void testGetTotalStockValue(){
    	//Given a cooler
        //And it has Monsters and Rockstars, worth 2.50 and 1.50, respectively
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        cooler.setBeveragePrice("Monster", 2.50);
        cooler.setBeveragePrice("Rockstar", 1.50);
        //When I ask for the value of the stock in the cooler
        double coolerStockValue = cooler.getTotalStockValue();
        //Then the correct value should be given
        assertEquals(47.50, coolerStockValue, 0.000001);
    }
    
    @Test
    public void testGetStockValueByBeverage(){
        //Given a cooler with some stock
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        //And that stock has a set retail price
        cooler.setBeveragePrice("Monster", 2.50);
        cooler.setBeveragePrice("Rockstar", 1.50);
        //When I ask for the value of the stock, but for a specific beverage
        double monsterValue = cooler.getStockValueByBeverage("Monster");
        double rockstarValue = cooler.getStockValueByBeverage("Rockstar");
        //Then the correct value should be given
        assertEquals(25.00, monsterValue, .000001);
        assertEquals(22.50, rockstarValue, .000001);
         
    }
        
    @Test
    public void testCreateEditOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I order some more stock
    	cooler.orderer.createOrder("Monster", 10, cooler);
    	//And: I add to the order before I send it
    	cooler.orderer.addToOrder("Rockstar", 15, cooler);
    	//Then: The additions should be on the order
    	Order result = cooler.orderer.checkOrder();
    	assertEquals(10, result.getCountForName("Monster"));
    	assertEquals(15, result.getCountForName("Rockstar"));
    }
    
    @Test
    public void testPlaceOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I create an order for more stock
    	cooler.orderer.createOrder("Monster", 10, cooler);
    	cooler.orderer.addToOrder("Rockstar", 15, cooler);
    	//And: I send the order to a BottleManufacturer
    	cooler.orderer.placeOrder("EnergyDrinkCo", cooler);
    	//Then: The cooler's stock should be updated by the order
    	assertEquals(10, cooler.getBottleCountByBeverage("Monster"));
    	assertEquals(15, cooler.getBottleCountByBeverage("Rockstar"));
    }
        
    @Test(expected=RuntimeException.class)
     public void testOverCapacityOrderVeto(){
         //Given a cooler with a physical capacity of 100
         //And some stock
         cooler.addLocalStock("Monster", 30);
         cooler.addLocalStock("Rockstar", 40);
         //When placing an order that will cause the cooler to be over capacity
         cooler.orderer.createOrder("Monster", 50, cooler);
         cooler.orderer.placeOrder("Monster Inc", cooler);
         //Then the cooler should veto the order
         assertEquals(30, cooler.getBottleCountByBeverage("Monster"));
         assertEquals(40, cooler.getBottleCountByBeverage("Rockstar"));
     }
     
    @Test
    public void testSetGetDesiredMinimumStockForBeverage(){
    	//Given: A Cooler
    	//When: I want to set a lower threshold for stock capacity for a beverage
    	cooler.setDesiredMinimumStock("Monster", 10);
    	cooler.setDesiredMinimumStock("Rockstar", 15);
    	//Then: The threshold should be set correctly
    	assertEquals(10, cooler.getDesiredMinimumStock("Monster"));
    	assertEquals(15, cooler.getDesiredMinimumStock("Rockstar"));
    }
    
    @Test
    public void testReorderCheck(){
    	Cooler cooler = new Cooler(100);
    	cooler.addLocalStock("Monster", 20);
    	cooler.setDesiredMinimumStock("Monster", 40);
    	assertEquals(40, cooler.getDesiredMinimumStock("Monster"));
    	assertEquals(20, cooler.reorderCheck("Monster"));
    }
    
/*    @Test public void testIsThereAnOrderPending(){
    	Cooler cooler = new Cooler(100);
    	assertFalse(cooler.thereIsAnOrderPending());
    	cooler.orderer.createOrder("Monster", 10, cooler);
    	assertTrue(cooler.thereIsAnOrderPending());
    }*/
  
   @Test    
    public void testAutomaticReorderCreation(){
	    // Given a cooler with some stock
    	Cooler cooler = new Cooler(100);
    	cooler.addLocalStock("Monster", 20);
    	cooler.addLocalStock("Rockstar", 40);
    	// And: A minimum threshold for that beverage
    	cooler.setDesiredMinimumStock("Monster", 20);
    	cooler.setDesiredMinimumStock("Rockstar", 40);
    	// When stock falls below capacity 
    	cooler.removeBottles("Monster", 12);
    	cooler.removeBottles("Rockstar", 18);
    	// Then a new order is created for the missing stock
    	assertEquals(20, cooler.getDesiredMinimumStock("Monster"));
    	assertEquals(40, cooler.getDesiredMinimumStock("Rockstar"));
    	assertEquals(12, cooler.orderer.checkOrder().getCountForName("Monster"));
    	assertEquals(18, cooler.orderer.checkOrder().getCountForName("Rockstar"));
    }
    
}
    
    

