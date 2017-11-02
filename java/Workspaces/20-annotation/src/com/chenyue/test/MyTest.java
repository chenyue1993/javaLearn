package com.chenyue.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chenyue.beans.Student;
import com.chenyue.dao.IStudentDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private static IStudentDao dao;
	private Student student;
	private static SqlSession sqlSession;
	
	@BeforeClass
	public static void before(){	
		sqlSession = MyBatisUtils.getSqlSession();
		System.out.println(sqlSession);
		dao = sqlSession.getMapper(IStudentDao.class);
		
	}
	
	@Before
	public void before1(){
		student = new Student("孙8",24,95.5);
	}
	
	@AfterClass
	public static void after(){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test1Insert(){
		dao.insertStudent(student);
	    sqlSession.commit();
	}
	
	@Test
	public void test2Insert(){
		System.out.println("插入前：student"+student);
		dao.insertStudentCacheId(student);
		System.out.println("插入后：student"+student);
		sqlSession.commit();
	}
	
	@Test
	public void test3Delete(){
		dao.deleteStudentById(1);
		sqlSession.commit();
	}
	
	@Test
	public void test4Update(){
		student.setId(2);
		dao.updateStudent(student);
		sqlSession.commit();
	}
		
	@Test
	public void test4SelectAll(){
		List<Student> students = dao.selectAllStudents();
		if (students != null) {
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
//	@Test
//	public void test4SelectAllStudentsMap(){
//		Map<String, Student> students = dao.selectAllStudentsMap();
//		if (students != null) {
//			Set<String> keys = students.keySet();
//			for (String key : keys) {
//				Student student = students.get(key);
//				System.out.println(key+"--"+student);
//			}
//		}
//	}
	
	@Test
	public void test5SelectStudentById(){
		Student student = dao.selectStudentById(2);
		System.out.println(student);
	}
	
	@Test
	public void test6SelectStudentByName(){
		List<Student> students = dao.selectStudentByName("孙");
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
