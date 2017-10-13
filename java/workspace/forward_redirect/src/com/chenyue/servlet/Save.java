package com.chenyue.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Save extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码
		req.setCharacterEncoding("utf-8");
		//获取表单数据
		String usercode = req.getParameter("usercode");
		String username = req.getParameter("username");
		//jdbc
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			conn.setAutoCommit(false);
			String sql = "insert into t_user(usercode,username) value(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usercode);
			stmt.setString(2, username);
			count = stmt.executeUpdate();
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(count == 1){
			//保存成功，“跳转”到成功页面
			//转发
			req.getRequestDispatcher("/success.html").forward(req, resp);
			//重定向
			resp.sendRedirect("./success.html");
		}
		
		
	}
}
