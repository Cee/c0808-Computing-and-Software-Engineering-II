package businesslogicservice.userblservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.userbl.BroadCastReceiver;

import po.PO;
import utility.Constant;
import databaseutility.DatabaseFactory;
import dataservice.DatabaseService;
import dataservice.Table;


public interface UserControllerService {
	/**
	 * 登录
	 * @param id
	 * @param password
	 * @return
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public int login(int id, char[] password)throws RemoteException, MalformedURLException, NotBoundException;
	/**
	 * 修改密码
	 * @param old
	 * @param newPassword
	 * @return
	 * @throws RemoteException
	 */
	public boolean changePassword(char[] old, char[] newPassword) throws RemoteException;
	/**
	 * 获取个人信息
	 * @return
	 */
	public PO getInformation();
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName();
	public DatabaseFactory getFactory();
	public void reConnect();
	public BroadCastReceiverService getBroadCast() throws RemoteException, MalformedURLException, NotBoundException;

}
