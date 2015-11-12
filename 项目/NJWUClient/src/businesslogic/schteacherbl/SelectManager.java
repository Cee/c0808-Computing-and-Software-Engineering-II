package businesslogic.schteacherbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.SelectRecordPO;
import po.StudentPO;
import businesslogicservice.displayblservice.LessonDisplayService;
import businesslogicservice.displayblservice.LessonRecordDisplayService;
import businesslogicservice.displayblservice.SelectRecordDisplayService;
import businesslogicservice.displayblservice.StudentInfoDisplayService;
import dataservice.choosedataservice.SelectRecordDataService;
import dataservice.lessonrecorddataservice.LessonRecordDataService;
/**
 * 负责排课
 * @author 小c
 *
 */
public class SelectManager {
	/**
	 * Display
	 */
	private SelectRecordDisplayService selectRecordDisplay;
	private LessonRecordDisplayService lessonRecordDisplay;
	private LessonRecordDataService lessonRecordDataService;
	private LessonDisplayService lessonDisplay;
	private StudentInfoDisplayService studentDisplay;
	
	private int OVER = -1 ;
	private SelectRecordDataService selectRecordDataBaseService;
	
	public SelectManager(SelectRecordDisplayService selectRecordDisplay ,LessonRecordDisplayService lessonRecordDisplay , LessonRecordDataService lessonRecordData , LessonDisplayService lessonDisplay , StudentInfoDisplayService studentInfoDisplay, SelectRecordDataService selectRecordDataBaseService  )  {
		this.selectRecordDisplay  = selectRecordDisplay;
		this.lessonDisplay = lessonDisplay;
		this.lessonRecordDataService = lessonRecordData;
		this.lessonRecordDisplay = lessonRecordDisplay;
		this.studentDisplay = studentInfoDisplay;
		this.selectRecordDataBaseService = selectRecordDataBaseService;
	}

	void allo() throws RemoteException {
		ArrayList<LessonUniquePO> toAlloList = lessonDisplay.getByChooseLesson(
				1, 0);

		for (int i = 0; i < toAlloList.size(); ++i) {
			LessonUniquePO lesson = toAlloList.get(i);
			int les_id = lesson.getLes_Id();
			ArrayList<SelectRecordPO> records = selectRecordDisplay
					.getRecordOfLesson(les_id);
			ArrayList<RecordStruct> result = sortedResult(records,
					lesson.getMax_stu_num());
			
			for(int j = 0 ; j < result.size() ; ++j){
				SelectRecordPO sel_po = result.get(j).getRecord();
				String stu_name  = studentDisplay.getStudent(sel_po.getStu_Id()).getName(); //
				LessonRecordPO po = new LessonRecordPO(les_id, sel_po.getStu_Id(), 0, stu_name, lesson.getLes_name());
				lessonRecordDataService.insert(po);
				
			}
			
			for(int j = 0 ; j < records.size() ; ++j){
				lessonRecordDataService.delete(records.get(i).getId());
			}

		}
	}

	ArrayList<RecordStruct> sortedResult(ArrayList<SelectRecordPO> records,
			int max) throws RemoteException {
		ArrayList<RecordStruct> result = new ArrayList<SelectManager.RecordStruct>();
		for (int i = 0; i < records.size(); ++i) {
			result.add(new RecordStruct(records.get(i)));
		}
		Collections.sort(result);
		if (max >= result.size()) {
			return result;
		} else {
			return new ArrayList<RecordStruct>(result.subList(0, max));
		}
	}

	class RecordStruct implements Comparable<RecordStruct> {
		private SelectRecordPO record;
		private int value;

		RecordStruct(SelectRecordPO po) throws RemoteException {
			record = po;
			setValue();
		}

		private void setValue() throws RemoteException {
			int stu_id = record.getStu_Id();
			StudentPO student = studentDisplay.getStudent(stu_id);
			int grade = student.getGrade();
			int credits = 0;
			ArrayList<LessonRecordPO> lessonList = lessonRecordDisplay.getLessonRecord(stu_id);
			for(int i = 0 ; i < lessonList.size() ; ++i){
				
				int les_id = lessonList.get(i).getLes_Id();
				LessonUniquePO lesson = lessonDisplay.getLessonInfo(les_id);
				if(lesson.getState() == OVER){
					credits +=lesson.getCredit(); 
				}
				
			}
			value = 0 - grade * grade;
			value *= credits  ;
			
			value +=  (int) ( Math.random()*100 );
			
			
		}

		public int getValue() {
			return value;
		}

		public SelectRecordPO getRecord() {
			return record;
		}
		
		public int compareTo(RecordStruct o) {
			if (value < (o.getValue() )) {
				return -1;
			} else if (value == ((RecordStruct) o).getValue()) {
				return 0;
			} else {
				return 1;
			}
		}

	}

}
