package databaseutility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
 * @author luck
 *
 */
public class DataHelper extends UnicastRemoteObject{
	protected Connection conn;
	protected Statement st;
    protected PreparedStatement PS;
    protected ResultSet RS;
	public DataHelper(Connection conn) throws RemoteException{
		this.conn = conn;
	}
}
