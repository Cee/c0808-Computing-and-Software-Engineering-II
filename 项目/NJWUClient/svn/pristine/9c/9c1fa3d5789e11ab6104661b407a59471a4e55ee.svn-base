package businesslogic.studentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.LessonUniquePO;
import dataservice.DatabaseService;
/**
 * 协助学生进行补选
 * @author luck
 *
 */
public class BySelectHelper {
	DatabaseService lessonRecordData;
	DatabaseService lessonUniqueData;
	/**
	 * 我的课程
	 */
	ArrayList<LessonRecordPO> myLessons;
	public BySelectHelper(DatabaseService lessonRecordData,
			DatabaseService lessonUniqueData) {
		this.lessonRecordData = lessonRecordData;
		this.lessonUniqueData = lessonUniqueData;

	}

	public void setMyLessons(ArrayList<LessonRecordPO> myLessons) {
		this.myLessons = myLessons;
	}

	/**
	 * 补选
	 * 判断是否已选以及是否课程学生是否已满
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean bySelect(LessonRecordPO po) throws RemoteException {
		LessonUniquePO lesson = (LessonUniquePO) lessonUniqueData.find(po
				.getLes_Id());
		if (lesson.getCur_stu_num() == lesson.getMax_stu_num())
			return false;
		else {
			lesson.setCur_stu_num(lesson.getCur_stu_num() + 1);
			lessonUniqueData.update(lesson);
		}
		po.setLes_name(lesson.getLes_name());
		myLessons.add(po);
		return lessonRecordData.insert(po);
	}

	public ArrayList<LessonRecordPO> getMyLessons() {
		return myLessons;
	}

	/**
	 * 退选
	 * 判断自己是否有这门课程
	 * @param Les_id
	 * @return
	 * @throws RemoteException
	 */
	public boolean byCancel(int Les_id) throws RemoteException {
		for (LessonRecordPO po : myLessons) {
			if (po.getLes_Id() == Les_id) {
				myLessons.remove(po);

				if (lessonRecordData.delete(po.getId())) {
					LessonUniquePO lesson = (LessonUniquePO) lessonUniqueData
							.find(po.getLes_Id());
					lesson.setCur_stu_num(lesson.getCur_stu_num() - 1);
					return lessonUniqueData.update(lesson);
				}

			}
		}
		return false;
	}
}
