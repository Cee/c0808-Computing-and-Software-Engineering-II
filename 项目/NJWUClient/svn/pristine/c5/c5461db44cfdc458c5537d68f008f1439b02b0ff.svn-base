package mock.adminbl_mock;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.StudentPO;
import po.TeacherPO;

import java.util.Iterator;

import mock.display_mock.StudentInfoDisplay_Mock;
import mock.display_mock.TeacherInfoDisplay_Mock;

import jxl.read.biff.BiffException;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;

public class Admin_Mock implements AdminblService{
	TeacherInfoDisplayService teacherInfoDisplayService = new TeacherInfoDisplay_Mock();
	StudentInfoDisplayService studentInfoDisplayService = new StudentInfoDisplay_Mock();
	@Override
	public ArrayList<StudentVO> addStudent(File studentListFile) throws BiffException,
			IOException {
		return null;
	}

	@Override
	public ArrayList<TeacherVO> addTeacher(File teacherListFile) throws BiffException,
			IOException {
		return null;
	}

	@Override
	public boolean addStudent(StudentVO student) throws RemoteException {
		return true;
	}

	@Override
	public boolean addTeacher(TeacherVO teacher) throws RemoteException {
		return true;
	}

	@Override
	public boolean delTeacher(int[] teachers) throws RemoteException {
		return true;
	}

	@Override
	public boolean delStudent(int id) throws RemoteException {
		return true;
	}

	@Override
	public boolean delTeacher(int id) throws RemoteException {
		return true;
	}

	@Override
	public boolean delStudent(int[] students) throws RemoteException {
		return true;
	}

	@Override
	public StudentVO showStudent(int Stu_id) throws RemoteException {
		return new StudentVO(studentInfoDisplayService.getStudent(Stu_id));
	}

	@Override
	public Iterator<StudentVO> showStudentofins(int ins_id, int grade)
			throws RemoteException {
		ArrayList<StudentPO> list = studentInfoDisplayService.getStudentList(ins_id, grade);
		ArrayList<StudentVO> voList = new ArrayList<>();
		for (StudentPO po :list){
			voList.add(new StudentVO(po));
		}
		return voList.iterator();
	}

	@Override
	public TeacherVO showTeacher(int Tea_id) throws RemoteException {
		return new TeacherVO(teacherInfoDisplayService.getTeacher(Tea_id));
	}

	@Override
	public Iterator<TeacherVO> showTeacherofins(int ins_id)
			throws RemoteException {
		ArrayList<TeacherPO> list = teacherInfoDisplayService.getTeacherOfIns(ins_id);
		ArrayList<TeacherVO> voList = new ArrayList<>();
		for (TeacherPO po :list){
			voList.add(new TeacherVO(po));
		}
		return voList.iterator();
	}

	@Override
	public boolean modifyStudent(StudentVO student) throws RemoteException {
		return true;
	}

	@Override
	public boolean modifyTeacher(TeacherVO teacher) throws RemoteException {
		return true;
	}

}
