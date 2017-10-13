package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * GenericServlet是一个适配器adapter，这个适配器是一个Servlet
 * 以后程序员无需直接实现Servlet接口了，去继承这个适配器即可，重写service方法
 * @author Administrator
 *
 */
public abstract class GenericServlet implements Servlet {

	private ServletConfig config;
	
	@Override
	public final void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}
	/**
	 * 若在初始化时刻需要执行一段特殊的程序，建议重写无参init()方法
	 */
	public void init(){
		
	}
	@Override
	public abstract void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException;
	
	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		//author,version,copyright
		return "";
	}
	
	//.........
	//以下所有的方法都是扩展的方法，方便子类使用
	public ServletContext getServletContext(){
		return getServletContext();
	}
}
