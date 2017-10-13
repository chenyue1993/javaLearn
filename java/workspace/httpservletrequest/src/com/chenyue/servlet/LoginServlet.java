package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest hRequest = (HttpServletRequest)req;
		HttpServletResponse hResponse = (HttpServletResponse)res;
		String method = hRequest.getMethod();
		System.out.println(method);
	}

}
