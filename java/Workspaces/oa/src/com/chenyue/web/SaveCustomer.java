package com.chenyue.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chenyue.util.DBUtil;


public class SaveCustomer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户信息
		request.setCharacterEncoding("utf-8");
		String realname = request.getParameter("realname");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		
		//JDBC连接数据库保存数据
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String sql = "insert into t_customer(realname,birth,gender,tel) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, realname);
			ps.setString(2, birth);
			ps.setString(3, gender);
			ps.setString(4, tel);
			count = ps.executeUpdate();
			DBUtil.commitTransaction(conn);
		} catch (SQLException e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, null);
		}
		//保存成功跳转到成功页面
		if (count == 1) {
			System.out.println("保存");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
}
