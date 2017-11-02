package com.chenyue.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * JDBC�����࣬����JDBC����
 * @author chenyuecns
 *
 */
public class DBUtil {
	//�������еĹ��췽��һ�㶼��˽�еģ���Ϊ�������еķ������Ǿ�̬����������Ҫnew����
	private DBUtil(){}
	
	//��̬������еĳ���������ص�ʱ��ִֻ��һ��
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "123";
		Connection conn = DriverManager.getConnection(url, username , password);
		return conn;
	}
	/**
	 * �ر���Դ
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,Statement ps,ResultSet rs){
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
	/**
	 * ��������
	 * @param conn
	 * @throws SQLException
	 */
	public static void beginTransaction(Connection conn) throws SQLException{
		if (conn != null) {
			conn.setAutoCommit(false);
		}
	}
	/**
	 * �ύ����
	 * @param conn
	 * @throws SQLException
	 */
	public static void commitTransaction(Connection conn) throws SQLException{
		if (conn != null) {
			conn.commit();
		}
	}
	/**
	 * �ع�����
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn){
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
