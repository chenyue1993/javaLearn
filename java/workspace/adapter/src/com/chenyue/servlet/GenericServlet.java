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
 * GenericServlet��һ��������adapter�������������һ��Servlet
 * �Ժ����Ա����ֱ��ʵ��Servlet�ӿ��ˣ�ȥ�̳�������������ɣ���дservice����
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
	 * ���ڳ�ʼ��ʱ����Ҫִ��һ������ĳ��򣬽�����д�޲�init()����
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
	//�������еķ���������չ�ķ�������������ʹ��
	public ServletContext getServletContext(){
		return getServletContext();
	}
}
