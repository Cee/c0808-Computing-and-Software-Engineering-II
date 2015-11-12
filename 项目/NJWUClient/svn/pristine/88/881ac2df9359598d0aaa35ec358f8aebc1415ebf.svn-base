package mock;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import businesslogicservice.teacherblservice.TeacherBlService;

public class TeacherMockDriver {
	TeacherBlService teacher;

	public TeacherMockDriver(TeacherBlService teacher) {
		this.teacher = teacher;
	}

	public void space() {
		System.out
				.println("---------------------------------------------------------------");
	}

	public void drive() throws RemoteException {
		System.out.println("下面对任课老师进行模拟操作");
		System.out.println("1.点击查看课程学生,系统显示该教师的所有课程列表");
		Iterator<LessonUniqueVO> list = teacher.showMyLesson();
		show(list);
		space();

		System.out.println("2.教师在对应课程后点击查看，查看该课程学生列表");
		Iterator<StudentVO> slist = teacher.showMyStudent(4);
		while(slist.hasNext()) {
			System.out.println(slist.next().simpleInfo());
		}
		space();
		System.out
				.println("3.返回，选择编辑课程信息——>选中课程4——>点击编辑，系统显示该课程完整信息，并允许教师进行编辑");
		LessonUniqueVO lesson = teacher.showDetail(4);
		System.out.println(lesson.fullInfo());
		System.out.println("4.编辑课程信息，点击提交");
		lesson = new LessonUniqueVO(lesson.getLes_Id(), lesson.getLes_Id_Ab()	, lesson.getLessonName()	, lesson.getIns_Id(), lesson.getDay(), lesson.getStart(), lesson.getEnd(), lesson.getIntroduction(), "《软件开发的技术基础》", lesson.getOutline(), lesson.getCredit(), lesson.getMax_stu_num(), lesson.getCur_stu_num(), lesson.getState(), lesson.getTea_Id(), lesson.getLocation(),lesson.getTerm());
		teacher.editLesInfo(lesson);
		System.out.println("5.系统保存信息");
		System.out.println("6.返回重新查看");
		lesson = teacher.showDetail(4);
		
		System.out.println(lesson.fullInfo());
		lesson = new LessonUniqueVO(lesson.getLes_Id(), lesson.getLes_Id_Ab()	, lesson.getLessonName()	, lesson.getIns_Id(), lesson.getDay(), lesson.getStart(), lesson.getEnd(), lesson.getIntroduction(), "", lesson.getOutline(), lesson.getCredit(), lesson.getMax_stu_num(), lesson.getCur_stu_num(), lesson.getState(), lesson.getTea_Id(), lesson.getLocation(),lesson.getTerm());

		teacher.editLesInfo(lesson);
		space();

		System.out.println("7.教师点击登记成绩——>选择课程4——>点击登记");
		Iterator<LessonRecordVO> record = teacher.chooseLesson(4);
		while (record.hasNext()) {
			System.out.println(record.next().getScoreString());
		}
		System.out.println("8.教师开始登记成绩，将167与156的分数设为100");
		teacher.addScore(121250167, 100);
		teacher.addScore(121250156, 100);
		System.out.println("9.点击保存");
		teacher.recordScore();
		System.out.println("10,返回，重新进入");
		record = teacher.chooseLesson(4);
		while (record.hasNext()) {
			System.out.println(record.next().getScoreString());
		} 
		
		// 复原
		teacher.addScore(121250167, 0);
		teacher.addScore(121250156, 0);
		teacher.recordScore();
		space();
		System.out.println("11,修改密码");
		teacher.changePassword("25014".toCharArray(), "25014".toCharArray());
		System.out.println("Teacher测试结束");
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
