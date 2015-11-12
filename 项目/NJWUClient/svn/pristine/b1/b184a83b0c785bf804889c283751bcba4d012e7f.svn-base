package businesslogic.displaybl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.PO;
import po.SelectRecordPO;
import businesslogicservice.displayblservice.SelectRecordDisplayService;
import dataservice.DatabaseService;

public class SelectRecordDisplay implements SelectRecordDisplayService {
	/**
	 * 选课记录数据服务
	 */
	DatabaseService selectRecordData;
	/**
	 * 	 * 与调用者共享数据服务
	 * @param selectRecordData
	 */
	public SelectRecordDisplay(DatabaseService selectRecordData) {
		this.selectRecordData = selectRecordData;
	}
	@Override
	public ArrayList<SelectRecordPO> getRecordOfLesson(int lesson_Id) throws RemoteException{
		ArrayList<SelectRecordPO> cList = new ArrayList<SelectRecordPO>();
		ArrayList<PO> list = selectRecordData.find(lesson_Id, 0);
		for (PO po : list) {
			cList.add((SelectRecordPO) po);
		}
	return cList;
	}
	@Override
	public ArrayList<SelectRecordPO> getAll() throws RemoteException{
		ArrayList<SelectRecordPO> cList = new ArrayList<SelectRecordPO>();
		ArrayList<PO> list = selectRecordData.findAll();
		for (PO po : list) {
			cList.add((SelectRecordPO) po);
		}
	return cList;
	}
	@Override
	public ArrayList<SelectRecordPO> getChooseList(int stu_id, int type) throws RemoteException{
		ArrayList<SelectRecordPO> cList = new ArrayList<SelectRecordPO>();

			ArrayList<PO> list = selectRecordData.find(stu_id, type);
			for (PO po : list) {
				cList.add((SelectRecordPO) po);
			}
		return cList;
	}

}
