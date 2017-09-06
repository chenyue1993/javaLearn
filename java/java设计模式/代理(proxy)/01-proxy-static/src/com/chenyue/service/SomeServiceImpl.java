package com.chenyue.service;

//目标类
public class SomeServiceImpl implements ISomeService {

	@Override
	public String doFirst() {
		System.out.println("执行doFirst");
		return "abcde";
	}

	@Override
	public void doSecond() {
		System.out.println("执行doSecond");
		
	}

}
