package po;

/**
 * @author Xc
 * @date 13.10.16
 * @version 1.0
 * 
 *          选课记录持久化对象
 */

public class SelectRecordPO extends PO {

	private int id; // 选课记录编号

	public void setId(int id) {
		this.id = id;
	}

	public void setLes_Id(int les_Id) {
		this.les_Id = les_Id;
	}

	public void setStu_Id(int stu_Id) {
		Stu_Id = stu_Id;
	}

	public void setType(int type) {
		this.type = type;
	}

	private int les_Id;// 课程编号
	private int Stu_Id;// 学生编号
	private int type; // 课程类别

	public SelectRecordPO(int id, int Stu_Id, int les_Id, int type) {
		this.id = id;
		this.les_Id = les_Id;
		this.Stu_Id = Stu_Id;
		this.type = type;
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
	 * @return les_type
	 */
	public int getType() {
		return type;
	}

}
