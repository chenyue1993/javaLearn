package com.chenyue.beans;

import java.io.Serializable;

public class Student implements Serializable{
	
	//��Ա����
	private Integer id;
	private String name;
	private Integer age;
	private Double score;
	
	public Student() {
		super();
	}
	
	public Student(String name, Integer age, Double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public Integer getId() {   //���� id��get����ĵ���Сд ��
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", score=" + score + "]";
	}
	
	
	
}
