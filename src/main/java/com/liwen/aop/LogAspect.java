package com.liwen.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect // 声明是一个切面
@Component
public class LogAspect {
	//@Pointcut(@annotation(com.liwen.aop.Action))
	public void annotationPointCut() {};
}	
