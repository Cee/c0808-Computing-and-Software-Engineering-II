package data.institutedata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import po.InstitutePO;
import po.ModulePO;
import po.PO;
import databaseutility.DataHelper;
import dataservice.institutedataservice.InstituteDataService;
/**
 * 院系类别数据服务
 * @author luck
 *
 */
public class InstituteData extends DataHelper implements InstituteDataService{

	public InstituteData(Connection conn) throws RemoteException {
		super(conn);
	}

	@Override
	public boolean insert(PO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(PO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public PO find(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<PO> find(int condition, int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		ArrayList<PO> list = new ArrayList<PO>();
		String sSelect = "select * from institute ";
		try {
			PS = conn.prepareStatement(sSelect);
			RS = PS.executeQuery();
			while (RS.next()) {
				InstitutePO po = new InstitutePO(RS.getInt(1), RS.getString(2));
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
