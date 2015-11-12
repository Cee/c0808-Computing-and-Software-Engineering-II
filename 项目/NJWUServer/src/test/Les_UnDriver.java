package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonUniquePO;
import po.PO;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class Les_UnDriver {
	DatabaseService lessonUnData;
	public Les_UnDriver(DatabaseService lessonUnData){
		this.lessonUnData = lessonUnData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		
		System.out.println("搜索院系号为25的所有已发布课程");
		ArrayList<PO> list = lessonUnData.find(0, 25);
		for (PO po :list){
			System.out.println(((LessonUniquePO)po).normalInfo());
		}
		space();
		
		System.out.println("搜索课程1");
		LessonUniquePO po = (LessonUniquePO) lessonUnData.find(1);
		System.out.println(po.normalInfo());
		
		space();
		
		System.out.println("修改课程1,时间改为周五");
		po.setDay(5);
		lessonUnData.update(po);
		System.out.println("重新搜索课程1");
		po = (LessonUniquePO) lessonUnData.find(1);
		System.out.println(po.normalInfo());
		System.out.println("改回来");
		po.setDay(2);
		lessonUnData.update(po);
		po = (LessonUniquePO) lessonUnData.find(1);
		System.out.println(po.normalInfo());
		space();
		
		
		System.out.println("将该课程院系设为0，及通识研讨课程，增加");
		po.setIns_Id(1);
		lessonUnData.insert(po);
		System.out.println("查找所有已发布通识研讨课程");
		list = lessonUnData.find(0,1);
		for (PO eachPo :list){
			System.out.println(((LessonUniquePO)eachPo).normalInfo());
		}
		space();
		System.out.println("请输入刚才增加的课程的编号");
		int id = Integer.parseInt(getInput());
		System.out.println("删除刚增加的课程，重新查找");
		lessonUnData.delete(id);
		po = (LessonUniquePO) lessonUnData.find(id);
		if (po==null){
			System.out.println("不存在该课程");
		}
		space();
		
		
		
		
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String mark = factory.getDataBase(Table.Lesson_unique);
			DatabaseService lessonUnData;
			lessonUnData = (DatabaseService) Naming.lookup(mark);
			Les_UnDriver driver = new Les_UnDriver(lessonUnData);
			driver.drive();
		} catch (MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	public static String getInput(){
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String line = null; 
		try {
			line = BR.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
