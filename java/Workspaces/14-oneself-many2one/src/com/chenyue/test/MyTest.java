package com.chenyue.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes.Name;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenyue.beans.NewsLabel;
import com.chenyue.dao.INewsLabelDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private INewsLabelDao dao;
	private SqlSession sqlSession;
	
	@Before
	public void before(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(INewsLabelDao.class);
	}
	
	@After
	public void after(){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test0selectMyself(){
		NewsLabel newsLabel = dao.selectMyself(4);
		System.out.println(newsLabel);
		
	}
	
	@Test
	public void test1INewsLabelDao(){
		NewsLabel newsLabel = dao.selectParentByChild(6);
		System.out.println(newsLabel);
		
	}
	
	@Test
	public void test2INewsLabelDao(){
		NewsLabel newsLabel = dao.selectNewsLabelById(2);
		System.out.println(newsLabel);
	}
}
