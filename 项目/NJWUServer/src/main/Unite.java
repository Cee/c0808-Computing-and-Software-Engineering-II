package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.LessonUniquePO;
import po.PO;
import po.SelectRecordPO;
import test.Sel_RecordDriver;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class Unite {
	public static void main(String[] args){
		
			try {
				DatabaseFactory factory = (DatabaseFactory) Naming.lookup("//localhost:1099/NJWU");
				String mark = factory.getDataBase(Table.select_record);
				DatabaseService selectData = (DatabaseService) Naming.lookup(mark);
				mark = factory.getDataBase(Table.Lesson_unique);
				DatabaseService lessonData = (DatabaseService) Naming.lookup(mark);
				ArrayList<PO> list = selectData.findAll();
				for (PO po:list){
					int les_id = ((SelectRecordPO)po).getLes_Id();
					LessonUniquePO lesson = (LessonUniquePO)lessonData.find(les_id);
					lesson.setCur_stu_num(lesson.getCur_stu_num()+1);
					lessonData.update(lesson);
					System.out.println("已更新课程："+lesson.getLes_name()+"当前学生"+lesson.getCur_stu_num());
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
	}
	public static int formScore(){
		int score =(int) (Math.random()*100);
		if (score>=10&&score<=50){
			score=100-score+10;
		}
		if (score<10)
			score=100-score;
		return score;
	}
//	成绩清零
//	String mark=factory.getDataBase(Table.lesson_record);
//	DatabaseService lessonRecord = (DatabaseService)Naming.lookup(mark);
//	ArrayList<PO> list = lessonRecord.findAll();
//	for (PO po : list) {
//		LessonRecordPO lessonRecordPO = (LessonRecordPO)po;
//		if (lessonRecordPO.getStu_Id()>=130000000){
//			lessonRecordPO.setScore(0);
//			lessonRecord.update(lessonRecordPO);	
//		}
//		System.out.println("已完成"+lessonRecordPO.getStu_name()+"的成绩清零");
}
