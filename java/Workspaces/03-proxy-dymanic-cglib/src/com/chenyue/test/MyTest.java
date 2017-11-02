package com.chenyue.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.chenyue.factory.MyCGLIBFactory;

import com.chenyue.service.SomeService;

public class MyTest {
	public static void main(String[] args) {
		SomeService service =new MyCGLIBFactory().MyCGLIBCreator();
	
		String result = service.doFirst();
		System.out.println("result:"+result);
		service.doSecond();
		result = service.doThird();
		System.out.println("result:"+result);
	}
}
