package com.visionarysoftwaresolutions.refillable;
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
	}
	
    @Test
    public void testAddBottlesToCooler(){
        // When I add bottles to the cooler
        List<Bottle> toAdd = collaborator.place(new Order("Monster", 5));
        cooler.addBottles(toAdd);
        // Then the bottles should be present
        assertEquals(5, cooler.getBottles());
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
        List<Bottle> greenMonsters = collaborator.place(new Order("Green Monster", 10));
        List<Bottle> blueMachines = collaborator.place(new Order("Blue Machine", 5));
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
        List<Bottle> ordered = collaborator.place(new Order("Green Monster", 10));
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
        List<Bottle> genericWater = collaborator.place(new Order("Generic Water", 13));
        List<Bottle> dasani = collaborator.place(new Order("Dasani", 5));
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
        List<Bottle> mountainDew = collaborator.place(new Order("Mountain Dew", 20));
        List<Bottle> melloYello = collaborator.place(new Order("Mello Yello", 20));
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
        List<Bottle> monsters = collaborator.place(new Order("Monster", 10));
        List<Bottle> rockstars = collaborator.place(new Order("Rockstar", 10));
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
        List<Bottle> neurogasm = collaborator.place(new Order("Neurogasm", 69));
        List<Bottle> gatorade =  collaborator.place(new Order("Gatorade", 100));
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
    public void testOrderingFromCoolerSingleType(){
        cooler.setCapacity(50);
        //When placing an order directly from the cooler
        cooler.order(collaborator, "Arizona Iced Tea", 20);
        cooler.order(collaborator, "Brisk Lemonade", 20);
        //Then the order should be delivered
        assertEquals(20, cooler.getBeverageCountByType("Arizona Iced Tea"));
        assertEquals(20, cooler.getBeverageCountByType("Brisk Lemonade"));
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
    public void testEditOrdersFromCooler(){
    	//Given: I have a cooler in need of some stock
    	//When: I order some more stock
    	cooler.createOrder("Monster", 10);
    	//And: I add to the order before I send it
    	cooler.addToOrder("Rockstar", 20);
    	//Then: The additions should be on the order
    	Order result = cooler.getPendingOrder();
    	assertEquals(10, result.getCountForName("Monster"));
    	assertEquals(20, result.getCountForName("Rockstar"));
    }
    
    /*@Test
    public void testOverCapacityOrderVeto(){
        //Given a cooler with a set capacity
        Cooler cooler = new Cooler();
        cooler.setCapacity(100);
        //And some stock
        cooler.orderBottlesFromManufacturer("Powerade", 30);
        cooler.orderBottlesFromManufacturer("Life Water", 40);
        //When placing an order that will cause the cooler to be over capacity
        cooler.orderBottlesFromManufacturer("Powerade", 50);
        cooler.orderBottlesFromManufacturer("Life Water", 50);
        //Then the cooler should veto the order
        assertEquals(30, cooler.getBeverageCountByType("Powerade"));
        assertEquals(40, cooler.getBeverageCountByType("Life Water"));
    }*/
    
        //@Test    
        //public void testAutomaticReorder(){
        //Cooler cooler = new Cooler();
        //cooler.setCapacity(50);
        //cooler.orderBottlesFromManufacturer("Rooster Booster", 20);
        //cooler.orderBottlesFromManufacturer("Cock Master", 20);
        //}
}
    
    

