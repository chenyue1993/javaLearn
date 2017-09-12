package dao;

import org.apache.ibatis.session.SqlSession;

import utils.MyBatisUtils;

import beans.Student;

public class StudentDaoImpl implements IStudentDao {
	private SqlSession sqlSession;
	
	@Override
	public void saveStudent(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.insert("saveStudent", student);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
