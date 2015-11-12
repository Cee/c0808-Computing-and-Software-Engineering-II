package po;

/**
 * 
 * @author luck
 * @data 13.10.15
 * @version 1.0 Student持久化对象
 */
public class StudentPO extends PO implements User {

	private int Stu_Id;// 学号
	private int Ins_Id;// 院系号
	private int grade;// 年级
	private String name;// 姓名
	private char[] password;// 密码
	private String institute;// 院系
	private String gender;// 性别

	public StudentPO(int Stu_Id, String name, char[] password, int Ins_Id,
			String institute, String gender, int grade) {
		this.Stu_Id = Stu_Id;
		this.name = name;
		this.password = password;
		this.Ins_Id = Ins_Id;
		this.institute = institute;
		this.gender = gender;
		this.grade = grade;
	}

	public String simpleInfo() {
		return "学号:" + Stu_Id + " 姓名：" + name + " 院系:" + institute + " 年级："
				+ grade + " 性别：" + gender;
	}

	public String getGender() {
		return gender;
	}

	public int getGrade() {
		return grade;
	}

	public int getIns_Id() {
		return Ins_Id;
	}

	public String getInstitute() {
		return institute;
	}

	public String getName() {
		return name;
	}

	public char[] getPassword() {
		return password;
	}

	public int getStu_Id() {
		return Stu_Id;
	}

	public boolean setPassword(char[] old, char[] password) {
		if (String.valueOf(this.password).equals(String.valueOf(old))) {
			this.password = password;
			return true;
		}
		return false;
	}

	public void setStu_Id(int stu_Id) {
		Stu_Id = stu_Id;
	}

	public void setIns_Id(int ins_Id) {
		Ins_Id = ins_Id;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
