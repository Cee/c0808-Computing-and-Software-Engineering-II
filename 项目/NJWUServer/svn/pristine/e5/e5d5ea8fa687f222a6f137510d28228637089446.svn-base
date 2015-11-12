package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BroadCastPO;
import po.ModulePO;
import po.PO;
import data.broadcastdata.BroadCastData;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;
import dataservice.broadcastservice.BroadCastDataService;
import dataservice.framedataservice.ModuleDataService;

public class BroadcastDriver {
	DatabaseService broadCast;
	public BroadcastDriver(DatabaseService broadCast){
		this.broadCast = broadCast;
	}
	public void space(){
		System.out.println("-------------------------------------------------------");
	}
	public void drive() throws RemoteException{
		broadCast.insert(new BroadCastPO("本学期开始！"));
		System.out.println("搜索所有通知:");
		BroadCastPO broadCastPO = null ;
		ArrayList<PO> list = broadCast.findAll();
		for (PO po:list){
			broadCastPO = (BroadCastPO)po;
			System.out.println(broadCastPO.getMessage()+"  "+broadCastPO.getDate());
		}
		broadCast.delete(broadCastPO.getId());
		list = broadCast.findAll();
		for (PO po:list){
			broadCastPO = (BroadCastPO)po;
			System.out.println(broadCastPO.getMessage()+"  "+broadCastPO.getDate());
		}
		
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try {
			DatabaseFactory factory = (DatabaseFactory) Naming.lookup("NJWU");
			String broadcast = factory.getDataBase(Table.broadcast);
			DatabaseService broadcastData;
			broadcastData = (DatabaseService) Naming.lookup(broadcast);
			BroadcastDriver driver = new BroadcastDriver(broadcastData);
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
