package com.chinasofti.studentmanager.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.studentmanager.dao.CourseDao;
import com.chinasofti.studentmanager.domain.Course;
import com.chinasofti.studentmanager.util.DBUtil;

public class CourseDaoImpl implements CourseDao {
	private DBUtil db;
	
	@Override
	public boolean addCourse(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> selectAll() {
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from course";
		try {
			ResultSet rs = this.db.query(sql);
			List<Course> list=new ArrayList<Course>();
			while(rs.next()){
				list.add(new Course(rs.getInt("cid"), rs.getString("cname")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean deleteCourse(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addScore(int stuid, int cid, double score) {
		this.db=new DBUtil();
		String sql="insert into scoretable values(?,?,?)";
		try {
			int i = this.db.update(sql,stuid,cid,score);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateScore(int stuid, int cid, double score) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course selectScore(int stuid, int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
