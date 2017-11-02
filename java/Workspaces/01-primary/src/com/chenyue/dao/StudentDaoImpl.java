package com.chenyue.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chenyue.beans.Student;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {
		try {
			//1.�����������ļ�
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			//2.����SqlSessionFactory����
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			//4.��ز���(String statement,Object parameter)
			//statement:mapper/insert/id
			//parameter:beans.class
			sqlSession.insert("insertStudent", student);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}


	}

}
