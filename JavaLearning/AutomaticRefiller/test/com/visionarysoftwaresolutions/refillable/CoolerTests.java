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
	Cooler cooler = new Cooler();
	BottleManufacturer collaborator = new BottleManufacturer("tester");
	
	@Before
	public void setup(){
		cooler.setPowerOn(true);
		cooler.setCapacity(100);
	}
	
	@Test
	public void testSetupCoolerInitialState(){
		Cooler cooler = new Cooler(50);
		assertEquals(50, cooler.getCapacity());
		assertFalse(cooler.isPowerOn());
	}
	
    @Test
    public void testAddBottlesToCooler(){
        // When I add bottles to the cooler
        cooler.addLocalStock("Monster", 10);
        // Then the bottles should be present
        assertEquals(10, cooler.getBottleCount());
    }
    
    @Test
    public void testRemoveBottlesFromCooler(){
        // Given I have a cooler with a bottle in it
        cooler.addBottle(new Bottle("Green Monster"));
        // When I remove that bottle from the cooler
        Orderable result = cooler.removeBottle();
        // Then the bottle should not be present
        assertEquals("Green Monster", result.getName());
    }
    
    @Test
    public void testCountBottlesByType(){
        // Given I want to order 10 Green Monsters and 5 Blue Machines
        List<Bottle> greenMonsters = collaborator.fill(new Order("Green Monster", 10));
        List<Bottle> blueMachines = collaborator.fill(new Order("Blue Machine", 5));
        // And I add them to the cooler
        cooler.addBottles(greenMonsters);
        cooler.addBottles(blueMachines);
        // When I want to check the amount of a given drink
        int currentMonsters = cooler.getBeverageCountByType("Green Monster");
        int currentBlueMachines = cooler.getBeverageCountByType("Blue Machine");
        // Then the amount of that particular drink should be given
        assertEquals(currentMonsters, 10);
        assertEquals(currentBlueMachines, 5);
    }
    
    @Test
    public void testBottleManufacturing(){
        // When I ask a manufacturer to create bottles of a number and type
        List<Bottle> ordered = collaborator.fill(new Order("Green Monster", 10));
        // Then the manufacturer should deliver the order
        assertEquals(ordered.size(), 10);
        for(Orderable aBottle : ordered){
            assertEquals(aBottle.getName(), "Green Monster");
        }
    }
    
    @Test
    public void testCoolerCapacity(){
        // When I want to set a cooler's capacity
        cooler.setCapacity(100);
        // Then the capacity should be set
        assertEquals(cooler.getCapacity(), 100);
    }
    
    @Test
    public void testGetPercentFull(){
        // Given a cooler with a specified capacity
    	cooler.setCapacity(38);
        // And by necessity some stock
        List<Bottle> genericWater = collaborator.fill(new Order("Generic Water", 13));
        List<Bottle> dasani = collaborator.fill(new Order("Dasani", 5));
        cooler.addBottles(genericWater);
        cooler.addBottles(dasani);
        //When I ask how full the cooler is
        int percent = cooler.getPercentFull();
        //Then it should return the percent of capacity being used
        assertEquals(47, percent);
     }
    
    @Test
    public void testSetGetBeveragePriceByType(){
        //Given a cooler with some stock
        List<Bottle> mountainDew = collaborator.fill(new Order("Mountain Dew", 20));
        List<Bottle> melloYello = collaborator.fill(new Order("Mello Yello", 20));
        cooler.addBottles(mountainDew);
        cooler.addBottles(melloYello);
        //When I want to set the the price for the respective bottles
        cooler.setBeveragePriceByType("Mountain Dew", 1.50);
        cooler.setBeveragePriceByType("Mello Yello", 0.99);
        //Then the price should be set correctly per type
        assertEquals(cooler.getBeveragePriceByType("Mountain Dew"), 1.50, .000001);
        assertEquals(cooler.getBeveragePriceByType("Mello Yello"), 0.99, .000001);
        }
    
    @Test
    public void testGetTotalStockValue(){
        //And it has Monsters and Rockstars, worth 3.95 and 2.95, respectively
        List<Bottle> monsters = collaborator.fill(new Order("Monster", 10));
        List<Bottle> rockstars = collaborator.fill(new Order("Rockstar", 10));
        cooler.addBottles(monsters);
        cooler.addBottles(rockstars);
        cooler.setBeveragePriceByType("Monster", 3.95);
        cooler.setBeveragePriceByType("Rockstar", 2.95);
        //When I ask for the value of the stock in the cooler
        double coolerStockValue = cooler.getTotalStockValue();
        //Then the correct value should be given
        assertEquals(69.00, coolerStockValue, 0.000001);
    }
    
    @Test
    public void testGetStockValueByType(){
        //Given a cooler with some stock
        List<Bottle> neurogasm = collaborator.fill(new Order("Neurogasm", 69));
        List<Bottle> gatorade =  collaborator.fill(new Order("Gatorade", 100));
        cooler.addBottles(neurogasm);
        cooler.addBottles(gatorade);
        //And that stock has a set retail price
        cooler.setBeveragePriceByType("Neurogasm", 6.90);
        cooler.setBeveragePriceByType("Gatorade", 2.99);
        //When I ask for the value of the stock, but for a specific beverage
        double neurogasmicValue = cooler.getStockValueByType("Neurogasm");
        double gatoradeValue = cooler.getStockValueByType("Gatorade");
        //Then the correct value should be given
        assertEquals(476.10, neurogasmicValue, .000001);
        assertEquals(299.00, gatoradeValue, .000001);
         
    }

    @Test
    public void testSetDesiredMinimumStockForBeverage(){
    	//Given: A Cooler
    	//When: I want to set a lower threshold for stock capacity for a beverage
    	cooler.setDesiredMinimumStock("Monster", 10);
    	//Then: The threshold should be set correctly
    	assertEquals(10, cooler.getDesiredMinimumStock("Monster"));
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
        //Given a cooler with a set capacity
        Cooler cooler = new Cooler(100);
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
    	int minimum = 20;
    	List<Bottle> roosters = createStock("Rooster Booster", minimum);
    	cooler.addBottles(roosters);
    	// And : A minimum threshold for that beverage
    	cooler.setDesiredMinimumStock("Rooster Booster", minimum);
    	// When a bottle is removed 
    	cooler.removeBottle();
    	// And the beverage falls below the minimum threshold
    	assertTrue(cooler.getBeverageCountByType("Rooster Booster") < minimum);
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
    
    

