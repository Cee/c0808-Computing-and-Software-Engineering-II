package businesslogic.displaybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ModulePO;
import po.PO;
import po.TypePO;
import businesslogicservice.displayblservice.FrameInfoDisplayService;
import dataservice.DatabaseService;

/**
 * 
 * @author NorviNS松鼠
 * @version 1.0
 * @date 13.11.8 教学框架展示接口实现
 */
public class FrameInfoDisplay implements FrameInfoDisplayService {
	/**
	 * 模块数据服务
	 */
	DatabaseService ModuleData;
	/**
	 * 课程类别数据服务
	 */
	DatabaseService typeData;

	/**
	 * 与依赖者共享的数据服务
	 * @param ModuleData
	 * @param typeData
	 */
	public FrameInfoDisplay(DatabaseService ModuleData, DatabaseService typeData) {
		this.ModuleData = ModuleData;
		this.typeData = typeData;
	}

	@Override
	public TypePO getType(int id) throws RemoteException {
		return (TypePO) typeData.find(id);
	}

	@Override
	public ArrayList<TypePO> getType() throws RemoteException {
		ArrayList<TypePO> tList = new ArrayList<TypePO>();
		ArrayList<PO> list = typeData.findAll();
		for (PO po : list) {
			tList.add((TypePO) po);
		}
		return tList;
	}

	@Override
	public ModulePO getModule(int id) throws RemoteException {

		return (ModulePO) ModuleData.find(id);
	}

	@Override
	public ArrayList<ModulePO> getModule() throws RemoteException {
		ArrayList<ModulePO> mList = new ArrayList<ModulePO>();

		ArrayList<PO> list = ModuleData.findAll();
		for (PO po : list) {
			mList.add((ModulePO) po);
		}
		return mList;
	}

}
