package com.chinasofti.studentmanager.dao;

import java.util.List;

import com.chinasofti.studentmanager.domain.Course;

public interface CourseDao {
	//添加课程的方法
	public boolean addCourse(Course c);
	//查询所有课程的方法
	public List<Course> selectAll();
	//删除课程的方法
	public boolean deleteCourse(int id);
	//添加成绩的方法
	public boolean addScore(int stuid,int cid,double score);
	//修改成绩的方法
	public boolean updateScore(int stuid,int cid,double score);
	//根据学生和课程编号查询成绩
	public Course selectScore(int stuid,int cid);
}
