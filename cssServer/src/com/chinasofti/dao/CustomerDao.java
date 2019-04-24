package com.chinasofti.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.domain.Bill;
import com.chinasofti.domain.Clothes;
import com.chinasofti.domain.Customer;

public interface CustomerDao {//基础层
	//根据客户id查询客户信息
	public Customer selectByCtid(int ctid) throws SQLException;
	//查询所有衣服
	public List<Clothes> selectAllClothes() throws SQLException;
	//根据衣服id查询衣服
	public Clothes selectByClid(int clid) throws SQLException;
	//将衣服添加到购物车
	public boolean addBill(int clid,int bnum) throws SQLException;
	//根据衣服id将衣服从购物车中删除
	public boolean deleteByClid(int clid) throws SQLException;
	//查询购物车中的信息
	public List<Bill> selectAllBill() throws SQLException;
	//修改购物车中衣服的数量
	public boolean updateBill(int clid,int bnum) throws SQLException;
	//顾客修改自己密码
	public boolean updateCtpassword(String str,int ctid) throws SQLException;
	//模糊查询衣服属性
	public List<Clothes> selectLikeClname(String str) throws SQLException;
	////购物车自动清空
	public void dropBill() throws SQLException;
	//结账
	public boolean updateBalance(int ctid,double dd) throws SQLException;
}
  