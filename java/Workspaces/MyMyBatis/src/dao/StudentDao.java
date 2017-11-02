package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import beans.Student;

public class StudentDao implements IStudnetDao {
	
	private SqlSession sqlSession;

	@Override
	public void saveStudent(Student student) {
		
		try {
			InputStream inputStream = Resources.getResourceAsStream("config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert("saveStudent", student);
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
