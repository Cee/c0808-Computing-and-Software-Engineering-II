package vo;

import po.SelectRecordPO;

public class SelectRecordVO extends VO{
	private int id; // 选课记录编号

	private int les_Id;// 课程编号
	private int Stu_Id;// 学生编号
	private int type; // 课程类别

	public SelectRecordVO(int id, int Stu_Id, int les_Id, int type) {
		this.id = id;
		this.les_Id = les_Id;
		this.Stu_Id = Stu_Id;
		this.type = type;
	}

	
	public SelectRecordVO( SelectRecordPO po ){
		if (po!=null){
			this.id = po.getId();
			this.les_Id = po.getLes_Id();
			this.Stu_Id = po.getStu_Id();
			this.type = po.getType();		
		}
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
