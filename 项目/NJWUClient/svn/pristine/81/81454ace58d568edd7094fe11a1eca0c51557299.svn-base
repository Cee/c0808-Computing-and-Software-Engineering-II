package businesslogic.displaybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonUniquePO;
import po.PO;
import businesslogicservice.displayblservice.LessonDisplayService;
import dataservice.DatabaseService;

/**
 * 
 * @author NorviNS松鼠
 * @version 1.0
 * @date 13.11.8 已发布课程展示接口实现
 */
public class LessonDisplay implements LessonDisplayService {
	/**
	 * 课程数据服务
	 */
	DatabaseService lessonDisplayData;

	/**
	 * 与调用者共享数据服务
	 * @param lessonDisplayData
	 */
	public LessonDisplay(DatabaseService lessonDisplayData) {
		this.lessonDisplayData = lessonDisplayData;
	}

	@Override
	public ArrayList<LessonUniquePO> getByChooseLesson(int type, int ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> choosenList = new ArrayList<LessonUniquePO>();
		ArrayList<PO> list = lessonDisplayData.find(type, ins_id);
		for (PO po : list) {
			LessonUniquePO lesson = (LessonUniquePO) po;
			if (lesson.getState()==0)
				choosenList.add(lesson);
		}
		return choosenList;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonsOfIns(int ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> iList = new ArrayList<LessonUniquePO>();

		ArrayList<PO> list = lessonDisplayData.find(-1, ins_id);
		for (PO po : list) {
			iList.add((LessonUniquePO) po);
		}
		return iList;
	}
	@Override
	public ArrayList<LessonUniquePO> getLessonOfTeacher(int tea_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> tList = new ArrayList<LessonUniquePO>();
		ArrayList<PO> list = lessonDisplayData.find(0, tea_id);
		for (PO po : list) {
			LessonUniquePO lesson = (LessonUniquePO)po;
			if (lesson.getState()==0)
				tList.add(lesson);
		}
		return tList;
	}
	
	@Override
	public LessonUniquePO getLessonInfo(int Les_id) throws RemoteException {
		return (LessonUniquePO) lessonDisplayData.find(Les_id);
	}

}
