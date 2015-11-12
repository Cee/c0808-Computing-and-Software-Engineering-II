package businesslogic.studentbl;

import java.util.ArrayList;

import po.LessonUniquePO;
import vo.ScheduleVO;
/**
 * 构建一个Schedule
 * @author luck
 *
 */
public class ScheduleMaker {
	ArrayList<LessonUniquePO> schedule;

	public ScheduleMaker(ArrayList<LessonUniquePO> schedule) {
		this.schedule = schedule;
	}

	// 此处方法暂时省去
	public ScheduleVO makeSchedule() {
		return new ScheduleVO(schedule.iterator());
	}

}
