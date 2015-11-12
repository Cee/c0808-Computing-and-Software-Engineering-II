package mock;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.adminblservice.AdminblService;

public class AdminMockDriver {
	AdminblService admin;

	public AdminMockDriver(AdminblService admin) {
		this.admin = admin;
	}

	public void space() {
		System.out
				.println("---------------------------------------------------------------");
	}

	public void drive() throws RemoteException {
		System.out.println("以下为默认的测试操作");
		System.out.println("下面开始模拟管理员操作：");
		System.out.println("管理员点击修改用户/删除用户——>学生——>选择院系软件学院，年级2");
		Iterator<StudentVO> sList = admin.showStudentofins(25, 2);
		while (sList.hasNext()) {
			System.out.println(sList.next().simpleInfo());
		}
		space();

		System.out.println("管理员点击修改用户/删除用户——>教师——>选择院系软件学院");
		Iterator<TeacherVO> tList = admin.showTeacherofins(25);
		while (sList.hasNext()) {
			System.out.println(sList.next().simpleInfo());
		}
		space();

		System.out.println("管理员在修改用户/删除用户——学生界面右上角搜索框输入：121250151 点击搜索");
		System.out.println("显示学号为121250151的学生");
		StudentVO student = admin.showStudent(121250151);
		System.out.println(student.simpleInfo());
		space();

		System.out.println("管理员在修改用户/删除用户——教师界面右上角搜索框输入：25014 点击搜索");
		System.out.println("显示工号为25014的教师");
		TeacherVO teacherVO = admin.showTeacher(25014);
		System.out.println(teacherVO.simpleInfo());
		space();

		System.out.println("管理员在修改用户——学生界面选中学号为121250151的学生，点击编辑");
		System.out.println("修改学号为121250151学生的性别为女，点击确定，系统更新学生信息，并重新显示");
		student = new StudentVO(student.getStu_Id(), student.getName(),
				student.getPassword(), student.getGrade(), student.getIns_Id(),
				student.getInstitute(), "女");
		admin.modifyStudent(student);
		student = admin.showStudent(121250151);
		System.out.println(student.simpleInfo());
		System.out.println("执行相同操作，改回来");
		student = new StudentVO(student.getStu_Id(), student.getName(),
				student.getPassword(), student.getGrade(), student.getIns_Id(),
				student.getInstitute(), "男");
		admin.modifyStudent(student);
		student = admin.showStudent(121250151);
		System.out.println(student.simpleInfo());
		space();

		System.out.println("管理员在修改用户——教师界面选中学号为25014的教师，点击编辑");
		System.out.println("修改工号为25014的教师的名字为钦哥哥，点击确定，系统更新教室信息，并重新显示");
		teacherVO = new TeacherVO(teacherVO.getTea_Id(), teacherVO.getIns_Id(),
				"钦哥哥", teacherVO.getPassword(), teacherVO.getInstitution(),
				teacherVO.getType(), teacherVO.getGender());
		admin.modifyTeacher(teacherVO);
		teacherVO = admin.showTeacher(25014);
		System.out.println(teacherVO.simpleInfo());
		teacherVO = new TeacherVO(teacherVO.getTea_Id(), teacherVO.getIns_Id(),
				"刘钦", teacherVO.getPassword(), teacherVO.getInstitution(),
				teacherVO.getType(), teacherVO.getGender());
		System.out.println("执行相同操作，改回来");
		admin.modifyTeacher(teacherVO);
		teacherVO = admin.showTeacher(25014);
		System.out.println(teacherVO.simpleInfo());
		space();

		System.out.println("管理员注册用户");
		System.out.println("输入学号121251111,姓名：王琨，性别男，用户类型:学生，院系：软件学院,点击保存");
		student = new StudentVO(121251111, student.getName(),
				student.getPassword(), student.getGrade(), student.getIns_Id(),
				student.getInstitute(), "男");
		admin.addStudent(student);
		System.out.println("系统提示注册成功");
		System.out.println("管理员在修改用户/删除用户——学生界面搜索121251111的学生");
		student = admin.showStudent(121251111);
		System.out.println(student.simpleInfo());
		space();

		System.out.println("注册新的老师，工号为25111,,个人信息与之前的老师相同");
		teacherVO = new TeacherVO(25111, teacherVO.getIns_Id(), "刘钦",
				teacherVO.getPassword(), teacherVO.getInstitution(),
				teacherVO.getType(), teacherVO.getGender());
		admin.addTeacher(teacherVO);
		System.out.println("搜索工号为25111的教师");
		teacherVO = admin.showTeacher(25111);
		System.out.println(teacherVO.simpleInfo());
		space();

		System.out.println("管理员在删除用户——教师——搜索工号为25111的教师，点击删除");
		System.out.println("系统提示删除成功");

		admin.delTeacher(25111);
		System.out.println("重新搜索该工号");
		teacherVO = admin.showTeacher(25111);
		if (teacherVO.getName() == null) {
			System.out.println("系统提示：没有该老师");
		}
		space();

		System.out.println("管理员在删除用户——学生——搜索学号为121251111的学生，点击删除");
		System.out.println("系统提示删除成功");
		admin.delStudent(121251111);
		System.out.println("重新搜索该学号");
		student = admin.showStudent(121251111);
		if (student == null) {
			System.out.println("系统提示：没有该学生");
		}
		space();

		System.out.println("批量添加功能保留");
		System.out.println("Admin_Mock测试结束");
	}

}
