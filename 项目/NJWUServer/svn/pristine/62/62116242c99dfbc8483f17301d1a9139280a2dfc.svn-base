package data.userdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.PO;
import po.StudentPO;
import po.TeacherPO;
import databaseutility.DataHelper;
import dataservice.userdataservice.TeacherDataService;
/**
 * 教师信息数据服务
 * @author luck
 *
 */
public class TeacherData extends DataHelper implements TeacherDataService {

	public TeacherData(Connection conn) throws RemoteException{
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException{
		TeacherPO teacher = (TeacherPO) po;
		String password = String.valueOf(teacher.getPassword());
		String sInsert = "INSERT INTO teacher(Tea_ID, Ins_Id, name,gender,"
				+ " password, type) VALUES (?,?,?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, teacher.getTea_Id());
			PS.setInt(2, teacher.getIns_Id());
			PS.setString(3, teacher.getName());
			PS.setString(4,teacher.getGender());
			PS.setString(5, password);
			PS.setInt(6, teacher.getType());
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
		String sUpdate = "DELETE FROM teacher WHERE Tea_Id=" + id;
		try {
			PS = conn.prepareStatement(sUpdate);
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
		TeacherPO teacher = (TeacherPO) po;
		String password = String.valueOf(teacher.getPassword());
		String sUpdate = "UPDATE teacher SET Tea_Id=?,Ins_Id=?,name=?,gender=?,"
				+ "password=?,type=? WHERE Tea_Id=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, teacher.getTea_Id());
			PS.setInt(2, teacher.getIns_Id());
			PS.setString(3, teacher.getName());
			PS.setString(4, teacher.getGender());
			PS.setString(5, password);
			PS.setInt(6, teacher.getType());
			PS.setInt(7, teacher.getTea_Id());
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
		TeacherPO po = null;
		String sSelect = "select tea.name,tea.password, tea.Ins_Id,tea.type, ins.name "
				+ "AS ins_name,tea.gender from "
				+ "teacher as tea inner join institute as ins using ( Ins_Id )"
				+ "  where tea.Tea_Id =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new TeacherPO(id, RS.getInt(3), RS.getString(1), RS
						.getString(2).toCharArray(), RS.getString(5),
						RS.getInt(4),RS.getString(6));
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
	public ArrayList<PO> find(int condition, int Ins_id) throws RemoteException{
		ArrayList<PO> list = new ArrayList<PO>();
		String sSelect = "select tea.name,tea.password, tea.Tea_Id,tea.type, ins.name "
				+ "AS ins_name,tea.gender from "
				+ "teacher as tea inner join institute as ins using ( Ins_Id )"
				+ "  where tea.Ins_Id =" + Ins_id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				TeacherPO po = new TeacherPO(RS.getInt(3), Ins_id, RS.getString(1), RS
						.getString(2).toCharArray(), RS.getString(5),
						RS.getInt(4),RS.getString(6));
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
	public ArrayList<PO> findAll() throws RemoteException{
		return null;
	}

}
