package test;

import org.junit.Before;
import org.junit.Test;

import dao.IStudnetDao;
import dao.StudentDao;

import beans.Student;

public class MyTest {
	private Student student;
	private IStudnetDao studentDao;
	
	@Before
	public void before(){
		String name = "ут";
		int age = 25;
		double score = 95.5;
		student = new Student(name, age, score);
		studentDao = new StudentDao();
	}
	
	@Test
	public void TestSave(){
		studentDao.saveStudent(student);
	}
}
