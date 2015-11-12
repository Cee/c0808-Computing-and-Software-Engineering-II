package mock;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.FrameVO;
import vo.LessonUniqueVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public class SchTeacherMockDriver {
	SchTeacherBlService schTeacher;

	public SchTeacherMockDriver(SchTeacherBlService schTeacher) {
		this.schTeacher = schTeacher;
	}

	public void space() {
		System.out
				.println("---------------------------------------------------------------");
	}

	public void drive() throws RemoteException {
		System.out.println("下面开始学校教务老师的功能测试");
		space();
		System.out.println("1.学校教务点击查看信息——查看课程信息——选择院系软件工程");
		Iterator<LessonUniqueVO> lessonList = schTeacher.showLessonList(25);
		while (lessonList.hasNext()) {
			System.out.println(lessonList.next().normalInfo());
		}
		space();
		
		System.out.println("2.学校教务老师点击查看信息——查看学生信息——选择软件工程二年级");
		Iterator<StudentVO> studentList = schTeacher.showStudentList(25, 2);
		while (studentList.hasNext()) {

			System.out.println(studentList.next().simpleInfo());

		}
		space();

		System.out.println("3.学校教务老师点击查看信息——查看教师信息——选择软件工程");
		Iterator<TeacherVO> teacherList = schTeacher.showTeacherList(25);
		while (teacherList.hasNext()) {
			System.out.println(teacherList.next().simpleInfo());
		}
		space();

		System.out.println("4.学校教务老师点击查看信息——查看各院系教学计划——选择院系软件工程");
		PlanVO plan = schTeacher.showPlan(25);
		System.out.println(plan);
		space();

		System.out.println("5.学校教务老师点击编辑教学框架,系统显示已有框架");
		FrameVO frame = schTeacher.showFrame();
		System.out.println(frame);
		System.out.println("学校教务老师功能测试完毕");

		System.out.println("6.学校教务老师修改教学框架");
		space();
		System.out.println("系统提示修改成功");
		space();
		System.out.println("7.学校教务 老师修改密码");
		schTeacher.changePassword("123456".toCharArray(),
				"123456".toCharArray());
		System.out.println("学校教务老师测试完毕");
	}
}
