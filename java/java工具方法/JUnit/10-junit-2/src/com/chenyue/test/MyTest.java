package com.chenyue.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
	@Before
	public void before(){
		System.out.println("ִ��before()����");
	}
	
	@After
	public void after(){
		System.out.println("ִ��after()����");
	}
	
	@Test
	public void test01(){
		System.out.println("ִ��test01()����");
	}
}
