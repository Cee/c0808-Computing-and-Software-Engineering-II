package stubdriver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonAbstractPO;
import po.LessonUniquePO;
import po.StudentPO;
import vo.LessonAbstractVO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import businesslogic.stub.InsTeacher_Stub;
import businesslogic.stub.UserControllerStub;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;

public class InsTeacher_Driver {
	InsTeacherBlService insTeacher;

	public InsTeacher_Driver(InsTeacherBlService insTeacher) {
		this.insTeacher = insTeacher;
	}

	public static void main(String[] args) {
		System.out.println("以下为院系教务老师的 桩测试");
		UserControllerService userController = new UserControllerStub();
		System.out.println("欢迎进入南京哪个大学选课系统");
		System.out.println("账户:1250002,密码:123456");
		char[] password = "123456".toCharArray();
		try {
			userController.login(1250002, password);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 这里默认为院系教务老师登陆
		InsTeacherBlService insTeacher = new InsTeacher_Stub(userController);
		InsTeacher_Driver driver = new InsTeacher_Driver(insTeacher);
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
		space();
		System.out.println("修改密码 输入： 原密码：123456 新 密码 654321");
		insTeacher.changePassword("123456".toCharArray(),
				"654321".toCharArray());
	
		space();
		System.out
				.println("编辑教学计划：添加课程 软件学院, 31001,6 , 专业核心课程, 软件工程I, 2, 4, 2, 2");
		LessonAbstractVO lesson_abstractPO = new LessonAbstractVO(250001, "软件工程I", 2, 4,1 ,5,3,3, "专业核心课程","学科专业课程",2);
		insTeacher.addLesson(lesson_abstractPO);
		
		space();
		System.out
				.println("修改教学计划：修改课程 软件学院, 31001,6 , 专业核心课程, 软件工程2, 2, 4, 2, 2 ");
		insTeacher.modifyPlan(new LessonAbstractVO(250001, "软件工程2", 2, 4,1 ,5,3,3, "专业核心课程","学科专业课程",2));
		LessonUniqueVO lesson = new LessonUniqueVO(new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程"));	
		space();
		System.out.println("发布课程软工2, 001, 软件学院, 仙II-303, 3, 240,238, 0, 1250001, 刘钦, 1, 3, 4");
		insTeacher.publishLesson(new LessonUniqueVO(new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程")));
		System.out.println("修改发布课程软工2, 001, 软件学院, 仙II-304, 3, 240,238, 0, 1250001, 刘钦 1, 3, 4");
		
		space();
		insTeacher.modifyLesson(new LessonUniqueVO(new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程")));
		
		space();
		System.out.println("添加课程学生，在软工2中添加学生121250151");
		LessonRecordVO record = new LessonRecordVO(121250151,lesson );
		insTeacher.addStudent(record);
		
		space();
		System.out.println("删除课程学生，在软工2中删除学生12150151");
		insTeacher.deleteStudent(record);
		
		space();
		System.out.println("显示该院系的所有课程");
		Iterator<LessonUniqueVO> lessonList = insTeacher.showLesson();
		while(lessonList.hasNext()){
			System.out.println(lessonList.next().simpleInfo());
		}
		
		space();
		System.out.println("显示指定课程的学生 软工2");
		Iterator<LessonRecordVO> studentList = insTeacher.showStudentofLesson(1);
		while (studentList.hasNext()){
			System.out.println(studentList.next().getScoreString());
		}
		System.out.println("这里因为底层StudentData桩的find方法固定返回某学生信息，这里是两条相同的学生信息");
		System.out.println("院系教务老师桩测试完毕");
		// public boolean addLesson(LessonAbstractPO
		// lesson_abstractPO);//计划——>添加课程
		// public boolean publishLesson(LessonAbstractPO lesson_abstractPO,
		// LessonUniquePO newLesson);//发布计划中的课程
		// public boolean modifyPlan(LessonAbstractPO
		// lesson_abstractPO);//修改教学计划（即计划中的课程);
		// public boolean modifyLesson(LessonUniquePO
		// lesson_uniquePO);//修改已发布课程
		// public boolean addStudent(Les_RecordPO les_RecordPO); //在某门课中添加学生
		// public boolean deleteStudent(Les_RecordPO les_RecordPO); //在某门课中删除学生
		// public ArrayList<LessonUniquePO> showLesson();//显示该院系的 所有课程
		// public ArrayList<StudentPO> showStudentofLesson(int les_id);
		// public boolean changePassword(char[] old, char[] newPassword);//修改密码
		// public PlanVO showPlan();
	}

 }
