package businesslogicservice.insteacherblservice;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import vo.LessonAbstractVO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.19 院系教务老师业务接口
 */
public interface InsTeacherBlService {
	/**
	 * Add
	 */
	/**
	 * 发布课程
	 * @param newLesson
	 * @return
	 * @throws RemoteException
	 */
	boolean publishLesson(LessonUniqueVO newLesson)throws RemoteException;

	/**
	 * 根据文件导入课程记录
	 * @param file
	 * @return
	 */
	boolean addStudent(File file) ;
	/**
	 * 添加课程（教学计划中）
	 * 调用planEditor
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public boolean addLesson(LessonAbstractVO vo) throws RemoteException;// 计划——>添加课程
	
	/**
	 * 增加一条课程记录
	 * 调用studentManager
	 * 
	 * @param les_RecordVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addStudent(LessonRecordVO les_RecordVO)throws RemoteException; // 在某门课中添加学生

	

	
	/**
	 * modify
	 */
	/**
	 * 修改教学计划
	 * 调用planEditor
	 * @param lesson_abstractVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyPlan(LessonAbstractVO lesson_abstractVO)throws RemoteException;// 修改教学计划（即计划中的课程);

	/**
	 * 修改已发布课程
	 * 调用LessonPublisher
	 * @param lesson_uniqueVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyLesson(LessonUniqueVO lesson_uniqueVO)throws RemoteException;// 修改已发布课程


	/**
	 * Delete
	 */
	/**
	 * 删除一条课程记录
	 * 调用StudentManager
	 * @param les_RecordVO
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteStudent(LessonRecordVO les_RecordVO)throws RemoteException; // 在某门课中删除学生
	/**
	 * 根据课程编号删除一门课程
	 * @param Les_Id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteLesson(int Les_Id)throws RemoteException;
	
	/**
	 * 根据课程号书一门抽象课程
	 * @param les_Ab_id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deletePlan(int les_Ab_id) throws RemoteException;
	
	/**
	 * Show
	 */
	/**
	 * 查看该院系所有已发布课程
	 * 调用LessonDisplay
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonUniqueVO> showLesson()throws RemoteException;// 显示该院系的 所有课程
	/**
	 * 查看指定课程的学生列表
	 * 调用RecordDisplay
	 * @param les_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonRecordVO> showStudentofLesson(int les_id)throws RemoteException;


	/**
	 * 查看院系教学计划
	 * @return
	 * @throws RemoteException
	 */
	public PlanVO showPlan()throws RemoteException;
	/**
	 * 获取院系教学计划
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonAbstractVO> getPlan()throws RemoteException;
	/**
	 * 查看院系指定年级的学生
	 * @param grade
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<StudentVO> showStudent(int grade)throws RemoteException;

	
	/**
	 * 得到所有课程类别信息
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<TypeVO> getAllTypes() throws RemoteException;
	/**
	 * 得到所有课程模块信息
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<ModuleVO> getAllModules() throws RemoteException;	
	
	public boolean changePassword(char[] old, char[] newPassword)throws RemoteException;// 修改密码


	public ArrayList<TeacherVO> getTeacherOfIns(int ins_id) throws RemoteException;

	boolean addStudent(int les_Id,int grade) throws RemoteException;

	TeacherVO getTeacher(int tea_id) throws RemoteException;
	
}
