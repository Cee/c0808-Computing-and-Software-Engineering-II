package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonUniquePO;
import businesslogicservice.displayblservice.LessonDisplayService;

public class LessonDisplay_Mock implements LessonDisplayService{
	LessonUniquePO lesson1 = new LessonUniquePO("软工2", 1, "软件学院", "仙2 303", 3, 250, 243, 1, 25014, "刘钦", 250001, 25, 1, 1, 2, null, null, null, 3, 1, 5, "学科平台课程");
	LessonUniquePO lesson2 = new LessonUniquePO("西方音乐通论", 2, "公共课程", "仙1 303", 1, 250, 250, 1, 10001, "吕指", 100001, 1, 1, 9, 10, null, null, null, 2, 2, 1, "通识教育课程");
	@Override
	public ArrayList<LessonUniquePO> getByChooseLesson(int type, int ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> list  = new ArrayList<>();
		if (type==1){
			list.add(lesson2);
		} else {
			list.add(lesson1);
		}
		return list;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonsOfIns(int ins_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> list  = new ArrayList<>();
			list.add(lesson1);
			return list;
	}

	@Override
	public ArrayList<LessonUniquePO> getLessonOfTeacher(int tea_id)
			throws RemoteException {
		ArrayList<LessonUniquePO> list  = new ArrayList<>();
			list.add(lesson1);
			return list;
	}

	@Override
	public LessonUniquePO getLessonInfo(int Les_id) throws RemoteException {
		return lesson1;
	}

}
