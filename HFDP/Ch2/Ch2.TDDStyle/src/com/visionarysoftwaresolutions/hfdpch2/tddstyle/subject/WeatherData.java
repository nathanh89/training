package com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject;

import java.util.Observable;

public class WeatherData extends Observable{
	
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData(){
	}

	public float getTemperature(){
		return temperature;
	}
	
	public float getHumidity(){
		return humidity;
	}
	
	public float getPressure(){
		return pressure;
	}
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
		System.out.println("\n");
	}

	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}