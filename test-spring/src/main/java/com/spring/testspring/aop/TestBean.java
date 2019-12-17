package com.spring.testspring.aop;

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