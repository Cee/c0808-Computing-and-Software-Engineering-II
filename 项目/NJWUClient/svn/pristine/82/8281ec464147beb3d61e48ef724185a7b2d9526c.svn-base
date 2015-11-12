package stubdriver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;


import po.StudentPO;
import po.TeacherPO;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogic.stub.Admin_Stub;
import businesslogic.stub.UserControllerStub;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.userblservice.UserControllerService;

/**
 * 
 * @author Cee
 * @date 13.10.18
 * @version 1.0 管理员功能驱动测试
 */
public class Admin_Driver {

	AdminblService admin;

	public Admin_Driver(AdminblService admin) {
		this.admin = admin;
	}

	public static void main(String[] args) {
		System.out.println("以下为Admin的桩测试,包含了登陆、修改密码、查看学生、查看老师、添加用户、修改用户");
		UserControllerService userController = new UserControllerStub();
		System.out.println("欢迎进入南京哪个大学选课系统");
		System.out.println("账户:0,密码:admin");
		char[] password = "admin".toCharArray();
		try {
			userController.login(0, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		Admin_Stub admin = new Admin_Stub(userController);
		Admin_Driver driver = new Admin_Driver(admin);
		driver.space();
		try {
			driver.drive();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void space(){
		System.out.println("--------------------------------------------");
	}
	public void drive() throws RemoteException {
		StudentVO student = new StudentVO(121250151, "王琨",
				"121250151".toCharArray(),2, 19, "软件学院", "female");
		System.out.println("添加一个学生 From Admin_Driver");
		System.out
				.println("学生信息：121250151, 王琨, 121250151, 19, 软件学院, female, 2");
		admin.addStudent(student);
		space();
		
		TeacherVO teacher =  new TeacherVO(25041, 19, "刘钦", new char[]{'1','2','3','4','5','6'}, "软件学院", 2,"男");
		System.out.println("添加一个老师 From Admin_Driver");
		System.out.println("老师信息：000000001, 刘钦, 123456, 19, 软件学院, 2");
		admin.addTeacher(teacher);
		space();
		
		// 变性
		student  = new StudentVO(121250151, "王琨",
				"121250151".toCharArray(),2, 19, "软件学院", "male");
		System.out.println("更改学生信息 From Admin_Driver");
		admin.modifyStudent(student);
		System.out
				.println("王琨成功改变了性别 学生信息：121250151, 王琨, 121250151, 19, 软件学院, "
						+ student.getGender() + ", 2");
		space();
		
		// 改名
		teacher = new TeacherVO(25041, 19, "钦哥哥", new char[]{'1','2','3','4','5','6'}, "软件学院", 2,"男");
		System.out.println("更改老师信息 From Admin_Driver");
		admin.modifyTeacher(teacher);
		System.out.println("钦哥哥成功改变了姓名 老师信息：000000001, " + teacher.getName()
				+ ", 123456, 19, 软件学院, 2");
		space();
		
		// 查找
		System.out.println("查找指定学号学生 From Admin_Driver");
		System.out.println(admin.showStudent(121250151).simpleInfo());
		space();
		
		System.out.println("查找指定工号老师 From Admin_Driver");
		System.out.println(admin.showTeacher(1250001).simpleInfo());
		space();
		
		System.out.println("查找指定院系学生 From Admin_Driver");
		Iterator<StudentVO> slist = admin.showStudentofins(19,1);
		while (slist.hasNext()) {
			System.out.println(slist.next().simpleInfo());
		}
		space();
		
		System.out.println("查找指定院系老师 From Admin_Driver");
		Iterator<TeacherVO> tlist = admin.showTeacherofins(19);
		while (tlist.hasNext()){
			System.out.println(tlist.next().simpleInfo());
		}
		space();
		
		System.out.println("删除学生 From Admin_Driver");
		admin.delStudent(121250151);
		space();
		
		System.out.println("删除老师 From Admin_Driver");
		admin.delTeacher(000000001);
		space();
		
		System.out.println("管理员桩测试完毕");
	}
 }
