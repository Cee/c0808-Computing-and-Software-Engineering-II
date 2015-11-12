package stubdriver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;

import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.ScheduleVO;
import vo.ScoreVO;
import businesslogic.stub.Student_Stub;
import businesslogic.stub.UserControllerStub;
import businesslogicservice.studentblservice.StudentBlService;
import businesslogicservice.userblservice.UserControllerService;

/**
 * 
 * @author luck
 * @version 1.0
 * @ 13.10.17
 */
public class Student_Driver {
	StudentBlService  student;
	public Student_Driver(StudentBlService student){
		this.student = student;
	}
	
	public static void main(String[] args) {
		System.out.println("以下为Student的桩测试,包含了登陆、修改密码、选课、取消选课、补选、退选、查看选课、查看我的课程、查看我的选课");
		UserControllerService userController = new UserControllerStub();
		System.out.println("欢迎进入南京哪个大学选课系统");
		System.out.println("账户:121250151,密码:123456");
		char[] password = "123456".toCharArray();
		try {
			userController.login(121250151, password);
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
		// 这里默认为学生登陆
		Student_Stub student = new Student_Stub(userController);
		Student_Driver driver = new Student_Driver(student); 
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
		System.out.println("选择课程1");
		
		space();
		student.select(1);
		
		space();
		System.out.println("取消选课1");
		
		space();
		student.cancel(1);
		
		space();
		System.out.println("查看我的选课");
		Iterator<LessonUniqueVO> chooseList = student.show_mySelection();
		while (chooseList!=null&&chooseList.hasNext()){
			System.out.println(chooseList.next().simpleInfo());
		}
		
		space();
		System.out.println("查看我的课程");
		ScheduleVO schdule = student.show_myLesson();
		if(schdule!=null){
			Iterator<LessonUniqueVO> lessonList = schdule.getlessons();
			while (lessonList!=null&&lessonList.hasNext()){
				System.out.println(lessonList.next().simpleInfo());
			}
		}
		
		
		space();
		System.out.println("查看我的成绩");
		ScoreVO score = student.show_myScore();
		if (score!=null){
			Iterator<LessonRecordVO> lessonRecord =score.getAcademy();
			while(lessonRecord!=null&&lessonRecord.hasNext()){
				System.out.println(lessonRecord.next().getScoreString());
			}
		}
		
		
		space();
		System.out.println("补选课程2");
		student.by_select(2);
		
		space();
		System.out.println("退选课程2");	
		student.by_cancel(2);
		
		space();
		System.out.println("修改密码\n 旧密码：123456 新密码：654321");
		char[] old = "123456".toCharArray();
		char[] newPassword = "654321".toCharArray();
		student.changePassword(old, newPassword);
		
		space();
		System.out.println("学生桩测试完毕");
	}

 }
