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
		//��request��Χ�д洢����
		req.setAttribute("username", "����");
		
		//ת��forward��һ������
		//req.getRequestDispatcher("/r").forward(req, resp);
		
		//�ض���redirect����������
		//ִ�е��˴������·��"./r"��Ӧ�����������������������������һ��ȫ�µ�����
		resp.sendRedirect("./r");
	}
}
