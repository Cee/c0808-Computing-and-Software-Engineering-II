package businesslogic.studentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DatabaseService;

import po.LessonUniquePO;
import po.SelectRecordPO;
import utility.Constant;
/**
 * 协助学生进行选课
 * @author luck
 *
 */
public class SelectHelper {
	int lessonType;
	/**
	 * 原先我的选课记录
	 */
	ArrayList<SelectRecordPO> mySelection = new ArrayList<SelectRecordPO>();
	/**
	 * 我新的选课记录
	 */
	ArrayList<SelectRecordPO> newSelection = new ArrayList<SelectRecordPO>();
	DatabaseService selectRecordData;
	DatabaseService lessonData;
	public SelectHelper(DatabaseService selectRecordData,DatabaseService lessonData) {
		this.selectRecordData = selectRecordData;
		this.lessonData = lessonData;

	}

	public void setMySelection(ArrayList<SelectRecordPO> mySelection) {
		this.mySelection = mySelection;
		newSelection.clear();
		for (SelectRecordPO po : mySelection) {
			newSelection.add(po);
		}
	}
	/**
	 * 删除旧的
	 * 提交新的
	 * @return
	 * @throws RemoteException
	 */
	public boolean submit() throws RemoteException {
		for (SelectRecordPO po : mySelection) {
			selectRecordData.delete(po.getId());
			LessonUniquePO lesson = (LessonUniquePO)lessonData.find(po.getLes_Id());
			lesson.setCur_stu_num(lesson.getCur_stu_num()-1);
			lessonData.update(lesson);
		}
		for (SelectRecordPO po : newSelection) {
			selectRecordData.insert(po);
			LessonUniquePO lesson = (LessonUniquePO)lessonData.find(po.getLes_Id());
			if (lesson!=null){
				lesson.setCur_stu_num(lesson.getCur_stu_num()+1);
				lessonData.update(lesson);		
			}else {
				return false;
			}
		
		}
		return true;
	}
	/**
	 * 增加选课记录
	 * 判断是否满四节
	 * @param les_id
	 * @param stu_id
	 * @return
	 */
	public boolean addSelection(int les_id, int stu_id) {
		if (newSelection.size() == Constant.Student.MAXSELECTION && (lessonType == 1 || lessonType == 9))
			return false;
		for (SelectRecordPO po : newSelection) {
			if (po.getLes_Id() == les_id)
				return false;
		}
		newSelection.add(new SelectRecordPO(0, stu_id, les_id, lessonType));
		return true;
	}

	/**
	 * 减少选课
	 * @param les_id
	 * @param stu_id
	 * @return
	 */
	public boolean deleteSelection(int les_id, int stu_id) {
		for (SelectRecordPO po : newSelection) {
			if (les_id == po.getLes_Id() && stu_id == po.getStu_Id()) {
				newSelection.remove(po);
				return true;
			}
		}
		return false;
	}

	public void setLessonType(int lessonType) {
		this.lessonType = lessonType;
	}

	public ArrayList<SelectRecordPO> getNewSelection() {
		return newSelection;
	}
}
