package presentation.uielements.tablehead;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 课程记录表头
 * @author luck
 *
 */
public class RecordHead extends JPanel{
	public RecordHead() {
		setBounds(6, 6, 839, 110);
		setLayout(null);
		setOpaque(false);
		String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;\"";
		String thCss_1 = " style=\"background-color:#d2bbd2;width:400px;height:34px;\"";
		JLabel headHead = new JLabel(
				"<HTML>" +
				"<table>" +
					"<th"+thCss_1+">未登记学生</th>" +
					"<th"+thCss_1+">已登记学生</th>" +
				"</table>" +
				"</HTML>");
		headHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		headHead.setBounds(6, -11, 827, 72);
		add(headHead);
		JLabel tableHead = new JLabel(
				"<HTML>" +
				"<table>" +
					"<th"+thCss+">学  号</th>" +
					"<th"+thCss+">姓  名</th>" +
					"<th"+thCss+">成  绩</th>" +
					"<th"+thCss+">操  作</th>" +
					"<th"+thCss+">学  号</th>" +
					"<th"+thCss+">姓  名</th>" +
					"<th"+thCss+">成  绩</th>" +
					"<th"+thCss+">操  作</th>" +
				"</table>" +
				"</HTML>");
		tableHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tableHead.setBounds(6, 40, 827, 72);
		add(tableHead);
	}
}
