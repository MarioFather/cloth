package com.chinasofti.studentmanager.service;

import java.util.List;

import com.chinasofti.studentmanager.domain.Clazz;
import com.chinasofti.studentmanager.domain.Course;
import com.chinasofti.studentmanager.domain.Student;

public interface TotalService {
	//创建添加班级的方法
	public String addClazz(int id,String name);
	//创建删除班级的方法
	public String deleteClazz(int id);
	//根据id查询学生的方法
	public Student selectStudentById(int id);
	//显示所有课程的方法
	public List<Course> selectAllCourse();
	
	
	//创建学生信息添加的方法
	public String addStudent(Student s);
	//创建学生信息删除的方法
	
	//添加课程的方法
	
	//创建删除课程的方法
	
	//录入学生成绩的方法
	public void addScore(Student stu, Course course, double double1);
	//根据id查询班级的方法
	public Clazz selectById(int id);
	
	//创建学生所有课程成绩获取的方法
}
