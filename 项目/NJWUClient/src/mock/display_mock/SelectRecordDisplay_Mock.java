package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SelectRecordPO;
import businesslogicservice.displayblservice.SelectRecordDisplayService;

public class SelectRecordDisplay_Mock implements SelectRecordDisplayService{
	ArrayList<SelectRecordPO> list = new ArrayList<>();
	SelectRecordPO recordPO = new SelectRecordPO(1, 121250151, 2, 1);
	@Override
	public ArrayList<SelectRecordPO> getChooseList(int stu_id, int type)
			throws RemoteException {
		return list;
	}
	@Override
	public ArrayList<SelectRecordPO> getAll() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SelectRecordPO> getRecordOfLesson(int lesson_Id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
