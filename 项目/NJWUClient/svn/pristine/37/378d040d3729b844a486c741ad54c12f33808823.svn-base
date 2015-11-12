package vo;

import java.util.ArrayList;
import java.util.Iterator;

public class ScoreVO {
	ArrayList<ArrayList<LessonRecordVO>> scores = new ArrayList<ArrayList<LessonRecordVO>>();
	ArrayList<LessonRecordVO> academy = new ArrayList<>();
	int totalCredit=0;
	int totalScore=0;
	int generalCredit=0;
	boolean isFail=false;
	public int getGeneralCredit() {
		return generalCredit;
	}
	public Iterator<LessonRecordVO> getAcademy(){
		return academy.iterator();
	}
	public ScoreVO(Iterator<LessonRecordVO> record){
		for (int i = 0 ; i <11; i++){
			scores.add(new ArrayList<LessonRecordVO>());
		}
		while (record.hasNext()){
			LessonRecordVO vo = record.next();
			if (vo.getTerm()>=1){
				scores.get(vo.getTerm()-1).add(vo);	
			}
			if (vo.getScore()>=60){
				totalCredit = totalCredit + vo.getCredit();
				totalScore = totalScore+vo.getCredit()*vo.getScore();
			} else {
				isFail=true;
			}
			if (vo.getCompulsory()!=null&&vo.getCompulsory().equals("必修"))
				academy.add(vo);
			if (vo.getType_id()==1)
				generalCredit=generalCredit+vo.getCredit();
		}
	}
	public Iterator<LessonRecordVO> getScores(int term) {
		return scores.get(term-1).iterator();
	}
	public int getTotalCredit() {
		return totalCredit;
	}
	public String GPA(){
		if (isFail) {
			return "有挂科，无学分绩";
		} else {
			if (totalCredit!=0)
				return totalScore/totalCredit/20.0+"";
			return 0+"";
		}
		
	}
	
}
