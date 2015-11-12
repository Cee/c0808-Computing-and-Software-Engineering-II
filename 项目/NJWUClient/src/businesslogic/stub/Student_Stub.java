package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.StudentPO;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.PlanVO;
import vo.ScheduleVO;
import vo.ScoreVO;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.SelectRecordDisplayService;
import businesslogicservice.studentblservice.StudentBlService;
import businesslogicservice.userblservice.UserControllerService;
import databaseutility.DatabaseFactory_Stub;
import dataservice.DatabaseService;
import dataservice.Table;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.18 学生业务桩测试
 */
public class Student_Stub implements StudentBlService {
	StudentPO myInfo;// 该学生信息
	UserControllerService userController;// 用户管理
	DatabaseFactory_Stub databaseFactory = new DatabaseFactory_Stub();// 数据层工厂
	DatabaseService lessonRecordData = databaseFactory
			.getDataBase_Stub(Table.lesson_record);// 获取数据层课程记录服务
	DatabaseService selectRecordData = databaseFactory
			.getDataBase_Stub(Table.select_record);// 获取数据层选课记录服务
	LessonRecordDisplayService lessonRecordDisplay = new LessonRecordDisplay_Stub(
			lessonRecordData);// 获取负责展示课程记录的模块的服务
	SelectRecordDisplayService selectRecordDisplay = new SelectRecordDisplay_Stub(
			selectRecordData);// 获取负责展示选课记录的模块的服务

	public Student_Stub(UserControllerService userController) {
		this.userController = userController;
		myInfo = (StudentPO) userController.getInformation();
		sayHello();
	}

	public void sayHello() {
		System.out.println("欢迎您的登陆，" + myInfo.getName() + "您的身份是学生");
	}

	@Override
	public boolean select(int Les_id) throws RemoteException {
		selectRecordData.insert(new LessonRecordPO(Les_id, myInfo.getStu_Id(), 0,
				"软工2", "王琨"));
		System.out.println("选课成功,课程号" + Les_id + "学号" + myInfo.getStu_Id()
				+ " From StudentBl");
		return true;
	}

	@Override
	public boolean cancel(int Les_id) throws RemoteException {
		selectRecordData.delete(Les_id);
		System.out.println("取消选课成功 From StudentBl");
		return true;
	}

	@Override
	public boolean by_select(int Les_id) throws RemoteException {
		lessonRecordData.insert(new LessonRecordPO(Les_id, myInfo.getStu_Id(), 0,
				"软工2", "王琨"));
		System.out.println("补选成功 From StudentBl");
		return false;
	}

	@Override
	public boolean by_cancel(int Les_id) throws RemoteException {
		lessonRecordData.delete(Les_id);
		System.out.println("退选成功 From StudentBl");
		return false;
	}

	@Override
	public ScheduleVO show_myLesson() {
		System.out
				.println("从LessonRecordDisplay调用getLessonOfStudent方法,From StudentBl");
		return null;
	}

	@Override
	public Iterator<LessonUniqueVO> show_mySelection() {
		System.out
				.println("从SelectRecordDisplay调用getChooseList方法，From StudentBl");
		return null;
	}

	@Override
	public boolean changePassword(char[] old, char[] newPassword) throws RemoteException {
		userController.changePassword(old, newPassword);
		System.out.println("您的密码已修改成功，" + myInfo.getName() + "From StudentBl");
		return false;
	}

	@Override
	public ScoreVO show_myScore() throws RemoteException {
		System.out
				.println("从LessonRecordDisplay调用getLessonOfStudent方法,From StudentBl");
		ArrayList<LessonRecordPO> list = lessonRecordDisplay.getLessonRecord(myInfo.getStu_Id());
		ArrayList<LessonRecordVO> voList = new ArrayList<>();
		for (LessonRecordPO po:list){
			voList.add(new LessonRecordVO(po));
		}
		return new ScoreVO(voList.iterator());
	}

	@Override
	public boolean submit() throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public Iterator<LessonUniqueVO> showBySelection(int Ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setLessonType(int lessonType) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Iterator<LessonUniqueVO> showSelection(int Ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PlanVO showPlan() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
