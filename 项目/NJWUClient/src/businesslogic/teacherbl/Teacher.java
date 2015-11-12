package businesslogic.teacherbl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.read.biff.BiffException;
import po.LessonRecordPO;
import po.LessonUniquePO;
import po.TeacherPO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import businesslogic.displaybl.LessonDisplay;
import businesslogic.displaybl.LessonRecordDisplay;
import businesslogic.displaybl.StudentInfoDisplay;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.teacherblservice.TeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.11.9
 */
public class Teacher implements TeacherBlService {
	/**
	 * 我的信息
	 */
	TeacherPO myInfo;
	/**
	 * 用户管理器
	 */
	UserControllerService userController;
	/**
	 * 数据层工厂
	 */
	DatabaseFactory databaseFactory;
	/**
	 * 各数据服务
	 */
	DatabaseService lessonUnData;
	DatabaseService lessonRecordData;
	DatabaseService studentData;
	/**
	 * 各展示服务
	 */
	LessonDisplayService lessonDisplay;
	LessonRecordDisplayService lessonRecordDisplay;
	StudentInfoDisplay studentDisplay;
	ScoreRecordHelper helper;

	public Teacher(UserControllerService userController) throws RemoteException,
			MalformedURLException, NotBoundException {
		this.userController = userController;
		this.databaseFactory = userController.getFactory();
		String mark;

		mark = databaseFactory.getDataBase(Table.Lesson_unique);
		lessonUnData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.lesson_record);
		lessonRecordData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.student);
		studentData = (DatabaseService) Naming.lookup(mark);
		myInfo = (TeacherPO) userController.getInformation();
		lessonDisplay = new LessonDisplay(lessonUnData);
		lessonRecordDisplay = new LessonRecordDisplay(lessonRecordData);
		studentDisplay = new StudentInfoDisplay(studentData);
	}

	@Override
	public boolean recordScore() throws RemoteException {
		return helper.recordScore();
	}
	@Override
	public boolean massImport(File file) throws BiffException, IOException{
		return helper.massImport(file);
	}
	@Override
	public boolean editLesInfo(LessonUniqueVO lesson) throws RemoteException {
		LessonUniquePO po = new LessonUniquePO(lesson.getLessonName(),
				lesson.getLes_Id(), lesson.getInstitution(),
				lesson.getLocation(), lesson.getTerm(),
				lesson.getMax_stu_num(), lesson.getCur_stu_num(),
				lesson.getState(), lesson.getTea_Id(), lesson.getTeacherName(),
				lesson.getLes_Id_Ab(), lesson.getIns_Id(), lesson.getDay(),
				lesson.getStart(), lesson.getEnd(), lesson.getIntroduction(),
				lesson.getBooks(), lesson.getOutline(), lesson.getCredit(),lesson.getCompulsory(),lesson.getType_id(),lesson.getType_name());
		if(lessonUnData.update(po)){
			showMyLesson();
			return true;
		}
		return false;
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return userController.changePassword(old, newPassword);
	}

	@Override
	public Iterator<LessonUniqueVO> showMyLesson() throws RemoteException {
		ArrayList<LessonUniquePO> myLessons = lessonDisplay
				.getLessonOfTeacher(myInfo.getTea_Id());
		ArrayList<LessonUniqueVO> list = new ArrayList<LessonUniqueVO>();
		for (LessonUniquePO po : myLessons) {
			list.add(new LessonUniqueVO(po));
		}
		return list.iterator();
	}

	@Override
	public Iterator<StudentVO> showMyStudent(int les_id) throws RemoteException {
		ArrayList<StudentVO> myStudents = new ArrayList<StudentVO>();
		ArrayList<LessonRecordPO> lessonRecord = lessonRecordDisplay
				.getStudentOfLesson(les_id);
		for (LessonRecordPO po : lessonRecord) {
			myStudents.add(new StudentVO(studentDisplay.getStudent(po
					.getStu_Id())));
		}
		return myStudents.iterator();
	}

	@Override
	public boolean addScore(int Stu_Id, int score) throws RemoteException {
		helper.updataRecord(Stu_Id, score);
		return true;
	}

	@Override
	public Iterator<LessonRecordVO> chooseLesson(int les_id)
			throws RemoteException {
		ArrayList<LessonRecordPO> lessonRecord = lessonRecordDisplay
				.getStudentOfLesson(les_id);
		helper = new ScoreRecordHelper(les_id, lessonRecord, lessonRecordData);

		ArrayList<LessonRecordVO> list = new ArrayList<LessonRecordVO>();
		for (LessonRecordPO po : lessonRecord) {
			LessonUniquePO lesson = lessonDisplay.getLessonInfo(po.getLes_Id());
			list.add(new LessonRecordVO(po,lesson));
		}
		return list.iterator();
	}

	@Override
	public LessonUniqueVO showDetail(int les_id) throws RemoteException {
		ArrayList<LessonUniquePO> myLessons = lessonDisplay
				.getLessonOfTeacher(myInfo.getTea_Id());
		for (LessonUniquePO po : myLessons) {
			if (po.getLes_Id() == les_id)
				return new LessonUniqueVO(po);
		}
		return null;
	}
	@Override
	public Iterator<LessonRecordVO> showNewScore(){ 
		ArrayList<LessonRecordPO> list = helper.getLesRecordList();
		ArrayList<LessonRecordVO> voList = new ArrayList<>();
		for (LessonRecordPO po : list){
			voList.add(new LessonRecordVO(po));
		}
		return voList.iterator();
	}

}
