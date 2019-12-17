package com.spring.testspring.aop.aop1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class TestBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("dfw===before advice");
	}
}
