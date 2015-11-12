package junit;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import utility.Constant;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;

public class TestHelper {
	static DatabaseFactory databaseFactory;
	static{
	try {
		databaseFactory = (DatabaseFactory) Naming
					.lookup(Constant.NetInfo.ADDRESS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static DatabaseService getDatabaseService(Table table) throws RemoteException, MalformedURLException, NotBoundException{
		String mark = databaseFactory.getDataBase(table);
		DatabaseService databaseService = (DatabaseService)Naming.lookup(mark);
		return databaseService;
	}
}
