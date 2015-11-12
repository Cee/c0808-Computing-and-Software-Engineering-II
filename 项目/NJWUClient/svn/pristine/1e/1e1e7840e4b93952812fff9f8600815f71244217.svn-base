package businesslogic.displaybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PO;
import po.StudentPO;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import dataservice.DatabaseService;

public class StudentInfoDisplay implements StudentInfoDisplayService {
	/**
	 * 学生数据服务
	 */
	DatabaseService studentData;
/**
 * 	 * 与调用者共享数据服务
 * @param studentData
 */
	public StudentInfoDisplay(DatabaseService studentData) {
		this.studentData = studentData;
	}

	@Override
	public StudentPO getStudent(int stu_id) throws RemoteException{
			return (StudentPO) studentData.find(stu_id);
	}

	@Override
	public ArrayList<StudentPO> getStudentList(int ins_id, int grade) throws RemoteException{
		ArrayList<StudentPO> sList = new ArrayList<StudentPO>();
			ArrayList<PO> list = studentData.find(ins_id, grade);
			for (PO po : list) {
				sList.add((StudentPO) po);
			}
		return sList;
	}

}
