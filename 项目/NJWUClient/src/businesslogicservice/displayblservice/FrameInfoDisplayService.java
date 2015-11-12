package businesslogicservice.displayblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ModulePO;
import po.TypePO;

/**
 * 
 * @author luck
 * @version 1.0
 * @date 13.10.18 提供有关教学框架显示的服务
 * 
 */
public interface FrameInfoDisplayService {
	/**
	 * 根据id获取TypePO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TypePO getType(int id) throws RemoteException;

	/**
	 * 获取所有课程类别
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TypePO> getType()throws RemoteException;

	/**
	 * 根据id获取模块
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ModulePO getModule(int id)throws RemoteException;

	/**
	 * 获取所有模块
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ModulePO> getModule()throws RemoteException;
}
