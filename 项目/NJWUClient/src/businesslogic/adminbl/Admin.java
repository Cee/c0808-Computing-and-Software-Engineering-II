package businesslogic.adminbl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.read.biff.BiffException;

import po.StudentPO;
import po.TeacherPO;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogic.displaybl.StudentInfoDisplay;
import businesslogic.displaybl.TeacherInfoDisplay;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 2013.10.26
 */
public class Admin implements AdminblService {
	/**
	 * 用户管理器
	 */
	UserControllerService userController;
	/**
	 * 数据库操作工厂
	 */
	DatabaseFactory databaseFactory;
	/**
	 * 学生数据
	 */
	DatabaseService studentData;
	/**
	 * 教师数据
	 */
	DatabaseService teacherData;
	/**
	 * 学生数据展示
	 */
	StudentInfoDisplayService studentDisplay;
	/**
	 * 教师数据展示
	 */
	TeacherInfoDisplayService teacherDisplay;
	/**
	 * 负责管理员批量管理以及批量删除
	 */
	AdminMassManager massManager;

	/**
	 * 
	 * @param userController
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 *             Admin构造函数1，传入userControllerService
	 */
	public Admin(UserControllerService userController) throws RemoteException,
			MalformedURLException, NotBoundException {
		this.userController = userController;
		databaseFactory = userController.getFactory();
		String mark;
		mark = databaseFactory.getDataBase(Table.student);
		studentData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.teacher);
		teacherData = (DatabaseService) Naming.lookup(mark);
		studentDisplay = new StudentInfoDisplay(studentData);
		teacherDisplay = new TeacherInfoDisplay(teacherData);
		massManager = new AdminMassManager(studentData, teacherData);
	}

	@Override
	public boolean addStudent(StudentVO student) throws RemoteException {
		StudentPO po = new StudentPO(student.getStu_Id(), student.getName(),
				student.getPassword(), student.getIns_Id(),
				student.getInstitute(), student.getGender(), student.getGrade());
		if (!studentData.insert(po)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addTeacher(TeacherVO teacher) throws RemoteException {
		TeacherPO po = new TeacherPO(teacher.getTea_Id(), teacher.getIns_Id(),
				teacher.getName(), teacher.getPassword(),
				teacher.getInstitution(), teacher.getType(),
				teacher.getGender());
		if (!teacherData.insert(po)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delStudent(int id) throws RemoteException {
		if (!studentData.delete(id)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delTeacher(int id) throws RemoteException {
		if (!teacherData.delete(id)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modifyStudent(StudentVO student) throws RemoteException {
		StudentPO po = new StudentPO(student.getStu_Id(), student.getName(),
				student.getPassword(), student.getIns_Id(),
				student.getInstitute(), student.getGender(), student.getGrade());
		if (!studentData.update(po)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modifyTeacher(TeacherVO teacher) throws RemoteException {
		TeacherPO po = new TeacherPO(teacher.getTea_Id(), teacher.getIns_Id(),
				teacher.getName(), teacher.getPassword(),
				teacher.getInstitution(), teacher.getType(),
				teacher.getGender());
		if (!teacherData.update(po)) {
			return false;
		}
		return true;
	}

	@Override
	public StudentVO showStudent(int Stu_id) throws RemoteException {
		return new StudentVO(studentDisplay.getStudent(Stu_id));
	}

	@Override
	public Iterator<StudentVO> showStudentofins(int ins_id, int grade)
			throws RemoteException {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		for (StudentPO po : studentDisplay.getStudentList(ins_id, grade)) {
			list.add(new StudentVO(po));
		}

		return list.iterator();
	}

	@Override
	public TeacherVO showTeacher(int Tea_id) throws RemoteException {
		return new TeacherVO(teacherDisplay.getTeacher(Tea_id));
	}

	@Override
	public Iterator<TeacherVO> showTeacherofins(int ins_id)
			throws RemoteException {
		ArrayList<TeacherVO> list = new ArrayList<TeacherVO>();
		for (TeacherPO po : teacherDisplay.getTeacherOfIns(ins_id)) {
			list.add(new TeacherVO(po));
		}
		return list.iterator();
	}

	@Override
	public boolean delStudent(int[] students) throws RemoteException {
		return massManager.deleteStudent(students);
	}

	@Override
	public boolean delTeacher(int[] teachers) throws RemoteException {
		return massManager.deleteTeacher(teachers);
	}

	@Override
	public ArrayList<StudentVO> addStudent(File studentListFile) throws BiffException, IOException {
		return massManager.addStudent(studentListFile);
	}

	@Override
	public ArrayList<TeacherVO> addTeacher(File teacherListFile) throws BiffException, IOException {
		return massManager.addTeacher(teacherListFile);
	}

}
