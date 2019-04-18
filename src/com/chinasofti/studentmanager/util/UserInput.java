package com.chinasofti.studentmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//工具类   用于处理用户输入信息的验证
public class UserInput {
	//接收用户输入的内容String
	public String getString(String msg){
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		return sc.next(); 
	}
	
	public Date getDate(String msg){
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		String str=null;
		Date date = null;
		str = sc.next("^\\d{4}-\\d{2}-\\d{2}$");
		try{date = new SimpleDateFormat("yyyy-MM-dd").parse(str) ;}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return date;	
	}
	
	//接收整数
	public int getInt(String msg){
		while(true){
			try {
				System.out.println(msg);
				Scanner sc=new Scanner(System.in);
				return sc.nextInt();
			} catch (Exception e) {
				System.out.println("输入内容格式不正确，请输入整数类型！");
			}
		}
	}
	//接收浮点数
	public double getDouble(String msg){
		while(true){
			try {
				System.out.println(msg);
				Scanner sc=new Scanner(System.in);
				return sc.nextDouble();
			} catch (Exception e) {
				System.out.println("输入内容格式不正确，请输入小数类型！");
			}
		}
	}
}
