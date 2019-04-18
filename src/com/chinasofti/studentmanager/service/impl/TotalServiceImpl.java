package com.chinasofti.studentmanager.service.impl;

import java.util.List;

import com.chinasofti.studentmanager.biz.ClazzBiz;
import com.chinasofti.studentmanager.biz.CourseBiz;
import com.chinasofti.studentmanager.biz.StudentBiz;
import com.chinasofti.studentmanager.biz.impl.ClazzBizImpl;
import com.chinasofti.studentmanager.biz.impl.CourseBizImpl;
import com.chinasofti.studentmanager.biz.impl.StudentBizImpl;
import com.chinasofti.studentmanager.domain.Clazz;
import com.chinasofti.studentmanager.domain.Course;
import com.chinasofti.studentmanager.domain.Student;
import com.chinasofti.studentmanager.service.TotalService;

public class TotalServiceImpl implements TotalService{
	//调用班级biz
	private ClazzBiz cbiz;
	private StudentBiz sBiz;
	private CourseBiz coBiz;
	public TotalServiceImpl() {
		this.cbiz=new ClazzBizImpl();
		this.sBiz=new StudentBizImpl();
		this.coBiz=new CourseBizImpl();
	}

	@Override
	public String addClazz(int id, String name) {
		return this.cbiz.addClazz(new Clazz(id, name));
	}

	@Override
	public Student selectStudentById(int id) {
		
		return this.sBiz.selectId(id);
	}

	@Override
	public List<Course> selectAllCourse() {
		
		return this.coBiz.findAll();
	}

	@Override
	public void addScore(Student stu, Course course, double double1) {
		
		this.coBiz.insertScore(stu.getStuId(),course.getCid(),double1);
	}

	@Override
	public String deleteClazz(int id) {
		return this.cbiz.removeClazz(id);
	}

	@Override
	public Clazz selectById(int id) {
		return this.cbiz.selectClazz(id);
	}

	@Override
	public String addStudent(Student s) {
		return this.sBiz.addStudent(s);
		
	}

}
