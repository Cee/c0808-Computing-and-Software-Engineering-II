package presentation.studentui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.uielements.MyButton;
import presentation.uielements.tablehead.ScheduleTableHead;
import vo.LessonUniqueVO;
import vo.ScheduleVO;
/**
 * 查看课表
 * @author luck
 *
 */
public class Stu_ShowSchedule extends Stu_ShowPanel {
	private ScheduleVO schedule;

	public Stu_ShowSchedule(ScheduleVO scheduleVO) {
		this.schedule = scheduleVO;
		tableHead = new String[]{ "", "", "", "", "", "", "" };
		fillRowData();
		initialTable();
//		initialSearch();
	}
	
	/**
	 * 搜索栏
	 */
	public void initialSearch(){
		JLabel label = new JLabel("课程号");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 6, 89, 41);
		add(label);
		
		searchField = new JTextField();
		searchField.setBounds(107, 12, 134, 28);
		add(searchField);
		searchField.setColumns(10);

		MyButton button = new MyButton("查询");
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		button.setBounds(248, 13, 75, 29);
		add(button);
	}

	@Override
	public void setThead() {
		ScheduleTableHead tHead = new ScheduleTableHead();
		tHead.setBounds(6, 33, 845, 96);
		add(tHead);
	}

	@Override
	public void fillRowData() {
		Iterator<LessonUniqueVO> iter = schedule.getlessons();
		ArrayList<LessonUniqueVO> lessons = new ArrayList<>();
		while (iter.hasNext()) {
			lessons.add(iter.next());
		}
		rowData = new String[lessons.size()][7];// 每行每列的数据设置在这里！！！！
		for (int i = 0; i<lessons.size(); i++) {
			LessonUniqueVO term = lessons.get(i);
			rowData[i][0] = term.getLessonId();
			rowData[i][1] = term.getLessonName();
			rowData[i][2] = term.getTeacherName();
			rowData[i][3] = term.getTime();
			rowData[i][4] = term.getLocation();
			rowData[i][5] = term.getCompulsoryString();
			rowData[i][6] = term.getCreditString();
		}
	}
	@Override
	public void setTableWidth() {
		tableScrollPane.setBounds(11, 100, 839, 374);
	}
}
