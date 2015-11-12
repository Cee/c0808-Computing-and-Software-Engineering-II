package po;

import vo.LessonAbstractVO;


/**
 * @aucher Xc
 * @data 13.10.15
 * @version 1.0 
 * 抽象课程持久化对象
 */

public class LessonAbstractPO extends PO {
	private int Module_Id;
	private String module_name;
	private int compulsory;
	private int Ins_Id; // 院系编号
	private String Ins_name; // 院系名称
	private int Les_Id_Ab; // 课程号
	private int Type_Id; // 所属课程类别编号
	private String Type_name; // 所属课程类别
	private String name; // 名称
	private int min_credit; // 建议学分下限
	private int max_credit; // 建议学分上限
	private int term_start; // 开始学期
	private int term_end; // 结束学期
	
	public void setModule_Id(int module_Id) {
		Module_Id = module_Id;
	}

	public void setCompulsory(int compulsory) {
		this.compulsory = compulsory;
	}

	public void setIns_Id(int ins_Id) {
		Ins_Id = ins_Id;
	}

	public void setIns_name(String ins_name) {
		Ins_name = ins_name;
	}

	public void setLes_Id_Ab(int les_Id_Ab) {
		Les_Id_Ab = les_Id_Ab;
	}

	public void setType_Id(int type_Id) {
		Type_Id = type_Id;
	}

	public void setType_name(String type_name) {
		Type_name = type_name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMin_credit(int min_credit) {
		this.min_credit = min_credit;
	}

	public void setMax_credit(int max_credit) {
		this.max_credit = max_credit;
	}

	public void setTerm_start(int term_start) {
		this.term_start = term_start;
	}

	public void setTerm_end(int term_end) {
		this.term_end = term_end;
	}

	public LessonAbstractPO(int Ins_Id, String Ins_name, int Les_Id_Ab,
			int Type_Id, String Type_name, String name, int min_credit,
			int max_credit, int term_start, int term_end,int Module_id,int compulsory, String module_name) {
		this.Ins_Id = Ins_Id;
		this.Ins_name = Ins_name;
		this.Les_Id_Ab = Les_Id_Ab;
		this.Type_Id = Type_Id;
		this.Type_name = Type_name;
		this.name = name;
		this.min_credit = min_credit;
		this.max_credit = max_credit;
		this.term_start = term_start;
		this.term_end = term_end;
		this.compulsory = compulsory;
		this.Module_Id = Module_id;
		this.module_name = module_name;
	}

	
	public int getCompulsory() {
		return compulsory;
	}
	public int getModule_Id() {
		return Module_Id;
	}
	public String getModule_name() {
		return module_name;
	}
public void setModule_name(String module_name) {
	this.module_name = module_name;
}
	public int getIns_Id() {
		return Ins_Id;
	}

	public String getIns_name() {
		return Ins_name;
	}

	public int getLes_Id_Ab() {
		return Les_Id_Ab;
	}

	public int getType_Id() {
		return Type_Id;
	}

	public String getType_name() {
		return Type_name;
	}

	public String getName() {
		return name;
	}

	public int getMin_credit() {
		return min_credit;
	}

	public int getMax_credit() {
		return max_credit;
	}

	public int getTerm_start() {
		return term_start;
	}

	public int getTerm_end() {
		return term_end;
	}

	public String info() {
		String com= null;
		String credit;
		String term;
		if (compulsory==1)
			com = "必修";
		else  if(compulsory==2)
			com = "指选";
		else 
			com = "选修";
		
		if (max_credit==min_credit)
			credit = max_credit+"";
		else 
			credit = min_credit+"-"+max_credit;
		
		if (term_start == term_end)
			term = term_start+" ";
		else 
			term = term_start+"-"+term_end;
		char module = (char) ('A'+Module_Id-1);
		return module+" "+module_name+" "+Type_name+" "+com+" "+Les_Id_Ab+" "+name+" "+credit+" "+term;
		
	}
}
