package com.chenyue.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class AServlet implements Servlet {
	
	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("1..................");
		ServletConfig config = getServletConfig();
		System.out.println(config.toString());
//		String url = config.getInitParameter("url");
//		System.out.println(url);
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+" = "+value);
		}
		ServletContext context = config.getServletContext();
		String path = context.getRealPath("/index.html");
		System.out.println(path);
		context.setAttribute("name", "chenyue");
		names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = context.getInitParameter(name);
			System.out.println(name+" = "+value);
		}
	}
	
	@Override
	public void destroy() {


	}

	@Override
	public ServletConfig getServletConfig() {

		return config;
	}

	@Override
	public String getServletInfo() {

		return null;
	}


}
