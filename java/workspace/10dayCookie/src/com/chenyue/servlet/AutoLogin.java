package com.chenyue.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String autoLogin = req.getParameter("tendayautologinflag");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean loginSuccess = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
			String sql = "select * from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				loginSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
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
			if(loginSuccess){
				if ("ok".equals(autoLogin)) {
					Cookie cookie1 = new Cookie("username", username);
					Cookie cookie2 = new Cookie("password", password);
					cookie1.setMaxAge(10*24*60*60);
					cookie2.setMaxAge(10*24*60*60);
					resp.addCookie(cookie1);
					resp.addCookie(cookie2);
				}
				resp.sendRedirect("./welcome.html");
			}else {
				resp.sendRedirect("./error");
			}
		}
	}
}
