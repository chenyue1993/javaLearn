package dao;

import java.util.List;
import java.util.Map;

import beans.Student;

public interface IStudentDao {
	void savaStudent(Student student);
	void saveStudentCacheId(Student student);
	
	void removeStudentById(Integer id);
	void updateStudentById(Student student);
	
	List<Student> selectAllStudents();
	Map<String, Student> selectAllStudentsMap();
	
	Student selectStudentById(Integer id);
	List<Student> selectStudentByName(String name);
}
