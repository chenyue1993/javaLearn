package com.chenyue.test;



import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenyue.beans.Country;
import com.chenyue.beans.Minister;
import com.chenyue.dao.ICountryDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private ICountryDao dao;
	private SqlSession sqlSession;
	
	@Before
	public void before(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
	}
	
	@After
	public void after(){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	//在配置文件设置延迟加载settings
	//lazyLoadingEnabled打开延迟加载
	//默认aggressiveLazyLoading侵入式加载
	@Test
	public void test1selectCountryById(){//直接加载
		Country country = dao.selectCountryById(2);
		System.out.println(country.getCname());
		Set<Minister> ministers = country.getMinisters();
		System.out.println(ministers.size());
	}
	
	@Test
	public void test2selectCountryById(){//侵入式延迟
		Country country = dao.selectCountryById(2);
		System.out.println(country.getCname());
		Set<Minister> ministers = country.getMinisters();
		System.out.println(ministers.size());
	}
	
	@Test
	public void test3selectCountryById(){//深度延迟
		Country country = dao.selectCountryById(2);
		System.out.println(country.getCname());
		Set<Minister> ministers = country.getMinisters();
		System.out.println(ministers.size());
	}

}
