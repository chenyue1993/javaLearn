package com.chenyue;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		System.out.println(req.getContextPath());
		//InputStream in = getClass().getResourceAsStream("/DBconfig.properties");
		InputStream in  = this.getClass().getClassLoader().getResourceAsStream("DBconfig.properties"); 

		Properties properties = new Properties();
		properties.load(in);
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String DBUsername = properties.getProperty("DBUsername");
		String DBPassword = properties.getProperty("DBPassword");
		System.out.println("driver="+driver+"\nurl="+url+"\nDBUsername="+DBUsername+"\nDBPassword="+DBPassword);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,DBUsername,DBPassword);
			String sql = "select * from t_user" +
					" where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
		}
		if(flag){
			HttpSession session = req.getSession();

			session.setAttribute("username", username);
			resp.sendRedirect("./index.html");
			return;
			
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
		out.close();
	}
}
