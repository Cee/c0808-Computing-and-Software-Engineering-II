package data.userdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.PO;
import po.StudentPO;
import databaseutility.DataHelper;
import dataservice.userdataservice.StudentDataService;
/**
 * 学生信息数据服务
 * @author luck
 *
 */
public class StudentData extends DataHelper implements StudentDataService {
	public StudentData(Connection conn) throws RemoteException{
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException{
		StudentPO student = (StudentPO) po;
		String password = String.valueOf(student.getPassword());
		String sInsert = "INSERT INTO student(Stu_Id, Ins_Id, name," +
				" gender, grade, password) VALUES (?,?,?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, student.getStu_Id());
			PS.setInt(2, student.getIns_Id());
			PS.setString(3, student.getName());
			PS.setString(4, student.getGender());
			PS.setInt(5, student.getGrade());
			PS.setString(6, password);
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
		String sDelete = "DELETE FROM student WHERE Stu_Id="+id;
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
		StudentPO student = (StudentPO) po;
		String password = String.valueOf(student.getPassword());
		String sUpdate = "UPDATE student SET Stu_Id=?,Ins_Id=?,name=?,"
				+ "gender=?,grade=?,password=? WHERE Stu_Id=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, student.getStu_Id());
			PS.setInt(2, student.getIns_Id());
			PS.setString(3, student.getName());
			PS.setString(4, student.getGender());
			PS.setInt(5, student.getGrade());
			PS.setString(6, password);
			PS.setInt(7, student.getStu_Id());
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
		StudentPO po = null;
		String sSelect = "select stu.name,stu.password, stu.Ins_Id, ins.name "
				+ "AS ins_name,stu.gender,stu.grade from "
				+ "student as stu inner join institute as ins using ( Ins_Id )"
				+ "  where stu.Stu_Id =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new StudentPO(id, RS.getString(1), RS.getString(2)
						.toCharArray(), RS.getInt(3), RS.getString(4),
						RS.getString(5), RS.getInt(6));
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
	public ArrayList<PO> find(int Ins_Id, int grade) throws RemoteException{
		ArrayList<PO> list = new ArrayList<PO>();
		String sSelect = "select stu.Stu_Id,stu.name,stu.password, stu.Ins_Id, ins.name "
				+ "AS ins_name,stu.gender,stu.grade from "
				+ "student as stu inner join institute as ins using ( Ins_Id )"
				+ "  where stu.Ins_Id =" +Ins_Id+" and stu.grade="+grade ;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				StudentPO po = new StudentPO(RS.getInt(1), RS.getString(2), RS.getString(3)
						.toCharArray(), RS.getInt(4), RS.getString(5),
						RS.getString(6), RS.getInt(7));
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
