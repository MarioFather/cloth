package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.domain.Clothes;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Dept;
import com.chinasofti.domain.Employee;
import com.chinasofti.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private  DBUtil db=new DBUtil();
	private  CustomerDao cusDao=new CustomerDaoImpl();

	@Override
	public Employee selectByEid(int emid) throws SQLException {
		Employee employee = new Employee();
		String sql="select * from employee where emid="+emid;
		ResultSet r = db.query(sql);
		if(r.next()){
			employee.setEmid(r.getInt("emid"));
			employee.setEname(r.getString("ename"));
			employee.setEmsex(r.getString("emsex"));
			employee.setDeptno(r.getInt("deptno"));
			employee.setEpassword(r.getString("epassword"));
		}
		String sql2="select * from dept where deptno="+employee.getDeptno();
		ResultSet r2 = db.query(sql2);
		Dept dept = new Dept();
		if(r2.next()){
			dept.setDeptno(r2.getInt("deptno"));
			dept.setDname(r2.getString("dname"));
			dept.setLoc(r2.getString("loc"));
			employee.setDe(dept);
		}
		return employee;
	}

	@Override
	public List<Customer> selectAllC() throws SQLException {
		List<Customer> list = new ArrayList<Customer>();
		String sql="select * from client";
		ResultSet r = db.query(sql);
		boolean b;
		while(b=r.next()){
			Customer customer = new Customer();
			if(b){
				customer.setCtid(r.getInt("ctid"));
				customer.setCtpassword(r.getString("ctpassword"));
				customer.setCvip(r.getInt("cvip"));
				customer.setBalance(r.getDouble("balance"));
				customer.setFrozen(r.getInt("frozen"));
				customer.setCtname(r.getString("ctname"));
				
			}
			list.add(customer);
		}
		return list;
	}

	
	@Override
	public boolean addCus(Customer cus) throws SQLException {
		String sql="insert into client values(?,?,?,?,?,?)";
		int i= db.update(sql, cus.getCtid(),cus.getCtpassword(),cus.getCvip(),cus.getBalance(),cus.getFrozen(),cus.getCtname());
		return i>0;
	}

	@Override
	public boolean addMoney(int ctid, double money) throws SQLException {
		String sql="update client set balance=? where ctid=?";
		int i = db.update(sql, (this.cusDao.selectByCtid(ctid).getBalance()+money),ctid);
		return i>0;
	}

	@Override
	public boolean addVip(int ctid) throws SQLException {
		String sql="update client set cvip=1 where ctid="+ctid;
		int i = db.update(sql);
		return i>0;
	}

	@Override
	public boolean updateFrozen(int ctid) throws SQLException {
		String sql="update client set frozen=1 where ctid="+ctid;
		int i = db.update(sql);
		return i>0;
	}

	@Override
	public boolean addClothes(Clothes clo) throws SQLException {
		String sql="insert into clothes values(?,?,?,?)";
		int i = db.update(sql, clo.getClid(),clo.getClname(),clo.getPrice(),clo.getSeaid());
		return i>0;
	}

	@Override
	public boolean updateClo(int clid, double price) throws SQLException {
		String sql="update clothes set price=? where clid=?";
		int i = db.update(sql, price,clid);
		return i>0;
	}

	@Override
	public boolean deleteClo(int clid) throws SQLException {
		String sql="delete from clothes where clid="+clid;
		int i = db.update(sql);
		return i>0;
	}

	@Override
	public boolean addEmp(Employee e) throws SQLException {
		String sql="insert into employee values(?,?,?,?,?)";
		int i = db.update(sql, e.getEmid(),e.getEname(),e.getEmsex(),e.getDeptno(),e.getEpassword());
		return i>0;
	}

	@Override
	public boolean deleteEmp(int emid) throws SQLException {
		String sql="delete from employee where emid="+emid;
		int i = db.update(sql);
		return i>0;
	}

	@Override
	public boolean updatePasswordByEid(String str, int emid) throws SQLException {
		String sql="update employee set epassword=? where emid=?";
		int i = db.update(sql, str,emid);
		return i>0;
	}

	@Override
	public List<Employee> selectAllEmp() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		String sql="select * from employee";
		ResultSet r = db.query(sql);
		boolean b;
		while(b=r.next()){
			Employee e = new Employee();
			Dept d = new Dept();
			if(b){
				e.setEmid(r.getInt("emid"));
				e.setEname(r.getString("ename"));
				e.setEmsex(r.getString("emsex"));
				e.setDeptno(r.getInt("deptno"));
				e.setEpassword(r.getString("epassword"));
			}
			String sql2="select * from dept where deptno="+e.getDeptno();
			ResultSet r2 = db.query(sql2);
			if(r2.next()){
				d.setDeptno(r2.getInt("deptno"));
				d.setDname(r2.getString("dname"));
				d.setLoc(r2.getString("loc"));
			}
			list.add(e);
		}
		return list;
	}
	

}
