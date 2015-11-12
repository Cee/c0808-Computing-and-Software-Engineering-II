package businesslogicservice.teacherblservice;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Iterator;

import jxl.read.biff.BiffException;

import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;

public interface TeacherBlService {
	
	/**
	 * 录入成绩
	 * @return
	 * @throws RemoteException
	 */
	public boolean recordScore() throws RemoteException;
	/**
	 * 编辑课程信息
	 * @param lesson
	 * @return
	 * @throws RemoteException
	 */
	public boolean editLesInfo(LessonUniqueVO lesson) throws RemoteException;
	/**
	 * 查看我的课程
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonUniqueVO> showMyLesson() throws RemoteException;
	/**
	 * 查看我的学生列表
	 * @param les_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<StudentVO> showMyStudent(int les_id)
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
	 * 更新分数
	 * @param Stu_Id
	 * @param score
	 * @return
	 * @throws RemoteException
	 */
	public boolean addScore(int Stu_Id, int score) throws RemoteException;
	/**
	 * 选择指定课程进行操作
	 * @param les_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<LessonRecordVO> chooseLesson(int les_id)
			throws RemoteException;
	/**
	 * 查看课程明细
	 * @param les_id
	 * @return
	 * @throws RemoteException
	 */
	public LessonUniqueVO showDetail(int les_id) throws RemoteException;
	/**
	 * 查看新的分数
	 * @return
	 */
	Iterator<LessonRecordVO> showNewScore();
	/**
	 * 批量导入
	 * @param file
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	boolean massImport(File file) throws BiffException, IOException;
}
