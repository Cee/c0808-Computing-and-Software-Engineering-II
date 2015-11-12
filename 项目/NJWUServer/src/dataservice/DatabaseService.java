package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PO;
/**
 * 
 * @author luck
 * @version 1.0
 * @data 13.10.15
 * 数据库基本服务接口
 */
public interface DatabaseService extends Remote{
	/**
	 * 增加
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(PO po) throws RemoteException;
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(int id)throws RemoteException;
	/**
	 * 更新
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(PO po)throws RemoteException;
	/**
	 * 查找
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public PO find(int id)throws RemoteException;
	/*
	 * 条件查找
	 */
	public ArrayList<PO> find(int condition, int id)throws RemoteException;	
	/**
	 * 查找全部
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PO> findAll()throws RemoteException;
}
