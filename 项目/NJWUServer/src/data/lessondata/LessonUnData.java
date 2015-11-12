package data.lessondata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.LessonUniquePO;
import po.PO;
import databaseutility.DataHelper;
import dataservice.lessondataservice.LessonUnDataService;
/**
 * 具体课程数据服务
 * @author luck
 *
 */
public class LessonUnData extends DataHelper implements LessonUnDataService {
	public LessonUnData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		LessonUniquePO lesson = (LessonUniquePO) po;
		String sInsert = "INSERT INTO lesson_unique(" + "location" + ",term"
				+ ",max_stu_num" + ",cur_stu_num" + ",state," + "Tea_Id,"
				+ "Ins_Id," + "day," + "start," + "end," + "book,"
				+ "introduction," + "outline," + "Les_name," + "Les_Id_Ab,"
				+ "credit)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PS = conn.prepareStatement(sInsert);
			PS.setString(1, lesson.getLocation());
			PS.setInt(2, lesson.getTerm());
			PS.setInt(3, lesson.getMax_stu_num());
			PS.setInt(4, lesson.getCur_stu_num());
			PS.setInt(5, lesson.getState());
			PS.setInt(6, lesson.getTea_Id());
			PS.setInt(7, lesson.getIns_Id());
			PS.setInt(8, lesson.getDay());
			PS.setInt(9, lesson.getStart());
			PS.setInt(10, lesson.getEnd());
			PS.setString(11, lesson.getBooks());
			PS.setString(12, lesson.getIntroduction());
			PS.setString(13, lesson.getOutline());
			PS.setString(14, lesson.getLes_name());
			PS.setInt(15, lesson.getLes_Id_Ab());
			PS.setInt(16, lesson.getCredit());
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
		String sDelete = "DELETE FROM lesson_unique WHERE Les_Id=" + id;
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
		LessonUniquePO lesson = (LessonUniquePO) po;
		String sUpdate = "UPDATE lesson_unique SET " + "Les_Id=?,"
				+ "location=?," + "term=?," + "max_stu_num=?,"
				+ "cur_stu_num=?," + "state=?," + "Tea_Id=?," + "Ins_Id=?,"
				+ "day=?," + "start=?," + "end=?," + "book=?,"
				+ "introduction=?," + "outline=?," + "Les_name=?,"
				+ "Les_Id_Ab=?," + "credit=?" + " WHERE Les_Id=?";
		try {
			PS = conn.prepareStatement(sUpdate);
			PS.setInt(1, lesson.getLes_Id());
			PS.setString(2, lesson.getLocation());
			PS.setInt(3, lesson.getTerm());
			PS.setInt(4, lesson.getMax_stu_num());
			PS.setInt(5, lesson.getCur_stu_num());
			PS.setInt(6, lesson.getState());
			PS.setInt(7, lesson.getTea_Id());
			PS.setInt(8, lesson.getIns_Id());
			PS.setInt(9, lesson.getDay());
			PS.setInt(10, lesson.getStart());
			PS.setInt(11, lesson.getEnd());
			PS.setString(12, lesson.getBooks());
			PS.setString(13, lesson.getIntroduction());
			PS.setString(14, lesson.getOutline());
			PS.setString(15, lesson.getLes_name());
			PS.setInt(16, lesson.getLes_Id_Ab());
			PS.setInt(17, lesson.getCredit());
			PS.setInt(18, lesson.getLes_Id());
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
		LessonUniquePO po = null;
		String sSelect = "select "
				+ "les.Les_name,"
				+ "les.Les_Id, "
				+ "ins.name as ins_name, "
				+ "les.location,"
				+ "les.term,"
				+ "les.max_stu_num,"
				+ "les.cur_stu_num,"
				+ "les.state,"
				+ "les.Tea_Id,"
				+ "tea.name as tea_name,"
				+ "les.Les_Id_Ab,"
				+ "les.Ins_Id,"
				+ "les.day,"
				+ "les.start,"
				+ "les.end,"
				+ "les.introduction,"
				+ "les.book,"
				+ "les.outline,"
				+ "les.credit,"
				+"lesb.Type_Id as type_id,"
				+"type.name,"
				+ "type.compulsory "
				+ "from lesson_unique as les "
				+ "inner join institute as ins using ( Ins_Id ) inner"
				+ " join teacher as tea using(Tea_Id) inner join lesson_abstract as lesb using(Les_Id_Ab) inner join type as type using(type_id) where les.Les_Id = "
				+ id;
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				po = new LessonUniquePO(RS.getString(1), RS.getInt(2),
						RS.getString(3), RS.getString(4), RS.getInt(5),
						RS.getInt(6), RS.getInt(7), RS.getInt(8), RS.getInt(9),
						RS.getString(10), RS.getInt(11), RS.getInt(12),
						RS.getInt(13), RS.getInt(14), RS.getInt(15),
						RS.getString(16), RS.getString(17), RS.getString(18),
						RS.getInt(19), RS.getInt(22),RS.getInt(20),RS.getString(21));
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
		sSelect = "select les.Les_name,"
				+ "les.Les_Id, "
				+ "ins.name as ins_name, "
				+ "les.location,"
				+ "les.term,"
				+ "les.max_stu_num,"
				+ "les.cur_stu_num,"
				+ "les.state,"
				+ "les.Tea_Id,"
				+ "tea.name as tea_name,"
				+ "les.Les_Id_Ab,"
				+ "les.Ins_Id,"
				+ "les.day,"
				+ "les.start,"
				+ "les.end,"
				+ "les.introduction,"
				+ "les.book,"
				+ "les.outline,"
				+ "les.credit, "
				+"lesb.Type_Id as type_id,"
				+"type.name,"
				+ "type.compulsory "
				+ "from lesson_unique as les "
				+ "inner join institute as ins using ( Ins_Id ) inner"
				+ " join teacher as tea using(Tea_Id) inner join lesson_abstract as lesb using(Les_Id_Ab) inner join type as type using(type_id) where ";
		switch (condition) {
		case 1:
			sSelect = sSelect + "lesb.Type_Id=1";
			break;
		case 9:
			sSelect = sSelect + "lesb.Type_Id=9";
			break;
		case 0:
			sSelect = sSelect + "les.Tea_Id=" + id;
			break;
		case -1:
			sSelect = sSelect +"les.Ins_Id=" + id;
			break;
		default:
			sSelect = sSelect + "lesb.Type_Id="+condition+" and les.Ins_Id= " + id;
			break;
		}
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				PO po = new LessonUniquePO(RS.getString(1), RS.getInt(2),
						RS.getString(3), RS.getString(4), RS.getInt(5),
						RS.getInt(6), RS.getInt(7), RS.getInt(8), RS.getInt(9),
						RS.getString(10), RS.getInt(11), RS.getInt(12),
						RS.getInt(13), RS.getInt(14), RS.getInt(15),
						RS.getString(16), RS.getString(17), RS.getString(18),
						RS.getInt(19), RS.getInt(22),RS.getInt(20),RS.getString(21));
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
		return null;
	}

}
