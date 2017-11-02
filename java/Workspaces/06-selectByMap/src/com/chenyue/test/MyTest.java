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

import com.chenyue.beans.Student;
import com.chenyue.dao.IStudentDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private IStudentDao dao;
	private Student student;
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nameCondition", "Ëï");
		map.put("ageCondition", 23);
		student = new Student();
		student.setScore(95.0);
		map.put("student", student);
		List<Student> students = dao.selectStudentsByMap(map);
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
