package com.liwen.spring4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
		System.out.println(userFunctionService.sayHello("di"));
		context.close();
	}
}
