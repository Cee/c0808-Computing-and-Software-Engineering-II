package dataservice.plandataservice;

import java.util.ArrayList;

import po.LessonAbstractPO;
import po.PO;
/**
 * 
 * @author Norvi
 * @version 1.0
 * @ 13.10.17
 *
 */
public class LessonAbData_Stub implements LessonAbDataService{
	@Override
	public boolean insert(PO po) {
		System.out.println("成功插入一条抽象课程记录 From LessonAbData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除一条抽象课程记录 From LessonAbData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新抽象课程记录 From LessonAbData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("找到此id的抽象课程记录 From LessonAbData");
		return new LessonAbstractPO(id, "软件学院", 31001,6 , "专业核心课程", "软件工程I", 2, 4, 2, 2,2,1,"学科专业课程");
		
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("找到符合条件的抽象课程记录 From LessonAbData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new LessonAbstractPO(id, "软件学院", 31001,6 , "专业核心课程", "软件工程I", 2, 4, 2, 2,2,1,"学科专业课程"));
		list.add(new LessonAbstractPO(id, "软件学院", 31002,6 , "专业核心课程", "C++", 3,3, 3, 3,2,1,"学科专业课程"));
		return list;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("找到所有抽象课程信息 From LessonAbData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new LessonAbstractPO(25, "软件学院", 31001,6 , "专业核心课程", "软件工程I", 2, 4, 2, 2,2,1,"学科专业课程"));
		list.add(new LessonAbstractPO(25, "软件学院", 31002,6 , "专业核心课程", "C++", 3,3, 3, 3,2,1,"学科专业课程"));
		return list;
	}

 }
