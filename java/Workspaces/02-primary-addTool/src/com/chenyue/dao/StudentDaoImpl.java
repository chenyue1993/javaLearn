package com.chenyue.dao;

import java.io.InputStream;

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
//		try {
//			//1.加载主配置文件
//			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//			//2.创建SqlSessionFactory对象
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			sqlSession = sqlSessionFactory.openSession();
//			//4.相关操作(String statement,Object parameter)
//			//statement:mapper/insert/id
//			//parameter:beans.class
//			sqlSession.insert("insertStudent", student);
//			
//			sqlSession.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			if (sqlSession != null) {
//				sqlSession.close();
//			}
//		}
		
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

}
