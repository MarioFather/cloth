package com.chinasofti.studentmanager.dao;

import java.util.List;

import com.chinasofti.studentmanager.domain.Student;

public interface StudentDao {
	//添加学生的方法
	public boolean addStudent(Student s);
	//根据id查询学生的方法
	public Student selectById(int id);
	//删除学生的方法
	public boolean deleteStudent(int id);
	//查询所有学生的方法
	public List<Student> selectAll();
}
