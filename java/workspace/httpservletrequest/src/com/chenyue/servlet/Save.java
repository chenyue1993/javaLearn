package com.chenyue.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Save extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//��ȡ�û���Ϣ�����ύ����Щ���ݱ��Զ���װ��HttpServletRequest��
		//��HttpServletRequest�л�ȡ��Щ��Ϣ
		//�������������ĸ�ʽ�ύ�ģ�post�������������ύ�����ݸ�ʽ��
		//username=admin&password=123&interest=sport&interest=music...
		/*
		 * Map<String,String[]>
		 */

		String username = request.getParameter("username");
		System.out.println(username);
		String gender = request.getParameter("gender");
		System.out.println(gender);
		Map<String,String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String[] values = map.get(key);
			System.out.println(key+" = ");
			for (String valueString : values) {
				System.out.println(valueString+"\\tr");
			}
			System.out.println(key+"--"+values);
		}
		String[] interests = request.getParameterValues("interest");
		for (String string : interests) {
			System.out.println(string);
		}
	}
}
