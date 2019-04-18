package com.chinasofti.studentmanager.biz.impl;

import com.chinasofti.studentmanager.biz.ClazzBiz;
import com.chinasofti.studentmanager.dao.ClazzDao;
import com.chinasofti.studentmanager.dao.impl.ClazzDaoImpl;
import com.chinasofti.studentmanager.domain.Clazz;

public class ClazzBizImpl implements ClazzBiz{
	private ClazzDao dao;
	
	public ClazzBizImpl() {
		super();
		this.dao = new ClazzDaoImpl();
	}

	@Override
	public String addClazz(Clazz z) {
		//查询id是否已经存在
		Clazz c = this.dao.selectById(z.getClid());
		if(c!=null){
			return "添加的班级id已存在";
		}
		//boolean addClazz = this.dao.addClazz(z);
		
		return this.dao.addClazz(z)?"添加成功":"添加失败";
	}

	@Override
	public String removeClazz(int id) {
		return this.dao.deleteClazz(id)?"删除成功":"删除失败";
	}

	@Override
	public Clazz selectClazz(int id) {
		
		return this.dao.selectById(id);
	}
	
}
