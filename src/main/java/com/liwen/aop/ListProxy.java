package com.liwen.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class ListProxy<T> implements InvocationHandler{
	
	private List<T> target;
	public ListProxy(List<T> target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retVal = null;
		System.out.println("[" + method.getName() + ":" + args[0] + "]");
		retVal = method.invoke(target, args);
		System.out.println("[size = " + target.size() + "]");
		return retVal;
	}
	
}
