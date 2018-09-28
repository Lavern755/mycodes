package com.liwen.designPatterns.observerDesign;
/**
 * 主题 subject
 * @author Administrator
 *
 */
public interface Subject {
	public void registerObservers(Observer o);
	public void removeObservers(Observer o);
	public void notifyObservers();
}
