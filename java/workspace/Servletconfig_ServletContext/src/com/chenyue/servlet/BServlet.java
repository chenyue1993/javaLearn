package com.chenyue.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet {
	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;

	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+" = "+value);
		}
		ServletContext context = config.getServletContext();
		String nameString = (String) context.getAttribute("name");
		System.out.println(nameString);
		res.getWriter().print(nameString);
		String path = context.getRealPath("/b");
		System.out.println(path);
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
