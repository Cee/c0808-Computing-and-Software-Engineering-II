package businesslogic.insteacherbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DatabaseService;

import po.LessonAbstractPO;
import vo.PlanVO;

public class PlanEditor {
	DatabaseService planData;
	ArrayList<LessonAbstractPO> list;

	public PlanEditor(DatabaseService planData) {
		this.planData = planData;
	}
	
	
	public boolean addLesson(LessonAbstractPO lesson_abstractPO)
			throws RemoteException {
		list.add(lesson_abstractPO);
		planData.insert(lesson_abstractPO);
		return true;
	}

	/**
	 * 根据课程号删除课程
	 * @param les_Id_Ab
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteLesson(int les_Id_Ab) throws RemoteException {
		for (LessonAbstractPO po : list) {
			if (po.getLes_Id_Ab() == les_Id_Ab) {
				list.remove(po);
				planData.delete(les_Id_Ab);
				return true;
			}
		}
		return false;
	}

	/**
	 * 修改抽象课程
	 * 返回是否修改成功
	 * @param lesson_abstractPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyPlan(LessonAbstractPO lesson_abstractPO)
			throws RemoteException {
		for (LessonAbstractPO po : list) {
			if (po.getLes_Id_Ab() == lesson_abstractPO.getLes_Id_Ab()) {
				po = lesson_abstractPO;
				planData.update(lesson_abstractPO);
				break;
			}
		}
		return true;
	}

	/**
	 * 判断计划是否符合要求-。- 
	 * 暂时空着
	 * @param list
	 * @return
	 */
	public boolean checkPlan(ArrayList<LessonAbstractPO> list) {
		return false;
	};

	/**
	 * 返回一个教学计划
	 * @return
	 */
	public PlanVO showPlan() {
		return new PlanVO(list);
	}

	public void setList(ArrayList<LessonAbstractPO> list) {
		this.list = list;
	}

	public ArrayList<LessonAbstractPO> getList() {
		return list;
	}
}
