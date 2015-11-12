package stubdriver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;

import vo.LessonAbstractVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;
import businesslogic.stub.SchTeacher_Stub;
import businesslogic.stub.UserControllerStub;
import businesslogicservice.schteacherblservice.SchTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;

/**
 * 
 * @author Xc
 * @version 1.0
 * @date 13.10.19
 */
public class SchTeacher_Driver {

	SchTeacherBlService schTeacher;

	public SchTeacher_Driver(SchTeacherBlService schTeacher) {
		this.schTeacher = schTeacher;
	}

	public static void main(String[] args) {
		System.out
				.println("以下为SchTeacher的桩测试,包含了" +
						"登陆、修改密码、添加模块、添加类别、添加抽象课程、修改模块、" +
						"修改类别、修改抽象课程、删除模块、删除类别删除抽象课程" +
						"查看某院系教师列表、查看某院系学生列表、查看某院系抽象课程列表");
		UserControllerService userController = new UserControllerStub();
		System.out.println("欢迎进入南京哪个大学选课系统");
		System.out.println("账户:3,密码:123456");
		char[] password = "123456".toCharArray();
		try {
			userController.login(3, password);
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
		// 这里默认为学校老师登陆
		SchTeacher_Stub teacher = new SchTeacher_Stub(userController);
		SchTeacher_Driver driver = new SchTeacher_Driver(teacher);
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
		System.out.println("修改原密码123456为121255");
		schTeacher.changePassword("123456".toCharArray(),
				"121255".toCharArray());

		space();
		System.out.println("添加一个模块 125001，通识通修, 1, 5 ");
		schTeacher.addModule(new ModuleVO(125001, "通识通修", 1, 5));
		
		space();
		System.out.println("添加一个类别125011, 1, 通识通修, 军事课程, 1, 1, 2, 1, 4");
		schTeacher.addType(new TypeVO(125011, 1, "通识通修", "军事课程", 1, 1, 2, 1, 4));

		space();
		System.out.println("添加抽象课程 1250, 软件学院, 1, 1, 通识通修,军事理论与高科技, 1, 4, 1, 2");
		schTeacher.addLesson(new LessonAbstractVO(250001, "军事理论与高科技", 2, 4,1 ,5,3,3, "思想道德课程","通识通修课程",2));
		space();
		System.out.println("修改模块 125001，通识通修, 1, 6");
		schTeacher.modifyModule(new ModuleVO(1, "通识通修", 1, 6));

		space();
		System.out.println("修改类别125011, 1, 通识通修, 军事课程, 1, 1, 2, 1, 5");
		schTeacher.modifyType(new TypeVO(1, 1, "通识通修", "军事课程", 1, 1, 2, 1, 5));

		space();
		System.out.println("修改抽象课程 1250, 软件学院, 1, 1, 通识通修,军事理论与高科技, 1, 4, 1, 1");
		schTeacher.modifyLesson(new LessonAbstractVO(250001, "军事理论与高科技", 2, 4,1 ,5,3,3, "思想道德课程","通识通修课程",2));
		
		space();
		System.out.println("显示院系号为1250的院系学生列表");
		Iterator<StudentVO> stu_list =  schTeacher.showStudentList(1250,1);
		while(stu_list.hasNext()){
			System.out.println(stu_list.next().simpleInfo());
		}

		
		space();
		System.out.println("显示院系号为1250的院系老师列表");
		Iterator<TeacherVO> tea_list = schTeacher.showTeacherList(1250);
		while(tea_list.hasNext()){
			System.out.println(tea_list.next().simpleInfo());
		}
		
		space();
		System.out.println("显示院系号为1250的院系抽象课程列表");
		Iterator<LessonUniqueVO> les_list = schTeacher.showLessonList(1250);
		while(les_list!=null&&les_list.hasNext()){
			System.out.println(les_list.next().simpleInfo());
		}
		
		
		space();
		System.out.println("删除课程 31001");
		schTeacher.deleteLesson(31001);

		space();
		System.out.println("删除模块 1");
		schTeacher.deleteModule(1);

		space();
		System.out.println("删除模块 1");
		schTeacher.deleteType(1);

		space();
		System.out.println("学校教务老师桩测试完毕");

	}

 }
