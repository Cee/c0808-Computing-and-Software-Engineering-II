package businesslogic.insteacherbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.LessonUniquePO;
import dataservice.DatabaseService;

public class StudentManager {
	DatabaseService lessonRecordData;
	DatabaseService lessonUniqueData;
	ArrayList<LessonRecordPO> recordList = new ArrayList<LessonRecordPO>();

	public StudentManager(DatabaseService lessonRecordData,
			DatabaseService lessonUniqueData) {
		this.lessonRecordData = lessonRecordData;
		this.lessonUniqueData = lessonUniqueData;
	}
	
	/**
	 * 清空list
	 */
	public void initial() {
		recordList.clear();
	}

	public ArrayList<LessonRecordPO> getRecordList() {
		return recordList;
	}

	public void setRecordList(ArrayList<LessonRecordPO> recordList) {
		this.recordList = recordList;
	}


	/**
	 * 删除一条课程记录
	 * 同时对应课程的当前学生-1
	 * @param record
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteRecord(LessonRecordPO record) throws RemoteException {
		recordList.remove(record);
		if (lessonRecordData.delete(record.getId())) {
			LessonUniquePO lesson = (LessonUniquePO) lessonUniqueData
					.find(record.getLes_Id());
			lesson.setCur_stu_num(lesson.getCur_stu_num() - 1);
			return lessonUniqueData.update(lesson);
		}
		return false;
	}

	/**
	 * 增加一条课程记录
	 * 先检验该课程的学生数目是否已满
	 * 如果满了则提示失败
	 * @param record
	 * @return
	 * @throws RemoteException
	 */
	public boolean addRecord(LessonRecordPO record) throws RemoteException{
			LessonUniquePO lesson = (LessonUniquePO) lessonUniqueData
					.find(record.getLes_Id());
			System.out.println(lesson.getLes_Id()+lesson.getLes_name());
			lesson.setCur_stu_num(lesson.getCur_stu_num() + 1);
			if (lesson.getCur_stu_num() >= lesson.getMax_stu_num()){
				return false;
			}
			if (lessonRecordData.insert(record)) {
				recordList.add(record);
				return lessonUniqueData.update(lesson);
			}
			return false;
	}
}
