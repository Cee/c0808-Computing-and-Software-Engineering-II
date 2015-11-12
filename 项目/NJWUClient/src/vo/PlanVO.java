package vo;

import java.util.ArrayList;
import java.util.Iterator;

import po.LessonAbstractPO;

public class PlanVO extends VO{
	ArrayList<LessonAbstractPO> list;
	ArrayList<LessonAbstractVO> lessons = new ArrayList<LessonAbstractVO>();
	public PlanVO(ArrayList<LessonAbstractPO> list) {
		this.list = list;
		loadList();
	}
	public Iterator<LessonAbstractVO> getLessons() {
		return lessons.iterator();
	}
	public String toString() {
		String vo = "";
		for (LessonAbstractPO po : list) {
			vo = vo + po.info() + "\n";
		}
		return vo;
	}
	
	
	private void loadList(){
		for (LessonAbstractPO po : list) {
			LessonAbstractVO vo = new LessonAbstractVO(po);
			lessons.add(vo);
		}
	}
	
}
