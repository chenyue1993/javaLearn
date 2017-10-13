package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Character extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
//		byte[] bytes = name.getBytes("ISO-8859-1");
//		name = new String(bytes);
		System.out.println(name);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(name);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		String name = req.getParameter("name");
		System.out.println(name);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(name);
	}
}
