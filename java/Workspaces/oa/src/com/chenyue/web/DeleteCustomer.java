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

import com.chenyue.util.DBUtil;

public class DeleteCustomer extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户ID
		//int id = Integer.valueOf(request.getParameter("id"));
		String id = request.getParameter("id");
		//连接数据库删除数据
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String sql = "DELETE FROM t_customer WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			count = ps.executeUpdate();
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
		if (count != 0) {
			request.getRequestDispatcher("/list").forward(request, response);
		}
	}
}
