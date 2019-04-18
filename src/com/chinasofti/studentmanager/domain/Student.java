package com.chinasofti.studentmanager.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Student implements Serializable{
	private int stuId;
	private String stuName;
	private String sex;
	private Date birth;
	private Clazz cl;
	private List<Course> list;
	public Student(int stuId, String stuName, String sex, Date birth, Clazz cl) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.sex = sex;
		this.birth = birth;
		this.cl = cl;
	}
	public Student() {
		super();
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Clazz getCl() {
		return cl;
	}
	public void setCl(Clazz cl) {
		this.cl = cl;
	}
	public List<Course> getList() {
		return list;
	}
	public void setList(List<Course> list) {
		this.list = list;
	}
	
}
