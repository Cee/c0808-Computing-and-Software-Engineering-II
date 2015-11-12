package businesslogic.displaybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.PO;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import dataservice.DatabaseService;

public class LessonRecordDisplay implements LessonRecordDisplayService {
	/**
	 * 课程记录数据服务
	 */
	DatabaseService lessonRecordData;

	/**
	 * 与调用者共享数据服务
	 * @param lessonRecordData
	 */
	public LessonRecordDisplay(DatabaseService lessonRecordData) {
		this.lessonRecordData = lessonRecordData;
	}

	@Override
	public ArrayList<LessonRecordPO> getLessonRecord(int stu_id)
			throws RemoteException {
		ArrayList<LessonRecordPO> recordList = new ArrayList<LessonRecordPO>();

		ArrayList<PO> list = lessonRecordData.find(1, stu_id);
		for (PO po : list) {
			recordList.add( (LessonRecordPO)po  );
		}
		return recordList;
	}

	@Override
	public ArrayList<LessonRecordPO> getStudentOfLesson(int les_id)
			throws RemoteException {
		ArrayList<LessonRecordPO> recordList = new ArrayList<LessonRecordPO>();
		ArrayList<PO> list = lessonRecordData.find(2, les_id);
		for (PO po : list) {
			recordList.add( (LessonRecordPO) po);
		}
		return recordList;
	}

}
