package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StationSetUpTests {
	
	StationSetUp setUp;
	
	@Before
	public void setUp(){
	setUp = new StationSetUp();
	}

	@Test
	public void testGetInstalledDisplays(){
		//Given: I want to set up a Weather Station
		//And: I have some Displays installed already
		//When: I want scan for installed Displays
		setUp.displayGetter.scanForDisplays(setUp);
		//Then: The installed displays should be added the a list
		assertEquals(4,setUp.installedDisplays.size());
		assertTrue(setUp.installedDisplays.contains("CurrentConditions"));
		assertTrue(setUp.installedDisplays.contains("Forecast"));
		assertTrue(setUp.installedDisplays.contains("Statistics"));
		assertTrue(setUp.installedDisplays.contains("HeatIndex"));
	}

	@Test
	public void testInstalledDisplaysPrompt(){
		//Not totally sure how to test this, since it spits out a mutli-line output to the console
		}
	
	@Test
	public void testRegisterDisplaySelection() {
		//Given: I want to set up a Weather Station
		//And: I am asked to add displays from a list
		setUp.promptForDisplays();
		//When: I select the displays I want to add
		//(Input 1, 2, and d into the console to pass)
		//Then: They are added to the display list to be passed into the WeatherStation
		assertEquals(2,setUp.getDesiredDisplays().size());
	}
}