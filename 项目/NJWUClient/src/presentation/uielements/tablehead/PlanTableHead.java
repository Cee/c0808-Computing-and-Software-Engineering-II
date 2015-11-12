package presentation.uielements.tablehead;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 教学计划表头
 * @author luck
 *
 */
public class PlanTableHead extends JPanel{
	public PlanTableHead(){
		setBounds(6, 6, 839, 96);
		setLayout(null);
		setOpaque(false);
		
		String thCss_2_1 = " style=\"background-color:#d2bbd2;height:66px;";
		String thCss_1_11 = " style=\"background-color:#d2bbd2;height:34px;width:310px;\"";
		String tdCss_1_1 = " style=\"background-color:#d2bbd2;height:30px;width:27px;\"";
		
		JLabel tableHead = new JLabel(
				"<HTML>" +
				"<table>" +
					"<th"+thCss_2_1+"width:136\">课程<br>模块</th>" +
					"<th"+thCss_2_1+"width:135\">课程分类</th>" +
					"<th"+thCss_2_1+"width:43\">课程<br>性质</th>" +
					"<th"+thCss_2_1+"width:103\">课程<br>编号</th>" +
					"<th"+thCss_2_1+"width:260\">课程名称</th>" +
					"<th"+thCss_2_1+"width:40\">课程<br>学分</th>" +
				"</table>" +
				"</HTML>");
		tableHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tableHead.setBounds(6, 4, 510, 96);
		add(tableHead);
		
		
		
		JLabel tableHead2 = new JLabel("<HTML>" +
				"<table>" +
				"<th"+tdCss_1_1+">一</th>" +
				"<th"+tdCss_1_1+">二</th>" +
				"<th"+tdCss_1_1+">暑<br>假</th>" +
				"<th"+tdCss_1_1+">三</th>" +
				"<th"+tdCss_1_1+">四</th>" +
				"<th"+tdCss_1_1+">暑<br>假</th>" +
				"<th"+tdCss_1_1+">五</th>" +
				"<th"+tdCss_1_1+">六</th>" +
				"<th"+tdCss_1_1+">暑<br>假</th>" +
				"<th"+tdCss_1_1+">七</th>" +
				"<th"+tdCss_1_1+">八</th>" +
				"</table>" +
				"</HTML>");
		tableHead2.setBounds(514, 49, 300, 53);
		tableHead2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 11));
		add(tableHead2);
		
		JLabel label = new JLabel("<HTML><table><th"+thCss_1_11+">各学期周学时分配</th></table></HTML>");
		label.setBounds(514, 6, 300, 50);
		setVisible(true);
		add(label);
	}
}
