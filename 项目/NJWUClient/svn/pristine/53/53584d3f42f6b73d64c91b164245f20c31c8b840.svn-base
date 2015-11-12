package vo;

import com.sun.tracing.dtrace.ModuleName;

import po.ModulePO;

public class ModuleVO extends VO {


	private int Module_Id; // 模块编号
	private String Name; // 模块名称
	private int min_credit; // 建议最低学分
	private int max_credit; // 建议最高学分
	public ModuleVO(int Module_Id, String Name, int Min_Credit, int Max_Credit) {
		this.Module_Id = Module_Id;
		this.Name = Name;
		this.min_credit = Min_Credit;
		this.max_credit = Max_Credit;
	}
	public String toString(){
		return (char) ('A' + Module_Id - 1) + " "
				+ Name;
	}
	public ModuleVO(ModulePO po) {
		if (po!=null){
			this.Module_Id = po.getModule_Id();
			this.Name = po.getName();
			this.min_credit = po.getMin_Credit();
			this.max_credit = po.getMax_Credit();	
		}
	}
	public int getModule_Id() {
		return Module_Id;
	}
	public String getName() {
		return Name;
	}
	
	public String getCredit(){
		return judgeCredit(max_credit, min_credit);
	}
	public int getMin_credit() {
		return min_credit;
	}
	public int getMax_credit() {
		return max_credit;
	}
	
	
	
	
}
