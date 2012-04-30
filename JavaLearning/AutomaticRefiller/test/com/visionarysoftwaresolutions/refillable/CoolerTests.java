package com.visionarysoftwaresolutions.refillable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

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
        cooler.addBottles(5);
        //Then the bottles should be present
        assertTrue(cooler.getBottles() == 5);
    }
    
    @Test
    public void testRemoveBottlesFromCooler(){
        //Given a cooler, by necessity containing some bottles
        Cooler cooler = new Cooler();
        cooler.currentBottles = 10;
        //When I remove bottles from the cooler
        cooler.removeBottles(5);
        //Then the bottles should not be present
        assertTrue(cooler.getBottles() == 5);
    }
    
    @Test
    public void testCountBottlesByType(){
        //Given I have a cooler containing 15 bottles
        Cooler cooler = new Cooler();
        //and there are 10 Green Monsters and 5 BlueMachines
        List<Bottle> greenMonsters = makeGreenMonsters();
        List<Bottle> blueMachines = makeBlueMachines();
        cooler.addBottles(greenMonsters);
        cooler.addBottles(blueMachines);
        //When I want to check the amount of a given drink
        int currentMonsters = cooler.getBeverageCount("Green Monster");
        int currentBlueMachines = cooler.getBeverageCount("Blue Machine");
        //Then the amount of that particular drink should be given
        assertEquals(currentMonsters, 10);
        assertEquals(currentBlueMachines, 5);
    }
    
    private List<Bottle> makeGreenMonsters(){
        List<Bottle> monsters = new ArrayList<Bottle>();
        for(int i=0; i<10; i++){
            monsters.add(new Bottle("Green Monster"));
        }
        return monsters;
    }
    
    private List<Bottle> makeBlueMachines(){
        List<Bottle> bluemachines = new ArrayList<Bottle>();
        for(int i=0; i<5; i++){
            bluemachines.add(new Bottle("Blue Machine"));
        }
        return bluemachines;    } 

}
