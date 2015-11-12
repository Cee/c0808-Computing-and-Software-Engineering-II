package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StudentPO;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.17 获取学生信息
 */
public interface StudentInfoDisplayService {
	/**
	 * 根据学号获取学生个人信息
	 * @param stu_id
	 * @return
	 * @throws RemoteException
	 */
	public StudentPO getStudent(int stu_id) throws RemoteException;
	/**
	 * 根据院系号获取学生列表
	 * @param ins_id
	 * @param grade
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StudentPO> getStudentList(int ins_id, int grade)throws RemoteException;

}
