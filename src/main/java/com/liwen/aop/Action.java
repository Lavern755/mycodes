package com.liwen.aop;

import java.lang.annotation.Documented;

/**
 * 元数据,解释数据的数据
 * @author Administrator
 *
 */
@Documented
public @interface Action {
	String name();
}
