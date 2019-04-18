package com.chinasofti.studentmanager.biz.impl;

import java.util.List;

import com.chinasofti.studentmanager.biz.CourseBiz;
import com.chinasofti.studentmanager.dao.CourseDao;
import com.chinasofti.studentmanager.dao.impl.CourseDaoImpl;
import com.chinasofti.studentmanager.domain.Course;
import com.chinasofti.studentmanager.domain.Student;

public class CourseBizImpl implements CourseBiz{
	private CourseDao dao;
	
	public CourseBizImpl() {
		super();
		this.dao = new CourseDaoImpl();
	}

	@Override
	public String addCourse(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeCourse(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return this.dao.selectAll();
	}

	@Override
	public List<Course> findByStu(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findBySingle(Student s, Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertScore(int stuId, int cid, double double1) {
		
		this.dao.addScore(stuId, cid, double1);
	}

}
