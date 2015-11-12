package data.broadcastdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.BroadCastPO;
import po.PO;
import databaseutility.DataHelper;
import dataservice.broadcastservice.BroadCastDataService;
/**
 * 通知的数据服务
 * @author luck
 *
 */
public class BroadCastData extends DataHelper implements BroadCastDataService{

	public BroadCastData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		BroadCastPO broadCastPO = (BroadCastPO)po;
		String sInsert = "INSERT INTO broadcast (message,date) VALUES (?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setString(1, broadCastPO.getMessage());
			PS.setString(2, broadCastPO.getDate());
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		String sDelete = "DELETE FROM broadcast WHERE id=" + id;
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
	public boolean update(PO po) throws RemoteException {
		return false;
	}

	@Override
	public PO find(int id) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PO> find(int condition, int id) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		ArrayList<PO> poList = new ArrayList<PO>();
		BroadCastPO po = null;
		String sSelect = "select * from broadcast order by id desc";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new BroadCastPO(RS.getInt(1),RS.getString(2),RS.getString(3));
				poList.add(po);
			}
			PS.close();
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return poList;
	}
}
