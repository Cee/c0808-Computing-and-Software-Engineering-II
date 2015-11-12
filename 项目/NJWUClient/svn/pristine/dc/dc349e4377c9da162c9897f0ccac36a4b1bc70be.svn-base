package businesslogic.insteacherbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonAbstractPO;
import po.LessonRecordPO;
import po.LessonUniquePO;
import po.ModulePO;
import po.StudentPO;
import po.TeacherPO;
import po.TypePO;
import vo.LessonAbstractVO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;
import businesslogic.displaybl.FrameInfoDisplay;
import businesslogic.displaybl.LessonDisplay;
import businesslogic.displaybl.LessonRecordDisplay;
import businesslogic.displaybl.PlanDisplay;
import businesslogic.displaybl.StudentInfoDisplay;
import businesslogic.displaybl.TeacherInfoDisplay;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class InsTeacher implements InsTeacherBlService {
	/**
	 * 数据层工厂
	 */
	DatabaseFactory databaseFactory;
	
	/**
	 * 用户管理器
	 */
	UserControllerService userController;
	
	/**
	 * 负责各记录的显示
	 */
	LessonRecordDisplayService lessonRecordDatadisplay;
	StudentInfoDisplayService studentDisplay;
	LessonDisplayService lessonDisplay;
	PlanDisplayService planDisplay;
	FrameInfoDisplay framDisplay;
	TeacherInfoDisplay teacherDisplay;
	
	/**
	 * 协助院系教务老师进行各项操作
	 */
	InsTeacherMassManager massManager;
	LessonPublisher lessonPublisher;
	StudentManager studentManager;
	PlanEditor editor;
	
	/**
	 * 个人信息
	 */
	TeacherPO myInfo;
	
	
	public InsTeacher(UserControllerService userController) throws RemoteException,
			MalformedURLException, NotBoundException {
		this.userController = userController;
		databaseFactory = userController.getFactory();
		myInfo = (TeacherPO) userController.getInformation();
		setDisplay();
	}

	public void setDisplay() throws RemoteException, MalformedURLException,
			NotBoundException {
		String mark;
		/**
		 * 抽象课程
		 */
		mark = databaseFactory.getDataBase(Table.lesson_abstract);
		DatabaseService LessonAbstractData = (DatabaseService) Naming
				.lookup(mark);
		
		/**
		 * 具体课程
		 */
		mark = databaseFactory.getDataBase(Table.Lesson_unique);
		DatabaseService lessonData = (DatabaseService) Naming.lookup(mark);
		
		/**
		 * 课程记录
		 */
		mark = databaseFactory.getDataBase(Table.lesson_record);
		DatabaseService lessonRecordData = (DatabaseService) Naming
				.lookup(mark);
		
		/**
		 * 学生
		 */
		mark = databaseFactory.getDataBase(Table.student);
		DatabaseService studentData = (DatabaseService) Naming.lookup(mark);
		
		/**
		 * 教学计划部分
		 */
		mark = databaseFactory.getDataBase(Table.type);
		DatabaseService typeData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.module);
		DatabaseService moduleData = (DatabaseService) Naming.lookup(mark);

		/**
		 * 教師部份
		 */
		mark = databaseFactory.getDataBase(Table.teacher);
		DatabaseService teacherData =  (DatabaseService)Naming.lookup(mark);
		/**
		 * 新建display
		 */
		lessonDisplay = new LessonDisplay(lessonData);
		lessonRecordDatadisplay = new LessonRecordDisplay(lessonRecordData);
		planDisplay = new PlanDisplay(LessonAbstractData);
		studentDisplay = new StudentInfoDisplay(studentData);
		framDisplay = new FrameInfoDisplay(moduleData, typeData);
		teacherDisplay = new TeacherInfoDisplay(teacherData);
		
		/**
		 * 新建协助类
		 */
		studentManager = new StudentManager(lessonRecordData, lessonData);
		lessonPublisher = new LessonPublisher(lessonData);
		editor = new PlanEditor(LessonAbstractData);
		massManager = new InsTeacherMassManager(lessonRecordData,lessonData);
	}

	
	public String getTypeName(int type_Id) throws RemoteException {
		TypePO po = framDisplay.getType(type_Id);
		return po.getName();
	}

	
	public int getModuleId(int type_Id) throws RemoteException {
		TypePO po = framDisplay.getType(type_Id);
		return po.getModule_Id();
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return userController.changePassword(old, newPassword);
	}
	
	/**
	 * Add方法
	 */
	@Override
	public boolean addStudent(LessonRecordVO vo)
			throws RemoteException {
		StudentPO student = studentDisplay.getStudent(vo.getStu_id());
		if (student==null){
			return false;
		}
		System.out.println(student.getName());
		LessonRecordPO po = new LessonRecordPO(vo.getLes_id(), vo.getStu_id(),
				0, student.getName(), vo.getLes_name());
		if (	studentManager.addRecord(po)){
			studentManager.setRecordList(lessonRecordDatadisplay
					.getStudentOfLesson(po.getLes_Id()));
			return true;		
		}
		return false;
	}
	
	
	@Override
	public boolean addStudent(int les_id,int grade) throws RemoteException {
		massManager.setLesson(les_id);
		return massManager.addStudent(studentDisplay.getStudentList(myInfo.getIns_Id(), grade));
	}	
	
	@Override
	public boolean addStudent(File file) {
		return false;
	}
	

	@Override
	public boolean publishLesson(LessonUniqueVO newLesson)
			throws RemoteException {
		LessonUniqueVO vo = newLesson;
		LessonUniquePO po = new LessonUniquePO(vo.getLessonName(),
				vo.getLes_Id(), myInfo.getInstitution(), vo.getLocation(),
				vo.getTerm(), vo.getMax_stu_num(), vo.getCur_stu_num(),
				vo.getState(), vo.getTea_Id(), vo.getTeacherName(),
				vo.getLes_Id_Ab(), myInfo.getIns_Id(), vo.getDay(),
				vo.getStart(), vo.getEnd(), vo.getIntroduction(),
				vo.getBooks(), vo.getOutline(), vo.getCredit(),vo.getCompulsory(),vo.getType_id(),vo.getType_name());
		return lessonPublisher.publish(po);
	}

	@Override
	public boolean addLesson(LessonAbstractVO lessonAbstractVO)
			throws RemoteException {
		LessonAbstractVO vo = lessonAbstractVO;
		LessonAbstractPO po = new LessonAbstractPO(myInfo.getIns_Id(),
				myInfo.getInstitution(), vo.getLes_Id_Ab(), vo.getType_Id(),
				vo.getType(), vo.getName(), vo.getMin_credit(),
				vo.getMax_credit(), vo.getTerm_start(), vo.getTerm_end(),
				vo.getModule_Id(), vo.getCompulsory(), vo.getModule());
		return editor.addLesson(po);
	}
	
	
	
	/**
	 * Get方法
	 */
	@Override
	public Iterator<LessonUniqueVO> showLesson() throws RemoteException {
		lessonPublisher.setLessonList(lessonDisplay.getLessonsOfIns(myInfo
				.getIns_Id()));
		ArrayList<LessonUniqueVO> list = new ArrayList<LessonUniqueVO>();
		for( LessonUniquePO po : lessonPublisher.getLessonList()){
			if (po.getState()==0){
				list.add(new LessonUniqueVO(po));	
			}
			
		}
		return list.iterator();
	}
	
	
	@Override
	public Iterator<StudentVO> showStudent(int grade) throws RemoteException {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		for( StudentPO po : studentDisplay.getStudentList(myInfo.getIns_Id(), grade)){
			list.add(new StudentVO(po));
		}
		return list.iterator();
	}
	
	
	@Override
	public Iterator<LessonRecordVO> showStudentofLesson(int les_id)
			throws RemoteException {
		ArrayList<LessonRecordPO> lessonRecord = lessonRecordDatadisplay
				.getStudentOfLesson(les_id);
		ArrayList<LessonRecordVO> records = new ArrayList<>();
		for (LessonRecordPO po : lessonRecord){
			records.add(new LessonRecordVO(po));
		}
		studentManager.initial();
		studentManager.setRecordList(lessonRecord);
		massManager.setLesson(les_id);
		return records.iterator();
	}
	
	
	@Override
	public PlanVO showPlan() throws RemoteException {
		getPlan();
		return editor.showPlan();
	}
	
	
	@Override
	public Iterator<LessonAbstractVO> getPlan() throws RemoteException {
		editor.setList(planDisplay.getPlanofIns(myInfo.getIns_Id()));
		ArrayList<LessonAbstractVO> list = new ArrayList<LessonAbstractVO>();
		for(LessonAbstractPO po : editor.getList()){
			list.add(new LessonAbstractVO(po));
		}
		return list.iterator();
	}
	
	
	@Override 
	public Iterator<TypeVO> getAllTypes() throws RemoteException{
		ArrayList<TypePO> types = framDisplay.getType();
		ArrayList<TypeVO> typeVOs = new ArrayList<>();
		for (TypePO po: types){
			typeVOs.add(new TypeVO(po));
		}
		return typeVOs.iterator();
	}
	
	@Override
	public Iterator<ModuleVO> getAllModules() throws RemoteException{
		ArrayList<ModulePO> modules = framDisplay.getModule();
		ArrayList<ModuleVO> moduleVOs = new ArrayList<>();
		for (ModulePO po: modules){
			moduleVOs.add(new ModuleVO(po));
		}
		return moduleVOs.iterator();
	}
	/**
	 * Modify方法
	 */
	
	@Override
	public boolean modifyPlan(LessonAbstractVO lesson_abstractVO)
			throws RemoteException {
		LessonAbstractVO vo = lesson_abstractVO;
		LessonAbstractPO po = new LessonAbstractPO(myInfo.getIns_Id(),
				myInfo.getInstitution(), vo.getLes_Id_Ab(), vo.getType_Id(),
				vo.getType(), vo.getName(), vo.getMin_credit(),
				vo.getMax_credit(), vo.getTerm_start(), vo.getTerm_end(),
				vo.getModule_Id(), vo.getCompulsory(), vo.getModule());
		return editor.modifyPlan(po);
	}
	
	@Override
	public boolean modifyLesson(LessonUniqueVO lesson_uniqueVO)
			throws RemoteException {
		LessonUniqueVO vo = lesson_uniqueVO;
		LessonUniquePO po = new LessonUniquePO(vo.getLessonName(),
				vo.getLes_Id(), myInfo.getInstitution(), vo.getLocation(),
				vo.getTerm(), vo.getMax_stu_num(), vo.getCur_stu_num(),
				vo.getState(), vo.getTea_Id(), vo.getTeacherName(),
				vo.getLes_Id_Ab(), myInfo.getIns_Id(), vo.getDay(),
				vo.getStart(), vo.getEnd(), vo.getIntroduction(),
				vo.getBooks(), vo.getOutline(), Integer.parseInt(vo
						.getCreditString()),vo.getCompulsory(),vo.getType_id(),vo.getType_name());
		return lessonPublisher.modify(po);
	}
	
	
	/**
	 * Delete方法
	 */
	
	@Override
	public boolean deleteStudent(LessonRecordVO les_RecordVO)
			throws RemoteException {
		LessonRecordVO vo = les_RecordVO;
		LessonRecordPO po = new LessonRecordPO(vo.getId(),vo.getLes_id(), vo.getStu_id(),
				vo.getScore(), vo.getStu_name(), vo.getLes_name());
		if (studentManager.deleteRecord(po)){
			studentManager.setRecordList(lessonRecordDatadisplay
					.getStudentOfLesson(po.getLes_Id()));
			return true;
		}
	
		return false;

	}
	
	@Override
	public boolean deleteLesson(int Les_Id) throws RemoteException {
		return lessonPublisher.delete(Les_Id);
	}

	@Override
	public boolean deletePlan(int les_Ab_id) throws RemoteException {
		return editor.deleteLesson(les_Ab_id);
	}
	
	@Override
	public ArrayList<TeacherVO> getTeacherOfIns(int ins_id) throws RemoteException{
		ArrayList<TeacherPO> teachers = teacherDisplay.getTeacherOfIns(ins_id);
		ArrayList<TeacherVO> list = new ArrayList<>();
		for (TeacherPO teacher:teachers){
			list.add(new TeacherVO(teacher));
		}
		return list;
	}
	@Override
	public TeacherVO getTeacher(int tea_id) throws RemoteException{
		return new TeacherVO(teacherDisplay.getTeacher(tea_id));
	}

}
