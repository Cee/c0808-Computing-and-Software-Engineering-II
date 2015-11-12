package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonAbstractPO;

public interface PlanDisplayService {
	/**
	 * 根据院系号获取院系教学计划
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LessonAbstractPO> getPlanofIns(int ins_id)
			throws RemoteException;

	/**
	 * 根据课程号获取单个课程
	 * @param LesAb_id
	 * @return
	 * @throws RemoteException
	 */
	LessonAbstractPO getPlan(int LesAb_id) throws RemoteException;

}
