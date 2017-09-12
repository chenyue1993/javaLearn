package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Student;

import dao.IStudentDao;
import dao.StudentDaoImpl;

public class MyTest {
	
	private IStudentDao studentDao;

	@Before
	public void before(){
		studentDao = new StudentDaoImpl();
	}
	
	@After
	public void after(){
		
	}
	
	@Test
	public void testSaveStudent(){
		studentDao.saveStudent(new Student("¿Ó", 25, 100));
	}
}
