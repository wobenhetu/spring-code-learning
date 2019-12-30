package com.spring.testspring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

	/*@Pointcut("execution(*  *.test(..))")
	public void test(){

	}*/

	@Pointcut("@annotation(com.spring.testspring.aop.MyNameAnnotation)")
	public void test(){ }

	@Before("test()")
	public void beforeTest(){
		System.out.println("beforeTest");
	}

	@After("test()")
	public void afterTest(){
		System.out.println("afterTest");
	}


	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint){

		System.out.println("before!");

		Object o =  null;

		try {
			o = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		System.out.println("after1");
		return o;
	}
}
