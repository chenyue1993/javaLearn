package com.chenyue.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {

	//ÿ�����Է���ִ��֮ǰ����ִ��setUp����
	@Before
	public void setUp() throws Exception {
		System.out.println("ִ��setUp()����");
	}

	//ÿ�����Է���ִ��֮�����ִ��tearDown����
	@After
	public void tearDown() throws Exception {
		System.out.println("ִ��tearDown()����");
	}
	
	//����ǩ��������public
	@Test
	public void test01() {
		System.out.println("ִ��test01()����");
	}
	@Test
	public void test02() {
		System.out.println("ִ��test02()����");
	}
	@Test
	public void test03() {
		System.out.println("ִ��test03()����");
	}

}
