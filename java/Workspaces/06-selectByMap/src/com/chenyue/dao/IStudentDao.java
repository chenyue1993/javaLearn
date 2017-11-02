package com.chenyue.dao;

import java.util.List;
import java.util.Map;

import com.chenyue.beans.Student;

public interface IStudentDao {

	List<Student> selectStudentsByMap(Map<String, Object> map);
	
}
