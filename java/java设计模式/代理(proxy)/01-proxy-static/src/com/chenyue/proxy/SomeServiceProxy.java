package com.chenyue.proxy;

import com.chenyue.service.ISomeService;
import com.chenyue.service.SomeServiceImpl;
//代理类
public class SomeServiceProxy implements ISomeService{
	private  ISomeService target;
	
	public SomeServiceProxy(){
		target = new SomeServiceImpl();
	}

	@Override
	public String doFirst() {
		//创建目标对象
		//调用目标方法
		String result = target.doFirst();
		//增强
		return result.toUpperCase();
	}

	@Override
	public void doSecond() {
		target.doSecond();
		
	}
	
}
