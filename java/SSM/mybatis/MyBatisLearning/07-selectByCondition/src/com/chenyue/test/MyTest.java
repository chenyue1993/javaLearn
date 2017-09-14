package com.chenyue.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenyue.beans.Student;
import com.chenyue.dao.IStudentDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private IStudentDao dao;
	private SqlSession sqlSession;
	
	@Before
	public void before(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@After
	public void after(){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test6SelectStudentByCondition(){
		List<Student> students = dao.selectStudentsByCondition("Ëï", 24);
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
