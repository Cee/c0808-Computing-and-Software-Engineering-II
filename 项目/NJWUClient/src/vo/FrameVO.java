package vo;

import java.util.ArrayList;

import po.LessonAbstractPO;
import po.ModulePO;
import po.TypePO;

public class FrameVO extends VO {
	ArrayList<ModuleVO> moduleList = new ArrayList<>() ;
	ArrayList<TypeVO> typeList = new ArrayList<>();
	ArrayList<LessonAbstractVO> lessonList = new ArrayList<>();

	public FrameVO(ArrayList<ModulePO> moduleList, ArrayList<TypePO> typeList,
			ArrayList<LessonAbstractPO> lessonList) {
		for (ModulePO module :moduleList){
			this.moduleList.add(new ModuleVO(module));
		}
		for (TypePO type: typeList){
			this.typeList.add(new TypeVO(type));
		}
		for (LessonAbstractPO lesson:lessonList){
			this.lessonList.add(new LessonAbstractVO(lesson));
		}
	}
	public ArrayList<LessonAbstractVO> getLessonList() {
		return lessonList;
	}
	public ArrayList<ModuleVO> getModuleList() {
		return moduleList;
	}
	public ArrayList<TypeVO> getTypeList() {
		return typeList;
	}
	
	
	public String toString() {
		String frame = "";
		for (ModuleVO po : moduleList) {
			char sequence = (char) (po.getModule_Id() + 'A' - 1);
			frame = frame + sequence + " " + po.getName() + "\n";
			for (TypeVO typePO : typeList) {
				if (typePO.getModule_Id() == po.getModule_Id()) {
					frame = frame + "	" + typePO.getType_Id() + " "
							+ typePO.getName() + "\n";
					for (LessonAbstractVO lesson : lessonList) {
						if (typePO.getType_Id() != 1
								&& lesson.getType_Id() == typePO.getType_Id()) {
							frame = frame + "		" + lesson.getName() + "\n";
						}
					}
					frame = frame + "\n";
				}
			}
			frame = frame + "\n";
		}
		return frame;
	}
}
