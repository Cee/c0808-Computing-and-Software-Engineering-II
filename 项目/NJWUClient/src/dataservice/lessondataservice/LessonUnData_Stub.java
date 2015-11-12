package dataservice.lessondataservice;

import java.util.ArrayList;

import po.LessonUniquePO;
import po.PO;

/**
 * 
 * @author Cee
 * @date 13.10.17
 * @version 1.0 具体课程桩测试
 */
public class LessonUnData_Stub implements LessonUnDataService {

	@Override
	public boolean insert(PO po) {
		System.out.println("成功添加一个具体课程 From LessonUnData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除一个具体课程 From LessonUnData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新一个具体课程 From LessonUnData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("成功找到一个具体课程 From LessonUnData");
		return new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程");
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("成功找到一组符合条件的具体课程 From LessonUnData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程"));
		list.add(new LessonUniquePO("C++", 2, "软件学院", "仙II-303", 3, 240,
				238, 0, 125002, "郑滔", 31002, 19, 2, 3, 4, null, null, null,3, 1, 5, "学科平台课程"));
		return list;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("成功找到所有的具体课程 From LessonUnData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new LessonUniquePO("软工2", 1, "软件学院", "仙II-303", 3, 300, 250, 0, 25014, "刘钦", 25000320, 25, 1, 3, 4, null, null, null, 3, 1, 5, "学科平台课程"));
		list.add(new LessonUniquePO("C++", 2, "软件学院", "仙II-303", 3, 240,
				238, 0, 125002, "郑滔", 31002, 19, 2, 3, 4, null, null, null,3, 1, 5, "学科平台课程"));
		return list;
	}

}
