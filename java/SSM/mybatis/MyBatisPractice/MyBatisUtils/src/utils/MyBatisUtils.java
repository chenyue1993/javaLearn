package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSession sqlSession;
	

	public static SqlSession getSqlSession(){
		try {
			if (sqlSession == null) {
				InputStream inputStream = Resources.getResourceAsStream("config.xml");
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				sqlSession = sqlSessionFactory.openSession();
				return sqlSession;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
