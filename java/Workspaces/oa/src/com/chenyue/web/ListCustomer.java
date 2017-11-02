package com.chenyue.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenyue.entity.Customer;
import com.chenyue.util.DBUtil;

public class ListCustomer extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> customers = new ArrayList<Customer>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select id,realname,birth,gender,tel from t_customer ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String realname = rs.getString("realname");
				String birth = rs.getString("birth");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				Customer customer = new Customer(id, realname, birth, gender, tel);
				customers.add(customer);
			}
			//×ª·¢
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, rs);
		}
	}
}
