package data.framedata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.ModulePO;
import po.PO;
import po.TypePO;
import databaseutility.DataHelper;
import dataservice.framedataservice.TypeDataService;
/**
 * 课程类别数据服务
 * @author luck
 *
 */
public class TypeData extends DataHelper implements TypeDataService {

	public TypeData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		TypePO type = (TypePO) po;
		String sInsert = "INSERT INTO type(Module_Id,name,compulsory, term_start,term_end,min_credit, max_credit,Type_Id"
				+ ") VALUES (?,?,?,?,?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, type.getModule_Id());
			PS.setString(2, type.getName());
			PS.setInt(3, type.getCompulsory());
			PS.setInt(4, type.getTerm_start());
			PS.setInt(5, type.getTerm_end());
			PS.setInt(6, type.getMin_credit());
			PS.setInt(7, type.getMax_credit());
			PS.setInt(8, type.getType_Id());
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
		String sDelete = "DELETE FROM type WHERE Type_Id=" + id;
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
		TypePO type = (TypePO) po;
		String sUpdate = "update type set Type_Id=?,Module_Id=?, name=?,compulsory=?"
				+ ",term_start=?,term_end=?,min_credit=?,max_credit=?"
				+ " where Type_Id=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, type.getType_Id());
			PS.setInt(2, type.getModule_Id());
			PS.setString(3, type.getName());
			PS.setInt(4, type.getCompulsory());
			PS.setInt(5, type.getTerm_start());
			PS.setInt(6, type.getTerm_end());
			PS.setInt(7, type.getMin_credit());
			PS.setInt(8, type.getMax_credit());
			PS.setInt(9, type.getType_Id());
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
		TypePO po = null;
		String sSelect = "select type.Type_Id,type.Module_Id, module.name as module_name"
				+ ", type.name,type.compulsory,type.term_start,type.term_end,type.min_credit,type.max_credit from "
				+ "type as type inner join module as module using ( Module_Id )"
				+ "  where type.Type_Id =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new TypePO(RS.getInt(1), RS.getInt(2), RS.getString(3),
						RS.getString(4), RS.getInt(5), RS.getInt(6),
						RS.getInt(7), RS.getInt(8), RS.getInt(9));
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
	public ArrayList<PO> find(int condition, int id) throws RemoteException {
		ArrayList<PO> list = new ArrayList<PO>();
		String sSelect = "select type.Type_Id,type.Module_Id, module.name as module_name"
				+ ", type.name,type.compulsory,type.term_start,type.term_end,type.min_credit,type.max_credit from "
				+ "type as type inner join module as module using ( Module_Id )"
				+ "  where type.Module_Id =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				PO po  = new TypePO(RS.getInt(1), RS.getInt(2), RS.getString(3),
						RS.getString(4), RS.getInt(5), RS.getInt(6),
						RS.getInt(7), RS.getInt(8), RS.getInt(9));
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

	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		ArrayList<PO> list = new ArrayList<PO>();
		String sSelect = "select type.Type_Id,type.Module_Id, module.name as module_name"
				+ ", type.name,type.compulsory,type.term_start,type.term_end,type.min_credit,type.max_credit from "
				+ "type as type inner join module as module using ( Module_Id )";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				PO po  = new TypePO(RS.getInt(1), RS.getInt(2), RS.getString(3),
						RS.getString(4), RS.getInt(5), RS.getInt(6),
						RS.getInt(7), RS.getInt(8), RS.getInt(9));
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
