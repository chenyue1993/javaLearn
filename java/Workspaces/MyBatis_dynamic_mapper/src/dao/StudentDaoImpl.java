package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Utils.MybatisUtils;
import beans.Student;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;
	
	@Override
	public void savaStudent(Student student) {
		try {
			sqlSession = MybatisUtils.getSqlSession();
			sqlSession.insert("savaStudent", student);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void saveStudentCacheId(Student student) {
		try {
			sqlSession = MybatisUtils.getSqlSession();
			sqlSession.insert("saveStudentCacheId", student);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void removeStudentById(Integer id) {
		try {
			sqlSession = MybatisUtils.getSqlSession();
			sqlSession.delete("removeStudentById", id);
			sqlSession.commit();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void updateStudentById(Student student) {
		try {
			sqlSession = MybatisUtils.getSqlSession();
			sqlSession.update("updateStudentById", student);
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
			sqlSession = MybatisUtils.getSqlSession();
			students = sqlSession.selectList("selectAllStudents");
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public Map<String, Student> selectAllStudentsMap() {
		Map<String, Student> students;
		try {
			sqlSession = MybatisUtils.getSqlSession();
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
		Student student;
		try {
			sqlSession = MybatisUtils.getSqlSession();
			student = sqlSession.selectOne("selectStudentById", id);
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
			sqlSession = MybatisUtils.getSqlSession();
			students = sqlSession.selectList("selectStudentByName", name);
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return students;
	}

}
