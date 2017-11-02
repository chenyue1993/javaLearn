package com.chenyue.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chenyue.util.DBUtil;

public class ModifyCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户ID
		//int id = Integer.valueOf(request.getParameter("id"));
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		String realname = request.getParameter("realname");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		System.out.println(id+","+realname+","+birth+","+gender+","+tel);
		//连接数据库删除数据
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String sql = "UPDATE t_customer SET realname = ?,birth = ?,gender = ?,tel = ? WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(5, id);
			ps.setString(1, realname);
			ps.setString(2, birth);
			ps.setString(3, gender);
			ps.setString(4, tel);
			System.out.println(2);
			count = ps.executeUpdate();
			System.out.println(3);
		} catch (SQLException e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally{
			try {
				DBUtil.commitTransaction(conn);
			} catch (SQLException e) {
				DBUtil.rollbackTransaction(conn);
				e.printStackTrace();
			}
			DBUtil.close(conn, ps, null);
		}
		System.out.println(count);
		if (count != 0) {
			System.out.println(1);
			//request.getRequestDispatcher("/list").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/list");
		}
	}
}
