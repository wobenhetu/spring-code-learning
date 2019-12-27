package com.spring.testspring.jdkproxy;

import org.springframework.stereotype.Component;

@Component("myInterfacesIml")
public class MyInterfacesIml implements MyInterfaces,MyInterfaces2 {

	public MyInterfacesIml() {

		System.out.println("MyInterfacesIml Init!!!");
	}

	@Override
	public void query() {
		System.out.println("dfw====query==原方法输出内容");
	}

	@Override
	public void insert() {
		System.out.println("dfw====insert==原方法输出内容");
	}

	@Override
	public void query2() {
		System.out.println("dfw====query2==原方法输出内容");
	}
}
