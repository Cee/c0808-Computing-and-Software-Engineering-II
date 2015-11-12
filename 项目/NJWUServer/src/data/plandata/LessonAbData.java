package data.plandata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.LessonAbstractPO;
import po.PO;
import po.StudentPO;
import databaseutility.DataHelper;
import dataservice.plandataservice.LessonAbDataService;
/**
 * 抽象课程数据服务
 * @author luck
 *
 */
public class LessonAbData extends DataHelper implements LessonAbDataService {

	public LessonAbData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		LessonAbstractPO lesson = (LessonAbstractPO) po;
		String sInsert = "INSERT INTO lesson_abstract(Ins_Id, Les_Id_Ab,"
				+ " Type_Id, name, min_credit,max_credit,term_start,term_end) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, lesson.getIns_Id());
			PS.setInt(2, lesson.getLes_Id_Ab());
			PS.setInt(3, lesson.getType_Id());
			PS.setString(4, lesson.getName());
			PS.setInt(5, lesson.getMin_credit());
			PS.setInt(6, lesson.getMax_credit());
			PS.setInt(7, lesson.getTerm_start());
			PS.setInt(8, lesson.getTerm_end());
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
		String sDelete = "DELETE FROM lesson_abstract WHERE Les_Id_Ab=" + id;
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
		LessonAbstractPO lesson = (LessonAbstractPO) po;
		String sUpdate = "UPDATE lesson_abstract SET Ins_Id=?,Les_Id_Ab=?,Type_Id=?,"
				+ "name=?,min_credit=?,max_credit=?,term_start=?,term_end=? WHERE Les_Id_Ab=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, lesson.getIns_Id());
			PS.setInt(2, lesson.getLes_Id_Ab());
			PS.setInt(3, lesson.getType_Id());
			PS.setString(4, lesson.getName());
			PS.setInt(5, lesson.getMin_credit());
			PS.setInt(6, lesson.getMax_credit());
			PS.setInt(7, lesson.getTerm_start());
			PS.setInt(8, lesson.getTerm_end());
			PS.setInt(9, lesson.getLes_Id_Ab());
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
		LessonAbstractPO po = null;
		String sSelect = "select les.Ins_Id,ins.name As ins_name,les.Les_Id_Ab,les.Type_Id, type.name as type_name, les.name, "
				+ "les.min_credit,les.max_credit,les.term_start,les.term_end ,type.Module_Id as module_id,type.compulsory,module.name as module_name from "
				+ "lesson_abstract as les inner join institute as ins using ( Ins_Id ) inner join type as type using(Type_Id) inner join module as module using(module_id)"
				+ "  where les.Les_Id_Ab =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new LessonAbstractPO(RS.getInt(1), RS.getString(2),
						RS.getInt(3), RS.getInt(4), RS.getString(5),
						RS.getString(6), RS.getInt(7), RS.getInt(8),
						RS.getInt(9), RS.getInt(10), RS.getInt(11),
						RS.getInt(12), RS.getString(13));
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
		String sSelect;
		String type;
		if (condition == 1) {
			type = "Ins_Id";
		} else {
			type = "Type_Id";
		}
		sSelect = "select les.Ins_Id,ins.name As ins_name,les.Les_Id_Ab,les.Type_Id, type.name as type_name, les.name, "
				+ "les.min_credit,les.max_credit,les.term_start,les.term_end ,type.Module_Id as module_id,type.compulsory ,module.name as module_name from "
				+ "lesson_abstract as les inner join institute as ins using ( Ins_Id ) inner join type as type using(Type_Id) inner join module as module using(module_id)"
				+ "  where " + type + "=" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				PO po = new LessonAbstractPO(RS.getInt(1), RS.getString(2),
						RS.getInt(3), RS.getInt(4), RS.getString(5),
						RS.getString(6), RS.getInt(7), RS.getInt(8),
						RS.getInt(9), RS.getInt(10), RS.getInt(11),
						RS.getInt(12), RS.getString(13));
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
	public ArrayList<PO> findAll() {
		return null;
	}

}
