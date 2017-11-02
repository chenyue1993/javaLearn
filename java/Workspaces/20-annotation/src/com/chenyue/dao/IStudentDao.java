package com.chenyue.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.chenyue.beans.Student;

public interface IStudentDao {
	@Insert(value={"insert into student(tname,tage,score) values(#{name},#{age},#{score})"})
	void insertStudent(Student student);
	
	@Insert(value={"insert into student(tname,tage,score) values(#{name},#{age},#{score})"})
	@SelectKey(statement="select @@identity",keyProperty="id",resultType=int.class,before=false)
	void insertStudentCacheId(Student student);
	
	@Delete(value="delete from student where tid=#{xxx}")
	void deleteStudentById(Integer id);
	
	//只有value属性可以省略
	@Update("update student set tname=#{name}, tage=#{age}, score=#{score} where tid=#{id}")
	void updateStudent(Student student);
	
	@Select("select tid, tname, tage, score from student")
	List<Student> selectAllStudents();
	
	@Select("select tid, tname, tage, score from student")
	Map<String, Student> selectAllStudentsMap();
	
	@Select("select tid, tname, tage, score from student where tid=#{XXX}")
	Student selectStudentById(Integer id);
	
	@Select("select tid, tname, tage, score from student where tname like '%' #{XXX} '%'")
	List<Student> selectStudentByName(String name);
	
}
