package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Forward extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//向request范围中存储数据
		req.setAttribute("username", "张三");
		
		//转发forward：一次请求
		//req.getRequestDispatcher("/r").forward(req, resp);
		
		//重定向redirect：两次请求
		//执行到此处后将这个路径"./r"响应给浏览器，浏览器又向服务器发送了一个全新的请求
		resp.sendRedirect("./r");
	}
}
