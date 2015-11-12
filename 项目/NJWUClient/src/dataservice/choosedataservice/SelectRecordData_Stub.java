package dataservice.choosedataservice;

import java.util.ArrayList;

import po.PO;
import po.SelectRecordPO;

/**
 * 
 * @author Cee
 * @date 13.10.17
 * @version 1.0 选课记录数据桩测试
 */
public class SelectRecordData_Stub implements SelectRecordDataService{

	@Override
	public boolean insert(PO po) {
		System.out.println("成功插入一条选课记录 From SelectRecordData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除一条选课记录 From SelectRecordData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新一条选课记录 From SelectRecordData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("找到一条选课记录 From SelectRecordData");
		return new SelectRecordPO(2 , 121250002 , 10 , 1);
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("找到符合条件选课记录 From SelectRecordData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new SelectRecordPO(2 , 121250002 , 10 , 1));
		list.add(new SelectRecordPO(1 , 121250001 , 10 , 1));
		return list;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("找到所有的选课记录 From SelectRecordData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new SelectRecordPO(2 , 121250002 , 10 , 1));
		list.add(new SelectRecordPO(1 , 121250001 , 10 , 1));
		return list;
	}

 }
