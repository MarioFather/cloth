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
		System.out.println("\t     品如服装店【结账单】\n");
		System.out.println("   NO:"+cus.getCtid()+y+m+d+"\t服务员工："+emp.getEname());
		System.out.println("\n     时间："+date);
		System.out.println("---------------------------------------");
		List<Bill> selectAllBill = c.selectAllBill();
		System.out.println("衣服名称\t\t数量\t衣服价格\t小计\n");
		double sum=0;
		for (Bill bill : selectAllBill) {
			System.out.println(bill.getClo().getClname()+"\t\t"+bill.getBnum()+"\t"+bill.getClo().getPrice()+"\t"+bill.getBsum());
			sum+=bill.getBsum();
		}
		System.out.println("\n\t\t\t总计："+sum);
		System.out.println("\t\t\t折扣："+sum*0.1);
		System.out.println("\t\t\t实际总价："+sum*0.9);
		System.out.println("----------------------------------------");
		System.out.println("\n*************欢迎下次光临*************");
		
	}
}
