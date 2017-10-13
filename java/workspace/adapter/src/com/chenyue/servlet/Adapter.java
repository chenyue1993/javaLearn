package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

abstract public class Adapter implements Servlet {

	@Override
	abstract public void destroy();

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	abstract public void init(ServletConfig arg0) throws ServletException;

	@Override
	abstract public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException ;

}
