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
		assertEquals(1, cooler.getBeverageCountByType("Monster"));
	}
	
    @Test
    public void testAddMultipleBottlesToCooler(){
    	//Given an empty cooler with capacity 100
        // When I add bottles to the cooler
        cooler.addLocalStock("Monster", 10);
        // Then the bottles should be present
        assertEquals(10, cooler.getBeverageCountByType("Monster"));
    }
    
    @Test
    public void testRemoveBottleFromCooler(){
        // Given I have a cooler with some bottles
        cooler.addLocalStock("Monster", 10);
        // When I remove that bottle from the cooler
        cooler.removeBottle();
        // Then the bottle should not be present
        assertEquals(9, cooler.getBeverageCountByType("Monster"));
    }
    
    @Test
    public void testCountBottlesByType(){
        // Given I have a cooler with 10 Monsters and 15 Rockstars
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        // When I want to check the amount of a given drink
        int currentMonsters = cooler.getBeverageCountByType("Monster");
        int currentRockstars = cooler.getBeverageCountByType("Rockstar");
        // Then the amount of that particular drink should be given
        assertEquals(currentMonsters, 10);
        assertEquals(currentRockstars, 15);
    }
    
    @Test
    public void testCustomCoolerCapacity(){
        // When I want to set a cooler's capacity to a custom level
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
        //When I want to set the the price for the respective bottles
        cooler.setBeveragePriceByType("Monster", 2.50);
        cooler.setBeveragePriceByType("Rockstar", 1.50);
        //Then the price should be set correctly per type
        assertEquals(2.50, cooler.getBeveragePriceByType("Monster"), .000001);
        assertEquals(1.50, cooler.getBeveragePriceByType("Rockstar"), .000001);
        }
    
    @Test
    public void testGetTotalStockValue(){
    	//Given a cooler
        //And it has Monsters and Rockstars, worth 2.50 and 1.50, respectively
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        cooler.setBeveragePriceByType("Monster", 2.50);
        cooler.setBeveragePriceByType("Rockstar", 1.50);
        //When I ask for the value of the stock in the cooler
        double coolerStockValue = cooler.getTotalStockValue();
        //Then the correct value should be given
        assertEquals(47.50, coolerStockValue, 0.000001);
    }
    
    @Test
    public void testGetStockValueByType(){
        //Given a cooler with some stock
        cooler.addLocalStock("Monster", 10);
        cooler.addLocalStock("Rockstar", 15);
        //And that stock has a set retail price
        cooler.setBeveragePriceByType("Monster", 2.50);
        cooler.setBeveragePriceByType("Rockstar", 1.50);
        //When I ask for the value of the stock, but for a specific beverage
        double monsterValue = cooler.getStockValueByType("Monster");
        double rockstarValue = cooler.getStockValueByType("Rockstar");
        //Then the correct value should be given
        assertEquals(25.00, monsterValue, .000001);
        assertEquals(22.50, rockstarValue, .000001);
         
    }

    @Test
    public void testSetDesiredMinimumStockForBeverage(){
    	//Given: A Cooler
    	//When: I want to set a lower threshold for stock capacity for a beverage
    	cooler.setDesiredMinimumStock("Monster", 10);
    	cooler.setDesiredMinimumStock("Rockstar", 15);
    	//Then: The threshold should be set correctly
    	assertEquals(10, cooler.getDesiredMinimumStock("Monster"));
    	assertEquals(15, cooler.getDesiredMinimumStock("Rockstar"));
    }
    
    @Test
    public void testCreateEditOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I order some more stock
    	cooler.orderer.createOrder("Monster", 10, cooler);
    	//And: I add to the order before I send it
    	cooler.orderer.addToOrder("Rockstar", 20, cooler);
    	//Then: The additions should be on the order
    	Order result = cooler.orderer.checkOrder();
    	assertEquals(10, result.getCountForName("Monster"));
    	assertEquals(20, result.getCountForName("Rockstar"));
    }
    
    @Test
    public void testSendOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I create an order for more stock
    	cooler.orderer.createOrder("Monster", 10, cooler);
    	//And: I send the order to a BottleManufacturer
    	cooler.orderer.placeOrder("Monster, Inc", cooler);
    	//Then: The cooler's stock should be updated by the order
    	assertEquals(10, cooler.getBeverageCountByType("Monster"));
    }
    
   @Test(expected=RuntimeException.class)
    public void testOverCapacityOrderVeto(){
        //Given a cooler with a physical capacity of 100
        //And some stock
        List<Bottle> powerades = createStock("Powerade", 30);
        cooler.addBottles(powerades);
        List<Bottle> water = createStock("Life Water", 40);
        cooler.addBottles(water);
        //When placing an order that will cause the cooler to be over capacity
        cooler.orderer.createOrder("Powerade", 50, cooler);
        cooler.orderer.placeOrder("Coca Cola", cooler);
        //Then the cooler should veto the order
        assertEquals(30, cooler.getBeverageCountByType("Powerade"));
        assertEquals(40, cooler.getBeverageCountByType("Life Water"));
    }
    
    @Test    
    public void testAutomaticReorderCreation(){
	    // Given some stock
    	int minimum = 10;
    	cooler.addLocalStock("Monster", 10);
    	// And : A minimum threshold for that beverage
    	cooler.setDesiredMinimumStock("Monster", minimum);
    	// When a bottle is removed 
    	cooler.removeBottle();
    	// And the beverage falls below the minimum threshold
    	assertTrue(cooler.getBeverageCountByType("Monster") < minimum);
    	// Then a pending restock order for the beverage should be created 
	    assertNotNull(cooler.orderer.checkOrder());
    }
    
    private List<Bottle> createStock(String bottle, int desired){
    	List<Bottle> stock = new ArrayList<Bottle>();
    	for(int i = 0; i< desired; i++){
        	stock.add(new Bottle(bottle));
        }
    	return stock;
    }
}
    
    

