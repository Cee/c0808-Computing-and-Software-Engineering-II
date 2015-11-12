package businesslogic.displaybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PO;
import po.TeacherPO;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import dataservice.DatabaseService;
/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.11.8
 * 实现教师展示接口
 */
public class TeacherInfoDisplay implements TeacherInfoDisplayService {
	/**
	 * 教师数据服务
	 */
	DatabaseService teacherData;
	/**
	 * 	
	 * 与调用者共享数据服务
	 * @param teacherData
	 */
	public TeacherInfoDisplay(DatabaseService teacherData) {
		this.teacherData = teacherData;
	}

	@Override
	public TeacherPO getTeacher(int tea_id) throws RemoteException{
			return (TeacherPO) teacherData.find(tea_id);
	}

	@Override
	public ArrayList<TeacherPO> getTeacherOfIns(int ins_id) throws RemoteException{
		ArrayList<TeacherPO> tList = new ArrayList<TeacherPO>();
			ArrayList<PO> list = teacherData.find(0, ins_id);
			for (PO po : list) {
				tList.add((TeacherPO) po);
			}
		return tList;
	}

}
