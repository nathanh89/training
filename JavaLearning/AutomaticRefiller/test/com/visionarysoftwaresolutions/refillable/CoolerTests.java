package com.visionarysoftwaresolutions.refillable;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nathan
 */
public class CoolerTests {
    @Test
    public void testAddBottlesToCooler(){
        //Given a cooler
        Cooler cooler = new Cooler();
        //When I add bottles to the cooler
        List<Bottle> toAdd = BottleManufacturer.orderSingleType("Monster", 5);
        cooler.addBottles(toAdd);
        //Then the bottles should be present
        assertEquals(5, cooler.getBottles());
    }
    
    @Test
    public void testRemoveBottlesFromCooler(){
        //Given a cooler, by necessity containing some bottles
        Cooler cooler = new Cooler();
        cooler.togglePower();
        cooler.addBottle(new Bottle("Green Monster"));
        //When I remove bottles from the cooler
        Bottle result = cooler.removeBottle();
        //Then the bottles should not be present
        assertEquals("Green Monster", result.getBeverageName());
    }
    
    @Test
    public void testCountBottlesByType(){
        //Given I have a cooler containing 15 bottles
        Cooler cooler = new Cooler();
        //and there are 10 Green Monsters and 5 BlueMachines
        List<Bottle> greenMonsters = BottleManufacturer.orderSingleType("Green Monster", 10);
        List<Bottle> blueMachines = BottleManufacturer.orderSingleType("Blue Machine", 5);
        cooler.addBottles(greenMonsters);
        cooler.addBottles(blueMachines);
        //When I want to check the amount of a given drink
        int currentMonsters = cooler.getBeverageCountByType("Green Monster");
        int currentBlueMachines = cooler.getBeverageCountByType("Blue Machine");
        //Then the amount of that particular drink should be given
        assertEquals(currentMonsters, 10);
        assertEquals(currentBlueMachines, 5);
    }
    
    @Test
    public void testBottleManufacturing(){
        //Given that I want to have 10 Green Monsters and 5 Rockstars
        //BottleManufacturer vendor = new BottleManufacturer();
        //When I ask a manufacturer to create bottles of a number and type
        List<Bottle> ordered = BottleManufacturer.orderSingleType("Green Monster", 10);
        //Then the manufacturer should deliver the order
        assertEquals(ordered.size(), 10);
        for(Bottle aBottle : ordered){
            assertEquals(aBottle.getBeverageName(), "Green Monster");
        }
    }
    
    @Test
    public void testCoolerCapacity(){
        //Given a cooler
        Cooler cooler = new Cooler();
        //When I want to specify its capacity
        cooler.setCapacity(100);
        //Then the capacity should be set
        assertEquals(cooler.getCapacity(), 100);
    }
    
    @Test
    public void testGetPercentFull(){
        //Given a cooler with a specified capacity, and by necessity some stock
        Cooler cooler = new Cooler();
        cooler.setCapacity(38);
        List<Bottle> genericWater = BottleManufacturer.orderSingleType("Generic Water", 13);
        List<Bottle> dasani = BottleManufacturer.orderSingleType("Dasani", 5);
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
        Cooler cooler = new Cooler();
        List<Bottle> mountainDew = BottleManufacturer.orderSingleType("Mountain Dew", 20);
        List<Bottle> melloYello = BottleManufacturer.orderSingleType("Mello Yello", 20);
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
        //Given a cooler
        Cooler cooler = new Cooler();
        //And it has Monsters and Rockstars, worth 3.95 and 2.95, respectively
        List<Bottle> monsters = BottleManufacturer.orderSingleType("Monster", 10);
        List<Bottle> rockstars = BottleManufacturer.orderSingleType("Rockstar", 10);
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
        Cooler cooler = new Cooler();
        List<Bottle> neurogasm = BottleManufacturer.orderSingleType("Neurogasm", 69);
        List<Bottle> gatorade = BottleManufacturer.orderSingleType("Gatorade", 100);
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
        //Given an empty cooler
        Cooler cooler = new Cooler();
        cooler.setCapacity(50);
        //When placing an order directly from the cooler
        cooler.orderBottlesFromManufacturerSingleType("Arizona Iced Tea", 20);
        cooler.orderBottlesFromManufacturerSingleType("Brisk Lemonade", 20);
        //Then the order should be delivered
        assertEquals(20, cooler.getBeverageCountByType("Arizona Iced Tea"));
        assertEquals(20, cooler.getBeverageCountByType("Brisk Lemonade"));
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
    
    

