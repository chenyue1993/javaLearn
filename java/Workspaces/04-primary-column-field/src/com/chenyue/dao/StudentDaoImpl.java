package com.chenyue.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chenyue.beans.Student;
import com.chenyue.utils.MyBatisUtils;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {	
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.insert("insertStudent", student);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
	}

	@Override
	public void insertStudentCacheId(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.insert("insertStudentCacheId", student);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
	}

	@Override
	public void deleteStudentById(Integer id) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.delete("deleteStudentById", id);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.update("updateStudent", student);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			students = sqlSession.selectList("test.selectAllStudents");
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
		return students;
	}

	@Override
	public Map<String, Student> selectAllStudentsMap() {
		Map<String, Student> students = new HashMap<String, Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			students = sqlSession.selectMap("selectAllStudentsMap", "name");
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
		return students;
	}

	@Override
	public Student selectStudentById(Integer id) {
		Student student = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			student = sqlSession.selectOne("selectStudentById",id);
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
		return student;
	}

	@Override
	public List<Student> selectStudentByName(String name) {
		List<Student> students;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			students = sqlSession.selectList("selectStudentByName",name);
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
		    }
		}
		return students;
	}

}
