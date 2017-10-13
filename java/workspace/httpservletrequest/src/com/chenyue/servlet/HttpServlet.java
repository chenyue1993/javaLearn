package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest hRequest = (HttpServletRequest)req;
		HttpServletResponse hResponse = (HttpServletResponse)res;
		service(hRequest, hResponse);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String method = request.getMethod();
		if ("GET".equals(method)) {
			doGet(request,response);
		}else if("POST".equals(method)){
			doPost(request,response);
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html;charset=utf8");
		response.getWriter().print("405-您应该发送GET请求");
		throw new RuntimeException("405-您应该发送GET请求");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html;charset=utf8");
		response.getWriter().print("405-您应该发送POST请求");
		throw new RuntimeException("405-您应该发送POST请求");
	}
}
