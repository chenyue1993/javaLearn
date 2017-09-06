package com.chenyue.factory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.chenyue.service.ISomeService;
import com.chenyue.service.SomeServiceImpl;

public class MyCGLIBFactory implements MethodInterceptor{
	
	private ISomeService target;

	public MyCGLIBFactory() {
		super();
		target = new SomeServiceImpl();
	}

	public ISomeService MyCGLIBCreator(){
		//������ǿ������
		Enhancer enhancer = new Enhancer();
		//ָ��Ŀ���࣬������
		enhancer.setSuperclass(ISomeService.class);
		//���ûص��ӿڶ���
		enhancer.setCallback(this);
		return (ISomeService)enhancer.create();
	}

	//�ص�����
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		//����Ŀ�귽��
		Object result = method.invoke(target, args);
		if (result != null) {
			result = ((String) result).toUpperCase();
		}
		return result;
	}
}
