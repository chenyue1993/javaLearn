package com.chenyue.dao;

import java.util.List;
import java.util.Map;

import com.chenyue.beans.Student;

public interface IStudentDao {
	void insertStu(Student student);
	void insertStudentCacheId(Student student);
	
	void deleteStudentById(Integer id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Map<String, Student> selectAllStudentsMap();
	
	Student selectStudentById(Integer id);
	List<Student> selectStudentByName(String name);
	
}
