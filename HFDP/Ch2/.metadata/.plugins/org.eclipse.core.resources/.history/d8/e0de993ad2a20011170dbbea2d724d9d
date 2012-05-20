package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

import java.util.Observable;
import java.util.Observer;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement{

	Observable observable;
	private float currentPressure = 29.92f;  
	private float lastPressure;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public ForecastDisplay(){
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if(observable instanceof WeatherData){
			WeatherData weatherData = (WeatherData)observable;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}
