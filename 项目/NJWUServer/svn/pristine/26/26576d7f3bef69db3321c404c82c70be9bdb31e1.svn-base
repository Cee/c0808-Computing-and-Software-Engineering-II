package test;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PO;
import po.TeacherPO;
import po.TeacherPO;
import data.userdata.StudentData;
import data.userdata.TeacherData;
import databaseutility.DatabaseFactory;
import databaseutility.DatabaseFactoryImpl;
import dataservice.DatabaseService;
import dataservice.Table;


public class TeacherDriver {
	DatabaseService teacherData;
	public TeacherDriver(DatabaseService teacherData){
		this.teacherData = teacherData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive(){
		//搜索学号为25014的学生
		try {
			System.out.println("搜索工号为25014的老师");
			TeacherPO po =(TeacherPO)teacherData.find(25014);
			System.out.println(po.simpleInfo());
			space();
			//将学生院系号改为19
			System.out.println("将教师院系号改为19");
			po.setIns_Id(19);
			teacherData.update(po);
			po=(TeacherPO)teacherData.find(25014);
			System.out.println(po.simpleInfo());
			space();
			//将学生院系号改为25
			System.out.println("将教师院系号改为25");
			po.setIns_Id(25);
			teacherData.update(po);
			po=(TeacherPO)teacherData.find(25014);
			System.out.println(po.simpleInfo());
			space();
			//将学生学号改为1,并重新插入
			System.out.println("将教师工号改为1,并重新插入");
			po.setTea_Id(1);
			teacherData.insert(po);
			space();
			//搜索学号为1的学生
			System.out.println("搜索工号为1的教师");
			po=(TeacherPO)teacherData.find(1);
			System.out.println(po.simpleInfo());
			space();
			System.out.println("删除工号为1的教师");
			teacherData.delete(1);
			space();
			//搜索院系号为25，年级为2的学生
			System.out.println("搜索院系号为25的所有教师");
			ArrayList<PO> list;
			list = teacherData.find(0, 25);
			for (PO eachPO:list){
				System.out.println(((TeacherPO)eachPO).simpleInfo());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String mark = factory.getDataBase(Table.teacher);
			DatabaseService teacherData;
			teacherData = (DatabaseService) Naming.lookup(mark);
			TeacherDriver driver = new TeacherDriver(teacherData);
			driver.drive();
		} catch (MalformedURLException | NotBoundException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
