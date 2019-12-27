package com.spring.testspring.jdkproxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MyQueryBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if(beanName.equals("myInterfacesIml")){
			//这里bean ”myInterfacesIml“实现了两个接口，下面的索引就代表接口的索引；
			/*Class<?> cl = bean.getClass().getInterfaces()[0];
			Class<?> cl2 = bean.getClass().getInterfaces()[1];
			Class<?>[] cs = new Class[]{cl,cl2};*/

			Class<?>[] cs = new Class[bean.getClass().getInterfaces().length];
			for (int i=0;i<bean.getClass().getInterfaces().length;i++){
				cs[i] = bean.getClass().getInterfaces()[i];
			}
			//返回一个代理对象
			Object o = Proxy.newProxyInstance(MyQueryBeanPostProcessor.class.getClassLoader(),cs,new MyInovationHandler(bean));
			return o;
		}
		return bean;
	}
}
