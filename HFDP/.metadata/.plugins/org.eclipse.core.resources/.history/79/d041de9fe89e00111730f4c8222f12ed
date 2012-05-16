package com.visionarysoftwaresolutions.hfdp.ch2;

public class ShittyBookWeatherStationMultiple {
	
	static WeatherData weatherData = new WeatherData();
	
	public static void main(String[] args){
		
		//And the books implementation of the Observer method is not as flexible as mine
		//You can't select what displays to show beforehand, it just displays what is programmed in
		
		CurrentConditions currentDisplay = new CurrentConditions(weatherData);
		Forecast forecastDisplay = new Forecast(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		
		weatherData.removeObserver(currentDisplay);
		weatherData.setMeasurements(90, 60, 32.5f);
		weatherData.setMeasurements(95, 75, 29.2f);
		weatherData.setMeasurements(100, 90, 18.5f);
		
		}

}
