package com.chenyue.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.chenyue.beans.Student;
import com.chenyue.dao.IStudentDao;
import com.chenyue.dao.StudentDaoImpl;

public class MyTest {
	private IStudentDao dao;
	private Student student;
	@Before
	public void before(){
		dao = new StudentDaoImpl();
		student = new Student("孙4",24,95.5);
	}
	
	@Test
	public void test1Insert(){
		dao.insertStu(student);
	}
	
	@Test
	public void test2Insert(){
		System.out.println("插入前：student"+student);
		dao.insertStudentCacheId(student);
		System.out.println("插入后：student"+student);
	}
	
	@Test
	public void test3Delete(){
		dao.deleteStudentById(3);
	}
	
	@Test
	public void test4Update(){
		student.setId(16);
		dao.updateStudent(student);
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
	
	@Test
	public void test4SelectAllStudentsMap(){
		Map<String, Student> students = dao.selectAllStudentsMap();
		if (students != null) {
			Set<String> keys = students.keySet();
			for (String key : keys) {
				Student student = students.get(key);
				System.out.println(key+"--"+student);
			}
		}
	}
	
	@Test
	public void test5SelectStudentById(){
		Student student = dao.selectStudentById(1);
		System.out.println(student);
	}
	
	@Test
	public void test6SelectStudentByName(){
		List<Student> students = dao.selectStudentByName("张");
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
