package com.chenyue.dao;

import com.chenyue.beans.Student;

public interface IStudentDao {
	Student selectCourseById(int id);
	Student selectStudentById(int id);
}
