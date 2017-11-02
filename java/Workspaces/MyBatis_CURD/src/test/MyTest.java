package test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Utils.MybatisUtils;
import beans.Student;

import dao.IStudentDao;

public class MyTest {
	IStudentDao dao;
	Student student; 
	
	@Before
	public void before(){
		dao = MybatisUtils.getSqlSession().getMapper(IStudentDao.class);
		student = new Student("1÷‹23",14,95.5);
	}
	
	@Test
	public void savaStudent(){
		dao.savaStudent(student);
	}
	
	@Test
	public void saveStudentCacheId(){
		dao.saveStudentCacheId(student);
	}
	
	@Test
	public void removeStudentById(){
		dao.removeStudentById(1);
	}
	
	@Test
	public void updateStudentById(){
		student.setId(7);
		dao.updateStudentById(student);
	}
	
	@Test
	public void selectAllStudents(){
		List<Student> students = dao.selectAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void selectStudentByName(){
		List<Student> students = dao.selectStudentByName("÷‹");
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void selectAllStudentsMap(){
		Map<String, Student> students = dao.selectAllStudentsMap();
		Set<String> keys = students.keySet();
		for (String key : keys) {
			System.out.println(students.get(key));
		}
	}
	
	@Test
	public void selectStudentById(){
		Student student = dao.selectStudentById(2);
	}
	
}
