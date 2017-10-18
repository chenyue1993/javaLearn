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
		Student student1 = dao.selectStudentById(1);
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
	
	//增删改对二级缓存的影响
	//1.增删改同样也会清空二级缓存
	//2.对于二级缓存的清空实际上是对所查找KEY对应的VALUE置为NULL
	//      而并非将<key,value>对，即entry对象删除
	//3.从DB中进行select查询的条件：
	//    1)缓存中根本不存在这个key
	//    2)缓存中存在该key对应的entry对象，但其value为null
	@Test
	public void test2saveStudent(){
		student = dao.selectStudentById(2);
		System.out.println(student);
		
		sqlSession.close();//清空一级缓存
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		
		//插入
		//删除二次缓存Map中的value
		dao.saveStudent(new Student("si",25,95.0));
		
		Student student3 = dao.selectStudentById(2);
		System.out.println(student3);			
	}
	
	@Test
	public void test(){
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(path);
	}
}
