package mock.display_mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonAbstractPO;
import businesslogicservice.displayblservice.PlanDisplayService;

public class PlanDisplay_Mock implements PlanDisplayService{
	LessonAbstractPO lesson = new LessonAbstractPO(25, "软件工程", 250001, 5, "学科平台课程", "软工2", 3, 3, 3, 3, 2, 1, "学科专业课程");
	ArrayList<LessonAbstractPO> list = new ArrayList<>();
	@Override
	public ArrayList<LessonAbstractPO> getPlanofIns(int ins_id)
			throws RemoteException {
		list.clear();
		list.add(lesson);
		return list;
	}

	@Override
	public LessonAbstractPO getPlan(int LesAb_id) throws RemoteException {
		return lesson;
	}

}
