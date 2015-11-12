package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.StudentPO;
import po.SystemState;
import po.TeacherPO;

import vo.FrameVO;
import vo.LessonAbstractVO;
import vo.LessonUniqueVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.TypeVO;
import businesslogicservice.displayblservice.PlanDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import businesslogicservice.displayblservice.TeacherInfoDisplayService;
import businesslogicservice.schteacherblservice.SchTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory_Stub;
import dataservice.Table;
import dataservice.framedataservice.ModuleDataService;
import dataservice.framedataservice.TypeDataService;
import dataservice.plandataservice.LessonAbDataService;
import dataservice.userdataservice.StudentDataService;

/**
 * 
 * @author Xc
 * @version 1.0
 * @date 13.10.19
 */

public class SchTeacher_Stub implements SchTeacherBlService {
	UserControllerService userControl;

	TeacherPO myInfo;
	
	
	
	DatabaseFactory_Stub databaseFactory = new DatabaseFactory_Stub();
	LessonAbDataService plan  =(LessonAbDataService) databaseFactory.getDataBase_Stub(Table.lesson_abstract);
	TypeDataService type = (TypeDataService) databaseFactory.getDataBase_Stub(Table.type);
	ModuleDataService module = (ModuleDataService)databaseFactory.getDataBase_Stub(Table.module);

	StudentInfoDisplayService studentDis = new StudentInfoDisplay_Stub( (StudentDataService)databaseFactory.getDataBase_Stub(Table.student));
	PlanDisplayService planDis = new PlanDisplay_Stub( );
	TeacherInfoDisplayService teaDis = new TeacherInfoDisplay_Stub(databaseFactory.getDataBase_Stub(Table.teacher));
	
	
	public SchTeacher_Stub(UserControllerService userController){
		this.userControl = userController;
		myInfo = (TeacherPO) userController.getInformation();
		sayHello();
	}
	
	public void sayHello(){
		System.out.println("欢迎您的登陆，"+myInfo.getName()+"您的身份是学校教务老师");
	}
	
	@Override
	public boolean addLesson(LessonAbstractVO lesson_abstractVO) throws RemoteException {
		System.out.println("调用LessonAbDataService的insert方法");
		plan.insert(null);
		System.out.print("添加课程成功");
		System.out.println("from blService");
		return true;
	}

	@Override
	public boolean addType(TypeVO typeVO) throws RemoteException {
		System.out.println("调用TypeDataService的insert方法");		
		type.insert(null);
		System.out.print("添加类型成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public boolean addModule(ModuleVO moduleVO) throws RemoteException {
		System.out.println("调用ModuleDataService的insert方法");
		module.insert(null);
		System.out.print("添加模块成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public boolean modifyLesson(LessonAbstractVO lesson_abstractVO) throws RemoteException {
		System.out.println("调用LessonAbDataService的update方法");
		plan.update(null);
		System.out.print("更新课程成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public boolean modifyType(TypeVO typeVO) throws RemoteException {
		System.out.println("调用TypeDataService的update方法");
		type.update(null);
		System.out.print("修改类型成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public boolean modifyModule(ModuleVO moduleVO) throws RemoteException {
		System.out.println("调用ModuleDataService的update方法");
		module.update(null);
		System.out.print("修改模块成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public boolean deleteType(int id) throws RemoteException {
		System.out.println("调用TypeDataService的delete方法");
		type.delete(id);
		System.out.print("删除类型成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public boolean deleteModule(int id) throws RemoteException {
		System.out.println("调用ModuleDataService的delete方法");
		module.delete(id);
		System.out.print("删除模块成功");
		System.out.println("success from blService");
		return true;
	}

	public boolean deleteLesson( int id ) throws RemoteException{
		
		System.out.println("调用LessonAbDataService的delete方法");
		plan.delete(id);
		
		System.out.print("删除课程成功");
		System.out.println("success from blService");
		return true;
		
	}
	
	@Override
	public Iterator<StudentVO> showStudentList(int ins_id,int grade) throws RemoteException {
		System.out.println("这里调用 studentDisplayService的getStudentList方法");
		System.out.println("success from blService");
		ArrayList<StudentPO> list =  studentDis.getStudentList(ins_id,grade);
		ArrayList<StudentVO> voList = new ArrayList<>();
		for (StudentPO student :list){
			voList.add(new StudentVO(student));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<TeacherVO> showTeacherList( int ins_id) throws RemoteException {
		System.out.print("这里调用teacherDisplayService的getTeacherOfIns方法");
		System.out.println("success from blService");
		ArrayList<TeacherPO> list =  teaDis.getTeacherOfIns(ins_id);
		ArrayList<TeacherVO> voList = new ArrayList<>();
		for (TeacherPO teacher: list){
			voList.add(new TeacherVO(teacher));
		}
		return voList.iterator();
	}

	@Override
	public Iterator<LessonUniqueVO> showLessonList( int ins_id ) {
		return null;
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword) throws RemoteException {
		
		userControl.changePassword(old, newPassword);
		System.out.print("修改秘密成功");
		System.out.println("success from blService");
		return true;
	}

	@Override
	public void alloSelect() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean setState(SystemState state) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public PlanVO showPlan(int ins_id) throws RemoteException {
		System.out.print("这里调用LessonAbDisplayService的getPlanOfins方法");
		System.out.println("success from blService");
		return new PlanVO(planDis.getPlanofIns(ins_id));
	}

	@Override
	public FrameVO showFrame() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean sendBroadCast(String message) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
	
	
}
