package businesslogic.stub;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.TeacherPO;
import vo.LessonAbstractVO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory_Stub;
import dataservice.DatabaseService;
import dataservice.Table;
/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.19
 * 院系教务老师业务桩
 */
public class InsTeacher_Stub implements InsTeacherBlService{
	UserControllerService userController;
	TeacherPO myInfo;
	DatabaseFactory_Stub databaseFactory = new DatabaseFactory_Stub();
	DatabaseService les_ab= databaseFactory.getDataBase_Stub(Table.lesson_abstract);
	DatabaseService les_un = databaseFactory.getDataBase_Stub(Table.Lesson_unique);
	DatabaseService les_record = databaseFactory.getDataBase_Stub(Table.lesson_record);
	LessonRecordDisplayService les_record_display = new LessonRecordDisplay_Stub(les_record);
	LessonDisplay_Stub lesDisplay = new LessonDisplay_Stub(les_un);
	public InsTeacher_Stub(UserControllerService userController){
		this.userController = userController;
		myInfo = (TeacherPO)userController.getInformation();
		sayHello();
	}
	
	public void sayHello(){
		System.out.println("欢迎您的登陆，"+myInfo.getName()+"您的身份是院系教务老师");
	}

	@Override
	public boolean addLesson(LessonAbstractVO lesson_abstractPO) throws RemoteException {
		System.out.println("调用LessonAbData的insert方法 From InsTeacherBl");
		les_ab.insert(null);
		return true;
	}

	@Override
	public boolean publishLesson(LessonUniqueVO lesson) throws RemoteException {
		System.out.println("调用LessonUnData的insert方法 From InsTeacherBl");
		les_un.insert(null);
		return true;
	}

	@Override
	public boolean modifyPlan(LessonAbstractVO lesson_abstractPO) throws RemoteException {
		System.out.println("调用LessonAbData的update方法 From InsTeacherBl");
		les_ab.update(null);
		return true;
	}

	@Override
	public boolean modifyLesson(LessonUniqueVO lesson_uniquePO) throws RemoteException {
		System.out.println("调用LessonUnData的update方法 From InsTeacherBl");
		les_un.update(null);
		return true;
	}

	@Override
	public boolean addStudent(LessonRecordVO les_RecordPO) throws RemoteException {
		System.out.println("调用LessonRecordData的insert方法 From InsTeacherBL");
		les_record.insert(null);
		return true;
	}

	@Override
	public boolean deleteStudent(LessonRecordVO les_RecordPO) throws RemoteException {
		System.out.println("调用LessonRecordData的delete方法 From InsTeacherBL");
		les_record.delete(les_RecordPO.getId());
		return true;
	}

	@Override
	public Iterator<LessonUniqueVO> showLesson() throws RemoteException {
		System.out.println("调用LessonDisplay的getLessonOfIns方法，From InsTeacherBl");
		ArrayList<LessonUniquePO> list = lesDisplay.getLessonsOfIns(0);
		ArrayList<LessonUniqueVO> voList = new ArrayList<LessonUniqueVO>();
		for (LessonUniquePO po : list){
			voList.add(new LessonUniqueVO(po));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<LessonRecordVO> showStudentofLesson(int les_id) throws RemoteException {
		System.out.println("调用LessonRecordDisplay的getStudentofLesson方法，From InsTeacherBl");
		ArrayList<LessonRecordPO> list =les_record_display.getStudentOfLesson(les_id); 
		ArrayList<LessonRecordVO> voList = new ArrayList<LessonRecordVO>();
		for (LessonRecordPO po : list){
			voList.add(new LessonRecordVO(po));
		}
		
		return voList.iterator();
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword) throws RemoteException {
		System.out.println("调用UserController的changePassword方法，From InsTeacherBl");
		userController.changePassword(old, newPassword);
		return true;
	}

	@Override
	public PlanVO showPlan() {
		return null;
	}

	@Override
	public boolean addStudent(File file) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deleteLesson(int Les_Id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deletePlan(int les_Ab_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public Iterator<LessonAbstractVO> getPlan() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<StudentVO> showStudent(int grade) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<TypeVO> getAllTypes() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<ModuleVO> getAllModules() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<TeacherVO> getTeacherOfIns(int ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean addStudent(int les_Id, int grade) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public TeacherVO getTeacher(int tea_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
