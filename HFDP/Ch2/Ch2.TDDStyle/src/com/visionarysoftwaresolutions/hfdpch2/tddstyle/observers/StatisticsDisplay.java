package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

import java.util.Observable;
import java.util.Observer;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {
	
	Observable observable;
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public StatisticsDisplay(){
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings++;
			if (temp > maxTemp) {
				maxTemp = temp;
			}
 			if (temp < minTemp) {
				minTemp = temp;
			}
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
