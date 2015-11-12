package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import businesslogicservice.displayblservice.LessonRecordDisplayService;

public class LessonRecordDisplay_Mock implements LessonRecordDisplayService{
	LessonRecordPO record1 = new LessonRecordPO(1, 121250151, 100, "王琨", "软工2");
	ArrayList<LessonRecordPO> list = new ArrayList<>();
	@Override
	public ArrayList<LessonRecordPO> getLessonRecord(int stu_id)
			throws RemoteException {
		list.clear();
		list.add(record1);
		return list;
	}

	@Override
	public ArrayList<LessonRecordPO> getStudentOfLesson(int les_id)
			throws RemoteException {
		list.clear();
		list.add(record1);
		return list;
	}

}
