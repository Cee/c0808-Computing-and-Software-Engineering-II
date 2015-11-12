package po;

/**
 * 
 * @author Xc
 * @date 13.10.16
 * @version 1.0 教师持久化对象
 */

public class TeacherPO extends PO implements User {

	private int Tea_Id; // 教师编号
	private int Ins_Id; // 院系编号
	private String name; // 名称
	private char[] password; // 密码
	private String institution; // 院系名称
	private int type; // 类型（1=学校教务老师， 2 = 院系教务老师 ，3 = 一般老师）
	private String gender;
	public TeacherPO(int Tea_Id, int Ins_Id, String name, char[] password,
			String institution, int type,String gender) {
		this.Ins_Id = Ins_Id;
		this.institution = institution;
		this.name = name;
		this.password = password;
		this.Tea_Id = Tea_Id;
		this.type = type;
		UserType = type;
		this.gender = gender;
	}

	public String simpleInfo() {
		return "工号:" + Tea_Id + " 姓名：" + name +"性别:"+gender+ " 院系:" + institution;
	}

	/**
	 * @return the tea_Id
	 */
	public int getTea_Id() {
		return Tea_Id;
	}

	/**
	 * @return the ins_Id
	 */
	public int getIns_Id() {
		return Ins_Id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	public boolean setPassword(char[] old, char[] password) {
		if (String.valueOf(this.password).equals(String.valueOf(old))) {
			this.password = password;
			return true;
		}
		return false;
	}

	public void setTea_Id(int tea_Id) {
		Tea_Id = tea_Id;
	}

	public void setIns_Id(int ins_Id) {
		Ins_Id = ins_Id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public void setType(int type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
