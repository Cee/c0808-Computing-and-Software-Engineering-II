package presentation.schteacherui;

import java.awt.Font;
import java.awt.Rectangle;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyComboBox;
import utility.CurrentState;
import vo.StudentVO;
import vo.VO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public class Sch_ShowStudentInfo extends Sch_ShowPanel {

	JLabel label_Grade;
	JComboBox<String> comboBox_Grade;
	MyComboBox<String> gradeBox;
	public Sch_ShowStudentInfo(SchTeacherBlService schTeacher) {
		super(schTeacher,4);
		showType = STUDENT;
		label_Grade = new JLabel("年级:");
		label_Grade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_Grade.setBounds(200, 70, 60, 28);
		add(label_Grade);
		String grade[] = new String[] { "请选择年级", "大一", "大二", "大三", "大四" };
		comboBox_Grade = new JComboBox<String>(grade);
		gradeBox = new MyComboBox<>(comboBox_Grade, new Rectangle(255, 70, 124, 31), grade[0]);
		comboBox_Grade.setSelectedIndex(0);
		comboBox_Grade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		add(gradeBox);
		comboBox_Grade.addActionListener(new comboBoxListener());
	}
	
	protected void getResponse(){
		if ((CurrentState.getInsId((String) comboBox_Ins.getSelectedItem()) != 0)
				&& (comboBox_Grade.getSelectedIndex() != 0)){
			if (ins_id != (CurrentState.getInsId((String) comboBox_Ins
					.getSelectedItem())) || (grade != comboBox_Grade.getSelectedIndex())) {
				ins_id = (CurrentState.getInsId((String) comboBox_Ins
						.getSelectedItem()));
				grade = comboBox_Grade.getSelectedIndex();
				try {
					refresh(STUDENT);
				} catch (RemoteException e1) {
					MainFrameUI.showError( );
					e1.printStackTrace();
				}
			}
		}
	}
	@Override
	protected void getRowList(ArrayList<VO> infos) {
		rowList.clear();
		for (VO vo:infos) {
			String[] rowStrings = new String[4];
			StudentVO student = (StudentVO)vo;
			rowStrings[0] = student.getStu_Id()+"";
			rowStrings[1] = student.getName();
			rowStrings[2] = student.getGender();
			rowStrings[3] = student.getTypeString();
			rowList.add(rowStrings);
		}		
	}
}
