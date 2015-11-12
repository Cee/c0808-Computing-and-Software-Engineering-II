package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.18 提供根据Lesson_Record表所需要显示的内容
 */
public interface LessonRecordDisplayService {
	/**
	 * 根据学生学号获取课程记录
	 * @param stu_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LessonRecordPO> getLessonRecord(int stu_id)
			throws RemoteException;

	/**
	 * 根据课程号获取课程记录
	 * @param les_id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LessonRecordPO> getStudentOfLesson(int les_id)
			throws RemoteException;
}
