package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

import java.util.Observable;
import java.util.Observer;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	
	Observable observable;
	private float temperature;
	private float humidity;
		
	public CurrentConditionsDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public CurrentConditionsDisplay(){
	}
	
	public void setTemperature(float temperature){
		this.temperature = temperature;
	}
	
	public void setHumidity(float humidity){
		this.humidity = humidity;
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
