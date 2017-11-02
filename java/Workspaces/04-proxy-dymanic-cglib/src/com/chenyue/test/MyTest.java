package com.chenyue.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.chenyue.factory.MyCGLIBFactory;

import com.chenyue.service.ISomeService;

public class MyTest {
	public static void main(String[] args) {
		ISomeService service =new MyCGLIBFactory().MyCGLIBCreator();
	
		String result = service.doFirst();
		System.out.println("result:"+result);
		service.doSecond();
		System.out.println("result:"+result);
	}
}