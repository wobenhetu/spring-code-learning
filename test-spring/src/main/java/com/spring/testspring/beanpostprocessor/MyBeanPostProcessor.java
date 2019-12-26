package com.spring.testspring.beanpostprocessor;

import com.spring.testspring.beans.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Component;


public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("对象"+beanName+"开始实例化");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if(bean instanceof Student){
			Student stu = (Student) bean;
			stu.setAge("23");
			stu.setName("laoli");
		}
		System.out.println("对象"+beanName+"实例化完成");
		return bean;
	}
}
