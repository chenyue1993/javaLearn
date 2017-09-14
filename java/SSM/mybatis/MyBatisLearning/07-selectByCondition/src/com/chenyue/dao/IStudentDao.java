package com.chenyue.dao;

import java.util.List;

import com.chenyue.beans.Student;

public interface IStudentDao {

	List<Student> selectStudentsByCondition(String sname, int sage);
	
}
