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
		map.put("nameCondition", "��");
		map.put("ageCondition", 23);
		student = new Student();
		student.setScore(95.0);
		map.put("student", student);
		List<Student> students = dao.selectStudentsByMap(map);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	//һ�������Ǵ��ڵ�
	@Test
	public void test1SelectStudentByid(){
		student = dao.selectStudentById(1);
		Student student1 = dao.selectStudentById(2);
		System.out.println(student+"---"+student1);
	}
	
	//����ĵײ�ʵ����Map��Map��value�ǲ�ѯ���
	//Map��key������ѯ���ݣ�ʹ�õ�ORM����� ����ͬ����ѯ�����ǲ�ͬ��
	//֤��һ�������ж�ȡ���ݵ������ǣ�
	//MyBatis�Ĳ�ѯ�����ǣ�Sql��id + SQL���+��hashֵ��
	//Hibernate�Ĳ�ѯ�����ǣ���ѯ��������id
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
		
		//��ɾ�Ĳ����������һ������,�����Ƿ��ύ
		dao.saveStudent(new Student("zhang", 26, 25.5));
	
		Student student1 = dao.selectStudentById(2);
		System.out.println(student1);
	}
	
	//֤�����������Ǵ��ڵ�
	//�������õĶ������沽�裺
	//1)��ʵ��������л�
	//2)��ӳ���ļ������<cache/>��ǩ
	//cache hit ratio : ����������
	@Test
	public void test1saveStudent(){
		student = dao.selectStudentById(2);
		System.out.println(student);
		
		sqlSession.close();//���һ������
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);	
		Student student3 = dao.selectStudentById(2);
		System.out.println(student3);		


		
	}
}
