package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private String username;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf8");
		//局部变量(无线程安全问题)
		//String username = req.getParameter("username");
		
		//实例变量
		synchronized (this) {
			username = req.getParameter("username");
		}
		resp.getWriter().print("恭喜你"+username+"注册成功");
	}
}
