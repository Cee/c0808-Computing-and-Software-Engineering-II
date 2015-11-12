package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SelectRecordPO;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.17 获取选课信息
 */
public interface SelectRecordDisplayService { 
	/**
	 * 根据学号以及类别获取该学生该类别的所有选课
	 * @param stu_id
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SelectRecordPO> getChooseList(int stu_id, int type) throws RemoteException;
	/**
	 * 获取所有选课记录
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SelectRecordPO> getAll() throws RemoteException;
	/**
	 * 获取某课程的选课记录
	 * @param lesson_Id
	 * @return
	 * @throws RemoteException
	 */
	ArrayList<SelectRecordPO> getRecordOfLesson(int lesson_Id)
			throws RemoteException;
}
