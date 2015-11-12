package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.PO;
import po.SelectRecordPO;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class Sel_RecordDriver {
	DatabaseService sel_recordData;
	public Sel_RecordDriver(DatabaseService sel_recordData){
		this.sel_recordData = sel_recordData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		System.out.println("添加选课记录");
		System.out.println("学号131250167，所选课程计算系统基础");
		PO po = new SelectRecordPO(1,131250167,2, 5);
		sel_recordData.insert(po);
		System.out.println("学号131250167，所选课程离散数学");
		po = new SelectRecordPO(1,131250167,1 , 5);
		sel_recordData.insert(po);
		
		System.out.println("查询学号为131250167的同学平台专业课记录");
		ArrayList<PO> poList;
		poList = sel_recordData.find(131250167,5 );
		Iterator<PO> iter = poList.iterator();
		while( iter.hasNext() ){
			SelectRecordPO sel_rpo =(SelectRecordPO) iter.next();
			System.out.print("id: " + sel_rpo.getId());
			System.out.print("\tLes_id: " + sel_rpo.getLes_Id());
			System.out.print("\tStu_id: " + sel_rpo.getStu_Id());
			System.out.println("\tType: " + sel_rpo.getType());
		}
		
		
		System.out.println("取消选课,请输入需要取消的选课记录的id");
		int id = Integer.parseInt(getInput());
		sel_recordData.delete(id);
		System.out.println("取消选课,请输入需要取消的选课记录的id");
		id = Integer.parseInt(getInput());
		sel_recordData.delete(id);		
		System.out.println("取消成功");
		space();
		
		poList = sel_recordData.find(131250167,5 );
		iter = poList.iterator();
		while( iter.hasNext() ){
			SelectRecordPO sel_rpo =(SelectRecordPO) iter.next();
			System.out.print("id: " + sel_rpo.getId());
			System.out.print("\tLes_id: " + sel_rpo.getLes_Id());
			System.out.print("\tStu_id: " + sel_rpo.getStu_Id());
			System.out.println("\tType: " + sel_rpo.getType());
		}
		
		space();
		
		System.out.println("查询该同学的通识课选课记录");
		poList = sel_recordData.find(131250167,1 );
		iter = poList.iterator();
		while( iter.hasNext() ){
			SelectRecordPO sel_rpo =(SelectRecordPO) iter.next();
			System.out.print("id: " + sel_rpo.getId());
			System.out.print("\tLes_id: " + sel_rpo.getLes_Id());
			System.out.print("\tStu_id: " + sel_rpo.getStu_Id());
			System.out.println("\tType: " + sel_rpo.getType());
		}
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String mark = factory.getDataBase(Table.select_record);
			DatabaseService sel_recordData;
			sel_recordData = (DatabaseService) Naming.lookup(mark);
			Sel_RecordDriver driver = new Sel_RecordDriver(sel_recordData);
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
