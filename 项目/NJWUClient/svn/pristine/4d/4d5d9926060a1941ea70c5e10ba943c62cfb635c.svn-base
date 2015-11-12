package businesslogic.studentbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.SelectRecordPO;
import po.StudentPO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.PlanVO;
import vo.ScheduleVO;
import vo.ScoreVO;
import businesslogic.displaybl.LessonDisplay;
import businesslogic.displaybl.LessonRecordDisplay;
import businesslogic.displaybl.PlanDisplay;
import businesslogic.displaybl.SelectRecordDisplay;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.displayblservice.SelectRecordDisplayService;
import businesslogicservice.studentblservice.StudentBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class Student implements StudentBlService {
	/**
	 * 生成课表
	 */
	ScheduleMaker scheduleMaker;
	StudentPO myInfo;// 该学生信息
	UserControllerService userController;// 用户管理
	DatabaseFactory databaseFactory;// 数据层工厂
	/**
	 * Display
	 */
	LessonRecordDisplayService lessonRecordDisplay;// 获取负责展示课程记录的模块的服务
	SelectRecordDisplayService selectRecordDisplay;// 获取负责展示选课记录的模块的服务
	LessonDisplayService lessonDisplay;
	PlanDisplayService planDisplay;
	SelectHelper selectHelper;
	BySelectHelper bySelectHelper;
	int lessonType;
	ArrayList<LessonUniquePO> lessonList = new ArrayList<LessonUniquePO>();

	public Student(UserControllerService userController)
			throws RemoteException, MalformedURLException, NotBoundException {
		this.userController = userController;
		myInfo = (StudentPO) userController.getInformation();
		databaseFactory = userController.getFactory();
		setDisplay();
	}
	/**
	 * 初始化
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public void setDisplay() throws RemoteException, MalformedURLException,
			NotBoundException {
		String mark;
		mark = databaseFactory.getDataBase(Table.lesson_abstract);
		DatabaseService lessonAbData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.lesson_record);
		DatabaseService lessonRecordData = (DatabaseService) Naming
				.lookup(mark);
		mark = databaseFactory.getDataBase(Table.select_record);
		DatabaseService selectRecordData = (DatabaseService) Naming
				.lookup(mark);
		mark = databaseFactory.getDataBase(Table.Lesson_unique);
		DatabaseService lessonData = (DatabaseService) Naming.lookup(mark);
		selectRecordDisplay = new SelectRecordDisplay(selectRecordData);
		lessonRecordDisplay = new LessonRecordDisplay(lessonRecordData);
		planDisplay = new PlanDisplay(lessonAbData);
		lessonDisplay = new LessonDisplay(lessonData);
		selectHelper = new SelectHelper(selectRecordData,lessonData);
		bySelectHelper = new BySelectHelper(lessonRecordData, lessonData);

	}

	@Override
	public boolean select(int Les_id) {
		return selectHelper.addSelection(Les_id, myInfo.getStu_Id());
	}

	@Override
	public boolean cancel(int Les_id) {
		return selectHelper.deleteSelection(Les_id, myInfo.getStu_Id());
	}

	public String findLesson(int les_id) throws RemoteException{
		for (LessonUniquePO po : lessonList) {
			if (po.getLes_Id() == les_id)
				return po.getLes_name();
		}
		return null;
	}

	@Override
	public boolean by_select(int Les_id) throws RemoteException{
		show_myScore();
		return bySelectHelper.bySelect(new LessonRecordPO(Les_id, myInfo
				.getStu_Id(), 0, myInfo.getName(), findLesson(Les_id)));
	}

	@Override
	public boolean by_cancel(int Les_id) throws RemoteException{
		show_myScore();
		return bySelectHelper.byCancel(Les_id);
	}

	@Override
	public ScheduleVO show_myLesson() throws RemoteException {
		lessonList.clear();
		ArrayList<LessonRecordPO> recordList = lessonRecordDisplay
				.getLessonRecord((myInfo.getStu_Id()));
		for( LessonRecordPO po : recordList){
			LessonUniquePO lesson = lessonDisplay.getLessonInfo(po.getLes_Id());
			if (lesson.getState()==0)
				lessonList.add(lesson);
		}
		scheduleMaker = new ScheduleMaker(lessonList);
		return scheduleMaker.makeSchedule();
	}

	@Override
	public Iterator<LessonUniqueVO> show_mySelection() throws RemoteException {
		ArrayList<SelectRecordPO> selectList = getMyRecord();
		ArrayList<LessonUniqueVO> selectLessonList = new ArrayList<LessonUniqueVO>();
		for (SelectRecordPO selection : selectList) {
			for (LessonUniquePO po : lessonList) {
				if (selection.getLes_Id() == po.getLes_Id()){
					selectLessonList.add(new LessonUniqueVO(po));
				}
			}
		}

		return selectLessonList.iterator();
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		if (userController.changePassword(old, newPassword)) {
			return true;
		}
		return false;
	}
	
	@Override
	public ScoreVO show_myScore() throws RemoteException {
		bySelectHelper.setMyLessons(lessonRecordDisplay.getLessonRecord(myInfo
				.getStu_Id()));
		ArrayList<LessonRecordVO> list = new ArrayList<LessonRecordVO>();
		for( LessonRecordPO po : bySelectHelper.getMyLessons()){
			if (po.getScore()!=0){
				LessonUniquePO lesson = lessonDisplay.getLessonInfo(po.getLes_Id());
				list.add(new LessonRecordVO(po,lesson));	
			}
		}
		return new ScoreVO(list.iterator());
	}

	@Override
	public Iterator<LessonUniqueVO> showBySelection(int Ins_id)
			throws RemoteException {
		lessonList = lessonDisplay.getByChooseLesson(lessonType, Ins_id);
		ArrayList<LessonUniqueVO> list = new ArrayList<LessonUniqueVO>();
		for(LessonUniquePO po: lessonList){
			list.add(new LessonUniqueVO(po));
		}
		return list.iterator();
	}

	public ArrayList<SelectRecordPO> getMyRecord() throws RemoteException {
		return selectRecordDisplay
				.getChooseList(myInfo.getStu_Id(), lessonType);
	}

	@Override
	public boolean submit() throws RemoteException{
		selectHelper.submit();
		setLessonType(lessonType);
		return true;
	}

	public void setLessonType(int lessonType) throws RemoteException {
		this.lessonType = lessonType;
		selectHelper.setMySelection(getMyRecord());
		selectHelper.setLessonType(lessonType);
	}

	@Override
	public Iterator<LessonUniqueVO> showSelection(int Ins_id)
			throws RemoteException {
		lessonList = lessonDisplay.getByChooseLesson(lessonType, Ins_id);
		ArrayList<LessonUniqueVO> list = new ArrayList<LessonUniqueVO>();
		for(LessonUniquePO po: lessonList){
			list.add(new LessonUniqueVO(po));
		}
		return list.iterator();
	}

	@Override
	public PlanVO showPlan() throws RemoteException {
		return new PlanVO(planDisplay.getPlanofIns(myInfo.getIns_Id()));
	}
}
