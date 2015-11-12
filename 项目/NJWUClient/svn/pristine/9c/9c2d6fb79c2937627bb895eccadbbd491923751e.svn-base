package mock;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.ScheduleVO;
import vo.ScoreVO;
import businesslogicservice.studentblservice.StudentBlService;

public class StudentMockDriver {
	StudentBlService student;

	public StudentMockDriver(StudentBlService student) {
		this.student = student;
	}

	public void space() {
		System.out
				.println("---------------------------------------------------------------");
	}

	public void drive() throws RemoteException {
		System.out.println("以下为默认的测试操作");
		System.out.println("模拟选课");
		space();
		System.out.println("1.用户点击选课——>通识研讨课选课");
		student.setLessonType(1);

		System.out.println("2.系统显示可选的通识研讨课");
		Iterator<LessonUniqueVO> list = student.showSelection(0);
		show(list);
		space();

		System.out.println("3.系统显示用户已选择的通识研讨课");
		list = student.show_mySelection();
		show(list);
		space();

		System.out.println("4.用户取消对课程编号11的课程的选课，同时选择课程编号为10,14的课程");

		student.cancel(11);
		student.select(10);
		student.select(14);
		System.out.println("5.用户点击提交，系统将最新数据更新到服务器");
		student.submit();
		System.out.println("6.刷新，系统重新显示该同学已选择的通识研讨课");
		list = student.show_mySelection();
		show(list);
		space();
		// 复原数据
		student.cancel(14);
		student.cancel(10);
		student.select(11);
		student.submit();
		list = student.show_mySelection();
		show(list);
		
		space();

		System.out.println("7.用户点击选课——>跨专业选课——>软件学院");
		System.out.println("8.系统显示该专业可选课程");
		student.setLessonType(5);
		list = student.showSelection(25);
		show(list);
		System.out.println("9.系统显示该学生已选跨专业课");
		list = student.show_mySelection();
		show(list);
		space();

		System.out.println("10.学生选择三号课程点击提交");
		student.select(3);
		student.submit();
		System.out.println("11.系统更新数据,刷新重新显示该同学已选跨专业课程");
		list = student.show_mySelection();
		show(list);
		space();
		// 数据回复
		student.cancel(3);
		student.submit();

		System.out.println("12.学生点击退课，系统显示学生已有课程");
		space();

		ScheduleVO scheduleVO = student.show_myLesson();
		show(scheduleVO.getlessons());

		System.out.println("12.假设补选开放,学生点击补选——>通识研讨课补选");
		System.out.println("13.系统显示可补选的通识课");
		student.setLessonType(1);
		list = student.showBySelection(0);
		show(list);

		System.out.println("14.此处暂时不考虑抢课机制，学生选择课程24");
		student.by_select(24);
		System.out.println("系统提示选课成功");
		space();
		System.out.println("15.学生查看我的课程");
		scheduleVO = student.show_myLesson();
		show(scheduleVO.getlessons());
		student.by_cancel(24);

		System.out.println("16.学生点击查看我的成绩");
		ScoreVO scores = student.show_myScore();
		Iterator<LessonRecordVO> lessonRecord = scores.getAcademy();
		while (lessonRecord.hasNext()){
			System.out.println(lessonRecord.next().getScoreString());
		}
			

		System.out.println("17.学生点击修改密码,输入旧密码，两次输入新密码，点击确定");
		student.changePassword("19961018".toCharArray(),
				"19961018".toCharArray());
		System.out.println("系统提示修改成功");
		System.out.println("Admin_Mock测试结束");
	}

	public void show(Iterator<LessonUniqueVO> list) {
		boolean hasLesson = false;
		while (list.hasNext()) {
			System.out.println(list.next().normalInfo());
			hasLesson=true;
		}
		if(!hasLesson){
			System.out.println("没有课程.");
		}
	}
}
