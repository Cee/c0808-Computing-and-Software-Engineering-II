package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DatabaseService;
import po.PO;
import po.TeacherPO;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;

public class TeacherInfoDisplay_Stub implements TeacherInfoDisplayService{
	
	DatabaseService teacherDatabase;
	
	public TeacherInfoDisplay_Stub(DatabaseService teacherDatabase){
		this.teacherDatabase = teacherDatabase;
	}

	@Override
	public TeacherPO getTeacher(int tea_id) throws RemoteException {
		System.out.println("这里调用teacherDatabase的find方法 From TeacherInfoDisplay");
		return(TeacherPO) teacherDatabase.find(tea_id);
	}

	@Override
	public ArrayList<TeacherPO> getTeacherOfIns(int ins_id) throws RemoteException {
		System.out.println("这里调用teacherDatabase的find方法 From TeacherInfoDisplay");
		ArrayList<PO> list = teacherDatabase.find(0, ins_id);
		ArrayList<TeacherPO> infoList = new ArrayList<TeacherPO>();
		for (PO po : list) {
			infoList.add((TeacherPO)po);
		}
		return infoList;
	}

}
