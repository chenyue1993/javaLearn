package Utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSession sqlSession;
	
	public static SqlSession getSqlSession(){
		if (sqlSession == null) {
			try {
				return new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("config.xml")).openSession();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
