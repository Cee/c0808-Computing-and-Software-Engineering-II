
package data.lessonrecorddata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.LessonRecordPO;
import po.PO;
import databaseutility.DataHelper;
import dataservice.lessonrecorddataservice.LessonRecordDataService;
/**
 * 课程记录数据服务
 * @author luck
 *
 */
public class LessonRecordData extends DataHelper implements
		LessonRecordDataService {

	public LessonRecordData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		LessonRecordPO lesson = (LessonRecordPO) po;
		String sInsert = "INSERT INTO lesson_record(Les_Id, Stu_Id, score,"
				+ " Les_name, Stu_name) VALUES (?,?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setInt(1, lesson.getLes_Id());
			PS.setInt(2, lesson.getStu_Id());
			PS.setInt(3, lesson.getScore());
			PS.setString(4, lesson.getLes_name());
			PS.setString(5, lesson.getStu_name());
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
		String sDelete = "DELETE FROM lesson_record WHERE id=" + id;
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
		LessonRecordPO lesson = (LessonRecordPO) po;
		String sUpdate = "UPDATE lesson_record SET id=?, Les_Id=?, Stu_Id=?, score=?,"
				+ " Les_name=?, Stu_name=? WHERE id=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, lesson.getId());
			PS.setInt(2, lesson.getLes_Id());
			PS.setInt(3, lesson.getStu_Id());
			PS.setInt(4, lesson.getScore());
			PS.setString(5, lesson.getLes_name());
			PS.setString(6, lesson.getStu_name());
			PS.setInt(7, lesson.getId());
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
		LessonRecordPO po = null;
		String sSelect = "select les.id, les.Les_Id, les.Stu_Id,"
				+ "les.score, les.Les_Name, les.Stu_Name "
				+ "from lesson_record as les where les.id =" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new LessonRecordPO(RS.getInt(1), RS.getInt(2), RS.getInt(3),
						RS.getInt(4), RS.getString(5), RS.getString(6));
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
		String type = null;
		switch (condition) {
		case 1:
			type = "Stu_Id";
			break;
		case 2:
			type = "Les_Id";
			break;
		default:
			return null;
		}
		sSelect = "select les.id, les.Les_Id, les.Stu_Id,"
				+ "les.score, les.Les_Name, les.Stu_Name "
				+ "from lesson_record as les where " + type + "=" + id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				PO po = new LessonRecordPO(RS.getInt(1), RS.getInt(2),
						RS.getInt(3), RS.getInt(4), RS.getString(5),
						RS.getString(6));
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
		String sSelect;
		sSelect = "select les.id, les.Les_Id, les.Stu_Id,"
				+ "les.score, les.Les_Name, les.Stu_Name "
				+ "from lesson_record as les";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				PO po = new LessonRecordPO(RS.getInt(1), RS.getInt(2),
						RS.getInt(3), RS.getInt(4), RS.getString(5),
						RS.getString(6));
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
