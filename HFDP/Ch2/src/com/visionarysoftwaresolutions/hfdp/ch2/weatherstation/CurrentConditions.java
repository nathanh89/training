package com.visionarysoftwaresolutions.hfdp.ch2.weatherstation;

import java.util.Observable;

public class CurrentConditions implements ObservingDisplay{
	
	Observable observable;
	private float temperature;
	private float humidity;
		
	public CurrentConditions(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public CurrentConditions(){
		
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable instanceof WeatherData){
			WeatherData weatherData = (WeatherData)observable;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();			
		}
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + 
				"F degrees and " + humidity + "% humidity");
	}

}
