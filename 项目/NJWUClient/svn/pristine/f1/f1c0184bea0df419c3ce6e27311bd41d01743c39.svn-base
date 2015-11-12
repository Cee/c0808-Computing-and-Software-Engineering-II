package vo;

import po.StudentPO;

public class StudentVO extends VO {

	private int studentID;// 学号
	private int instituteID;// 院系号
	private int grade;// 年级
	private String name;// 姓名
	private char[] password;// 密码
	private String institute;// 院系
	private String gender;// 性别
	private int value;

	public StudentVO(StudentPO po) {
		if (po!=null){
			studentID = po.getStu_Id();
			instituteID = po.getIns_Id();
			grade = po.getGrade();
			name = po.getName();
			password = po.getPassword();
			institute = po.getInstitute();
			gender = po.getGender();	
		}
	}

	public StudentVO(int id, String name, char[] password, int grade,
			int institute, String instituteString ,String gender) {
		studentID = id;
		instituteID = institute;
		this.grade = grade;
		this.name = name;
		this.password = password;
		this.institute = instituteString;
		this.gender = gender;
	}

	public String simpleInfo() {
		return studentID + " " + name + " " + institute;
	}

	public int getStu_Id() {
		return studentID;
	}

	public int getIns_Id() {
		return instituteID;
	}

	public int getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public char[] getPassword() {
		return password;
	}

	public String getInstitute() {
		return institute;
	}

	public String getGender() {
		return gender;
	}
	
	
	/**
	 * 选修课分配时调用，计算出选课的权重
	 */
	public void setValue(){
		value += grade * grade;
//		value = value * Math.log(getCredits())
		
		
		
	}
	
	public int getValue(){
		return value;
	}
	
	public String getTypeString(){
		return "学生";
	}

}
