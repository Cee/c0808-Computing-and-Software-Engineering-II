package vo;

import po.LessonAbstractPO;

public class LessonAbstractVO extends VO {
	String name;
	String term;
	String credit;
	String compulsoryString;
	int les_Id_Ab;
	int term_start;
	int term_end;
	int max_credit;
	int min_credit;
	int compulsory;
	int type_Id;
	int module_Id;
	String type;
	String module;
	
	
	
	
	
	
	public LessonAbstractVO(int les_Id_Ab, String name, int min_credit,
			int max_credit, int compulsory, int type_id, int term_start,
			int term_end, String typeName, String moduleName, int module_Id) {
		this.type_Id = type_id;
		this.module_Id = module_Id;
		this.les_Id_Ab = les_Id_Ab;
		this.name = name;
		this.type = type_id + " " + typeName;
		this.max_credit = max_credit;
		this.min_credit = min_credit;
		this.term_end = term_end;
		this.term_start = term_start;
		this.compulsory = compulsory;
		this.module = (char) ('A' + module_Id - 1) + " " + moduleName;
	}

	public String getTerm() {
		return term;
	}

	public String getCredit() {
		return credit;
	}

	public String getCompulsoryString() {
		return compulsoryString;
	}

	public LessonAbstractVO(LessonAbstractPO po) {
		if (po!=null){
			this.module_Id = po.getModule_Id();
			this.type_Id = po.getType_Id();
			this.les_Id_Ab = po.getLes_Id_Ab();
			this.name = po.getName();
			this.max_credit = po.getMax_credit();
			this.min_credit = po.getMin_credit();
			this.type = po.getType_Id() + " " + po.getType_name();
			this.term_start = po.getTerm_start();
			this.term_end = po.getTerm_end();
			this.credit = judgeCredit(max_credit, min_credit);
			this.compulsory = po.getCompulsory();
			this.compulsoryString = judgeCompulsory(compulsory);
			this.term = judgeTerm(term_start, term_end);
			this.module = (char) ('A' + po.getModule_Id() - 1) + " "
					+ po.getModule_name();	
		}
	}

	public String getModule() {
		return module;
	}

	public String getType() {
		return type;
	}

	
	public int getTerm_end() {
		return term_end;
	}

	public int getTerm_start() {
		return term_start;
	}

	public String getName() {
		return name;
	}

	public int getMax_credit() {
		return max_credit;
	}

	public int getMin_credit() {
		return min_credit;
	}

	public int getCompulsory() {
		return compulsory;
	}

	public int getModule_Id() {
		return module_Id;
	}

	public int getType_Id() {
		return type_Id;
	}

	public int getLes_Id_Ab() {
		return les_Id_Ab;
	}
	
	public String getLes_Id_AbString() {
		return les_Id_Ab + "";
	}

	@Override
	public String toString() {
		return getName()+"("+ getLes_Id_AbString() +")";
	}
	
}
