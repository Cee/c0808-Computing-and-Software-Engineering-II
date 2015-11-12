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
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;
import dataservice.framedataservice.ModuleDataService;


public class ModuleDriver {
	ModuleDataService moduleData ;
	public ModuleDriver(ModuleDataService moduleData2){
		this.moduleData = moduleData2;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		System.out.println("搜索所有的模块");
		ArrayList<PO> list = moduleData.findAll();
		for (PO eachPo : list){
			System.out.println(((ModulePO)eachPo).info());
		}
		space();
		System.out.println("搜索模块编号为1的模块");
		ModulePO module = (ModulePO) moduleData.find(1);
		System.out.println(module.info());
		space();
		System.out.println("修改模块1内容");
		module.setName("通识通修课程");
		moduleData.update(module);
		space();
		System.out.println("重新查找模块1内容");
		module = (ModulePO) moduleData.find(1);
		System.out.println(module.info());
		space();
		System.out.println("增加一条模块");
		module.setName("睡觉");
		moduleData.insert(module);
		space();
		System.out.println("搜索所有模块");
		list = moduleData.findAll();
		for (PO eachPo : list){
			System.out.println(((ModulePO)eachPo).info());
		}
		space();
		System.out.println("请输入您将要删除的模块编号");
		int  id = Integer.parseInt(getInput());
		System.out.println("删除模块"+id);
		moduleData.delete(id);
		space();
		System.out.println("搜索所有模块");
		list = moduleData.findAll();
		for (PO eachPo : list){
			System.out.println(((ModulePO)eachPo).info());
		}
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String module = factory.getDataBase(Table.module);
			DatabaseService moduleData;
			moduleData = (DatabaseService) Naming.lookup(module);
			ModuleDriver driver = new ModuleDriver((ModuleDataService) moduleData);
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
