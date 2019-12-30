package com.spring.testspring.aop;


import org.springframework.stereotype.Component;

@Component("test2")
public class TestBean2 {

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	private String testStr = "testStr2";


	public void test(){
		System.out.println("testbean2");
	}
}
