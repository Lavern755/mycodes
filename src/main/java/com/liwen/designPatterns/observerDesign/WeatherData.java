package com.liwen.designPatterns.observerDesign;

import java.util.ArrayList;
/**
 * 主题的实现
 * @author Administrator
 *
 */
public class WeatherData implements Subject {
	
	private ArrayList<Observer> observers; // 记录观察者
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObservers(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObservers(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measureChanged() {
		notifyObservers(); // 有值改变时就通知订阅者
	}
	
	public void setMeasurements(float temperature,float humidity,float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measureChanged(); // 变化之后,要通知订阅者
	}

}
