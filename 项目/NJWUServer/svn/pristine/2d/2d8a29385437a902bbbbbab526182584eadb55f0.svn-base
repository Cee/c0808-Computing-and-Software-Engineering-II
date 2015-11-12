package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.PO;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class Les_RecordDriver {
	DatabaseService lessonRecordData;
	public Les_RecordDriver(DatabaseService lessonRecordData){
		this.lessonRecordData = lessonRecordData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		System.out.println("搜索课程编号为1的课程记录");
		ArrayList<PO> list = lessonRecordData.find(2, 1);
		for (PO po : list) {
			System.out.println(((LessonRecordPO)po).info());
		}
		space();
		
		System.out.println("搜索学号为121250151的学生的所有课程记录");
		list = lessonRecordData.find(1, 121250151);
		for (PO po : list) {
			System.out.println(((LessonRecordPO)po).info());
		}
		space();
		
		System.out.println("搜索1号课程记录");
		LessonRecordPO po = (LessonRecordPO) lessonRecordData.find(1);
		System.out.println(po.info());
		space();
		
		System.out.println("更改1号记录中的成绩");
		po.setScore(100);
		lessonRecordData.update(po);
		System.out.println("重新搜索");
		po = (LessonRecordPO) lessonRecordData.find(1);
		System.out.println(po.info());
		space();
		
		po.setLes_Id(4);
		System.out.println("将该课程记录的课程号改为2，重新插入");
		lessonRecordData.insert(po);
		System.out.println("搜索课程编号为2的课程记录");
		list = lessonRecordData.find(2, 4);
		for (PO eachpo : list) {
			System.out.println(((LessonRecordPO)eachpo).info());
		}
		space();		
		System.out.println("请输入您将要删除的课程记录的编号");
		int id = Integer.parseInt(getInput());
		lessonRecordData.delete(id);
		System.out.println("已删除，重新显示课程编号为2的课程记录");
		list = lessonRecordData.find(2, 4);
		for (PO eachpo : list) {
			System.out.println(((LessonRecordPO)eachpo).info());
		}
		space();
	}
	
	public static void main(String[] args) throws RemoteException{
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String mark = factory.getDataBase(Table.lesson_record);
			DatabaseService lessonRecordData;
			lessonRecordData = (DatabaseService) Naming.lookup(mark);
			Les_RecordDriver driver = new Les_RecordDriver(lessonRecordData);
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
