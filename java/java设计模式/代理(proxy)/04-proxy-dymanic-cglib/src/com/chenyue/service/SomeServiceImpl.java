package com.chenyue.service;

//Ŀ����
public class SomeServiceImpl implements ISomeService {

	@Override
	public String doFirst() {
		System.out.println("ִ��doFirst");
		return "abcde";
	}

	@Override
	public void doSecond() {
		System.out.println("ִ��doSecond");
		
	}

}
