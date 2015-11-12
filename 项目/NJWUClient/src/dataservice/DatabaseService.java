package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PO;

/**
 * 
 * @author luck
 * @version 1.0
 * @data 13.10.15 数据库基本服务接口
 */
public interface DatabaseService extends Remote {
	/**
	 * 
	 * @param po
	 * @return 是否成功插入，若为true 则成功 否则为false
	 */
	public boolean insert(PO po) throws RemoteException;

	/**
	 * 
	 * @param id
	 * @return 是否成功删除，若为true 则成功 否则为false
	 */
	public boolean delete(int id) throws RemoteException;

	/**
	 * 
	 * @param po
	 * @return 是否成功更新，若为true 则成功 否则为false
	 */
	public boolean update(PO po) throws RemoteException;

	/**
	 * 
	 * @param id
	 * @return 是否找到 若为null 则代表未找到
	 */
	public PO find(int id) throws RemoteException;

	/**
	 * 
	 * @param condition
	 * @param id
	 * @return 符合该条件的所有PO
	 */
	public ArrayList<PO> find(int condition, int id) throws RemoteException;

	public ArrayList<PO> findAll() throws RemoteException;
}
