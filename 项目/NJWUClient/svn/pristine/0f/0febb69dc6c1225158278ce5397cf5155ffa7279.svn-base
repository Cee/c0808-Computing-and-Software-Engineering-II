package dataservice.userdataservice;

import java.util.ArrayList;

import po.PO;
import po.StudentPO;
import dataservice.userdataservice.StudentDataService;
/**
 * 
 * @author Norvi
 * @version 1.0
 * @ 13.10.17
 *
 */
public class StudentData_Stub implements StudentDataService{

	@Override
	public boolean insert(PO po) {
		System.out.println("成功插入此id学生信息 From StudentData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除此id学生信息 From StudentData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新学生信息 From StudentData");
		return true;
	}

	@Override
	public PO find(int id) {
		char[] password = "123456".toCharArray();
		System.out.println("找到此id的学生信息 From StudentData");
		return new StudentPO(121250151, "王琨", password, 19, "软件学院", "男", 2);
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("找到符合条件的学生信息 From StudentData");
		ArrayList<PO> list = new ArrayList<>();
		char[] password = "123456".toCharArray();
		list.add(new StudentPO(121250151, "王琨", password, id, "软件学院", "男", 2));
		list.add(new StudentPO(121250156, "王天宇", password, id, "软件学院", "男", 2));
		
		return list;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("找到所有学生信息 From StudentData");
		ArrayList<PO> list = new ArrayList<>();
		char[] password = "123456".toCharArray();
		list.add(new StudentPO(121250151, "王琨", password, 19, "软件学院", "男", 2));
		list.add(new StudentPO(121250156, "王天宇", password, 19, "软件学院", "男", 2));
		return list;
	}

 }
