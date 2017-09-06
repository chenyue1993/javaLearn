package com.chenyue.test;

import com.chenyue.proxy.SomeServiceProxy;
import com.chenyue.service.ISomeService;
import com.chenyue.service.SomeServiceImpl;

public class MyTest {
	public static void main(String[] args) {
		ISomeService service = new SomeServiceImpl();
		String result = service.doFirst();
		System.out.println("result:"+result);
		service.doSecond();
		
		SomeServiceProxy proxy = new SomeServiceProxy();
		System.out.println("result:"+proxy.doFirst());
	}
}
