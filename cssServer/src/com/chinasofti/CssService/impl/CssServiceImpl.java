package com.chinasofti.CssService.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.chinasofti.CssService.CssService;
import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.dao.impl.CustomerDaoImpl;
import com.chinasofti.dao.impl.EmployeeDaoImpl;
import com.chinasofti.domain.Bill;
import com.chinasofti.domain.Clothes;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;

public class CssServiceImpl implements CssService{
	private CustomerDao cusDao;
	private EmployeeDao empDao;
	
	public CssServiceImpl() {
		super();
		this.cusDao = new CustomerDaoImpl();
		this.empDao = new EmployeeDaoImpl();
	}

	@Override
	public Customer loginC(int clid) throws SQLException {
		return this.cusDao.selectByCtid(clid);
	}

	@Override
	public Employee loginE(int emid) throws SQLException {
		return this.empDao.selectByEid(emid);
	}

	@Override
	public List<Clothes> selectAllClothes() throws SQLException {
		return this.cusDao.selectAllClothes();
	}

	@Override
	public List<Bill> selectAllBill() throws SQLException {
		return this.cusDao.selectAllBill();
	}

	@Override
	public Clothes selectClothesById(int clid) throws SQLException {
		return this.cusDao.selectByClid(clid);
	}
	
	@Override
	public String addBillById(int clid,int bnum) throws SQLException {
		return this.cusDao.addBill(clid, bnum)?"添加成功":"添加失败";
	}

	@Override
	public String deleteBillById(int clid) throws SQLException {
		return this.cusDao.deleteByClid(clid)?"删除成功":"删除失败";
	}

	@Override
	public String updateBill(int clid,int bnum) throws SQLException{
		return this.cusDao.updateBill(clid, bnum)?"修改成功":"修改失败";
	}

	@Override
	public String updatePasswordByCtid(String str,int ctid) throws SQLException{
		return this.cusDao.updateCtpassword(str, ctid)?"修改密码成功":"修改密码失败";
	}
	
	@Override
	public List<Customer> selectAllCustomer() throws SQLException {
		return this.empDao.selectAllC();
	}

	@Override
	public String updatePasswordByEid(String str,int emid) throws SQLException{
		return this.empDao.updatePasswordByEid(str, emid)?"密码修改成功":"密码修改失败";
	}

	@Override
	public String addCustomer(Customer cus) throws SQLException {
		return this.empDao.addCus(cus)?"顾客开卡成功":"顾客开卡成功顾客开卡失败";
	}

	@Override
	public String addMoney(int ctid, double money) throws SQLException {
		return this.empDao.addMoney(ctid, money)?"充值成功":"充值失败";
	}

	@Override
	public String addVip(int ctid) throws SQLException {
		return this.empDao.addVip(ctid)?"会员开通成功":"会员开通失败";
	}

	@Override
	public String updateFrozenById(int ctid) throws SQLException {
		return this.empDao.updateFrozen(ctid)?"账户已冻结":"账户冻结失败";
	}

	@Override
	public String addClothes(Clothes clo) throws SQLException {
		return this.empDao.addClothes(clo)?"服装添加成功":"服装添加失败";
	}

	@Override
	public String updateClothes(int clid,double price) throws SQLException {
		return this.empDao.updateClo(clid, price)?"服装价格修改成功":"服装价格修改失败";
	}

	@Override
	public String deleteClothes(int clid) throws SQLException {
		return this.empDao.deleteClo(clid)?"服装删除成功":"服装删除失败";
	}

	@Override
	public String addEmployee(Employee e) throws SQLException {
		return this.empDao.addEmp(e)?"员工添加成功":"员工添加失败";
	}

	@Override
	public String deleteEmployee(int emid) throws SQLException {
		return this.empDao.deleteEmp(emid)?"员工删除成功":"员工删除失败";
	}

	@Override
	public List<Employee> selectAllEmployee() throws SQLException {
		return this.empDao.selectAllEmp();
	}

	@Override
	public List<Clothes> selectLikeClothes(String str) throws SQLException {
		return this.cusDao.selectLikeClname(str);
	}
	
	

}
