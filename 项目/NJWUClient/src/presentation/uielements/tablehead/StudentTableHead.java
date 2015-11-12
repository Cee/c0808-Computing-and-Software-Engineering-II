package presentation.uielements.tablehead;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 学生表头
 * @author luck
 *
 */
public class StudentTableHead extends JPanel{
	public StudentTableHead(){
		setBounds(6, 6, 839, 96);
		setLayout(null);
		setOpaque(false);
		String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;\"";
		String thCss_1 = " style=\"background-color:#d2bbd2;width:200px;height:34px;\"";
		String thCss_2 = " style=\"background-color:#d2bbd2;width:100px;height:34px;\"";
		String thCss_3 = " style=\"background-color:#d2bbd2;width:50px;height:34px;\"";

		JLabel tableHead = new JLabel(
				"<HTML>" +
				"<table>" +
					"<th"+thCss+">学  号</th>" +
					"<th"+thCss+">姓  名</th>" +
					"<th"+thCss+">院  系</th>" +
					"<th"+thCss+">性  别</th>" +
					"<th"+thCss+">备  注</th>" +
				"</table>" +
				"</HTML>");
		tableHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tableHead.setBounds(6, 6, 827, 72);
		add(tableHead);
	}
}
