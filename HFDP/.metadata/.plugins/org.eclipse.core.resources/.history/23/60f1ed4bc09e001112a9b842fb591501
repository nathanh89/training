package com.visionarysoftwaresolutions.hfdp.ch2;

public class CurrentConditionsDisplay implements ObservingDisplay{
	
	private float temperature;
	private float humidity;
	private Subject weatherData;

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + 
				"F degrees and " + humidity + "% humidity");
	}

}
