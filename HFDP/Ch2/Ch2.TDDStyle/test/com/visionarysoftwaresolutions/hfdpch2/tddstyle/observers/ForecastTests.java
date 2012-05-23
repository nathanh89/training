package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class ForecastTests {

	ForecastDisplay forecast;
	WeatherData weatherData;
	
	@Before
	public void setup(){
		weatherData = new WeatherData();
	}
	
	@Test
	public void testSetUpAsObserver() {
		//Given: I have a ForecastDisplay
		//And: When I instantiate it, I want to set it as an observer
		//When: I do so for a specific Observable
		forecast = new ForecastDisplay(weatherData);
		//Then: It should be observing the Observable
		assertEquals(1, weatherData.countObservers());
	}
	
	@Test
	public void testDisplay(){
		//Given: I have a ForecastDisplay
		forecast = new ForecastDisplay();
		//And: I want it to display its data
		forecast.setCurrentPressure(30.23f);
		//When: I ask it to display
		//Then: It should display the data
		forecast.display();
		//Check console for output, manual pass verification here
	}

	@Test
	public void testManualUpdate(){
	//Given I have a ForecastDisplay
	forecast = new ForecastDisplay(weatherData);
	weatherData.setMeasurements(75, 75, 75);
	//And: The data in what it is observing is updated
	//When: The CurrentConditionsDisplay is notified
	//Then: It should display the new measurements
	//See console for output
	}
}