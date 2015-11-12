package businesslogic.stub;

import java.util.ArrayList;

import po.LessonAbstractPO;
import businesslogicservice.displayblservice.PlanDisplayService;

public class PlanDisplay_Stub implements PlanDisplayService{

	@Override
	public LessonAbstractPO getPlan(int LesAb_id) {
		return null;
	}
/**
 * 这里需要另外写一个类来返回Plan数据 暂时用抽象课程替代。
 */
	@Override
	public ArrayList<LessonAbstractPO> getPlanofIns(int ins_id) {
		ArrayList<LessonAbstractPO> list = new ArrayList<>();
		list.add(new LessonAbstractPO(ins_id, "软件学院", 31001,6 , "专业核心课程", "软件工程I", 2, 4, 2, 2,2,1,"学科专业课程"));
		list.add(new LessonAbstractPO(ins_id, "软件学院", 31002,6 , "专业核心课程", "C++", 3,3, 3, 3,2,1,"学科专业课程"));
		return list;	
	}

}
