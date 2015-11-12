package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import databaseutility.DatabaseFactoryImpl;

public class Launcher {
	public static void main(String[] args){
		
			try {
				LocateRegistry.createRegistry(1099);
				DatabaseFactoryImpl databaseFactoryImpl = new DatabaseFactoryImpl();
				Naming.rebind("//localhost:1099/NJWU", databaseFactoryImpl);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}			
		System.out.println("服务器端开始");
	}

}
