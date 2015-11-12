package test;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonAbstractPO;
import po.PO;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;


public class Les_AbDriver {
	DatabaseService lessonAbData;
	public Les_AbDriver(DatabaseService lessonAbData){
		this.lessonAbData = lessonAbData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		System.out.println("搜索院系号为25的抽象课程");
		ArrayList<PO> list = lessonAbData.find(1, 25);
		for (PO eachPo : list){
			System.out.println(((LessonAbstractPO)eachPo).info());
		}
		space();
		System.out.println("搜索课程类别为1的课程");
		list = lessonAbData.find(2, 1);
		for (PO eachPo : list){
			System.out.println(((LessonAbstractPO)eachPo).info());
		}
		space();
		System.out.println("搜索课程号为25000010的课程");
		LessonAbstractPO po = (LessonAbstractPO) lessonAbData.find(25000010);
		System.out.println(po.info());
		space();
		System.out.println("此处将该课程编号设为250011111,重新添加");
		po.setLes_Id_Ab(250011111);
		lessonAbData.insert(po);
		space();
		System.out.println("搜索250011111");
		po = (LessonAbstractPO)lessonAbData.find(250011111);
		System.out.println(po.info());
		space();
		System.out.println("修改课程类别，并重新搜索");
		po.setType_Id(1);
		lessonAbData.update(po);
		po = (LessonAbstractPO)lessonAbData.find(250011111);
		System.out.println(po.info());
		space();
		System.out.println("删除250011111");
		lessonAbData.delete(250011111);
		System.out.println("搜索院系号为25的抽象课程");
		list = lessonAbData.find(1, 25);
		for (PO eachPo : list){
			System.out.println(((LessonAbstractPO)eachPo).info());
		}
		space();
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("//localhost:1099/NJWU");
			String mark = factory.getDataBase(Table.lesson_abstract);
			DatabaseService lessonAbData;
			lessonAbData = (DatabaseService) Naming.lookup(mark);
			Les_AbDriver driver = new Les_AbDriver(lessonAbData);
			driver.drive();
		} catch (MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
