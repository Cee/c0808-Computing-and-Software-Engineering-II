package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ModulePO;
import po.PO;
import po.TypePO;
import data.framedata.TypeData;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;
import dataservice.framedataservice.ModuleDataService;


public class TypeDriver {
	DatabaseService typeData ;
	public TypeDriver(DatabaseService typeData){
		this.typeData = typeData;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		System.out.println("搜索所有的课程类别");
		ArrayList<PO> list = typeData.findAll();
		for (PO eachPo : list){
			System.out.println(((TypePO)eachPo).info());
		}
		space();
		System.out.println("搜索属于模块1的课程类别");
		list = typeData.find(0,1);
		for (PO eachPo : list){
			System.out.println(((TypePO)eachPo).info());
		}
		space();
		System.out.println("搜索编号为1的课程类别");
		TypePO type = (TypePO) typeData.find(1);
		System.out.println(type.info());
		space();
		System.out.println("修改类别1内容,选修改为必修");
		type.setCompulsory(1);
		typeData.update(type);
		space();
		System.out.println("重新查找课程类别1内容");
		type = (TypePO) typeData.find(1);
		System.out.println(type.info());
		space();
		System.out.println("改回来");
		type.setCompulsory(3);
		typeData.update(type);
		System.out.println("增加一条课程类别");
		type.setName("睡觉");
		typeData.insert(type);
		space();
		System.out.println("搜索所有课程类别");
		list = typeData.findAll();
		for (PO eachPo : list){
			System.out.println(((TypePO)eachPo).info());
		}
		space();
		System.out.println("请输入您想删除的课程类别编号");
		int id = Integer.parseInt(getInput());
		System.out.println("删除课程类别"+id);
		typeData.delete(id);
		space();
		System.out.println("搜索所有课程类别");
		list = typeData.findAll();
		for (PO eachPo : list){
			System.out.println(((TypePO)eachPo).info());
		}
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String mark = factory.getDataBase(Table.type);
			DatabaseService typeData;
			typeData = (DatabaseService) Naming.lookup(mark);
			TypeDriver driver = new TypeDriver((DatabaseService) typeData);
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
