package com.spring.testspring.beans;


import org.springframework.stereotype.Component;

@Component
public class Student {

	public String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name;

}
