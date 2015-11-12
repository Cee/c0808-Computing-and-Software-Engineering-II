package data.framedata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseutility.DataHelper;
import dataservice.framedataservice.ModuleDataService;

import po.ModulePO;
import po.PO;
/**
 * 课程模块数据服务
 * @author luck
 *
 */
public class ModuleData extends DataHelper implements ModuleDataService{
	
	
	public ModuleData(Connection conn) throws RemoteException{
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException{
		ModulePO module = (ModulePO) po;
		String sInsert = "INSERT INTO module(Module_Id,Name, Min_Credit, Max_Credit"
				+ ") VALUES (?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, module.getModule_Id());
			PS.setString(2, module.getName());
			PS.setInt(3, module.getMin_Credit());
			PS.setInt(4, module.getMax_Credit());
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}

	@Override
	public boolean delete(int id) throws RemoteException{
		String sDelete = "DELETE FROM module WHERE Module_Id=" + id;
		try {
			PS = conn.prepareStatement(sDelete);
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(PO po) throws RemoteException{
		ModulePO module = (ModulePO) po;
		String sUpdate = "update module set Name=?,Min_Credit=?, Max_Credit=?"
				+ " where Module_Id=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setString(1, module.getName());
			PS.setInt(2, module.getMin_Credit());
			PS.setInt(3, module.getMax_Credit());
			PS.setInt(4, module.getModule_Id());
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public PO find(int id) throws RemoteException{
		ModulePO po = null;
		String sSelect = "select * from module where Module_Id="+id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new ModulePO(RS.getInt(1),RS.getString(2), RS.getInt(3), RS.getInt(4));
			}
			PS.close();
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return po;
	}

	@Override
	public ArrayList<PO> find(int condition, int id) throws RemoteException{
		return null;
	}

	@Override
	public ArrayList<PO> findAll() throws RemoteException{
		ArrayList<PO> list = new ArrayList<PO>();
		String sSelect = "select * from module ";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				ModulePO po = new ModulePO(RS.getInt(1),RS.getString(2), RS.getInt(3), RS.getInt(4));
				list.add(po);
			}
			PS.close();
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return list;
	}

}
