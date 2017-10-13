package com.chenyue.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+":"+password);
		
		resp.setContentType("text/html;charset=utf-8");
//		Properties properties = new Properties();
//		FileReader fileReader = new FileReader(req.getContextPath()+"\\WEB-INF\\config.properties");
//		properties.load(fileReader);
//		String className = properties.getProperty("class");
//		String url = properties.getProperty("url");
//		String userString = properties.getProperty("username");
//		String passwordsString = properties.getProperty("password");
//		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
//			Class.forName(className);
//			conn = DriverManager.getConnection(url,userString,passwordsString);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");

			String sql = "select * from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(1);
				flag = true;
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
			if (ps != null){
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
		}
		
		if (flag) {
			System.out.println(1);
			Cookie cookie1 = new Cookie("name",username);
			Cookie cookie2 = new Cookie("password", password);
			cookie1.setMaxAge(60*60);
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);
			resp.sendRedirect("./welcome");
		}else {
			System.out.println(2);
			Cookie cookie1 = new Cookie("name",username);
			Cookie cookie2 = new Cookie("password", password);
			cookie1.setMaxAge(60*60);
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);
			req.getRequestDispatcher("./error").forward(req, resp);
		}
	}
}
