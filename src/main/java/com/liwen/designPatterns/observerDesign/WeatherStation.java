package com.liwen.designPatterns.observerDesign;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay currDisplay = new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
	}
}
