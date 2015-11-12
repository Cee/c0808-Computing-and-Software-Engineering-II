package vo;

import po.LessonRecordPO;
import po.LessonUniquePO;

public class LessonRecordVO extends VO {
	private int id;
	private int les_id;
	private int stu_id;
	private String stu_name;
	private String les_name;
	private int score;
	private int credit;
	private String compulsory;
	private String tea_name;
	private int term;
	private String type_name;
	private int type_id;
	public int getType_id() {
		return type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public int getLes_id() {
		return les_id;
	}

	public int getStu_id() {
		return stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public String getLes_name() {
		return les_name;
	}
	public String getTea_name() {
		return tea_name;
	}
	public int getTerm() {
		return term;
	}
	public LessonRecordVO(LessonRecordPO po, LessonUniquePO lesson) {
		
		if (po!=null&&lesson!=null){
			this.id = po.getId();
			this.les_id = lesson.getLes_Id_Ab();
			this.stu_id = po.getStu_Id();
			this.score = po.getScore();
			this.stu_name = po.getStu_name();
			this.les_name = po.getLes_name();
			this.compulsory = (VO.judgeCompulsory(lesson.getCompulsory()));
			this.credit = lesson.getCredit();
			this.tea_name = lesson.getTea_name();
			this.term = lesson.getTerm();
			this.type_id = lesson.getType_id();
			this.type_name = lesson.getType_name();	
		}
		
	}
public int getId() {
	return id;
}
	public LessonRecordVO(LessonRecordPO po){
		this.id = po.getId();
		this.les_id = po.getLes_Id();
		this.stu_id = po.getStu_Id();
		this.score = po.getScore();
		this.stu_name = po.getStu_name();
		this.les_name = po.getLes_name();
	}
	public LessonRecordVO(int stu_id, LessonUniqueVO lesson) {
		this.stu_id = stu_id;
		this.compulsory = (VO.judgeCompulsory(lesson.getCompulsory()));
		this.credit = lesson.getCredit();
		this.tea_name = lesson.getTeacherName();
		this.term = lesson.getTerm();
		this.type_id = lesson.getType_id();
		this.type_name = lesson.getType_name();	
		this.les_id =lesson.getLes_Id();
		this.les_name = lesson.getLessonName();
		
	}
	public String getCompulsory() {
		return compulsory;
	}

	public int getCredit() {
		return credit;
	}

	public int getScore() {
		return score;
	}

	public String getScoreString() {
		return "课程号：" + les_id + ";课程名：" + les_name + ": " + score;
	}

}
