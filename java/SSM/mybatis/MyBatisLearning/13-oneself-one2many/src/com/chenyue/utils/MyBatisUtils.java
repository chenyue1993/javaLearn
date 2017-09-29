package com.chenyue.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtils {
	
	//单例，当涉及修改数据是要注意线程安全
	//private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;

	public static SqlSession getSqlSession(){
//		try {
//			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			sqlSession = sqlSessionFactory.openSession();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally{
//			return sqlSession;
//		}
		try {
			if (sqlSession == null) {
				InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				sqlSession = sqlSessionFactory.openSession();
				return sqlSession;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
}
