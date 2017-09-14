package com.chenyue.dao;

import java.util.List;

import com.chenyue.beans.Student;

public interface IStudentDao {

	List<Student> selectStudentsByIf(Student student);
	List<Student> selectStudentsByWhere(Student student);
	List<Student> selectStudentsByChoose(Student student);
	List<Student> selectStudentsByForeach(int[] ids);
	List<Student> selectStudentsByForeachList(List<Integer> ids);
	List<Student> selectStudentsByForeachListObject(List<Student> ids);
	
}
