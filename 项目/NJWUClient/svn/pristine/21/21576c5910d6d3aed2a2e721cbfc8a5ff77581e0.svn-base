package po;

/**
 * 
 * @author Xc
 * @date 13.10.16
 * @version 课程类型持久化对象
 */
public class TypePO extends PO {
	private int Type_Id; // 类型编号
	private int Module_Id; // 所属模块编号
	private String module_name; // 所属模块名称
	private String name; // 类型名称
	private int compulsory; // 是否必修
	private int term_start; // 开始的学期
	private int term_end; // 结束的学期
	private int min_credit; // 建议最低学分
	private int max_credit; // 建议最高学分

	public TypePO(int Type_Id, int Module_Id, String module_name, String name,
			int compulsory, int term_start, int term_end, int min_credit,
			int max_credit) {
		this.compulsory = compulsory;
		this.max_credit = max_credit;
		this.min_credit = min_credit;
		this.Module_Id = Module_Id;
		this.module_name = module_name;
		this.name = name;
		this.term_end = term_end;
		this.term_start = term_start;
		this.Type_Id = Type_Id;

	}

	public String info() {
		String com = null;
		String credit;
		String term;
		if (compulsory == 1)
			com = "必修";
		else if (compulsory == 2)
			com = "指选";
		else
			com = "选修";

		if (max_credit == min_credit)
			credit = max_credit + "";
		else
			credit = min_credit + "-" + max_credit;

		if (term_start == term_end)
			term = term_start + " ";
		else
			term = term_start + "-" + term_end;
		char module = (char) ('A' + Module_Id - 1);
		return module + " " + module_name + " " + Type_Id + " " + name + " "
				+ com + " " + credit + " " + term;
	}

	/**
	 * @return the max_credit
	 */
	public int getMax_credit() {
		return max_credit;
	}

	/**
	 * @return the min_credit
	 */
	public int getMin_credit() {
		return min_credit;
	}

	public void setType_Id(int type_Id) {
		Type_Id = type_Id;
	}

	public void setModule_Id(int module_Id) {
		Module_Id = module_Id;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompulsory(int compulsory) {
		this.compulsory = compulsory;
	}

	public void setTerm_start(int term_start) {
		this.term_start = term_start;
	}

	public void setTerm_end(int term_end) {
		this.term_end = term_end;
	}

	public void setMin_credit(int min_credit) {
		this.min_credit = min_credit;
	}

	public void setMax_credit(int max_credit) {
		this.max_credit = max_credit;
	}

	/**
	 * @return the term_start
	 */
	public int getTerm_start() {
		return term_start;
	}

	/**
	 * @return the compulsory
	 */
	public int getCompulsory() {
		return compulsory;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the module_Id
	 */
	public int getModule_Id() {
		return Module_Id;
	}

	/**
	 * @return the type_Id
	 */
	public int getType_Id() {
		return Type_Id;
	}

	/**
	 * @return the term_end
	 */
	public int getTerm_end() {
		return term_end;
	}

	/**
	 * @return the module_name
	 */
	public String getModule_name() {
		return module_name;
	}

}
