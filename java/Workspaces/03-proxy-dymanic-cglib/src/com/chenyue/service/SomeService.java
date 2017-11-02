package com.chenyue.service;

//目标类
public class SomeService{


	public String doFirst() {
		System.out.println("执行doFirst");
		String[] nums = new String[6];
		return "abcde";
	}


	public void doSecond() {
		System.out.println("执行doSecond");
		
	}
	 
	public String doThird(){
		System.out.println("执行doThird");
		return "doThird";
	}
}
