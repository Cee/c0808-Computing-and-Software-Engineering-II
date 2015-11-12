package businesslogic.schteacherbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DatabaseService;
import po.LessonAbstractPO;
import po.ModulePO;
import po.TypePO;
import vo.FrameVO;
/**
 * 协助学校教务老师进行教学框架的编写
 * @author luck
 *
 */
public class FrameEditor {
	DatabaseService typeData;
	DatabaseService moduleData;
	DatabaseService LessonAbData;
	ArrayList<TypePO> typeList;
	ArrayList<ModulePO> moduleList;
	ArrayList<LessonAbstractPO> lessonAbList;
	
	public FrameEditor(DatabaseService typeData, DatabaseService moduleData,
			DatabaseService lessonAbData) {
		this.typeData = typeData;
		this.moduleData = moduleData;
		this.LessonAbData = lessonAbData;
	}

	/**
	 * 增加一门抽象课程
	 * 返回是否添加成功
	 * @param lesson
	 * @return
	 * @throws RemoteException
	 */
	public boolean addLesson(LessonAbstractPO lesson) throws RemoteException {
		lessonAbList.add(lesson);
		return LessonAbData.insert(lesson);
	}

	/**
	 * 增加一个课程类别
	 * 返回是否添加成功
	 * @param typePO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addType(TypePO typePO) throws RemoteException {
		typeList.add(typePO);
		return typeData.insert(typePO);
	}

	/**
	 * 增加一个课程模块
	 * 返回是否添加成功
	 * @param modulePO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addModule(ModulePO modulePO) throws RemoteException {
		moduleList.add(modulePO);
		return moduleData.insert(modulePO);
	}

	/**
	 * 修改一门抽象课程
	 * 返回是否添加成功
	 * @param lesson_abstractPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyLesson(LessonAbstractPO lesson_abstractPO)
			throws RemoteException {
		for (LessonAbstractPO po : lessonAbList) {
			if (po.getLes_Id_Ab() == lesson_abstractPO.getLes_Id_Ab()) {
				po = lesson_abstractPO;

				return LessonAbData.update(lesson_abstractPO);
			}
		}
		return false;

	}

	/**
	 * 修改一个课程类别
	 * 返回是否修改成功
	 * @param typePO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyType(TypePO typePO) throws RemoteException {
		for (TypePO po : typeList) {
			if (po.getType_Id() == typePO.getType_Id()) {
				po = typePO;
				return typeData.update(typePO);
			}
		}
		return false;

	}

	/**
	 * 修改一个课程模块
	 * 返回是否修改成功
	 * @param modulePO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyModule(ModulePO modulePO) throws RemoteException {
		for (ModulePO po : moduleList) {
			if (po.getModule_Id() == modulePO.getModule_Id()) {
				po = modulePO;
				return moduleData.update(modulePO);
			}
		}
		return false;
	}

	/**
	 * 删除一个课程类别
	 * 返回是否删除成功
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteType(int id) throws RemoteException {
		for (TypePO po : typeList) {
			if (po.getType_Id() == id) {
				typeList.remove(po);
				return typeData.delete(id);
			}
		}
		return false;
	}

	/**
	 * 删除一个课程模块
	 * 返回是否删除成功
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteModule(int id) throws RemoteException {
		for (ModulePO po : moduleList) {
			if (po.getModule_Id() == id) {
				moduleList.remove(po);
				return moduleData.delete(id);
			}
		}
		return false;
	}

	
	/**
	 * 删除一门抽象课程
	 * 返回是否删除成功
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteLesson(int id) throws RemoteException {
		for (LessonAbstractPO po : lessonAbList) {
			if (po.getLes_Id_Ab() == id) {
				lessonAbList.remove(po);
				return LessonAbData.delete(id);
			}
		}
		return false;
	}

	
	public FrameVO getFrame() {
		return new FrameVO(moduleList, typeList, lessonAbList);
	}

	public void setLessonAbList(ArrayList<LessonAbstractPO> lessonAbList) {
		this.lessonAbList = lessonAbList;
	}

	public void setModuleList(ArrayList<ModulePO> moduleList) {
		this.moduleList = moduleList;
	}

	public void setTypeList(ArrayList<TypePO> typeList) {
		this.typeList = typeList;
	}
}
