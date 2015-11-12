package dataservice.lessonrecorddataservice;

//学生选到的课程的课程号与成绩与学号的对应记录
import java.util.ArrayList;

import po.LessonRecordPO;
import po.PO;

/**
 * 
 * @author Norvi
 * @version 1.0 @ 13.10.17
 * 
 */
public class LessonRecordData_Stub implements LessonRecordDataService {

	@Override
	public boolean insert(PO po) {
		System.out.println("成功插入课程记录 From LessonRecordData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除课程记录 From LessonRecordData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新课程记录 From LessonRecordData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("找到此id的课程记录 From LessonRecordData");
		return new LessonRecordPO(id, 31001, 121250151, 0, "软工2", "王琨");
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("找到符合条件的课程记录 From LessonRecordData");
		ArrayList<PO> lessonRecord = new ArrayList<>();
		lessonRecord.add(new LessonRecordPO(31001, id, 0, "王琨", "软工2"));
		lessonRecord.add(new LessonRecordPO(31002, id, 0, "王琨", "C++"));
		return lessonRecord;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("找到所有课程记录 From LessonRecordData");
		ArrayList<PO> lessonRecord = new ArrayList<>();
		lessonRecord.add(new LessonRecordPO(31001, 121250151, 0, "软工2", "王琨"));
		lessonRecord.add(new LessonRecordPO(31002, 121250151, 0, "c++", "王琨"));
		return lessonRecord;
	}

}
