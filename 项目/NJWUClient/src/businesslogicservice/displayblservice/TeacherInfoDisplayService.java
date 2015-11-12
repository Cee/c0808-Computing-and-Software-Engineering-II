package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TeacherPO;

public interface TeacherInfoDisplayService {
	/**
	 * 根据教师号获取教师信息
	 * @param tea_id
	 * @return
	 * @throws RemoteException
	 */
	public TeacherPO getTeacher(int tea_id) throws RemoteException;

	/**
	 * 根据院系号获取院系信息
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TeacherPO> getTeacherOfIns(int ins_id)throws RemoteException;

}
