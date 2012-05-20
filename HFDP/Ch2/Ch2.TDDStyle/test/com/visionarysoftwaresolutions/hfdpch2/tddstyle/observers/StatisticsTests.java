package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class StatisticsTests {

	StatisticsDisplay statistics;
	WeatherData weatherData;
	
	@Before
	public void setup(){
		weatherData = new WeatherData();
	}
	
	@Test
	public void testSetUpAsObserver() {
		//Given: I have a StatisticsDisplay
		//And: When I instantiate it, I want to set it as an observer
		//When: I do so for a specific Observable
		statistics = new StatisticsDisplay(weatherData);
		//Then: It should be observing the Observable
		assertEquals(1, weatherData.countObservers());
	}
	
	@Test
	public void testDisplay(){
		//Given: I have a StatisticsDisplay
		statistics = new StatisticsDisplay();
		//And: I want it to display its data
		statistics.setAverage(180, 3);
		//When: I ask it to display
		//Then: It should display the data
		statistics.display();
		//Check console for output, manual pass verification here
	}

	@Test
	public void testManualUpdate(){
	//Given I have a StatisticsDisplay
	statistics = new StatisticsDisplay(weatherData);
	weatherData.setMeasurements(75, 75, 75);
	weatherData.setMeasurements(58, 33, 80);
	//And: The data in what it is observing is updated
	//When: The CurrentConditionsDisplay is notified
	//Then: It should display the new measurements
	//See console for output
	}
}