package com.chenyue.test;

import java.util.ArrayList;
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
	public void test6SelectStudentByIf(){
		Student student1 = new Student("Ëï", null, 0.0);
//		Student student1 = new Student("Ëï", 23, 0.0);
		List<Student> students = dao.selectStudentsByIf(student1);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test6SelectStudentByWhere(){
		Student student1 = new Student("Ëï", null, 0.0);
//		Student student1 = new Student("Ëï", 23, 0.0);
		List<Student> students = dao.selectStudentsByIf(student1);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test6SelectStudentByChoose(){
		Student student1 = new Student(null, null, null);
//		Student student1 = new Student("Ëï", 23, 0.0);
		List<Student> students = dao.selectStudentsByChoose(student1);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test6SelectStudentByForeach(){
		int[] ids = {1, 3};
		List<Student> students = dao.selectStudentsByForeach(ids);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test6SelectStudentByForeachList(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		List<Student> students = dao.selectStudentsByForeachList(ids);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test6SelectStudentByForeachListObject(){
		Student stu1  = new Student();
		stu1.setId(1);
		Student stu2  = new Student();
		stu2.setId(2);
		Student stu3  = new Student();
		stu3.setId(3);
		List<Student> stus = new ArrayList<Student>();
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		
		List<Student> students = dao.selectStudentsByForeachListObject(stus);
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
