package com.chinasofti.studentmanager.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.studentmanager.dao.ClazzDao;
import com.chinasofti.studentmanager.domain.Clazz;
import com.chinasofti.studentmanager.util.DBUtil;

public class ClazzDaoImpl implements ClazzDao {
	//创建dbutil变量
	private DBUtil db;
	
	@Override
	public List<Clazz> selectAll() {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from clazz";
		try {
			ResultSet rs = this.db.query(sql);
			//创建一个list集合用于存储所有的课程
			List<Clazz> list=new ArrayList<Clazz>();
			while(rs.next()){
				list.add(new Clazz(rs.getInt("clid"), rs.getString("clname")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addClazz(Clazz z) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into clazz values(?,?)";
		try {
			int i = this.db.update(sql,z.getClid(),z.getClname());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误"+e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteClazz(int id) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="delete  from clazz where clid="+id;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Clazz selectById(int id) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from clazz where clid="+id;
		try {
			 ResultSet rs = this.db.query(sql);
			 if(rs.next()){
				 return new Clazz(rs.getInt("clid"), rs.getString("clname"));
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
