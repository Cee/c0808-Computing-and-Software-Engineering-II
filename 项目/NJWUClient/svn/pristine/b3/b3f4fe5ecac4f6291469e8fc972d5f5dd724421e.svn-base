package businesslogicservice.schteacherblservice;

import java.rmi.RemoteException;
import java.util.Iterator;

import po.SystemState;
import vo.FrameVO;
import vo.LessonAbstractVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;

/**
 * 
 * @author Xc
 * @version 1.0
 * @date 13.10.19
 * 
 */

public interface SchTeacherBlService {
	/**
	 * 添加抽象课程
	 * @param lesson
	 * @return
	 * @throws RemoteException
	 */
	public boolean addLesson(LessonAbstractVO lesson) throws RemoteException;
	
	/**
	 * 分配选课
	 * @throws RemoteException
	 */
	public void alloSelect() throws RemoteException;

	/**
	 * 添加类别
	 * @param typeVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addType(TypeVO typeVO) throws RemoteException;

	/**
	 * 添加模块
	 * @param moduleVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addModule(ModuleVO moduleVO) throws RemoteException;

	/**
	 * 修改课程信息
	 * @param lessonAbstractVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyLesson(LessonAbstractVO lessonAbstractVO)
			throws RemoteException;

	/**
	 * 修改课程类别
	 * @param typeVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyType(TypeVO typeVO) throws RemoteException;

	/**
	 * 修改模块信息
	 * @param moduleVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyModule(ModuleVO moduleVO) throws RemoteException;

	
	/**
	 * 删除课程类别
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteType(int id) throws RemoteException;
	/**
	 * 删除课程模块
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteModule(int id) throws RemoteException;
	/**
	 * 删除抽象课程
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteLesson(int id) throws RemoteException;
	/**
	 * 查看指定院系指定年级的学生
	 * @param ins_id
	 * @param grade
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<StudentVO> showStudentList(int ins_id, int grade)
			throws RemoteException;

	/**
	 * 查看指定院系的老师
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<TeacherVO> showTeacherList(int ins_id)
			throws RemoteException;

	/**
	 * 查看指定院系的课程
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonUniqueVO> showLessonList(int ins_id)
			throws RemoteException;

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
	 * 设置系统状态
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public boolean setState(SystemState state) throws RemoteException;

	/**
	 * 查看教学计划
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	PlanVO showPlan(int ins_id) throws RemoteException;

	/**
	 * 查看教学框架
	 * @return
	 * @throws RemoteException
	 */
	FrameVO showFrame() throws RemoteException;

	boolean sendBroadCast(String message) throws RemoteException;
}
