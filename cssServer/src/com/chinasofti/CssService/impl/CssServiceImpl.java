package com.chinasofti.CssService.impl;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.CssService.CssService;
import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.dao.impl.CustomerDaoImpl;
import com.chinasofti.dao.impl.EmployeeDaoImpl;
import com.chinasofti.domain.Accounts;
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
	public Customer loginC(int clid){
		try {
			return this.cusDao.selectByCtid(clid);
		} catch (SQLException e) {
			System.out.println("你查找的顾客不存在");
			return null;
		}
		
	}

	@Override
	public Employee loginE(int emid) {
		try {
			return this.empDao.selectByEid(emid);
		} catch (SQLException e) {
			System.out.println("你查找的员工不存在");
			return null;
		}
	}

	@Override
	public List<Clothes> selectAllClothes() {
		try {
			return this.cusDao.selectAllClothes();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Bill> selectAllBill() {
		try {
			return this.cusDao.selectAllBill();
		} catch (SQLException e) {
			System.out.println("找不到购物车集合");
			return null;
		}
	}

	@Override
	public Clothes selectClothesById(int clid) {
		try {
			return this.cusDao.selectByClid(clid);
		} catch (SQLException e) {
			System.out.println("服装店没有此衣服编号");
			return null;
		}
	}
	
	@Override
	public String addBillById(int clid,int bnum) {
		try {
			return this.cusDao.addBill(clid, bnum)?"添加成功":"添加失败";
		} catch (SQLException e) {
			System.out.println("购物车添加衣服失败");
			return null;
		}
	}

	@Override
	public String deleteBillById(int clid) {
		try {
			return this.cusDao.deleteByClid(clid)?"删除成功":"删除失败";
		} catch (SQLException e) {
			System.out.println("购物车删除衣服错误");
			return null;
		}
	}

	@Override
	public String updateBill(int clid,int bnum) {
		try {
			return this.cusDao.updateBill(clid, bnum)?"修改成功":"修改失败";
		} catch (SQLException e) {
			System.out.println("购物车修改信息错误");
			return null;
		}
	}

	@Override
	public String updatePasswordByCtid(String str,int ctid) {
		try {
			return this.cusDao.updateCtpassword(str, ctid)?"修改密码成功":"修改密码失败";
		} catch (SQLException e) {
			System.out.println("员工修改密码错误");
			return null;
		}
	}
	
	@Override
	public List<Customer> selectAllCustomer() {
		try {
			return this.empDao.selectAllC();
		} catch (SQLException e) {
			System.out.println("没有找到顾客信息");
			return null;
		}
	}

	@Override
	public String updatePasswordByEid(String str,int emid) {
		try {
			return this.empDao.updatePasswordByEid(str, emid)?"密码修改成功":"密码修改失败";
		} catch (SQLException e) {
			System.out.println("员工修改密码错误");
			return null;
		}
	}

	@Override
	public String addCustomer(Customer cus) {
		try {
			return this.empDao.addCus(cus)?"顾客开卡成功":"顾客开卡成功顾客开卡失败";
		} catch (SQLException e) {
			System.out.println("顾客开卡错误");
			return null;
		}
	}

	@Override
	public String addMoney(int ctid, double money) {
		try {
			return this.empDao.addMoney(ctid, money)?"充值成功":"充值失败";
		} catch (SQLException e) {
			System.out.println("充值出错");
			return null;
		}
	}

	@Override
	public String addVip(int ctid) {
		try {
			return this.empDao.addVip(ctid)?"会员开通成功":"会员开通失败";
		} catch (SQLException e) {
			System.out.println("会员开通错误");
			return null;
		}
	}

	@Override
	public String updateFrozenById(int ctid,int i) {
		try {
			return this.empDao.updateFrozen(ctid,i)?"修改成功":"修改失败";
		} catch (SQLException e) {
			System.out.println("修改出现错误");
			return null;
		}
	}

	@Override
	public String addClothes(Clothes clo) {
		try {
			return this.empDao.addClothes(clo)?"服装添加成功":"服装添加失败";
		} catch (SQLException e) {
			System.out.println("服装添加错误");
			return null;
		}
	}

	@Override
	public String updateClothes(int clid,double price) {
		try {
			return this.empDao.updateClo(clid, price)?"服装价格修改成功":"服装价格修改失败";
		} catch (SQLException e) {
			System.out.println("服装修改失败");
			return null;
		}
	}

	@Override
	public String deleteClothes(int clid) {
		try {
			return this.empDao.deleteClo(clid)?"服装删除成功":"服装删除失败";
		} catch (SQLException e) {
			System.out.println("服装删除错误");
			return null;
		}
	}

	@Override
	public String addEmployee(Employee e) {
		try {
			return this.empDao.addEmp(e)?"员工添加成功":"员工添加失败";
		} catch (SQLException e1) {
			System.out.println("员工添加错误");
			return null;
		}
	}

	@Override
	public String deleteEmployee(int emid) {
		try {
			return this.empDao.deleteEmp(emid)?"员工删除成功":"员工删除失败";
		} catch (SQLException e) {
			System.out.println("员工删除错误");
			return null;
		}
	}

	@Override
	public List<Employee> selectAllEmployee() {
		try {
			return this.empDao.selectAllEmp();
		} catch (SQLException e) {
			System.out.println("无法找到员工信息");
			return null;
		}
	}

	@Override
	public List<Clothes> selectLikeClothes(String str) {
		try {
			return this.cusDao.selectLikeClname(str);
		} catch (SQLException e) {
			System.out.println("无法找到衣服集合");
			return null;
		}
	}

	@Override
	public void deleteBill() {
		try {
			this.cusDao.dropBill();
		} catch (SQLException e) {
			System.out.println("购物车清空失败");
		}
		
	}

	@Override
	public String updateBalance(int ctid, double dd) {
		try {
			return this.cusDao.updateBalance(ctid,dd)?"结账成功":"结账失败";
		} catch (SQLException e) {
			System.out.println("结账出现错误");
			return null;
		}
		
	}

	@Override
	public void addAccounts(String aname, String date, double money) {
		try {
			this.empDao.addAcc(aname,date,money);
		} catch (SQLException e) {
			System.out.println("账单添加失败");
		}
	}


	@Override
	public List<Accounts> selectMonthAccounts(String yy, String mm) {
		try {
			return this.empDao.selectMonthAcc(yy, mm);
		} catch (SQLException e) {
			System.out.println("根据月份查询账单失败");
			return null;
		}
	}

	@Override
	public List<Accounts> selectAllAccounts() {
		try {
			return this.empDao.selectAllAcc();
		} catch (SQLException e) {
			System.out.println("查询账单失败");
			return null;
		}
	}
	
	

}
