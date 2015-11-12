package mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.adminbl.Admin;
import businesslogic.insteacherbl.InsTeacher;
import businesslogic.schteacherbl.SchTeacher;
import businesslogic.studentbl.Student;
import businesslogic.teacherbl.Teacher;
import businesslogic.userbl.UserController;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import businesslogicservice.schteacherblservice.SchTeacherBlService;
import businesslogicservice.studentblservice.StudentBlService;
import businesslogicservice.teacherblservice.TeacherBlService;

public class Main {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		UserController userController = new UserController();
		System.out.println("输入id以及密码后自动进行身份识别以及Mock测试");
		System.out.println("请输入id：");
		int id = Integer.parseInt(getInput());
		System.out.println("请输入密码：");
		String input  = getInput();
		char[] password;
		if (input==null){
			password="".toCharArray();
		} else {
			password = input.toCharArray();
		}
		int type = userController.login(id, password);
		switch (type) {
		case -1:
			AdminblService admin = new Admin(userController);
			AdminMockDriver adminMock = new AdminMockDriver(admin);
			System.out.println("admin");
			adminMock.drive();
			break;
		case 0:
			StudentBlService student = new Student(userController);
			StudentMockDriver studentMock = new StudentMockDriver(student);
			studentMock.drive();
			break;
		case 1:
			TeacherBlService teacher = new Teacher(userController);
			TeacherMockDriver teacherMock = new TeacherMockDriver(teacher);
			teacherMock.drive();
			break;
		case 2:
			InsTeacherBlService insTeacher = new InsTeacher(userController);
			InsTeacherMockDriver insTeacherMock = new InsTeacherMockDriver(
					insTeacher);
			insTeacherMock.drive();
			break;
		case 3:
			SchTeacherBlService schTeacher = new SchTeacher(userController);
			SchTeacherMockDriver schTeacherMock = new SchTeacherMockDriver(
					schTeacher);
			schTeacherMock.drive();
			break;
		default:
			break;
		}
	}

	public static String getInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		;
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (input.length() == 0) {
			return null;
		}
		return input;
	}
}
