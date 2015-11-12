package dataservice.framedataservice;

import java.util.ArrayList;

import po.PO;
import po.TypePO;
import dataservice.framedataservice.TypeDataService;

/**
 * 
 * @author Cee
 * @date 13.10.17
 * @version 1.0 课程类别桩测试
 */
public class TypeData_Stub implements TypeDataService {

	@Override
	public boolean insert(PO po) {
		System.out.println("成功添加一个课程类别 From TypeData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除一个课程类别 From TypeData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新一个课程类别 From TypeData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("成功找到一个课程类别 From TypeData");
		return new TypePO(id, 1, "通识教育课程", "通识通修课程", 3, 1, 8, 14, 14);
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		System.out.println("成功找到符合条件的课程类别 From TypeData");
		return null;
	}

	@Override
	public ArrayList<PO> findAll() {
		ArrayList<PO> list = new ArrayList<>();
		list.add(new TypePO(1, 1, "通识教育课程", "通识通修课程", 3, 1, 8, 14, 14));
		list.add(new TypePO(2, 1, "军事政治理论课程", "通识通修课程", 1, 1, 6, 16, 16));
		list.add(new TypePO(3, 1, "军事课程", "通识通修课程", 1, 1, 6, 3, 3));
		list.add(new TypePO(3, 1, "军事课程", "通识通修课程", 1, 1, 6, 3, 3));

		return list;
	}

}
