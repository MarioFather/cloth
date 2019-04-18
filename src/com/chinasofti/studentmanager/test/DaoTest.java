package com.chinasofti.studentmanager.test;




import org.junit.Test;

import com.chinasofti.studentmanager.dao.StudentDao;
import com.chinasofti.studentmanager.dao.impl.StudentDaoImpl;
import com.chinasofti.studentmanager.domain.Student;

public class DaoTest {
	
	






	/*@Test
	public void addClazz(){
		ClazzDao c=new ClazzDaoImpl();
		System.out.println(c.addClazz(new Clazz(3, "高一三班")));
	}
	@Test
	public void selectAllClazz(){
		ClazzDao c=new ClazzDaoImpl();
		List<Clazz> list = c.selectAll();
		for (Clazz clazz : list) {
			System.out.println(clazz.getClid()+"---"+clazz.getClname());
		}
	}*/
	@Test 
	public void test(){
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.selectById(1);
		System.out.println(student);
	}


	
}
