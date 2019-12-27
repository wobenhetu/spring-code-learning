package com.spring.testspring.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInovationHandler implements InvocationHandler {

	private Object target;

	public MyInovationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("aop===begin");
		Object result = method.invoke(target);
		System.out.println("aop====after");
		return result;
	}
}
