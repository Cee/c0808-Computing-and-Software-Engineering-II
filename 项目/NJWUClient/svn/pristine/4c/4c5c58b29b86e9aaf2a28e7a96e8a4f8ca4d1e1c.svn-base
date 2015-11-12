package po;

import java.util.Set;

/**
 * 
 * @author Xc
 * @date 13.10.16
 * @version 1.0 具体课程的持久化对象
 */

public class LessonUniquePO extends PO {
	private String Les_name; // 课程名
	private int Les_Id; // 课程编号
	private String institution; // 学院名称
	private String location; // 上课地点
	private int term; // 上课学期
	private int max_stu_num; // 学生上限
	private int cur_stu_num; // 当前学生数目
	private int state; // 当前状态
	private int Tea_Id; // 教师编号
	private String Tea_name; // 教师名称
	private int Les_Id_Ab; // 课程号
	private int Ins_Id; // 院系编号
	private int day; // 上课的星期（1表示周一，2表示周二，一次类推）
	private int start; // 表示从第几节课开始
	private int end; // 表示从第几节课结束
	private String introduction; // 课程介绍
	private String books;// 教材
	private String outline;// 课程大纲
	private int credit;
	private int compulsory;
	private String type_name;
	private int type_id;

	public LessonUniquePO(String Les_name, int Les_Id, String institution,
			String location, int term, int max_stu_num, int cur_stu_num,
			int state, int Tea_Id, String Tea_name, int Les_Id_Ab, int Ins_Id,
			int day, int start, int end, String introduction, String books,
			String outline, int credit, int compulsory, int type_id,
			String type_name) {
		this.cur_stu_num = cur_stu_num;
		this.day = day;
		this.end = end;
		this.Ins_Id = Ins_Id;
		this.institution = institution;
		this.Les_Id = Les_Id;
		this.Les_Id_Ab = Les_Id_Ab;
		this.Les_name = Les_name;
		this.location = location;
		this.max_stu_num = max_stu_num;
		this.start = start;
		this.state = state;
		this.Tea_Id = Tea_Id;
		this.Tea_name = Tea_name;
		this.term = term;
		this.books = books;
		this.introduction = introduction;
		this.outline = outline;
		this.credit = credit;
		this.compulsory = compulsory;
		this.type_name = type_name;
		this.type_id = type_id;

	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(int compulsory) {
		this.compulsory = compulsory;
	}

	public int getCredit() {
		return credit;
	}

	public String simpleInfo() {
		return "课程号：" + Les_Id_Ab + "；课程名：" + Les_name;
	}

	public String normalInfo() {
		return "课程编号" + Les_Id + " 课程号：" + Les_Id_Ab + "；课程名：" + Les_name
				+ "；教师：" + Tea_name + "；上课教室" + location + "；时间:周" + day + " "
				+ start + "到" + end + "节" + "学分：" + credit;
	}

	public String fullInfo() {
		return "课程编号" + Les_Id + " 课程号：" + Les_Id_Ab + "；课程名：" + Les_name
				+ "；教师：" + Tea_name + "；上课教室" + location + "；时间:周" + day + " "
				+ start + "到" + end + "节" + "\n 课程介绍：" + introduction
				+ "\n 教材:" + books + "\n 课程大纲" + outline + "\n";
	}

	public String getBooks() {
		return books;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getOutline() {
		return outline;
	}

	public String getLes_name() {
		return Les_name;
	}

	public String getInstitution() {
		return institution;
	}

	public String getLocation() {
		return location;
	}

	public int getTerm() {
		return term;
	}

	public int getMax_stu_num() {
		return max_stu_num;
	}

	public int getCur_stu_num() {
		return cur_stu_num;
	}

	public int getState() {
		return state;
	}

	public int getTea_Id() {
		return Tea_Id;
	}

	public String getTea_name() {
		return Tea_name;
	}

	public int getLes_Id_Ab() {
		return Les_Id_Ab;
	}

	public int getIns_Id() {
		return Ins_Id;
	}

	public int getDay() {
		return day;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getLes_Id() {
		return Les_Id;
	}

	public void setLes_name(String les_name) {
		Les_name = les_name;
	}

	public void setLes_Id(int les_Id) {
		Les_Id = les_Id;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public void setMax_stu_num(int max_stu_num) {
		this.max_stu_num = max_stu_num;
	}

	public void setCur_stu_num(int cur_stu_num) {
		this.cur_stu_num = cur_stu_num;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setTea_Id(int tea_Id) {
		Tea_Id = tea_Id;
	}

	public void setTea_name(String tea_name) {
		Tea_name = tea_name;
	}

	public void setLes_Id_Ab(int les_Id_Ab) {
		Les_Id_Ab = les_Id_Ab;
	}

	public void setIns_Id(int ins_Id) {
		Ins_Id = ins_Id;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setBooks(String books) {
		this.books = books;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

}
