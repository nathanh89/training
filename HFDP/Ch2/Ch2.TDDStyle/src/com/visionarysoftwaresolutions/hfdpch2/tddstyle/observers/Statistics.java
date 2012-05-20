package com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers;

import java.util.Observable;
import com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject.WeatherData;

public class Statistics implements ObservingDisplay {
	
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	public Statistics(Observable observable) {
		observable.addObserver(this);
	}
	
	public Statistics(){
		
	}

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

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
