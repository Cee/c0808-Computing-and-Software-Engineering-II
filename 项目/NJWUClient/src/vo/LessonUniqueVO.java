package vo;

import po.LessonUniquePO;

public class LessonUniqueVO extends VO {
	private String lessonName; // 课程名
	private int Les_Id; // 课程编号
	private String institution; // 学院名称
	private String location; // 上课地点
	private int term; // 上课学期
	private int max_stu_num; // 学生上限
	private int cur_stu_num; // 当前学生数目
	private int state; // 当前状态
	private int Tea_Id; // 教师编号
	private String teacherName; // 教师名称
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
	// strings
	private String lessonId;
	private String time;
	private String creditString;
	private String compulsoryString;
	private String stu_num;

	public LessonUniqueVO(int les_Id,int Les_Id_Ab, String lesson_name, int Ins_Id, int day,
			int start, int end, String introduction, String books,
			String outline, int credit, int max_stu_num,int cur_stu_num,int state,int tea_id,String location,int term) {
		this.cur_stu_num = cur_stu_num;
		this.state = state;
		this.Tea_Id = tea_id;
		this.Les_Id = les_Id;
		this.Les_Id_Ab = Les_Id_Ab;
		this.lessonName = lesson_name;
		this.Ins_Id = Ins_Id;
		this.day = day;
		this.start = start;
		this.end = end;
		this.introduction = introduction;
		this.books = books;
		this.outline= outline;
		this.credit = credit ;
		this.max_stu_num = max_stu_num;
		this.location = location;
		this.term = term;
	}

	public LessonUniqueVO(LessonUniquePO lesson) {
		if (lesson!=null){
			this.books = lesson.getBooks();
	 		this.credit = lesson.getCredit();
			this.cur_stu_num = lesson.getCur_stu_num();
			this.day = lesson.getDay();
			this.end = lesson.getEnd();
			this.Ins_Id = lesson.getIns_Id();
			this.institution = lesson.getInstitution();
			this.introduction = lesson.getIntroduction();
			this.Les_Id = lesson.getLes_Id();
			this.Les_Id_Ab = lesson.getLes_Id_Ab();
			this.lessonName = lesson.getLes_name();
			this.location = lesson.getLocation();
			this.max_stu_num = lesson.getMax_stu_num();
			this.outline = lesson.getOutline();
			this.start = lesson.getStart();
			this.state = lesson.getState();
			this.Tea_Id = lesson.getTea_Id();
			this.teacherName = lesson.getTea_name();
			this.term = lesson.getTerm();
			this.compulsory = lesson.getCompulsory();
			this.compulsoryString = VO.judgeCompulsory(lesson.getCompulsory());
			lessonId = lesson.getLes_Id_Ab() + "";
			time = formTime(lesson);
			this.type_id = lesson.getType_id();
			this.type_name = lesson.getType_name();
			creditString = lesson.getCredit() + "";
			this.stu_num = lesson.getCur_stu_num() + "/" + lesson.getMax_stu_num();	
		}
		
	}

	public String getStu_num() {
		return stu_num;
	}

	public int getType_id() {
		return type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public int getCompulsory() {
		return compulsory;
	}

	public String getCompulsoryString() {
		return compulsoryString;
	}

	public String simpleInfo() {
		return "课程号：" + Les_Id_Ab + "；课程名：" + lessonName;
	}

	public String normalInfo() {
		return "课程号：" + Les_Id_Ab + "；课程名：" + lessonName + "；教师：" + teacherName
				+ "；上课教室" + location + "；时间:周" + day + " " + start + "到" + end
				+ "节";
	}

	public String getLessonName() {
		return lessonName;
	}

	public int getLes_Id() {
		return Les_Id;
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

	public String getTeacherName() {
		return teacherName;
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

	public String getIntroduction() {
		return introduction;
	}

	public String getBooks() {
		return books;
	}

	public String getOutline() {
		return outline;
	}

	public String getCreditString() {
		return String.valueOf(credit);
	}

	public int getCredit() {
		return credit;
	}

	public String getLessonId() {
		return lessonId;
	}

	public String getTime() {
		return time;
	}

	public String toString() {
		return lessonName;
	}
	public String fullInfo() {
		return "课程编号" + Les_Id + " 课程号：" + Les_Id_Ab + "；课程名：" + lessonName
				+ "；教师：" + teacherName + "；上课教室" + location + "；时间:周" + day + " "
				+ start + "到" + end + "节" + "\n 课程介绍：" + introduction
				+ "\n 教材:" + books + "\n 课程大纲" + outline + "\n";
	}
}
