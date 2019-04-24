package com.chinasofti.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.domain.Accounts;
import com.chinasofti.domain.Clothes;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;

public interface EmployeeDao {
	/**
	 * 根据员工id查询员工信息
	 * @param eid
	 * @return
	 */
	public Employee selectByEid(int emid) throws SQLException;
	/**
	 * 修改员工密码
	 * @return
	 */
	public boolean updatePasswordByEid(String str,int emid) throws SQLException;
	/**
	 * 查询所有顾客信息
	 * @return
	 * @throws SQLException
	 */
	public List<Customer> selectAllC() throws SQLException;
	/**
	 * 添加客户
	 * @param ctid
	 * @return
	 * @throws SQLException
	 */
	public boolean addCus(Customer cus) throws SQLException;
	/**
	 * 充值
	 * @param cid
	 * @param money
	 * @return
	 * @throws SQLException
	 */
	public boolean addMoney(int ctid,double money) throws SQLException; 
	/**
	 * 升级为会员
	 * @param ctid
	 * @return
	 * @throws SQLException
	 */
	public boolean addVip(int ctid) throws SQLException;
	/**
	 * （挂失）冻结
	 * @param ctid
	 * @return
	 * @throws SQLException
	 */
	public boolean updateFrozen(int ctid,int f) throws SQLException;
	
	
	/*-----------------------------------------------------------------*/
	/**
	 * 经理添加衣服
	 * @param clo
	 * @return
	 */
	public boolean addClothes(Clothes clo) throws SQLException;
	/**
	 * 经理修改衣服价格
	 * @param clid
	 * @param price
	 * @return
	 */
	public boolean updateClo(int clid,double price) throws SQLException;
	/**
	 * 经理删除衣服
	 * @param clid
	 * @return
	 */
	public boolean deleteClo(int clid) throws SQLException;
	/**
	 * 经理添加员工
	 * @param e
	 * @return
	 */
	public boolean addEmp(Employee e) throws SQLException;
	/**
	 * 经理删除员工
	 * @param eid
	 * @return
	 */
	public boolean deleteEmp(int emid) throws SQLException;
	/**
	 * 所有员工信息
	 * @return
	 */
	public List<Employee> selectAllEmp() throws SQLException;
	/**
	 * 查询所有账目
	 * @return
	 * @throws SQLException
	 */
	public List<Accounts> selectAllAcc() throws SQLException;
	/**
	 * 添加账目信息
	 * @param aname
	 * @param date
	 * @param money
	 * @throws SQLException
	 */
	public void addAcc(String aname, String date, double money) throws SQLException;
	/**
	 * 根据月份查询账目
	 * @return
	 * @throws SQLException
	 */
	public List<Accounts> selectMonthAcc(String yy,String mm)throws SQLException;
}
