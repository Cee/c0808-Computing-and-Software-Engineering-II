package businesslogic.stub;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.read.biff.BiffException;
import po.StudentPO;
import po.TeacherPO;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory_Stub;
import dataservice.DatabaseService;
import dataservice.Table;
/**
 * 
 * @author Cee
 * @date 13.10.18
 * @version 1.0 管理员功能桩测试
 */

public class Admin_Stub implements AdminblService{

	UserControllerService userController;
	DatabaseFactory_Stub databaseFactory = new DatabaseFactory_Stub();
	DatabaseService studentListData = databaseFactory.getDataBase_Stub(Table.student);
	DatabaseService teacherListData = databaseFactory.getDataBase_Stub(Table.teacher);
	StudentInfoDisplayService studentInfo = new StudentInfoDisplay_Stub(studentListData);
	TeacherInfoDisplayService teacherInfo = new TeacherInfoDisplay_Stub(teacherListData);
	
	public Admin_Stub(UserControllerService userController){
		this.userController = userController;
		sayHello();
	}
	
	public void sayHello(){
		System.out.println("欢迎您的登陆，您的身份是管理员");
	}

	@Override
	public boolean addStudent(StudentVO student) throws RemoteException {
		studentListData.insert(new StudentPO(student.getStu_Id(), student.getName(), student.getPassword(), student.getIns_Id(), student.getInstitute(), student.getGender(), student.getGrade()));
		System.out.println("添加学生成功 From AdminBl");
		return true;
	}

	@Override
	public boolean addTeacher(TeacherVO teacher) throws RemoteException {
		teacherListData.insert(null);
		System.out.println("添加教师成功 From AdminBl");
		return true;
	}

	@Override
	public boolean delStudent(int id) throws RemoteException {
		studentListData.delete(id);
		System.out.println("删除学生成功 From AdminBl");
		return true;
	}

	@Override
	public boolean delTeacher(int id) throws RemoteException {
		teacherListData.delete(id);
		System.out.println("删除老师成功 From AdminBl");
		return true;
	}

	@Override
	public boolean modifyStudent(StudentVO student) throws RemoteException {
		studentListData.update(null);
		System.out.println("更改学生信息成功 From AdminBl");
		return true;
	}

	@Override
	public boolean modifyTeacher(TeacherVO teacher) throws RemoteException {
		teacherListData.update(null);
		System.out.println("更改教师信息成功 From AdminBl");
		return true;
	}

	@Override
	public StudentVO showStudent(int Stu_id) throws RemoteException {
		System.out.println("这里调用StudentInfoDisplay中的showStudent方法");
		System.out.println("查找学生信息成功 From AdminBl");
		return new StudentVO(studentInfo.getStudent(Stu_id));
	}


	@Override
	public TeacherVO showTeacher(int Tea_id) throws RemoteException {
		System.out.println("这里调用TeacherInfoDisplay中的showTeacher方法");
		System.out.println("查找教师信息成功 From AdminBl");
		return new TeacherVO(teacherInfo.getTeacher(Tea_id));
	}

	@Override
	public Iterator<TeacherVO> showTeacherofins(int ins_id) throws RemoteException {
		System.out.println("这里调用TeacherInfoDisplay中的showTeacherlist方法");
		System.out.println("查找院系教师列表成功 From AdminBl");
		ArrayList<TeacherPO> list =teacherInfo.getTeacherOfIns(ins_id);
		ArrayList<TeacherVO> sList = new ArrayList<>();
		for (TeacherPO po:list){
			sList.add(new TeacherVO(po));
		}
				
		return sList.iterator();		
	}

	@Override
	public ArrayList<StudentVO> addStudent(File studentListFile)
			throws BiffException, IOException {
		return null;
	}

	@Override
	public ArrayList<TeacherVO> addTeacher(File teacherListFile)
			throws BiffException, IOException {
		return null;
	}

	@Override
	public boolean delTeacher(int[] teachers) throws RemoteException {
		
		return true;
	}

	@Override
	public boolean delStudent(int[] students) throws RemoteException {
		return true;
	}

	@Override
	public Iterator<StudentVO> showStudentofins(int ins_id, int grade)
			throws RemoteException {
		System.out.println("这里调用StudentInfoDisplay中的showStudentlist方法");
		System.out.println("查找院系学生列表成功 From AdminBl");
		ArrayList<StudentPO> list =studentInfo.getStudentList(ins_id,grade);
		ArrayList<StudentVO> sList = new ArrayList<>();
		for (StudentPO po:list){
			sList.add(new StudentVO(po));
		}
				
		return sList.iterator();
	}


	
}
