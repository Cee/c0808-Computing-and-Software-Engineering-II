package vo;

import po.TypePO;

public class TypeVO extends VO {
	private int Type_Id; // 类型编号
	private int Module_Id; // 所属模块编号
	private String module_name; // 所属模块名称
	private String name; // 类型名称
	private int compulsory; // 是否必修
	private int term_start; // 开始的学期
	private int term_end; // 结束的学期
	private int min_credit; // 建议最低学分
	private int max_credit; // 建议最高学分

	public String getCompulsoryString() {
		return VO.judgeCompulsory(compulsory);
	}

	public String getTermString() {
		return VO.judgeTerm(term_start, term_end);
	}

	public String getCredit() {
		return VO.judgeCredit(max_credit, min_credit);
	}

	public TypeVO(int Type_Id, int Module_Id, String module_name, String name,
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

	public TypeVO(TypePO po) {
		if (po != null) {
			this.compulsory = po.getCompulsory();
			this.max_credit = po.getMax_credit();
			this.min_credit = po.getMin_credit();
			this.Module_Id = po.getModule_Id();
			this.module_name = po.getModule_name();
			this.name = po.getName();
			this.term_end = po.getTerm_end();
			this.term_start = po.getTerm_start();
			this.Type_Id = po.getType_Id();
		}
	}

	public int getType_Id() {
		return Type_Id;
	}

	public int getModule_Id() {
		return Module_Id;
	}

	public String getModule_name() {
		return module_name;
	}

	public String getName() {
		return name;
	}

	public int getCompulsory() {
		return compulsory;
	}

	public int getTerm_start() {
		return term_start;
	}

	public int getTerm_end() {
		return term_end;
	}

	public int getMin_credit() {
		return min_credit;
	}

	public int getMax_credit() {
		return max_credit;
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

	public String toString() {
		return Type_Id + " " + name;
	}

}
