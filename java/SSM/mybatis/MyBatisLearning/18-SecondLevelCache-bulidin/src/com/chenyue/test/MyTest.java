package com.chenyue.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes.Name;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenyue.beans.Student;
import com.chenyue.dao.IStudentDao;
import com.chenyue.utils.MyBatisUtils;

public class MyTest {
	private IStudentDao dao;
	private Student student;
	private SqlSession sqlSession;
	
	@Before
	public void before(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);	
	}
	
	@After
	public void after(){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test6SelectStudentByCondition(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nameCondition", "孙");
		map.put("ageCondition", 23);
		student = new Student();
		student.setScore(95.0);
		map.put("student", student);
		List<Student> students = dao.selectStudentsByMap(map);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	//一级缓存是存在的
	@Test
	public void test1SelectStudentByid(){
		student = dao.selectStudentById(1);
		Student student1 = dao.selectStudentById(2);
		System.out.println(student+"---"+student1);
	}
	
	//缓存的底层实现是Map，Map的value是查询结果
	//Map的key，及查询依据，使用的ORM（框架 ）不同，查询依据是不同的
	//证明一级缓存中读取数据的依据是：
	//MyBatis的查询依据是：Sql的id + SQL语句+（hash值）
	//Hibernate的查询依据是：查询结果对象的id
	@Test
	public void testSelectStudentByid(){
		student = dao.selectStudentById(1);
		Student student1 = dao.selectStudentById(2);
		System.out.println(student+"---"+student1);
	}
	
	@Test
	public void testSelectStudentByid1(){
		student = dao.selectStudentById(1);
		Student student1 = dao.selectStudentById1(1);
		System.out.println(student+"---"+student1);
	}
	
	@Test
	public void testsaveStudent(){
		student = dao.selectStudentById(2);
		System.out.println(student);
		
		//增删改操作都会清空一级缓存,无论是否提交
		dao.saveStudent(new Student("zhang", 26, 25.5));
	
		Student student1 = dao.selectStudentById(2);
		System.out.println(student1);
	}
	
	//证明二级缓存是存在的
	//开启内置的二级缓存步骤：
	//1)对实体进行序列化
	//2)在映射文件中添加<cache/>标签
	//cache hit ratio : 缓存命中率
	@Test
	public void test1saveStudent(){
		student = dao.selectStudentById(2);
		System.out.println(student);
		
		sqlSession.close();//清空一级缓存
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);	
		Student student3 = dao.selectStudentById(2);
		System.out.println(student3);		


		
	}
}
