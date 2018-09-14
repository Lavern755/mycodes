package com.liwen.spring4;

import org.springframework.stereotype.Service;

@Service // 也可以使用@Resource
public class FunctionService {
	public String sayHello(String word) {
		return "Hello "+word;
	}
}
