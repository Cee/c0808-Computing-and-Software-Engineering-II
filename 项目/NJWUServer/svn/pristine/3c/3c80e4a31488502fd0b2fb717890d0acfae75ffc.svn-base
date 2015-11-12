package po;

/**
 * 
 * @author Xc
 * @date 13.10.16
 * @version 1.0 课程模块持久化对象
 */
public class ModulePO extends PO {

	private int Module_Id; // 模块编号
	private String Name; // 模块名称
	private int Min_Credit; // 建议最低学分
	private int Max_Credit; // 建议最高学分

	public ModulePO(int Module_Id, String Name, int Min_Credit, int Max_Credit) {
		this.Module_Id = Module_Id;
		this.Name = Name;
		this.Min_Credit = Min_Credit;
		this.Max_Credit = Max_Credit;
	}

	public String info() {
		return Module_Id + ":" + Name + " 学分范围：" + Min_Credit + "--"
				+ Max_Credit;
	}

	public int getModule_Id() {
		return Module_Id;
	}

	public String getName() {
		return Name;
	}

	public int getMin_Credit() {
		return Min_Credit;
	}

	public int getMax_Credit() {
		return Max_Credit;
	}

	public void setModule_Id(int module_Id) {
		Module_Id = module_Id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setMin_Credit(int min_Credit) {
		Min_Credit = min_Credit;
	}

	public void setMax_Credit(int max_Credit) {
		Max_Credit = max_Credit;
	}

}
