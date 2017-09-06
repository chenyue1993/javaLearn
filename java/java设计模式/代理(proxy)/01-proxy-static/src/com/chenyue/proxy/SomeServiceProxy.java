package com.chenyue.proxy;

import com.chenyue.service.ISomeService;
import com.chenyue.service.SomeServiceImpl;
//������
public class SomeServiceProxy implements ISomeService{
	private  ISomeService target;
	
	public SomeServiceProxy(){
		target = new SomeServiceImpl();
	}

	@Override
	public String doFirst() {
		//����Ŀ�����
		//����Ŀ�귽��
		String result = target.doFirst();
		//��ǿ
		return result.toUpperCase();
	}

	@Override
	public void doSecond() {
		target.doSecond();
		
	}
	
}
