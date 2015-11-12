package dataservice.userdataservice;

import java.util.ArrayList;

import po.PO;
import po.TeacherPO;
/**
 * 
 * @author Norvi
 * @version 1.0
 * @ 13.10.17
 *
 */
public class TeacherData_Stub implements TeacherDataService{

	@Override
	public boolean insert(PO po) {
		System.out.println("成功添加一名教师 From TeacherData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除一名教师 From TeacherData"); 
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新教师信息 From TeacherData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("找到该id教师 From TeacherData");
		if (id==1250001){
			return new TeacherPO(id, 19, "刘钦", new char[]{'1','2','3','4','5','6'}, "软件学院", 2,"男");
		}
		if (id==1250002){
			return new TeacherPO(id, 19, "王东霞", new char[]{'1','2','3','4','5','6'}, "软件学院", 3,"女");
		}
		if (id==3){
			return new TeacherPO(id, 0,"某学校教务老师", new char[]{'1','2','3','4','5','6'}, "公共课程", 4,"女");
		}
		return null;
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("找到符合条件的教师 From TeacherData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new TeacherPO(1, id, "刘钦", new char[]{'1','2','3','4','5','6'}, "软件学院", 2,"男"));
		list.add(new TeacherPO(2, id, "王东霞", new char[]{'1','2','3','4','5','6'}, "软件学院", 3,"女"));
		return list;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("找到所有教师信息 From TeacherData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new TeacherPO(1, 19, "刘钦", new char[]{'1','2','3','4','5','6'}, "软件学院", 2,"男"));
		list.add(new TeacherPO(2, 19, "王东霞", new char[]{'1','2','3','4','5','6'}, "软件学院", 3,"女"));
		list.add(new TeacherPO(3, 0,"某学校教务老师", new char[]{'1','2','3','4','5','6'}, "公共课程", 4,"女"));
		return list;
	}

 }
