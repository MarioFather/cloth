package com.chinasofti.studentmanager.dao;

import java.util.List;

import com.chinasofti.studentmanager.domain.Clazz;

public interface ClazzDao {
	//查询所有班级
	public List<Clazz> selectAll();
	//添加班级的方法
	public boolean addClazz(Clazz z);
	
	//删除班级的方法
	public boolean deleteClazz(int id);
	//根据班级编号查询班级的方法
	public Clazz selectById(int id);
}
