package databaseutility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.Table;

public interface DatabaseFactory extends Remote {
	public String getDataBase(Table table) throws RemoteException;
}
