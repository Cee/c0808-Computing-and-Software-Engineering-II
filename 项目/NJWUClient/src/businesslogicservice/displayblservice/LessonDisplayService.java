package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonUniquePO;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.17 提供与课程记录表有关的信息
 */
public interface LessonDisplayService {
	/**
	 * 根据课程类别以及院系号获取待选课程
	 * @param type
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LessonUniquePO> getByChooseLesson(int type, int ins_id) throws RemoteException;

	/**
	 * 根据院系号获取所有该院系课程
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LessonUniquePO> getLessonsOfIns(int ins_id)throws RemoteException;

	/**
	 * 根据教师号获取该教师课程
	 * @param tea_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LessonUniquePO> getLessonOfTeacher(int tea_id)throws RemoteException;

	/**
	 * 根据课程编号获取课程信息
	 * @param Les_id
	 * @return
	 * @throws RemoteException
	 */
	public LessonUniquePO getLessonInfo(int Les_id)throws RemoteException;
}
