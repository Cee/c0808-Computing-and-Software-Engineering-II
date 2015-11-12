package businesslogic.stub;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.read.biff.BiffException;

import po.LessonUniquePO;
import po.StudentPO;
import po.TeacherPO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.teacherblservice.TeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory_Stub;
import dataservice.DatabaseService;
import dataservice.Table;
/**
 * 
 * @author Norvi
 * @version 1.0
 * @ 13.10.17
 *
 */
public class Teacher_Stub implements TeacherBlService {
	TeacherPO myInfo;
	UserControllerService userController;
	DatabaseFactory_Stub databaseFactory = new DatabaseFactory_Stub();
	DatabaseService lessonUnData = databaseFactory.getDataBase_Stub(Table.Lesson_unique);
	DatabaseService lessonRecordData = databaseFactory.getDataBase_Stub(Table.lesson_record);
	LessonDisplayService lessonDisplay = new LessonDisplay_Stub(lessonUnData);
	LessonRecordDisplayService lessonRecordDisplay = new LessonRecordDisplay_Stub(lessonRecordData);
	public Teacher_Stub(UserControllerService userController ){
		this.userController = userController;
		myInfo = (TeacherPO) userController.getInformation();
		sayHello();
	}
	public void sayHello(){
		System.out.println("欢迎您的登陆，"+myInfo.getName()+"您的身份是任课老师");
	}
	
	@Override
	public boolean editLesInfo(LessonUniqueVO lesson) throws RemoteException {
		lessonUnData.update(null);
		System.out.println("修改课程信息成功 From TeacherBl");
		return true;
	}

	@Override
	public boolean recordScore() throws RemoteException{
		lessonRecordData.update(null);
		System.out.println("成绩登录成功 From TeacherBl");
		return true;
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword) throws RemoteException{
		userController.changePassword(old, newPassword);
		System.out.println("您的密码已修改成功，"+myInfo.getName()+"From StudentBl");
		return true;
	}

	@Override
	public Iterator<LessonUniqueVO> showMyLesson() throws RemoteException{
		System.out.println("从LessonDisplay调用getLessonOfTeacher方法,From TeacherBl");
		ArrayList<LessonUniquePO> list = lessonDisplay.getLessonOfTeacher(myInfo.getTea_Id());
		ArrayList<LessonUniqueVO> voList = new ArrayList<>();
		for (LessonUniquePO po:list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<StudentVO> showMyStudent(int les_id) throws RemoteException{
		System.out.println("从LessonRecordDisplay调用getStudentOfLesson方法,From TeacherBl");
		lessonDisplay.getLessonOfTeacher(les_id);
		ArrayList<StudentVO> voList = new ArrayList<>();
		return voList.iterator();		
	}
	@Override
	public boolean addScore(int Stu_Id, int score) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public Iterator<LessonRecordVO> chooseLesson(int les_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public LessonUniqueVO showDetail(int les_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public Iterator<LessonRecordVO> showNewScore() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public boolean massImport(File file) throws BiffException, IOException {
		// TODO 自动生成的方法存根
		return false;
	}

}
