package presentation.insteacherui;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
/**
 * 编辑教学计划二级页面
 * @author luck
 *
 */
public class Ins_EditSubPanel extends JPanel {
	private JTextField idField;
	private JTextField nameField;
	private JTextField teacherField;
	private JTextField creditField;
	private JTextField numField;
	private JTextField locationField;
	private JTextField timeField;
	public Ins_EditSubPanel() {
		setLayout(null);
		
		JLabel lblxxx = new JLabel("课程编号：XXX");
		lblxxx.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblxxx.setBounds(183, 35, 150, 37);
		add(lblxxx);
		
		JLabel label = new JLabel("课程名称：");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label.setBounds(183, 77, 68, 31);
		add(label);
		
		JLabel label_1 = new JLabel("任课老师：");
		label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_1.setBounds(183, 120, 68, 31);
		add(label_1);
		
		JLabel label_2 = new JLabel("课程学分：");
		label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_2.setBounds(183, 163, 68, 31);
		add(label_2);
		
		JLabel label_3 = new JLabel("上课时间：");
		label_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_3.setBounds(183, 206, 68, 31);
		add(label_3);
		
		JLabel label_4 = new JLabel("上课地点：");
		label_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_4.setBounds(183, 249, 68, 31);
		add(label_4);
		
		JLabel label_5 = new JLabel("课程信息：");
		label_5.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_5.setBounds(183, 292, 68, 31);
		add(label_5);
		
		idField = new JTextField();
		idField.setBounds(248, 77, 229, 31);
		add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(248, 121, 229, 31);
		add(nameField);
		
		teacherField = new JTextField();
		teacherField.setColumns(10);
		teacherField.setBounds(248, 164, 49, 31);
		add(teacherField);
		
		creditField = new JTextField();
		creditField.setColumns(10);
		creditField.setBounds(248, 207, 229, 31);
		add(creditField);
		
		numField = new JTextField();
		numField.setColumns(10);
		numField.setBounds(248, 249, 229, 31);
		add(numField);
		
		locationField = new JTextField();
		locationField.setColumns(10);
		locationField.setBounds(248, 293, 391, 140);
		add(locationField);
		
		JButton button = new JButton("发布");
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		button.setBounds(245, 459, 90, 30);
		add(button);
		
		JButton button_1 = new JButton("保存");
		button_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		button_1.setBounds(376, 459, 90, 30);
		add(button_1);
		
		JButton button_2 = new JButton("取消");
		button_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		button_2.setBounds(506, 459, 90, 30);
		add(button_2);
		
		JLabel label_6 = new JLabel("最大学生人数：");
		label_6.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_6.setBounds(309, 163, 123, 31);
		add(label_6);
		
		timeField = new JTextField();
		timeField.setColumns(10);
		timeField.setBounds(402, 164, 75, 31);
		add(timeField);
	}
}
