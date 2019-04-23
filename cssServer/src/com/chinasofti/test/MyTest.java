package com.chinasofti.test;


import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.chinasofti.CssService.CssService;
import com.chinasofti.CssService.impl.CssServiceImpl;
import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.dao.impl.CustomerDaoImpl;
import com.chinasofti.dao.impl.EmployeeDaoImpl;
import com.chinasofti.domain.Bill;
import com.chinasofti.domain.Clothes;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;

import oracle.sql.DATE;

public class MyTest {

	/*@Test
	public void testo() throws SQLException{
		CssService c= new CssServiceImpl();
		List<Bill> selectAllBill = c.selectAllBill();
		for (Bill bill : selectAllBill) {
			System.out.println(bill);
		}
	}*/
	/*@Test
	public void tes() throws SQLException  {
		CssService c = new CssServiceImpl();
		System.out.println(c.deleteEmployee(1));
	}*/
	@Test
	public void ttt() throws SQLException{
		CssService c = new CssServiceImpl();
		Customer cus = c.loginC(1111);
		Employee emp = c.loginE(11111111);
		Calendar cal = Calendar.getInstance();
		int y,m,d;
		y=cal.get(Calendar.YEAR);
		m=cal.get(Calendar.MONTH);
		d=cal.get(Calendar.DATE);
		String date=y+"-"+m+"-"+d;
		System.out.println("___________________________________________________");
		System.out.println("|\t\t\t\t\t\t   |");
		System.out.println("|\t\t     品如服装店【结账单】\t\t   |\n|\t\t\t\t\t\t   |");
		System.out.println("|\t  NO:"+cus.getCtid()+y+m+Calendar.AM_PM+"\t服务员工："+emp.getEname()+"\t\t   |");
		System.out.println("|\t\t\t\t\t\t   |\n|\t  时间："+date+"\t\t\t\t   |");
		System.out.println("|\t---------------------------------------"+"\t   |");
		List<Bill> selectAllBill = c.selectAllBill();
		System.out.println("|\t衣服名称\t\t数量\t衣服价格\t小计   \t   |\n|\t\t\t\t\t\t   |");
		double sum=0;
		for (Bill bill : selectAllBill) {
			System.out.println("|\t"+bill.getClo().getClname()+"\t\t"+bill.getBnum()+"\t"+bill.getClo().getPrice()+"\t"+bill.getBsum()+"\t   |");
			sum+=bill.getBsum();
		}
		System.out.println("|\t\t\t\t\t\t   |\n|\t\t\t\t总计："+sum+"\t   |");
		System.out.println("|\t\t\t\t折扣："+sum*0.1+"\t   |");
		System.out.println("|\t\t\t\t应收RMB："+sum*0.9+"\t   |");
		System.out.println("|\t---------------------------------------"+"\t   |");
		System.out.println("|\t\t\t\t\t\t   |\n|\t**************欢迎下次光临**************\t   |");
		System.out.println("|__________________________________________________|");
		
	}
}
