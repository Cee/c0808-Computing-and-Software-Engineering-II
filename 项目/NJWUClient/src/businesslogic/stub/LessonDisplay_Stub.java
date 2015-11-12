package businesslogic.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonUniquePO;
import po.PO;
import businesslogicservice.displayblservice.LessonDisplayService;
import dataservice.DatabaseService;

public class LessonDisplay_Stub implements LessonDisplayService{
	DatabaseService lessonUnData;
	public LessonDisplay_Stub(DatabaseService les_un) {
		lessonUnData = les_un;
	}
	
	@Override
	public ArrayList<LessonUniquePO> getByChooseLesson(int type, int ins_id) {
		return null;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonsOfIns(int ins_id) throws RemoteException {
		System.out.println("调用LessonUnData的find方法 From LessonDisplayBl");
		ArrayList<PO> list = lessonUnData.find(0, ins_id);
		ArrayList<LessonUniquePO> lessonList = new ArrayList<>();
		for (PO po : list){
			lessonList.add((LessonUniquePO) po);
		}
		return lessonList;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonOfTeacher(int tea_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LessonUniquePO getLessonInfo(int Les_id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
