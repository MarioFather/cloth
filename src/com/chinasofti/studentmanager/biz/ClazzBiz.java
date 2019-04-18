package com.chinasofti.studentmanager.biz;

import com.chinasofti.studentmanager.domain.Clazz;

public interface ClazzBiz {
	//添加班级
	public String addClazz(Clazz z);
	//删除班级
	public String removeClazz(int id);
	//查询班级
	public Clazz selectClazz(int id);
}
