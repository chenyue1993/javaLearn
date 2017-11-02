package com.chenyue.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {

	//每个测试方法执行之前会先执行setUp方法
	@Before
	public void setUp() throws Exception {
		System.out.println("执行setUp()测试");
	}

	//每个测试方法执行之后会先执行tearDown方法
	@After
	public void tearDown() throws Exception {
		System.out.println("执行tearDown()测试");
	}
	
	//方法签名必须是public
	@Test
	public void test01() {
		System.out.println("执行test01()测试");
	}
	@Test
	public void test02() {
		System.out.println("执行test02()测试");
	}
	@Test
	public void test03() {
		System.out.println("执行test03()测试");
	}

}
