package com.spring.testspring;

import com.spring.testspring.aop.TestBean;
import com.spring.testspring.aop.TestBean2;
import com.spring.testspring.beans.Student;
import org.junit.Test;
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
		TestBean testBean = (TestBean) bf.getBean("test");
		testBean.test();

		TestBean2 testBean2 = (TestBean2) bf.getBean("test2");
		testBean2.test();
	}
}