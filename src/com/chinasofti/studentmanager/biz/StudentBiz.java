package com.chinasofti.studentmanager.biz;

import com.chinasofti.studentmanager.domain.Student;

public interface StudentBiz {
	//通过id查询学生的方法
	Student selectId(int id);
	//添加学生的方法
	String addStudent(Student s);
}
