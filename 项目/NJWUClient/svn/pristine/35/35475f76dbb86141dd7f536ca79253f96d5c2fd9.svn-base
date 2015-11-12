package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.PO;
import po.StudentPO;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import dataservice.DatabaseService;
import dataservice.lessondataservice.LessonUnData_Stub;
import dataservice.userdataservice.StudentData_Stub;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.18 桩
 * 
 */
public class LessonRecordDisplay_Stub implements LessonRecordDisplayService {
	DatabaseService lessonRecordData;
	DatabaseService lessonUnData;
	DatabaseService studentData;

	public LessonRecordDisplay_Stub(DatabaseService lessonRecordData) {
		this.lessonRecordData = lessonRecordData;
		lessonUnData = new LessonUnData_Stub();
		studentData  = new StudentData_Stub();
	}

	@Override
	public ArrayList<LessonRecordPO> getStudentOfLesson(int les_id) throws RemoteException {
		System.out.println("LessonRecordDisplay调用LessonRecordData的find方法查找对应课程号的课程记录");
		System.out.println("因为是桩测试，这里默认返回两条课程记录记录");
		ArrayList<PO> list = lessonRecordData.find(1, les_id);
		ArrayList<LessonRecordPO> rList = new ArrayList<>();
		for (PO po : list){
			rList.add((LessonRecordPO)po);
		}
		return rList;
	}

//	@Override
//	public ArrayList<LessonUniquePO> getLessonOfStudent(int stu_id) {
//		System.out.println("LessonRecordDisplay调用LessonRecordData的find方法查找对应学号的课程记录");
//		System.out.println("因为是桩测试，这里默认返回两条课程记录");
//		ArrayList<PO> lessonRecord = lessonRecordData.find(0, stu_id);
//		ArrayList<LessonUniquePO> lessonInfoList = new ArrayList<LessonUniquePO>();
//		for (PO po : lessonRecord) {
//			LessonRecordPO les_RecordPO = (LessonRecordPO) po;
//			lessonInfoList.add((LessonUniquePO) lessonUnData
//					.find(les_RecordPO.getLes_Id()));
//		}
//		System.out.println("根据课程记录中的课程号查找课程具体信息，测试桩中返回的是给定的信息，所以这里是两条相同记录");
//		return lessonInfoList;
//	}

	@Override
	public ArrayList<LessonRecordPO> getLessonRecord(int stu_id) throws RemoteException {
		System.out.println("LessonRecordDisplay调用LessonRecordData的find方法查找对应学号的课程记录");
		System.out.println("因为是桩测试，这里默认返回两条课程记录");
		ArrayList<PO> lessonRecord = lessonRecordData.find(0, stu_id);
		ArrayList<LessonRecordPO> lessonRecordVoList = new ArrayList<>();
		for (PO po: lessonRecord){
			LessonRecordPO les_RecordPO = (LessonRecordPO) po;
			lessonRecordVoList.add(les_RecordPO);
		}
		return lessonRecordVoList;
	}

	

}
