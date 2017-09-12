package com.chenyue.test;

import org.junit.Before;
import org.junit.Test;

import com.chenyue.beans.Student;
import com.chenyue.dao.IStudentDao;
import com.chenyue.dao.StudentDaoImpl;

public class MyTest {
	IStudentDao dao;
	@Before
	public void before(){
		dao = new StudentDaoImpl();
	}
	
	@Test
	public void test1Insert(){
		Student student = new Student("ут",23,95.5);
		dao.insertStu(student);
	}

	
}
