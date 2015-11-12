package businesslogicservice.adminblservice;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.read.biff.BiffException;

import vo.StudentVO;
import vo.TeacherVO;

/**
 * 
 * @author Cee
 * @date 13.10.17
 * @version 1.0 管理员接口
 */
public interface AdminblService {
	/**
	 * add
	 */
	/**
	 * 批量添加学生
	 * 调用adminMassManager中的addStudent方法	
	 * @param studentListFile
	 * @return
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public ArrayList<StudentVO> addStudent (File studentListFile) throws BiffException, IOException;
	/**
	 * 批量添加教师
	 * 调用adminMassManager中的addTeacher方法	 
	 * @param teacherListFile
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public ArrayList<TeacherVO> addTeacher (File teacherListFile) throws BiffException, IOException;
	/**
	 * 管理员添加学生
	 * 调用studentData 
	 * 若成功返回true 反则返回false;
	 * @param student
	 * @return
	 * @throws RemoteException
	 */
	public boolean addStudent(StudentVO student) throws RemoteException;// 添加学生
	/**
	 * 管理员添加老师
	 * 调用teacherData 
	 * 若成功返回true，失败返回true
	 * @param teacher
	 * @return
	 * @throws RemoteException
	 */
	public boolean addTeacher(TeacherVO teacher) throws RemoteException;// 添加老师

	
	
	
	/**
	 * delete
	 */
	/**
	 * 根据工号数组批量删除教师
	 * 调用adminMassManager中的delTeacher方法 * 
	 * @param teachers
	 * @return 
	 * @throws RemoteException
	 */
	public boolean delTeacher (int[] teachers) throws RemoteException;

	/**
	 * 根据id删除学生 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean delStudent(int id) throws RemoteException;// 删除学生
	/**
	 * 根据id删除老师 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean delTeacher(int id) throws RemoteException;// 删除老师
	/**
	 * 根据学号数组删除学生
	 * 调用adminMassManage中的delStudent方法* 
	 * @param students
	 * @return
	 * @throws RemoteException 
	 */
	boolean delStudent(int[] students) throws RemoteException;
	
	
	
	/**
	 * show
	 */
	/**
	 * 根据学号显示学生具体信息
	 * 调用StudentInfoDisplay中的getStudent方法 * 
	 * @param Stu_id
	 * @return
	 * @throws RemoteException
	
	 */
	public StudentVO showStudent(int Stu_id) throws RemoteException;// 搜索指定学号学生
	/**
	 * 根据院系号以及年级显示学生列表
	 * 调用StudentInfoDisplay中的getStudentOfIns方法 * 
	 * @param ins_id
	 * @param grade
	 * @return
	 * @throws RemoteException
	
	 */
	public Iterator<StudentVO> showStudentofins(int ins_id, int grade)
			throws RemoteException;// 搜索指定院系学生列表
	/**
	 * 根据教师工号显示教师详细信息
	 * 调用TeacherInfoDisplay中的getTeacher方法	 * 
	 * @param Tea_id
	 * @return
	 * @throws RemoteException

	 */
	public TeacherVO showTeacher(int Tea_id) throws RemoteException;// 搜索指定工号老师

	/**
	 * 根据教师院系显示该院系教师列表
	 * 调用TeacherInfoDisplay中的getTeacherOfIns方法
	 * 其中ins_id=0时返回的是学校教务老师列表	 * 
	 * @param ins_id
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<TeacherVO> showTeacherofins(int ins_id)
			throws RemoteException;// 搜索指定院系老师列表
	
	
	
	
	/**
	 * modify
	 */
	/**
	 * 
	 * 修改学生信息
	 * @param student
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public boolean modifyStudent(StudentVO student) throws RemoteException;// 修改学生
	/**
	 * 修改教师信息
	 * @param teacher
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyTeacher(TeacherVO teacher) throws RemoteException;// 修改教师
	
}
