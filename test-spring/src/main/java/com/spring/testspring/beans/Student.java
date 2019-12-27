package com.spring.testspring.beans;


import org.springframework.stereotype.Component;

@Component("student")
public class Student {

	public String age;

	public Student() {

		System.out.println("student init!!!");
	}

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
