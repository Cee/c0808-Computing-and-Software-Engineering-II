package data.systemdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.PO;
import po.SystemState;
import databaseutility.DataHelper;
import dataservice.systemdataservice.SystemDataService;
/**
 * 系统状态数据服务
 * @author luck
 *
 */
public class SystemData extends DataHelper implements SystemDataService{

	public SystemData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		return false;
	}

	@Override
	public boolean update(PO po) throws RemoteException {
		SystemState state = (SystemState) po;
		String sUpdate = "update system SET bySelect=?,canSelect=? "
				+ "where id =0";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, state.getByselect());
			PS.setInt(2, state.getSelect());
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public PO find(int id) throws RemoteException {
		SystemState state = null;
		String sSelect = "select canSelect, bySelect, plan from system where id = 0";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				state = new SystemState(RS.getInt(1), RS.getInt(2), RS.getInt(3));
			}
			PS.close();
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return state;
	}

	@Override
	public ArrayList<PO> find(int condition, int id) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		return null;
	}

}
