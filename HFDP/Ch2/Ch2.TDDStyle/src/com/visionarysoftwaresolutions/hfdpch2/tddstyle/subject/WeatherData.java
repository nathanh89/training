package com.visionarysoftwaresolutions.hfdpch2.tddstyle.subject;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.ObservingDisplay;

public class WeatherData extends Observable{
	
	public ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public void addDisplay(ArrayList<ObservingDisplay> displaysToUse){
		observers = new ArrayList<Observer>();
		for(int i = 0; i<displaysToUse.size(); i++){
			observers.add((Observer) displaysToUse.get(i));
		}
	}

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
