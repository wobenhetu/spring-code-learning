package com.spring.testspring.aop;


import org.springframework.stereotype.Component;

@Component("test")
public class TestBean {

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	private String testStr = "testStr";


	@MyNameAnnotation
	public void test(){
		System.out.println("test");
	}

}