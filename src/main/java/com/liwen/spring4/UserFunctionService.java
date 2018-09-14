package com.liwen.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionService {
	@Autowired //注入
	private FunctionService functionService;
	
	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
}
