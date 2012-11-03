package com.visionarysoftwaresolutions.refillable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.visionarysoftwaresolutions.ordering.Manufacturer;
import com.visionarysoftwaresolutions.ordering.Order;
import com.visionarysoftwaresolutions.ordering.OrderContainer;
import com.visionarysoftwaresolutions.ordering.Orderable;

import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class CoolerTests {
	Cooler cooler = new Cooler(100);
	Manufacturer collaborator = new BottleManufacturer("tester");
	Orderable monster = new Bottle("Monster");
	OrderContainer holder = new OrderContainer(monster, 10);
	List<OrderContainer> containers = new ArrayList<OrderContainer>();
	UnmotivatedStoner oldNathan = new UnmotivatedStoner();
	
	@Before
	public void setup(){
		cooler.setPowerOn(true);
		containers.add(holder);
		OrderContainer rockers = new OrderContainer(new Bottle("Rockstar"), 15);
    	containers.add(rockers);
        oldNathan.stock(containers, cooler);
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
		Cooler cooler = new Cooler(100);
		//And I add a bottle of Monster
		cooler.addBottle("Monster");
		//Then that bottle should be in the cooler
		assertEquals(1, cooler.getCountForProduct("Monster"));
	}
	
    @Test
    public void testAddMultipleBottlesToCooler(){
    	//Given an empty cooler with capacity 100
        // When I add bottles to the cooler
    	cooler.addBottles("Monster", 10);
        // Then the bottles should be present
        assertEquals(20, cooler.getCountForProduct("Monster"));
    }
    
    @Test
    public void testRemoveBottleFromCoolerByBeverage(){
        // Given I have a cooler with some bottles
        // When I remove that bottle from the cooler
        cooler.removeBottle("Monster");
        // Then the bottle should not be present
        assertEquals(9, cooler.getCountForProduct("Monster"));
    }
    
    @Test
    public void testRemoveBottlesFromCoolerByBeverage(){
    	//Given I have a cooler with some bottles
    	//When I remove a specified beverage and quantity
    	cooler.removeBottles("Rockstar", 5);
    	//Then the bottles should be removed
    	assertEquals(10, cooler.getCountForProduct("Rockstar"));
    }
    
    @Test 
    public void testGetTotalBottleCount(){
    	//Given I have a cooler with some stock
    	//And I want to know the total number of bottles in the cooler
    	int bottleCount = cooler.getStoredCount();
    	//Then the correct amount should be given
    	assertEquals(25, bottleCount);
    }
    
    @Test
    public void testGetBottlesCountByBeverage(){
        // Given I have a cooler with 10 Monsters and 15 Rockstars
    	// When I want to check the amount of a given drink
        int currentMonsters = cooler.getCountForProduct("Monster");
        int currentRockstars = cooler.getCountForProduct("Rockstar");
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
    
    @Test
    public void testGetPercentFull(){
        // Given a cooler with a specified capacity 0f 100
        // And by necessity some stock
    	//When I ask how full the cooler is
        int percent = cooler.getPercentFull();
        //Then it should return the percent of capacity being used
        assertEquals(25, percent);
     }
    
    @Test
    public void testSetGetBeveragePriceByType(){
        //Given a cooler with some stock
    	//When I want to set the the price for the respective beverages
        cooler.updatePriceTag("Monster", 2.50);
        cooler.updatePriceTag("Rockstar", 1.50);
        //Then the price should be set correctly per type
        assertEquals(2.50, cooler.getPriceForProduct("Monster"), .000001);
        assertEquals(1.50, cooler.getPriceForProduct("Rockstar"), .000001);
        }
    
    @Test
    public void testGetTotalStockValue(){
    	//Given a cooler
        //And it has Monsters and Rockstars, worth 2.50 and 1.50, respectively
    	cooler.updatePriceTag("Monster", 2.50);
        cooler.updatePriceTag("Rockstar", 1.50);
        //When I ask for the value of the stock in the cooler
        double coolerStockValue = cooler.getTotalStockValue();
        //Then the correct value should be given
        assertEquals(47.50, coolerStockValue, 0.000001);
    }
    
    @Test
    public void testGetStockValueByBeverage(){
        //Given a cooler with some stock
    	//And that stock has a set retail price
        cooler.updatePriceTag("Monster", 2.50);
        cooler.updatePriceTag("Rockstar", 1.50);
        //When I ask for the value of the stock, but for a specific beverage
        double monsterValue = cooler.getStockValueByProduct("Monster");
        double rockstarValue = cooler.getStockValueByProduct("Rockstar");
        //Then the correct value should be given
        assertEquals(25.00, monsterValue, .000001);
        assertEquals(22.50, rockstarValue, .000001);
         
    }
        
    @Test
    public void testCreateEditOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I order some more stock
    	Orderable monster = new Bottle("Monster");
		Orderable rockstar = new Bottle("Rockstar");
		cooler.orderer.createOrder(monster, 10);
    	//And: I add to the order before I send it
    	cooler.orderer.addToOrder(rockstar, 15);
    	//Then: The additions should be on the order
    	Order result = cooler.orderer.checkOrder();
    	assertEquals(10, result.getCountForName("Monster"));
    	assertEquals(15, result.getCountForName("Rockstar"));
    }
    
    @Test
    public void testPlaceOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I create an order for more stock
    	Orderable monster = new Bottle("Monster");
		Orderable rockstar = new Bottle("Rockstar");
    	cooler.orderer.createOrder(monster, 10);
    	cooler.orderer.addToOrder(rockstar, 15);
    	//And: I send the order to a BottleManufacturer
    	Manufacturer bottler = new BottleManufacturer("EnergyDrinkCo");
    	//Then: The cooler's stock should be updated by the order
    	List<OrderContainer> toStock = cooler.orderer.placeOrder(bottler);
		//Then that order should be filled
		assertEquals(2, toStock.size());
		OrderContainer monsterContainer = toStock.get(0); 
		assertEquals(10, monsterContainer.getNumber());
		assertEquals("Monster", monsterContainer.getName());
		OrderContainer rockstarContainer = toStock.get(1); 
		assertEquals(15, rockstarContainer.getNumber());
	}
        
    @Test(expected=RuntimeException.class)
     public void testOverCapacityOrderVeto(){
         //Given a cooler with a physical capacity of 100
         //And some stock
    	 Manufacturer bottler = new BottleManufacturer("EnergyDrinkCo");
         //When placing an order that will cause the cooler to be over capacity
         cooler.orderer.createOrder(monster, 100);
         cooler.orderer.placeOrder(bottler);
         //Then the cooler should veto the order
         assertEquals(10, cooler.getCountForProduct("Monster"));
         assertEquals(15, cooler.getCountForProduct("Rockstar"));
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
    	cooler.setDesiredMinimumStock("Monster", 40);
    	assertEquals(30, cooler.reorderQuantityCheck("Monster"));
    }
    
    @Test    
    public void testAutomaticReorderCreation(){
	    // Given: A minimum threshold for that beverage
    	cooler.setDesiredMinimumStock("Monster", 10);
    	cooler.setDesiredMinimumStock("Rockstar", 15);
    	// When stock falls below capacity 
    	cooler.removeBottles("Monster", 8);
    	cooler.removeBottles("Rockstar", 5);
    	// Then a new order is created for the missing stock
    	assertEquals(8, cooler.orderer.countProductsInOrder("Monster"));
    	assertEquals(5, cooler.orderer.countProductsInOrder("Rockstar"));
    	//And updated when another bottle is removed
    	cooler.removeBottle("Monster");
    	assertEquals(9, cooler.orderer.countProductsInOrder("Monster"));
    }
}