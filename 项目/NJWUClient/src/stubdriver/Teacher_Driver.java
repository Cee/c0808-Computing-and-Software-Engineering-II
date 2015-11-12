package stubdriver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonUniquePO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import businesslogic.stub.Teacher_Stub;
import businesslogic.stub.UserControllerStub;
import businesslogicservice.teacherblservice.TeacherBlService;
import businesslogicservice.userblservice.UserControllerService;

/**
 * 
 * @author Norvi
 * @version 1.1
 * @date 13.10.18
 * @modify 13.10.18.14：52
 * 修改了LessonRecordPO 添加其构造函数中的参数
 *
 */
public class Teacher_Driver {
	TeacherBlService teacher;
	public Teacher_Driver(TeacherBlService teacher){
		this.teacher = teacher;
	}
	
	public static void main(String args[]){
		System.out.println("以下为Teacher的桩测试，包括了登陆、修改密码、修改课程信息、登陆成绩、查看我的课程、查看课程学生");
		UserControllerService userController = new UserControllerStub();
		System.out.println("欢迎进入南京哪个大学选课系统");
		System.out.println("账户:1250001,密码:123456\n");
		char[] password = "123456".toCharArray();
		 try {
			userController.login(1250001, password);
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		// 这里默认为任课老师登陆
		Teacher_Stub teacher = new Teacher_Stub(userController);
		Teacher_Driver driver = new Teacher_Driver(teacher); 
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
	public void drive() throws RemoteException{
		space();
		System.out.println("更新课程信息");
		System.out.println("新的课程信息为软工II, 001, 软件学院, 仙II-303, 3, 240, 238, 0, 1250001, 刘钦, 31001, 19, 001, 3,4\n");
		LessonUniqueVO lesson = new LessonUniqueVO(new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程"));
		teacher.editLesInfo(lesson);
		
		space();
		System.out.println("登录学生成绩");
		System.out.println("课程号31001，学号 121250151,分数 0\n");
		LessonRecordVO record = null;
		teacher.recordScore();
		
		space();
		System.out.println("查看我的课程");
		ArrayList<LessonUniqueVO> lessonList = new ArrayList<>();//teacher.showMyLesson();
		lessonList.add(lesson);//测试，先加一个课程进去看看情况，因为任课老师自己不能发布课程
		for(LessonUniqueVO eachPo : lessonList){
			System.out.println(eachPo.simpleInfo());
		}

		
		space();
		System.out.println("查看我的课程学生列表");
		Iterator<StudentVO> lessonStudentPO = teacher.showMyStudent(001);
		while (lessonStudentPO.hasNext()){
			System.out.println(lessonStudentPO.next().simpleInfo());
		}

		space();
		System.out.println("修改密码\n 旧密码：123456 新密码：654321\n");
		char[] old = "123456".toCharArray();
		char[] newPassword = "654321".toCharArray();
		teacher.changePassword(old, newPassword);
		System.out.println("任课老师桩测试完毕");
	}
 }
