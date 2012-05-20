package com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable{
	
	public ArrayList<Observer> observers = new ArrayList<Observer>();
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
	}

	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
