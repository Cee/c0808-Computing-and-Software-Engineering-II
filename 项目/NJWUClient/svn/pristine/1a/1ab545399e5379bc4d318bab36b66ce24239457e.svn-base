package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DatabaseService;

import po.PO;
import po.StudentPO;
import businesslogicservice.displayblservice.StudentInfoDisplayService;

public class StudentInfoDisplay_Stub implements StudentInfoDisplayService{
	DatabaseService studentDatabase ;
	public StudentInfoDisplay_Stub(DatabaseService  studentDatabase){
		this.studentDatabase = studentDatabase;
	}
	@Override
	public StudentPO getStudent(int stu_id) throws RemoteException {
		System.out.println("这里调用studentDatabase的find方法 From StudentInfoDisplay");
		return(StudentPO) studentDatabase.find(stu_id);
	}

	@Override
	public ArrayList<StudentPO> getStudentList(int ins_id,int grade) throws RemoteException {
		System.out.println("这里调用studentDatabase的find方法 From StudentInfoDisplay");
		ArrayList<PO> list = studentDatabase.find(0, ins_id);
		ArrayList<StudentPO> infoList = new ArrayList<StudentPO>();
		for (PO po : list) {
			infoList.add((StudentPO) po);
		}
		return infoList;
	}

}
