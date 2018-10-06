package com.liwen.aop;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Class<?> clazz = list.getClass();
		ListProxy<String> myProxy = new ListProxy<>(list);
		List<String> newList = (List<String>) Proxy.newProxyInstance(clazz.getClassLoader(),
																			clazz.getInterfaces(), myProxy);
		newList.add("apple");
		newList.add("banana");
		newList.add("orange");
		newList.add("banana");
		
	}
}
