package com.chenyue.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.chenyue.service.ISomeService;
import com.chenyue.service.SomeServiceImpl;

public class MyTest {
	public static void main(String[] args) {
		//ʹ��JDK��proxy��̬����Ҫ��Ŀ�������ʵ�ֽӿ�
		//��Ϊ��ײ��ִ��ԭ���뾲̬������ͬ
		final ISomeService target = new SomeServiceImpl();
		ISomeService service = (ISomeService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 	//Ŀ������������
				target.getClass().getInterfaces(), 		//Ŀ������ʵ�ֵ����нӿ�
				new InvocationHandler() {				//�����ڲ���
					//proxy	:�������
					//method:Ŀ�귽��
					//args	:Ŀ�귽���Ĳ���
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						//����Ŀ�귽��
						Object result = method.invoke(target, args); 
						if (result != null) {
							result = ((String) result).toUpperCase();
						}
						return result;
					}
				});
		String result = service.doFirst();
		System.out.println("result"+result);
		service.doSecond();
	}
}
