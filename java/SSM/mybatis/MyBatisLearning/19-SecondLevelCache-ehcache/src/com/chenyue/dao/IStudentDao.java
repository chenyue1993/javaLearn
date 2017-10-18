package com.chenyue.dao;

import java.util.List;
import java.util.Map;

import com.chenyue.beans.Student;

public interface IStudentDao {
	
	void saveStudent(Student student);
	
	List<Student> selectStudentsByMap(Map<String, Object> map);
	
	Student selectStudentById(int id);
	Student selectStudentById1(int id);
	
}
