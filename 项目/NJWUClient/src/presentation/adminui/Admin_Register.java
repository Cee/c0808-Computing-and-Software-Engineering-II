package presentation.adminui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.THREAD_POLICY_ID;

import jxl.read.biff.BiffException;
import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import presentation.uielements.tablehead.UserHead;
import sun.applet.Main;
import utility.Constant;
import utility.CurrentState;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.adminblservice.AdminblService;

public class Admin_Register extends JPanel {

	static class ImportType {
		final static int STUDENT = 0;
		final static int TEACHER = 1;
	}

	JLabel label_Id;
	JLabel label_Name;
	JLabel label_Gender;
	JLabel label_Type;
	JLabel label_Institute;
	JLabel label_Male;
	JLabel label_Female;
	JLabel label_Stu;
	JLabel label_Tea;
	JLabel label_Ins;
	JLabel label_Sch;
	JLabel label_Remind;
	JTextField text_Id;
	JTextField text_Name;

	ButtonGroup bg_Gender;
	JRadioButton maleButton;
	JRadioButton femaleButton;

	ButtonGroup bg_Type;
	JRadioButton stuTypeButton;
	JRadioButton teacherTypeButton;
	JRadioButton insTeacherTypeButton;
	JRadioButton schTeacherTypeButton;

	JComboBox<String> comboBox_Ins;

	MyButton confirmButton;
	MyButton resetButton;

	JTable table;
	JScrollPane tableScrollPane;
	String[][] rowData;
	AdminblService admin;
	private MyButton btmassImportStudent;
	private MyButton btmassImportTeacher;
	private JLabel label;

	class IdKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			char input = e.getKeyChar();
			boolean ignore = input == (char) KeyEvent.VK_ESCAPE
					|| input == (char) KeyEvent.VK_BACK_SPACE
					|| input == (char) KeyEvent.VK_ENTER
					|| input == (char) KeyEvent.VK_DELETE;
			if (ignore) {
			} else if (input >= KeyEvent.VK_0 && input <= KeyEvent.VK_9) {
				label_Remind.setVisible(false);
			} else {
				label_Remind.setVisible(true);
				e.consume(); // 关键，屏蔽掉非法输入
			}
		}

	}

	public Admin_Register(AdminblService admin) {

		this.admin = admin;

		setBounds(121, 128, 851, 495);
		setOpaque(false);
		setLayout(null);

		// labels

		label_Id = new JLabel("学工号:");
		label_Id.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Id.setBounds(64, 33, 60, 28);
		add(label_Id);

		label_Remind = new JLabel("学工号只能为数字！");
		label_Remind.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Remind.setForeground(Color.RED);
		label_Remind.setBounds(300, 33, 110, 28);
		label_Remind.setVisible(false);
		add(label_Remind);

		label_Name = new JLabel("姓名:");
		label_Name.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Name.setBounds(64, 86, 60, 28);
		add(label_Name);

		label_Gender = new JLabel("性别:");
		label_Gender.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Gender.setBounds(64, 139, 60, 28);
		add(label_Gender);

		label_Type = new JLabel("用户类型:");
		label_Type.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Type.setBounds(64, 193, 60, 28);
		add(label_Type);

		label_Institute = new JLabel("院系:");
		label_Institute.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Institute.setBounds(64, 360, 60, 28);
		add(label_Institute);

		// textfield

		text_Id = new JTextField();
		text_Id.setColumns(10);
		text_Id.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		text_Id.setEditable(true);
		text_Id.setBounds(120, 32, 124, 31);
		add(text_Id);

		text_Name = new JTextField();
		text_Name.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		text_Name.setEditable(true);
		text_Name.setColumns(10);
		text_Name.setBounds(120, 85, 124, 31);
		add(text_Name);

		// GenderButtons

		bg_Gender = new ButtonGroup();

		maleButton = new JRadioButton();
		maleButton.setBounds(136, 136, 28, 31);
		bg_Gender.add(maleButton);
		add(maleButton);

		femaleButton = new JRadioButton();
		femaleButton.setBounds(197, 136, 28, 31);
		bg_Gender.add(femaleButton);
		add(femaleButton);

		label_Male = new JLabel("男");
		label_Male.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Male.setBounds(164, 136, 28, 31);
		add(label_Male);

		label_Female = new JLabel("女");
		label_Female.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Female.setBounds(225, 136, 28, 31);
		add(label_Female);

		// TypeButtons
		bg_Type = new ButtonGroup();

		stuTypeButton = new JRadioButton();
		stuTypeButton.setBounds(136, 193, 28, 31);
		bg_Type.add(stuTypeButton);
		add(stuTypeButton);

		teacherTypeButton = new JRadioButton();
		teacherTypeButton.setBounds(136, 233, 28, 31);
		bg_Type.add(teacherTypeButton);
		add(teacherTypeButton);

		insTeacherTypeButton = new JRadioButton();
		insTeacherTypeButton.setBounds(136, 273, 28, 31);
		bg_Type.add(insTeacherTypeButton);
		add(insTeacherTypeButton);

		schTeacherTypeButton = new JRadioButton();
		schTeacherTypeButton.setBounds(136, 313, 28, 31);
		bg_Type.add(schTeacherTypeButton);
		add(schTeacherTypeButton);

		label_Stu = new JLabel("学生");
		label_Stu.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Stu.setBounds(164, 193, 100, 31);
		add(label_Stu);

		label_Tea = new JLabel("任课老师");
		label_Tea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Tea.setBounds(164, 233, 100, 31);
		add(label_Tea);

		label_Ins = new JLabel("院系教务老师");
		label_Ins.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Ins.setBounds(164, 273, 100, 31);
		add(label_Ins);

		label_Sch = new JLabel("学校教务老师");
		label_Sch.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label_Sch.setBounds(164, 312, 100, 31);
		add(label_Sch);

		/*
		String institutes[] = CurrentState.getInstitute();
		comboBox_Ins = new JComboBox<String>(institutes);
		comboBox_Ins.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		comboBox_Ins.setBounds(new Rectangle(120, 250, 124, 30));
		add(comboBox_Ins);
		 */
		String institutes[] = CurrentState.getInstitute();
		comboBox_Ins = new JComboBox<String>(institutes);
		comboBox_Ins.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		MyComboBox<String> insTable = new MyComboBox<>(comboBox_Ins,
				new Rectangle(120, 360, 124, 30), "请选择院系");
		add(insTable);
		confirmButton = new MyButton("确认");
		confirmButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		confirmButton.setBounds(64, 420, 60, 28);
		confirmButton.addActionListener(new ConfirmListener());
		add(confirmButton);

		resetButton = new MyButton("重置");
		resetButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		resetButton.setBounds(135, 420, 60, 28);
		resetButton.addActionListener(new ResetListener());
		add(resetButton);

		btmassImportStudent = new MyButton("导入学生");
		btmassImportStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				massImport(ImportType.STUDENT);
			}
		});

		btmassImportStudent.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btmassImportStudent.setBounds(225, 420, 83, 28);
		add(btmassImportStudent);

		btmassImportTeacher = new MyButton("导入老师");
		btmassImportTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				massImport(ImportType.TEACHER);
			}
		});

		btmassImportTeacher.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btmassImportTeacher.setBounds(325, 420, 83, 28);
		add(btmassImportTeacher);
		JPanel head = new UserHead();
		head.setBounds(510, 0, 300, 72);
		add(head);

		label = new JLabel("此次添加的用户：");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		label.setBounds(10, 10, 120, 20);
		head.add(label);

		String[] tableHead = new String[] { "", "", "", "" };
		table = new JTable(new DefaultTableModel(rowData, tableHead) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		table.setRowHeight(30);
		table.setGridColor(new Color(240, 240, 240));
		table.getColumnModel().setColumnMargin(2);
		table.setRowMargin(2);
		table.setOpaque(false);
		table.setBorder(null);
		tableScrollPane = new JScrollPane();
		tableScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setBounds(518, 54, 310, 359);
		tableScrollPane.setViewportView(table);
		tableScrollPane.setBorder(null);
		add(tableScrollPane);
		text_Id.addKeyListener(new IdKeyListener());
		reset();
	}

	/**
	 * 提交选项的监听
	 * @author Xc
	 *
	 */
	class ConfirmListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Thread() {
				public void run() {
					submit();
				}
			}.start();

		}
	}

	/**
	 * 重置选项的监听
	 * @author Xc
	 *
	 */
	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			reset();
		}
	}

	/**
	 * 重置选项
	 */
	private void reset() {
		text_Id.setText("");
		text_Name.setText("");
		bg_Gender.setSelected(maleButton.getModel(), true);
		bg_Type.setSelected(stuTypeButton.getModel(), true);
		comboBox_Ins.setSelectedIndex(0);
	}

	/**
	 * 
	 * @return 性别
	 */
	private String getGender() {
		String gender;
		if (maleButton.isSelected()) {
			gender = "男";
		} else {
			gender = "女";
		}
		return gender;
	}

	/**
	 * 
	 * @param importType 
	 */
	private void massImport(int importType) {
		try {
			boolean flag = false;
			JFileChooser jf = new JFileChooser("请选择文件");
			jf.setDialogTitle("请选择要导入的文件");
			String[] saveType = new String[] { "xls" }; //
			jf.setFileFilter(new FileNameExtensionFilter("Excel表单文件(*.xls)",
					saveType));
			jf.setAcceptAllFileFilterUsed(false);
			int result = jf.showOpenDialog(null);
			jf.setVisible(true);
			File selectedFile = null;
			selectedFile = jf.getSelectedFile();
			if (selectedFile!=null){
				MainFrameUI.loadingPanel.setMessage("正在导入中..");
				MainFrameUI.showWating();			
			}
			
			switch (importType) {
			case ImportType.TEACHER:
				ArrayList<TeacherVO> teacherList = admin.addTeacher(selectedFile);
				if (teacherList!=null){
					flag = true;
					for (TeacherVO teacher:teacherList){
						String[] rowData = new String[] { teacher.getTea_Id()+"", teacher.getName(), teacher.getInstitution(),
								teacher.getTypeString() };
						((DefaultTableModel) table.getModel()).addRow(rowData);
					}
				}
				break;
			case ImportType.STUDENT:
				ArrayList<StudentVO> studentList = admin.addStudent(selectedFile);
				if (studentList!=null){
					flag = true;
					for (StudentVO student :studentList){
						String[] rowData = new String[] { student.getStu_Id()+"", student.getName(), student.getInstitute(),
								Constant.UserTypeString.STUDENT_STRING };
						((DefaultTableModel) table.getModel()).addRow(rowData);
					}
				}
			}
			if (flag) {
				MainFrameUI.hideWating();
				MainFrameUI.loadingPanel.setMessage("正在读取数据..");
				JOptionPane.showMessageDialog(null, "导入成功");
			} else {
				MainFrameUI.hideWating();
				MainFrameUI.loadingPanel.setMessage("正在读取数据..");
				JOptionPane.showMessageDialog(null, "导入失败，请重试");
			}

		} catch (NullPointerException e) {

		} catch (BiffException | IOException e1) {
			JOptionPane.showMessageDialog(null, "选择文件时遇到意外，请重试");
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @return 用户类型
	 */
	private int getUserType() {
		int userType;
		if (stuTypeButton.isSelected()) {
			userType = Constant.UserType.STUDENT;
		} else if (teacherTypeButton.isSelected()) {
			userType = Constant.UserType.TEACHER;
		} else if (insTeacherTypeButton.isSelected()) {
			userType = Constant.UserType.INS_TEACHER;
		} else if (schTeacherTypeButton.isSelected()) {
			userType = Constant.UserType.SCH_TEACHER;
		} else {
			userType = 2127483647;
		}
		return userType;
	}

	private String getUserTypeString() {
		String userType;
		if (stuTypeButton.isSelected()) {
			userType = Constant.UserTypeString.STUDENT_STRING;
		} else if (teacherTypeButton.isSelected()) {
			userType = Constant.UserTypeString.TEACHER_STRING;
		} else if (insTeacherTypeButton.isSelected()) {
			userType = Constant.UserTypeString.INS_TEACHER_STRING;
		} else if (schTeacherTypeButton.isSelected()) {
			userType = Constant.UserTypeString.SCH_TEACHER_STRING;
		} else {
			userType = "ERROR";
		}
		return userType;
	}

	/**
	 * 提交
	 */
	private void submit() {
		if (comboBox_Ins.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "请选择院系");
			return;
		} else if (comboBox_Ins.getSelectedIndex() == 1
				&& stuTypeButton.isSelected()) {
			JOptionPane.showMessageDialog(null, "学生的院系不能为公共课程");
			return;
		} else if (comboBox_Ins.getSelectedIndex() == 1
				&& insTeacherTypeButton.isSelected()) {
			JOptionPane.showMessageDialog(null, "院系教务老师的院系不能为公共课程");
			return;
		} else if (comboBox_Ins.getSelectedIndex() != 1
				&& schTeacherTypeButton.isSelected()) {
			JOptionPane.showMessageDialog(null, "学校教务老师的院系只能为公共课程");
			return;
		}

		String idString = text_Id.getText();

		int id = Integer.parseInt(idString);
		String name = text_Name.getText();
		int userType = getUserType();
		String institute = (String) comboBox_Ins.getSelectedItem();
		int ins_id = CurrentState.getInsId(institute);
		try {
			boolean flag;
			if (userType==Constant.UserType.STUDENT&&id<=100000){
				JOptionPane.showMessageDialog( null, "学生学号位数不低于6位");
				return;
			}
			if (userType==Constant.UserType.TEACHER&&id<1000&id>100000){
				JOptionPane.showMessageDialog(null, "教师学号位数不得超过6位");
				return;
			}				
			MainFrameUI.loadingPanel.setMessage("正在添加信息..");
			MainFrameUI.showWating();
			switch (userType) {
			case Constant.UserType.STUDENT:
				flag = admin.addStudent(new StudentVO(id, name, idString
						.toCharArray(), 1, ins_id, "default_ins", getGender()));
				break;
			default:
				flag = admin.addTeacher(new TeacherVO(id, ins_id, name,
						idString.toCharArray(), "default_ins", userType,
						getGender()));
			}
			MainFrameUI.hideWating();
			if (flag) {
				JOptionPane.showMessageDialog(null, "添加成功");
				String[] rowData = new String[] { idString, name, institute,
						getUserTypeString() };
				((DefaultTableModel) table.getModel()).addRow(rowData);
				reset();
			} else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}

		} catch (Exception e) {
			MainFrameUI.hideWating();
			MainFrameUI.showError();
			e.printStackTrace();

		}
	}
}