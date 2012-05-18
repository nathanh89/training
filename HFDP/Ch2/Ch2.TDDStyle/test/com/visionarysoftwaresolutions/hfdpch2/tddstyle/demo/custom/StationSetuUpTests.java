package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.CurrentConditions;
import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.Forecast;


public class StationSetuUpTests {
	
	StationSetUp setUp;
	
	@Before
	public void setUp(){
	setUp = new StationSetUp();
	}

	@Test
	public void testGetInstalledDisplays(){
		//Given: I want to set up a Weather Station
		//And: I have some Displays installed already
		//When: I want to get a list of the installed displays
		//Then: The installed displays should be on the list
		setUp.getInstalledDisplays();
		assertEquals(4,setUp.displaysToShow.size());
		assertTrue(setUp.displaysToShow.contains("CurrentConditions"));
		assertTrue(setUp.displaysToShow.contains("Forecast"));
		assertTrue(setUp.displaysToShow.contains("Statistics"));
		assertTrue(setUp.displaysToShow.contains("HeatIndex"));
	}
	
	@Test
	public void testRegisterDisplaySelection() {
		//Given: I want to set up a Weather Station
		//And: I am asked to add displays from a list
		setUp.promptForDisplays();
		//When: I select the displays I want to add
		simulateInput("1");
		simulateInput("2");
		//Then: They are added to the display list to be passed into the WeatherStation
		assertTrue(setUp.displaysToShow.contains(new CurrentConditions()));
		assertTrue(setUp.displaysToShow.contains(new Forecast()));
	}

	private void simulateInput(String input){
		InputStream simulatedInput = System.in;
		try{
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
		} finally {
		System.setIn(simulatedInput);
		}
	}
}
