package com.liwen.designPatterns.observerDesign;

public class CurrentConditionDisplay implements Observer,DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObservers(this); // 注册主题
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display(); 
	}

	@Override
	public void display() {
		System.out.println("Current condition: " + temperature +
				"F degree and " + humidity + "% humidity");
	}

}
