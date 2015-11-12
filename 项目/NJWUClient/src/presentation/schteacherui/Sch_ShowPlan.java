package presentation.schteacherui;

import java.util.ArrayList;

import presentation.uielements.tablehead.PlanTableHead;
import vo.LessonAbstractVO;
import vo.VO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public class Sch_ShowPlan extends Sch_ShowPanel{
	@Override
	public void setThead(){
		PlanTableHead planTableHead = new PlanTableHead();
		planTableHead.setLocation(6, 100);
		add(planTableHead);
	}
	@Override
	public void setTableWidth(){
		tableScrollPane.setBounds(14, 195, 820, 350);
		for (int k = 0; k < 17; k++) {
			int tableWidth;
			if (k == 0) {
				tableWidth = 93;
			} 
			else if (k ==1) {
				tableWidth = 94;
			}
			else if(k == 2){
				tableWidth = 35;
			}
			else if(k == 3){
				tableWidth = 75;
			}
			else if(k == 4){
				tableWidth = 175;
			}
			else if(k == 5){
				tableWidth = 35;
			}
			else {
				tableWidth = 27;
			}
			table.getColumnModel().getColumn(k).setPreferredWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMaxWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMinWidth(tableWidth);
		}		
	}

	public Sch_ShowPlan(SchTeacherBlService schTeacher) {
		super(schTeacher, 18);
		showType = PLAN;
		tableHead = new String[] { "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "" };
	}
	@Override
	protected void getRowList(ArrayList<VO> infos) {
		rowList.clear();
		for (VO vo:infos){
			LessonAbstractVO lesson = (LessonAbstractVO)vo;
			String[] rowString = new String[18];
			rowString[0] = lesson.getModule();
			rowString[1] = lesson.getType();
			rowString[2] = lesson.getCompulsoryString();
			rowString[3] = lesson.getLes_Id_Ab() + "";
			rowString[4] = lesson.getName();
			rowString[5] = lesson.getCredit();
			String termString = lesson.getTerm();
			String[] terms = termString.split(";");
			for (String eachTerm : terms) {
				int term = Integer.parseInt(eachTerm);
				if (term > 2 && term < 5)
					term++;
				if (term >= 5 && term < 7)
					term = term + 2;
				if (term >= 7 && term < 9)
					term = term + 3;
				if (term >= 9)
					term = 3 * (term - 8);
				rowString[5 + term] = "√";
			}	
			rowList.add(rowString);
		}
	}
}
