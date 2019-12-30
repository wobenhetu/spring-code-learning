package com.spring.testspring;

import com.spring.testspring.aop.TestBean;
import com.spring.testspring.aop.TestBean2;
import com.spring.testspring.aop.aop1.*;
import com.spring.testspring.beans.Student;
import com.spring.testspring.jdkproxy.MyInterfaces;
import com.spring.testspring.jdkproxy.MyInterfaces2;
import com.spring.testspring.jdkproxy.MyInterfacesIml;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansTest {


    @Test
    public void testStudent(){
		System.out.println("dfw==");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		Student student = (Student) applicationContext.getBean("student");
		System.out.println(student.getName()+"  年龄："+student.getAge());
    }

    @Test
    public void testAop(){
		System.out.println("dfw==main");
		ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		//被代理
		TestBean testBean = (TestBean) bf.getBean("test");
		testBean.test();

		//未被代理
		TestBean2 testBean2 = (TestBean2) bf.getBean("test2");
		testBean2.test();
	}

	@Test
	public void testAopAdvice(){
		ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
		proxyFactory.setTarget(new GreetingImpl());         // 射入目标类对象
		proxyFactory.addAdvice(new TestBeforeAdvice()); // 添加前置增强
		proxyFactory.addAdvice(new TestAfterAdvice());  // 添加后置增强

		Greeting greeting = (Greeting) proxyFactory.getProxy(); // 从代理工厂中获取代理
		greeting.sayHello("Jack");
	}


	/*
	* 对类的增强叫做 Introduction（引入）。而 Introduction Advice（引入增强）就是对类的功能增强;
	* 不想在代码中让 GreetingImpl 直接去实现这个接口，我想在程序运行的时候动态地实现它。
	* 因为假如我实现了这个接口，那么我就一定要改写 GreetingImpl 这个类，
	* 关键是我不想改它，或许在真实场景中，这个类有1万行代码，
	* 我实在是不敢动了。于是，我需要借助 Spring 的引入增强
	*
	* */
	@Test
	public void testReferenceAdvice(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:reference-advice.xml");
		GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy"); // 注意：转型为目标类，而并非它的 Greeting 接口
		greetingImpl.sayHello("Jack");

		Apology apology = (Apology) greetingImpl; // 将目标类强制向上转型为 Apology 接口（这是引入增强给我们带来的特性，也就是“接口动态实现”功能）
		apology.saySorry("Jack");
	}


	@Test
	public void testBeanPostProcessor(){

		System.out.println("dfw==");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		Student student = (Student) applicationContext.getBean("student");
		System.out.println(student.getName()+"  年龄："+student.getAge());
	}

	/*
	* 测试jdk动态代理
	* */
	@Test
	public void testJDKProxy(){
		System.out.println("dfw==");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		MyInterfaces2 myInterfacesIml = (MyInterfaces2) applicationContext.getBean("myInterfacesIml");
		myInterfacesIml.query2();

		MyInterfaces myInterfaces = (MyInterfaces) applicationContext.getBean("myInterfacesIml");
		myInterfaces.query();
		myInterfaces.insert();

	}
}