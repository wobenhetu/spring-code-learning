package com.spring.testspring.beanpostprocessor;

import com.spring.testspring.beans.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Component;


/*
BeanPostProcessor接口的作用是在Spring容器完成Bean实例化前后可以添加一些自己的逻辑处理，我们可以定义一个或者多个BeanPostProcessor接口的实现。

BeanPostProcessor接口提供了两个方法：

1、postProcessBeforeInitialization  可以对Bean在实例化之前添加一些逻辑处理

2、postProcessAfterInitialization  可以对bean在实例化之后添加一些逻辑处理

（1）BeanFactoryPostProcessor和普通的bean一样注册到spring容器中。
（2）获取所有的BeanFactoryPostProcessor类型的类并初始化，添加到列表中
（3）在列表中循环执行所有的BeanFactoryPostProcessor实现类。
*/
@Component
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
