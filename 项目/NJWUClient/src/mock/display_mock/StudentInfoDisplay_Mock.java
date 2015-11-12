package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StudentPO;
import businesslogicservice.displayblservice.StudentInfoDisplayService;

public class StudentInfoDisplay_Mock implements StudentInfoDisplayService{
	StudentPO student = new StudentPO(12125151, "王琨", "121250151".toCharArray(), 25, "软件学院", "男", 2);
	@Override
	public StudentPO getStudent(int stu_id) throws RemoteException {
		return student;
	}

	@Override
	public ArrayList<StudentPO> getStudentList(int ins_id, int grade)
			throws RemoteException {
		ArrayList<StudentPO> list = new ArrayList<>();
		list.add(student);
		return list;
	}

}
