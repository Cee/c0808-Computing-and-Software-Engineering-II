package businesslogic.displaybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonAbstractPO;
import po.PO;
import businesslogicservice.displayblservice.PlanDisplayService;
import dataservice.DatabaseService;

public class PlanDisplay implements PlanDisplayService {
	DatabaseService lesAbData;

	public PlanDisplay(DatabaseService planService) {
		this.lesAbData = planService;
	}

	@Override
	public LessonAbstractPO getPlan(int LesAb_id) throws RemoteException {
		return (LessonAbstractPO) lesAbData.find(LesAb_id);
	}

	@Override
	public ArrayList<LessonAbstractPO> getPlanofIns(int ins_id)
			throws RemoteException {
		ArrayList<LessonAbstractPO> pList = new ArrayList<LessonAbstractPO>();

		ArrayList<PO> list = lesAbData.find(1, ins_id);
		for (PO po : list) {
			pList.add((LessonAbstractPO) po);
		}
		return pList;
	}

}
