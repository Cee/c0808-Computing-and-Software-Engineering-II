package businesslogicservice.studentblservice;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.LessonUniqueVO;
import vo.PlanVO;
import vo.ScheduleVO;
import vo.ScoreVO;

public interface StudentBlService {
	/**
	 * 提交选课
	 * @return
	 * @throws RemoteException
	 */
	public boolean submit() throws RemoteException;

	/**
	 * 选课
	 * @param Les_id
	 * @return
	 * @throws RemoteException
	 */
	public boolean select(int Les_id) throws RemoteException;

	/**
	 * 退选
	 * @param Les_id
	 * @return
	 * @throws RemoteException
	 */
	public boolean cancel(int Les_id) throws RemoteException;

	/**
	 * 补选
	 * @param Les_id
	 * @return
	 * @throws RemoteException
	 */
	public boolean by_select(int Les_id) throws RemoteException;

	/**
	 * 退选
	 * @param Les_id
	 * @return
	 * @throws RemoteException
	 */
	public boolean by_cancel(int Les_id) throws RemoteException;

	/**
	 * 查看我的课表
	 * @return
	 * @throws RemoteException
	 */
	public ScheduleVO show_myLesson() throws RemoteException;

	/**
	 * 修改密码
	 * @param old
	 * @param newPassword
	 * @return
	 * @throws RemoteException
	 */
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException;

	/**
	 * 查看我的分数
	 * @return
	 * @throws RemoteException
	 */
	public ScoreVO show_myScore() throws RemoteException;

	/**
	 * 查看补选列表
	 * @param Ins_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonUniqueVO> showBySelection(int Ins_id)
			throws RemoteException;

	/**
	 * 设置选课类型
	 * @param lessonType
	 * @throws RemoteException
	 */
	public void setLessonType(int lessonType) throws RemoteException;

	/**
	 * 查看指定院系的课程
	 * @param Ins_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonUniqueVO> showSelection(int Ins_id)throws RemoteException;

	/**
	 * 查看我的选课
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonUniqueVO> show_mySelection()throws RemoteException;

	/**
	 * 查看院系教学计划
	 * @return
	 * @throws RemoteException
	 */
	public PlanVO showPlan()throws RemoteException;
}
