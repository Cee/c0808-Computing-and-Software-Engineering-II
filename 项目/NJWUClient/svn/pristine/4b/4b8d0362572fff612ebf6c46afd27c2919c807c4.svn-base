package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DatabaseService;
import dataservice.lessondataservice.LessonUnData_Stub;

import po.LessonUniquePO;
import po.PO;
import po.SelectRecordPO;
import businesslogicservice.displayblservice.SelectRecordDisplayService;
/**
 * 
 * @author luck
 * @version 1.0
 * @13.10.18
 * 
 */
public class SelectRecordDisplay_Stub implements SelectRecordDisplayService {
	DatabaseService selectRecordData;
	DatabaseService lessonUndata;
	
	public SelectRecordDisplay_Stub(DatabaseService selectRecordData) {
		this.selectRecordData = selectRecordData;
		lessonUndata = new LessonUnData_Stub();
	}
	

	@Override
	public ArrayList<SelectRecordPO> getChooseList(int stu_id, int type) throws RemoteException {
		System.out.println("SelectRecordDisplay调用selectRecordData的find方法查找");
		ArrayList<PO> list = selectRecordData.find(type, stu_id);
		ArrayList<SelectRecordPO> sList = new ArrayList<SelectRecordPO>();
		for (PO po : list) {
			 SelectRecordPO selectPO = (SelectRecordPO) po;
			 sList.add(selectPO);
		}
		System.out.println("根据课程记录中的课程号查找课程具体信息，测试桩中返回的是给定的信息，所以这里是两条相同记录");
		return sList;
	}


	@Override
	public ArrayList<SelectRecordPO> getAll() throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<SelectRecordPO> getRecordOfLesson(int lesson_Id)
			throws RemoteException {
		return null;
	}

}
