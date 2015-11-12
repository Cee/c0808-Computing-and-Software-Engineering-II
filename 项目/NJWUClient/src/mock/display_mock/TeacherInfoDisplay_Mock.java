package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TeacherPO;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;

public class TeacherInfoDisplay_Mock implements TeacherInfoDisplayService{
	TeacherPO teacher1 = new TeacherPO(25014, 25, "刘钦", "25014".toCharArray(), "软件工程", 1, "男");
	TeacherPO teacher2 = new TeacherPO(25041, 25, "王东霞", "25041".toCharArray(), "软件工程", 2, "女");
	TeacherPO teacher3 = new TeacherPO(100, 1, "学校教务老师", "100".toCharArray(), "公共课程", 3, "男");
	
	@Override
	public TeacherPO getTeacher(int tea_id) throws RemoteException {
		return  teacher1;
	}

	@Override
	public ArrayList<TeacherPO> getTeacherOfIns(int ins_id)
			throws RemoteException {
		ArrayList<TeacherPO> teacherList = new ArrayList<>();
		teacherList.add(teacher1);
		teacherList.add(teacher2);
		return teacherList;
	}

}
