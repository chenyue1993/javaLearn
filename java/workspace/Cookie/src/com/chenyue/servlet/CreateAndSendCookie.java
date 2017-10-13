package com.chenyue.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSendCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//����Cookie����,��javascriptҲ���Դ���Cookie
		Cookie cookie1 = new Cookie("username", "zhangsan");
		Cookie cookie2 = new Cookie("password", "123");
		
		//Cookie���ù���·��
		//cookie1.setPath(req.getContextPath()+"/king");
		
		//����Cookie����Чʱ��
		cookie1.setMaxAge(10*24*60*60);
		cookie2.setMaxAge(60*60);
		
		//��Cookie�����͸��������
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
	}
}
