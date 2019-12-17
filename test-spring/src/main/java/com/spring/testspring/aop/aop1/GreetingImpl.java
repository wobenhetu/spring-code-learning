package com.spring.testspring.aop.aop1;

public class GreetingImpl implements Greeting {
 
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }

}