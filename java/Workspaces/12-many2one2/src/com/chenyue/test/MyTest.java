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

import com.chenyue.beans.Country;
import com.chenyue.beans.Minister;
import com.chenyue.dao.IMinisterDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private IMinisterDao dao;
	private SqlSession sqlSession;
	
	@Before
	public void before(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IMinisterDao.class);
	}
	
	@After
	public void after(){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test1selectCountryById(){
		Minister minister = dao.selectMinisterById(2);
		System.out.println(minister);
	}
}
