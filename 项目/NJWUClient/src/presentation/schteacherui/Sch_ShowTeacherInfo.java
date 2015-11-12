package presentation.schteacherui;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.TeacherVO;
import vo.VO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public class Sch_ShowTeacherInfo extends Sch_ShowPanel {
	public Sch_ShowTeacherInfo(SchTeacherBlService schTeacher) throws RemoteException{
		super(schTeacher,4);
		showType = TEACHER;
	}
	@Override
	public void getRowList(ArrayList<VO> infos) {
		rowList.clear();
		for (VO vo:infos) {
			String[] rowStrings = new String[4];
			TeacherVO teacherVO = (TeacherVO)vo;
			rowStrings[0] = Integer.toString((teacherVO.getTea_Id()));
			rowStrings[1] = teacherVO.getName();
			rowStrings[2] = teacherVO.getGender();
			rowStrings[3] = teacherVO.getTypeString();
			rowList.add(rowStrings);
		}
	}
}
