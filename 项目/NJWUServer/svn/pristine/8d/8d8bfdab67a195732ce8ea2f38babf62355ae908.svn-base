package test;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PO;
import po.StudentPO;
import data.userdata.StudentData;
import databaseutility.DatabaseFactory;
import databaseutility.DatabaseFactoryImpl;
import dataservice.DatabaseService;
import dataservice.Table;
import dataservice.framedataservice.ModuleDataService;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.11.1
 * StudentData测试驱动
 */
public class StudentDriver {
	DatabaseService studentData;
	public StudentDriver(DatabaseService studentData){
		this.studentData = studentData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive(){
		//搜索学号为121250151的学生
		try {
			System.out.println("搜索学号为121250151的学生");
			StudentPO po;
			po = (StudentPO)studentData.find(121250151);
			System.out.println(po.simpleInfo());
			space();
			//将学生院系号改为19
			System.out.println("将学生院系号改为19");
			po.setIns_Id(19);
			studentData.update(po);
			po=(StudentPO)studentData.find(121250151);
			System.out.println(po.simpleInfo());
			space();
			//将学生院系号改为25
			System.out.println("将学生院系号改为25");
			po.setIns_Id(25);
			studentData.update(po);
			po=(StudentPO)studentData.find(121250151);
			System.out.println(po.simpleInfo());
			space();
			//将学生学号改为1,并重新插入
			System.out.println("将学生学号改为1,并重新插入");
			po.setStu_Id(1);
			studentData.insert(po);
			space();
			//搜索学号为1的学生
			System.out.println("搜索学号为1的学生");
			po=(StudentPO)studentData.find(1);
			System.out.println(po.simpleInfo());
			space();
			System.out.println("删除学号为1的学生");
			studentData.delete(1);
			space();
			//搜索院系号为25，年级为2的学生
			System.out.println("搜索院系号为25，年级为2的学生");
			ArrayList<PO> list = studentData.find(25, 1);
			for (PO eachPO:list){
				System.out.println(((StudentPO)eachPO).simpleInfo());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String mark = factory.getDataBase(Table.student);
			DatabaseService studentData;
			studentData = (DatabaseService) Naming.lookup(mark);
			StudentDriver driver = new StudentDriver((DatabaseService) studentData);
			driver.drive();
		} catch (MalformedURLException | NotBoundException | RemoteException e) {
			e.printStackTrace();
		}
	}

}
