package data.choosedata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.PO;
import po.SelectRecordPO;
import databaseutility.DataHelper;
import dataservice.choosedataservice.SelectRecordDataService;
/**
 * 选课记录的数据服务
 * @author luck
 *
 */
public class SelectRecordData extends DataHelper implements
		SelectRecordDataService {

	public SelectRecordData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		SelectRecordPO selectRecord = (SelectRecordPO) po;
		String sInsert = "INSERT INTO SELECT_RECORD (Stu_Id,Les_Id,Type) VALUES (?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, selectRecord.getStu_Id());
			PS.setInt(2, selectRecord.getLes_Id());
			PS.setInt(3, selectRecord.getType());
			System.out.println(sInsert);
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
		String sDelete = "DELETE FROM select_record WHERE id= " + id;
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
	public PO find(int id) throws RemoteException {
		SelectRecordPO po = null;
		String sSelect = "select * from select_record where id =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new SelectRecordPO(RS.getInt(1), RS.getInt(2), RS.getInt(3),
						RS.getInt(4));
			}
			PS.close();
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return po;
	}

	public boolean update(PO po) {
		SelectRecordPO selectRecord = (SelectRecordPO) po;
		String sInsert = "UPDATE SELECT_RECORD SET" +
				"id = ?,Stu_Id = ? ,Les_Id = ? ,Type = ?";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, selectRecord.getId());
			PS.setInt(2, selectRecord.getStu_Id());
			PS.setInt(3, selectRecord.getLes_Id());
			PS.setInt(4, selectRecord.getType());
			PS.execute();
			PS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<PO> find(int stu_id, int type) throws RemoteException {
		if (type == 0) {
			ArrayList<PO> poList = new ArrayList<PO>();
			SelectRecordPO po = null;
			String sSelect = "select * from select_record where Les_Id = "
					+ stu_id;
			try {
				PS = conn.prepareStatement(sSelect);
				RS = PS.executeQuery();
				while (RS.next()) {
					po = new SelectRecordPO(RS.getInt(1), RS.getInt(2),
							RS.getInt(3), RS.getInt(4));
					poList.add(po);
				}
				PS.close();
				RS.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return poList;
		} else {
			ArrayList<PO> poList = new ArrayList<PO>();
			SelectRecordPO po = null;
			String sSelect = "select * from select_record where Stu_Id = "
					+ stu_id + " and Type = " + type;
			try {
				PS = conn.prepareStatement(sSelect);
				RS = PS.executeQuery();
				while (RS.next()) {
					po = new SelectRecordPO(RS.getInt(1), RS.getInt(2),
							RS.getInt(3), RS.getInt(4));
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

	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		ArrayList<PO> poList = new ArrayList<PO>();
		SelectRecordPO po = null;
		String sSelect = "select * from select_record";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new SelectRecordPO(RS.getInt(1), RS.getInt(2), RS.getInt(3),
						RS.getInt(4));
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
