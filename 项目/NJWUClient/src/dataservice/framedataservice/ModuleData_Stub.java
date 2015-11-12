package dataservice.framedataservice;

import java.util.ArrayList;

import po.ModulePO;
import po.PO;

/**
 * 
 * @author Cee
 * @date 13.10.17
 * @version 1.0 模块数据桩测试
 */
public class ModuleData_Stub implements ModuleDataService {

	@Override
	public boolean insert(PO po) {
		System.out.println("成功添加一个模块 From ModuleData");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("成功删除一个模块 From ModuleData");
		return true;
	}

	@Override
	public boolean update(PO po) {
		System.out.println("成功更新一个模块 From ModuleData");
		return true;
	}

	@Override
	public PO find(int id) {
		System.out.println("查找到一个模块 From ModuleData");
		return new ModulePO(id, "通识通修课程", 52, 56);
	}

	@Override
	public ArrayList<PO> find(int condition, int id) {
		return null;
	}

	@Override
	public ArrayList<PO> findAll() {
		System.out.println("查找到所有模块 From ModuleData");
		ArrayList<PO> list = new ArrayList<>();
		list.add(new ModulePO(1, "通识通修课程", 52, 56));
		list.add(new ModulePO(2, "学科专业课程", 38, 45));
		list.add(new ModulePO(3, "开放选修课程", 31, 52));
		return list;
	}

}
