package vo;

import java.util.ArrayList;
import java.util.Iterator;

import po.LessonUniquePO;

public class ScheduleVO extends VO {
	private ArrayList<LessonUniqueVO> lessons = new ArrayList<LessonUniqueVO>();
	
	public ScheduleVO(Iterator<LessonUniquePO> lessonsIter){
		while(lessonsIter.hasNext()){
			lessons.add(new LessonUniqueVO(lessonsIter.next()));
		}
	}
	
	public Iterator<LessonUniqueVO> getlessons() {
		return lessons.iterator();
	}

	
}
