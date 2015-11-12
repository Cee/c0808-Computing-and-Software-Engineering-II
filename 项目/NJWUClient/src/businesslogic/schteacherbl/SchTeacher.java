package businesslogic.schteacherbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonAbstractPO;
import po.LessonUniquePO;
import po.ModulePO;
import po.StudentPO;
import po.SystemState;
import po.TeacherPO;
import po.TypePO;
import utility.CurrentState;
import vo.FrameVO;
import vo.LessonAbstractVO;
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
import businesslogic.displaybl.SelectRecordDisplay;
import businesslogic.displaybl.StudentInfoDisplay;
import businesslogic.displaybl.TeacherInfoDisplay;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.schteacherblservice.SchTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;
import dataservice.choosedataservice.SelectRecordDataService;
import dataservice.lessonrecorddataservice.LessonRecordDataService;

public class SchTeacher implements SchTeacherBlService {
	/**
	 * 框架编辑
	 */
	private FrameEditor editor;
	/**
	 * 构建教学计划
	 */
	private PlanBuilder builder = new PlanBuilder();
	/**
	 * 用户管理器
	 */
	private UserControllerService userControl;
	/**
	 * 我的信息
	 */
	private TeacherPO myInfo;
	/**
	 * 数据服务的工厂
	 */
	private DatabaseFactory databaseFactory;
	/**
	 * 系统状态数据服务
	 */
	
	private DatabaseService systemStateData;
	/**
	 * 协助选课
	 */
	private SelectManager selectManager;
	/**
	 * Display
	 */
	private FrameInfoDisplay frameDisplay;
	private StudentInfoDisplayService studentDisplay;
	private TeacherInfoDisplayService teaDisplay;
	private PlanDisplayService planDisplay;
	private LessonDisplayService lessonDisplay;

	private SelectRecordDisplay selectRecordDisplay;
	private LessonRecordDisplayService lessonRecordDisplay;
	public SchTeacher(UserControllerService userController)
			throws RemoteException, MalformedURLException, NotBoundException {
		this.userControl = userController;
		this.databaseFactory = userController.getFactory();
		myInfo = (TeacherPO) userController.getInformation();
		setDisplay();
	}

	public void alloSelect() throws RemoteException {
		selectManager.allo();
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
		mark = databaseFactory.getDataBase(Table.module);
		DatabaseService moduleData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.student);
		DatabaseService studentData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.teacher);
		DatabaseService teacherData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.type);
		DatabaseService typeData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.lesson_abstract);
		DatabaseService lessonAbData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.Lesson_unique);
		DatabaseService lessonData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.system);
		systemStateData = (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.select_record);
		SelectRecordDataService selectRecordData =  (SelectRecordDataService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.lesson_record);
		DatabaseService lessonRecordData =  (DatabaseService) Naming.lookup(mark);
		mark = databaseFactory.getDataBase(Table.broadcast);
		DatabaseService broadCastData = (DatabaseService)Naming.lookup(mark);
		teaDisplay = new TeacherInfoDisplay(teacherData);
		studentDisplay = new StudentInfoDisplay(studentData);
		frameDisplay = new FrameInfoDisplay(moduleData, typeData);
		planDisplay = new PlanDisplay(lessonAbData);
		lessonDisplay = new LessonDisplay(lessonData);
		editor = new FrameEditor(typeData, moduleData, lessonAbData);
		sender = new BroadCastSender(broadCastData);
		selectRecordDisplay = new SelectRecordDisplay(selectRecordData);
		lessonRecordDisplay = new LessonRecordDisplay(lessonRecordData);
		selectManager = new SelectManager(selectRecordDisplay, lessonRecordDisplay, (LessonRecordDataService) lessonRecordData, lessonDisplay, studentDisplay,selectRecordData );
		getFrame();
	}
	private BroadCastSender sender;

	@Override
	public boolean addLesson(LessonAbstractVO lesson) throws RemoteException {
		LessonAbstractPO po = new LessonAbstractPO(0, null,
				lesson.getLes_Id_Ab(), lesson.getType_Id(), lesson.getType(),
				lesson.getName(), lesson.getMin_credit(),
				lesson.getMax_credit(), lesson.getTerm_start(),
				lesson.getTerm_end(), lesson.getModule_Id(),
				lesson.getCompulsory(), lesson.getModule());
		return editor.addLesson(po);
	}

	@Override
	public boolean addType(TypeVO vo) throws RemoteException {
		TypePO po = new TypePO(vo.getType_Id(), vo.getModule_Id(),
				vo.getModule_name(), vo.getName(), vo.getCompulsory(),
				vo.getTerm_start(), vo.getTerm_end(), vo.getMin_credit(),
				vo.getMax_credit());
		return editor.addType(po);
	}

	@Override
	public boolean addModule(ModuleVO vo) throws RemoteException {
		ModulePO po = new ModulePO(vo.getModule_Id(), vo.getName(),
				vo.getMin_credit(), vo.getMax_credit());
		return editor.addModule(po);
	}

	@Override
	public boolean modifyLesson(LessonAbstractVO vo) throws RemoteException {
		LessonAbstractPO po = new LessonAbstractPO(0, null, vo.getLes_Id_Ab(),
				vo.getType_Id(), vo.getType(), vo.getName(),
				vo.getMin_credit(), vo.getMax_credit(), vo.getTerm_start(),
				vo.getTerm_end(), vo.getModule_Id(), vo.getCompulsory(),
				vo.getModule());
		return editor.modifyLesson(po);
	}

	@Override
	public boolean modifyType(TypeVO vo) throws RemoteException {
		TypePO po = new TypePO(vo.getType_Id(), vo.getModule_Id(),
				vo.getModule_name(), vo.getName(), vo.getCompulsory(),
				vo.getTerm_start(), vo.getTerm_end(), vo.getMin_credit(),
				vo.getMax_credit());
		return editor.modifyType(po);
	}

	@Override
	public boolean modifyModule(ModuleVO vo) throws RemoteException {
		ModulePO po = new ModulePO(vo.getModule_Id(), vo.getName(),
				vo.getMin_credit(), vo.getMax_credit());
		return editor.modifyModule(po);
	}

	@Override
	public boolean deleteType(int id) throws RemoteException {
		return editor.deleteType(id);
	}

	@Override
	public boolean deleteModule(int id) throws RemoteException {
		return editor.deleteModule(id);
	}

	@Override
	public boolean deleteLesson(int id) throws RemoteException {
		return editor.deleteLesson(id);
	}

	@Override
	public Iterator<StudentVO> showStudentList(int ins_id, int grade)
			throws RemoteException {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		for (StudentPO po : studentDisplay.getStudentList(ins_id, grade)) {
			list.add(new StudentVO(po));
		}
		return list.iterator();
	}

	@Override
	public Iterator<TeacherVO> showTeacherList(int ins_id)
			throws RemoteException {
		ArrayList<TeacherVO> list = new ArrayList<TeacherVO>();
		for (TeacherPO po : teaDisplay.getTeacherOfIns(ins_id)) {
			list.add(new TeacherVO(po));
		}
		return list.iterator();
	}

	@Override
	public Iterator<LessonUniqueVO> showLessonList(int ins_id)
			throws RemoteException {

		ArrayList<LessonUniqueVO> list = new ArrayList<LessonUniqueVO>();
		for (LessonUniquePO po : lessonDisplay.getLessonsOfIns(ins_id)) {
			if (po.getState() == 0)
				list.add(new LessonUniqueVO(po));
		}

		return list.iterator();
	}

	public ArrayList<LessonAbstractPO> showLessonAb(int ins_id)
			throws RemoteException {
		return planDisplay.getPlanofIns(ins_id);
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword)
			throws RemoteException {
		return userControl.changePassword(old, newPassword);
	}

	@Override
	public PlanVO showPlan(int ins_id) throws RemoteException {
		return builder.buildPlan(showLessonAb(ins_id));
	}

	public void getFrame() throws RemoteException {
		editor.setTypeList(frameDisplay.getType());
		editor.setModuleList(frameDisplay.getModule());
		editor.setLessonAbList(planDisplay.getPlanofIns(0));
	}

	@Override
	public FrameVO showFrame() throws RemoteException {
		getFrame();
		return editor.getFrame();
	}

	@Override
	public boolean setState(SystemState state) throws RemoteException {
		if (CurrentState.select == 0 && state.getSelect() == 1) {

		}

		if (CurrentState.bySelect == 0 && state.getByselect() == 1) {

		}
		CurrentState.setState(state);
		return systemStateData.update(state);
	}
	
	@Override
	public boolean sendBroadCast(String message) throws RemoteException{
		return sender.sendBroadCast(message);
	}
}
