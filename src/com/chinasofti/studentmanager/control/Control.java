package com.chinasofti.studentmanager.control;

import java.sql.Date;
import java.util.List;

import com.chinasofti.studentmanager.domain.Clazz;
import com.chinasofti.studentmanager.domain.Course;
import com.chinasofti.studentmanager.domain.Student;
import com.chinasofti.studentmanager.service.TotalService;
import com.chinasofti.studentmanager.service.impl.TotalServiceImpl;
import com.chinasofti.studentmanager.util.UserInput;

public class Control {
	private UserInput ui;
	private TotalService service;
	public Control() {
		this.ui=new UserInput();
		this.service=new TotalServiceImpl();
	}

	public void start() {
		
			System.out.println("欢迎来到学生成绩管理系统");
			System.out.println("1、班级添加");
			System.out.println("2、班级删除");
			System.out.println("3、学生信息添加");
			System.out.println("4、学生信息删除");
			System.out.println("5、添加课程");
			System.out.println("6、删除课程");
			System.out.println("7、学生成绩录入");
			System.out.println("8、查询学生所有课程成绩");
			System.out.println("0、退出");
			int select = this.ui.getInt("请选择:");
			if(select == 0){
				System.out.println("系统退出");
				System.exit(0);
			}else if(select == 1){
				this.addClazz();
			}else if(select == 2){
				this.deleteClazz();
			}else if(select == 3){
				this.addStudent();
			}else if(select == 4){
				this.deleteClazz();
			}else if(select == 5){
				this.deleteClazz();
			}else if(select == 6){
				this.deleteClazz();
			}else if(select == 7){
				this.addScore();
			}else if(select == 8){
				this.deleteClazz();
			}
			
		
	}

	private void addStudent() {
		int id = this.ui.getInt("请输入学号:");
		Student stu=this.service.selectStudentById(id);
		if(stu !=null){
			System.out.println("该生已经存在,请重新输入!");
			return ;
		}else{
			System.out.println(
				this.service.addStudent
				(new Student(
						id, 
						this.ui.getString("请输入姓名学生:"),
						this.ui.getString("请输入姓名性别:") ,
						Date.valueOf(this.ui.getString("请输入学生生日:")),
						new Clazz(this.ui.getInt("班级号:"), null)))
				);
		}
		
		
	}

	private void deleteClazz() {
		int id = this.ui.getInt("请输入要删除的班级id:");
		Clazz clazz=this.service.selectById(id);
		System.out.println("班级信息如下:");
		System.out.println(clazz.getClid()+"\t"+clazz.getClname());
		int num = this.ui.getInt("是否删除?1.删除 2.返回:");
		if(num ==2){
			System.out.println("已返回");
		}else if(num==1){
		System.out.println(this.service.deleteClazz(id));
		}
	}

	private void addScore() {
		int id = this.ui.getInt("请输入要录入的学生学号:");
		Student stu=this.service.selectStudentById(id);
		if(stu.getStuName() ==null){
			System.out.println("该生不存在");
		}
		System.out.println("学生信息如下:");
		System.out.println(stu.getStuName()+"\t"+stu.getStuId());
		//查询所有课程
		List<Course> list=this.service.selectAllCourse();
		//遍历打印所有课程展示
		System.out.println("所有课程如下");
		for (Course c : list) {
			System.out.println(c.getCid()+"\t"+c.getCname());
		}
		//询问需要添加的课程
		int cid = this.ui.getInt("请输入要录入的课程编号,如果编号不存在 默认录入所有");
		//创建一个变量用于判断是否存在
		Course course=null;
		//遍历集合 判断输入的cid是否存在
		for (Course c : list) {
			if(c.getCid() == cid){
				course=c;
			}
		}
		if(course!=null){
			this.service.addScore(stu,course,this.ui.getDouble("请录入"+course.getCname()+"课程的成绩:"));
		}else{
			for (Course c : list) {
				this.service.addScore(stu,c,this.ui.getDouble("请录入"+c.getCname()+"课程的成绩:"));	
			}
		}
	}

	private void addClazz() {
		String s = this.service.addClazz(this.ui.getInt("请输入班级id:"), this.ui.getString("请输入班级名称"));
		System.out.println(s);
	}
	
	
	
	
}
