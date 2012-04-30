package com.visionarysoftwaresolutions.refillable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
        List<Bottle> toAdd = BottleManufacturer.order("Monster", 5);
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
        List<Bottle> greenMonsters = BottleManufacturer.order("Green Monster", 10);
        List<Bottle> blueMachines = BottleManufacturer.order("Blue Machine", 5);
        cooler.addBottles(greenMonsters);
        cooler.addBottles(blueMachines);
        //When I want to check the amount of a given drink
        int currentMonsters = cooler.getBeverageCount("Green Monster");
        int currentBlueMachines = cooler.getBeverageCount("Blue Machine");
        //Then the amount of that particular drink should be given
        assertEquals(currentMonsters, 10);
        assertEquals(currentBlueMachines, 5);
    }
    
    @Test
    public void testBottleManufacturing(){
        //Given that I want to have 10 Green Monsters and 5 Rockstars
        //BottleManufacturer vendor = new BottleManufacturer();
        //When I ask a manufacturer to create bottles of a number and type
        List<Bottle> ordered = BottleManufacturer.order("Green Monster", 10);
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
    public void testCheckHowFullIsCoolerPercent(){
        //Given a cooler with a specified capacity, and by necessity some stock
        Cooler cooler = new Cooler();
        cooler.setCapacity(38);
        List<Bottle> genericWater = BottleManufacturer.order("Generic Water", 13);
        List<Bottle> dasani = BottleManufacturer.order("Dasani", 5);
        cooler.addBottles(genericWater);
        cooler.addBottles(dasani);
        //When I ask how full the cooler is
        //Then it should return the percent of capacity being used
        assertEquals(47, cooler.getPercentFull());
         
    }
    
//    @Test
//    public void testAutomaticReorder(){
//        Cooler cooler = new Cooler();
//        cooler.orderBottles("Green Monster", 10);
//        cooler.orderBottles("Rockstar", 5);
//        }
    }
    
    

