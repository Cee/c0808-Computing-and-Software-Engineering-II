package presentation.schteacherui;

import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JLabel;

import vo.LessonUniqueVO;
import vo.VO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public class Sch_ShowClassInfo extends Sch_ShowPanel {
	
	@Override
	public void setThead(){
		String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;text-align:center\"";
		JLabel tHead = new JLabel(
				"<HTML>" +
				"<table contenteditable=\"true\">" + 
					"<tr>" +
					"<th"+thCss+">课程号</th>" +
					"<th"+thCss+">课程名</th>" +
					"<th"+thCss+">任课老师</th>" +
					"<th"+thCss+">上课时间</th>" +
					"<th"+thCss+">上课地点</th>" +
					"<th"+thCss+">学分</th>" +
					"</tr>"+
				"</table>" +
				"</HTML>");
		tHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tHead.setBounds(11, 105, 704, 40);
		add(tHead);
	}
	public Sch_ShowClassInfo(SchTeacherBlService schTeacher) throws RemoteException{
		super(schTeacher,6);
		showType = LESSON;
	}
	
	@Override
	protected void getRowList(ArrayList<VO> infos) {
		rowList.clear();
		for (VO vo : infos){
			String[] rowStrings = new String[6];
			LessonUniqueVO lesson = (LessonUniqueVO)vo;
			rowStrings[0] = lesson.getLessonId();
			rowStrings[1] = lesson.getLessonName();
			rowStrings[2] = lesson.getTeacherName();
			rowStrings[3] = lesson.getTime();
			rowStrings[4] = lesson.getLocation();
			rowStrings[5] = lesson.getCreditString();
			rowList.add(rowStrings);
		}
		
	}


}
