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
		//�ֲ�����(���̰߳�ȫ����)
		//String username = req.getParameter("username");
		
		//ʵ������
		synchronized (this) {
			username = req.getParameter("username");
		}
		resp.getWriter().print("��ϲ��"+username+"ע��ɹ�");
	}
}
