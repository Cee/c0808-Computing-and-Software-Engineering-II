package vo;

import po.TeacherPO;
import utility.Constant;
import utility.CurrentState;

public class TeacherVO extends VO{
	private int Tea_Id; // 教师编号
	private int Ins_Id; // 院系编号
	private String name; // 名称
	private char[] password; // 密码
	private String institution; // 院系名称
	private int type;
	private String gender;
	public TeacherVO(TeacherPO po) {
		if (po!=null){
			Tea_Id = po.getTea_Id();
			Ins_Id = po.getIns_Id();
			name = po.getName();
			password = po.getPassword();
			institution = po.getInstitution();
			type = po.getType();
			gender = po.getGender();	
		}
	}
	
	public TeacherVO( int id , int ins_id , String name , char[] password , String institution , int type ,String gender){
		this.Tea_Id = id;
		this.Ins_Id = ins_id;
		this.name = name;
		this.password = password;
		this.institution = institution;
		this.type = type;
		this.gender = gender;
	}
	

	public String simpleInfo() {
		return Tea_Id + " " + name + " " + institution;
	}

	public int getIns_Id() {
		return Ins_Id;
	}

	public String getInstitution() {
		return institution;
	}
public String getGender() {
	return gender;
}
	public String getName() {
		return name;
	}

	public char[] getPassword() {
		return password;
	}

	public int getTea_Id() {
		return Tea_Id;
	}

	public int getType() {
		return type;
	}
	
	public String getTypeString(){
		return CurrentState.getTypeString(type);
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
