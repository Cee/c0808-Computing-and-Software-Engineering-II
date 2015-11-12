package po;

/**
 * 
 * @author Xc
 * @date 13.10.16
 * @version 1.0 课程记录持久化对象
 */

public class LessonRecordPO extends PO {

	private int id; // 选课记录编号
	private int les_Id;// 课程编号
	private int Stu_Id;// 学生编号
	private int score; // 学生在该门课程的成绩
	private String les_name;
	private String stu_name;

	public LessonRecordPO(int id, int les_Id, int Stu_Id, int score,
			String les_name, String stu_name) {
		this.id = id;
		this.les_Id = les_Id;
		this.Stu_Id = Stu_Id;
		this.score = score;
		this.stu_name = stu_name;
		this.les_name = les_name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLes_Id(int les_Id) {
		this.les_Id = les_Id;
	}

	public void setStu_Id(int stu_Id) {
		Stu_Id = stu_Id;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setLes_name(String les_name) {
		this.les_name = les_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String info() {
		return les_name + " " + stu_name + " " + "成绩：" + score;
	}

	public String getLes_name() {
		return les_name;
	}

	public String getStu_name() {
		return stu_name;
	}

	public LessonRecordPO(int les_Id, int Stu_Id, int score, String stu_name,
			String les_name) {
		this.les_Id = les_Id;
		this.Stu_Id = Stu_Id;
		this.score = score;
		this.stu_name = stu_name;
		this.les_name = les_name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the less_Id
	 */
	public int getLes_Id() {
		return les_Id;
	}

	/**
	 * @return the stu_Id
	 */
	public int getStu_Id() {
		return Stu_Id;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

}
