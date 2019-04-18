package com.chinasofti.studentmanager.biz;

import java.util.List;

import com.chinasofti.studentmanager.domain.Course;
import com.chinasofti.studentmanager.domain.Student;

public interface CourseBiz {
	//添加课程
	public String addCourse(Course c);
	//删除课程
	public String removeCourse(int id);
	
	//查询课程所有
	public List<Course> findAll();
	
	//--------------------------成绩相关
	//查询课程和成绩   学生的所有课程结果
	public List<Course> findByStu(Student s);
	//查询学生的某个课程的成绩
	public Course findBySingle(Student s,Course c);
	
	
	public void insertScore(int stuId, int cid, double double1);
}
