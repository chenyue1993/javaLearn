package com.chenyue.factory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.chenyue.service.SomeService;

public class MyCGLIBFactory implements MethodInterceptor{
	
	private SomeService target;

	public MyCGLIBFactory() {
		super();
		target = new SomeService();
	}

	public SomeService MyCGLIBCreator(){
		//创建增强器对象
		Enhancer enhancer = new Enhancer();
		//指定目标类，即父类
		enhancer.setSuperclass(SomeService.class);
		//设置回调接口对象
		enhancer.setCallback(this);
		return (SomeService)enhancer.create();
	}

	//回调方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		//调用目标方法
		Object result = method.invoke(target, args);
		if (result != null) {
			result = ((String) result).toUpperCase();
		}
		return result;
	}
}
