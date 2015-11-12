package presentation.uielements.tablehead;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 课表表头
 * @author luck
 *
 */
public class ScheduleTableHead extends JPanel{
	public ScheduleTableHead(){
		setBounds(6, 6, 839, 96);
		setLayout(null);
		setOpaque(false);
		
		String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;\"";
		
		JLabel tableHead = new JLabel(
				"<HTML>" +
				"<table>" +
					"<th"+thCss+">课程号</th>" +
					"<th"+thCss+">课程名</th>" +
					"<th"+thCss+">教 师</th>" +
					"<th"+thCss+">上课时间</th>" +
					"<th"+thCss+">上课地点</th>" +
					"<th"+thCss+">类型</th>" +
					"<th"+thCss+">学分</th>" +
				"</table>" +
				"</HTML>");
		tableHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tableHead.setBounds(6, 6, 827, 72);
		add(tableHead);
	}
}
