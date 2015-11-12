package presentation.insteacherui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
/**
 * 查看课程学生
 * @author luck
 *
 */
public class Ins_CourseStuPanel extends Ins_ShowPanel {
	/**
	 * 保存当前课程号
	 */
	int les_id;
	/**
	 * 保存当前选中课程
	 */
	LessonUniqueVO lesson;
	/**
	 * 保存该院系课程
	 */
	LessonUniqueVO[] myLessons;
	JComboBox<LessonUniqueVO> comboBox;
	/**
	 * 存储学生名单
	 */
	ArrayList<LessonRecordVO> recordList = new ArrayList<LessonRecordVO>();
	/**
	 * 搜索框
	 */
	private JTextField textField;

	/**
	 * 添加JComboBox
	 */
	public void addJComboBox() {
		ArrayList<LessonUniqueVO> lessons = new ArrayList<>();
		try {
			Iterator<LessonUniqueVO> iterator = insTeacher.showLesson();
			while (iterator.hasNext()) {
				lessons.add(iterator.next());
			}
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
		myLessons = new LessonUniqueVO[lessons.size() + 1];
		for (int i = 0; i < lessons.size(); i++) {
			myLessons[i + 1] = lessons.get(i);
		}
		myLessons[0] = new LessonUniqueVO(-1, 0, "请选择课程", 0, 0, 0, 0, null,
				null, null, 0, 0, 0, 0, 0, null,1);
		JLabel label = new JLabel("选择课程");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label.setBounds(59, 23, 58, 33);
		add(label);
		comboBox = new JComboBox(myLessons);
		MyComboBox<LessonUniqueVO> myComboBox = new MyComboBox<>(comboBox, new Rectangle(117, 27, 251, 27), "请选择课程");
		comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		comboBox.addActionListener(new ComboBoxListener());
		add(myComboBox);
	}
	
	/**
	 * 获取学生列表
	 */
	public void getRecord() {
		MainFrameUI.loadingPanel.setMessage("正在获取学生...");
		MainFrameUI.showWating();
		lesson = ((LessonUniqueVO) comboBox.getSelectedItem());
		les_id = ((LessonUniqueVO) comboBox.getSelectedItem()).getLes_Id();
		try {
			recordList.clear();
			Iterator<LessonRecordVO> records = insTeacher
					.showStudentofLesson(les_id);
			while (records.hasNext()) {
				recordList.add(records.next());
			}
		} catch (RemoteException e1) {
			MainFrameUI.showError();
			e1.printStackTrace();
		}
		MainFrameUI.hideWating();
		refresh();
	}
	/**
	 * 院系的ComboBox的监听
	 * @author luck
	 *
	 */
	class ComboBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread() {
				public void run() {
					getRecord();
				}
			}.start();
		}
	}
	/**
	 * 刷新
	 */
	public void refresh() {
		fillRowData();
		table.refresh(rowData, tableHead);
		setTableWidth();
		table.repaint();
	}

	public Ins_CourseStuPanel(InsTeacherBlService insTeacher) {
		super(insTeacher);
		tableHead = new String[] { "", "", "", "" };
		new Thread() {
			public void run() {
				MainFrameUI.loadingPanel.setMessage("正在获取课程信息...");
				MainFrameUI.showWating();
				addJComboBox();
				initialTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();
						String stu_id = rowData[row][0];
						textField.setText(stu_id);
					}

				});
				MainFrameUI.hideWating();

			}
		}.start();
	}
	/**
	 * 初始化表头
	 */
	@Override
	public void setThead() {
		String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;\"";
		String thCss_1 = " style=\"background-color:#d2bbd2;width:150px;height:34px;\"";
		String thCss_2 = " style=\"background-color:#d2bbd2;width:200px;height:34px;\"";
		String thCss_3 = " style=\"background-color:#d2bbd2;width:100px;height:34px;\"";
		JLabel tHead = new JLabel("<HTML>" + "<table>" + "<th" + thCss
				+ ">学 号</th>" + "<th" + thCss_1 + ">姓 名</th>" + "<th" + thCss_2
				+ ">成  绩</th>" + "<th" + thCss_3 + ">备  注</th>" + "</table>"
				+ "</HTML>");
		tHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tHead.setBounds(56, 60, 731, 72);
		add(tHead);
		/**
		 * 删除
		 */
		MyButton btDelete = new MyButton("删除");
		btDelete.setBounds(683, 491, 73, 23);
		add(btDelete);
		btDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int stu_id = Integer.parseInt(textField.getText());
				for (LessonRecordVO vo : recordList) {
					if (vo.getStu_id() == stu_id) {
						try {
							System.out.println("ID:"+vo.getId());
							if(insTeacher.deleteStudent(vo)){
								JOptionPane.showMessageDialog(null, "删除成功");
								recordList.remove(vo);
								refresh();
							} else {
								JOptionPane.showMessageDialog(null, "删除失败");
							}
					
						} catch (RemoteException e1) {
							MainFrameUI.showError();
							e1.printStackTrace();
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "没有该学生");
			}
		});
		MyButton btAdd = new MyButton("增加");
		btAdd.setBounds(600, 491, 73, 23);
		add(btAdd);
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int stu_id = Integer.parseInt(textField.getText());
				for (LessonRecordVO vo : recordList) {
					if (vo.getStu_id() == stu_id) {
						JOptionPane.showMessageDialog(null, "已有该学生");
						break;
					}
				}
				try {
					if (insTeacher.addStudent(new LessonRecordVO(stu_id, lesson))) {
						JOptionPane.showMessageDialog(null, "添加成功");
						getRecord();
						refresh();
					} else {
						JOptionPane.showMessageDialog(null, "不存在该学生");
					}
				} catch (RemoteException e1) {
					MainFrameUI.showError();
					e1.printStackTrace();
				}
			}
		});
		textField = new JTextField();
		textField.setBounds(497, 492, 93, 21);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("学号：");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(444, 495, 43, 15);
		add(lblNewLabel);
	}

	@Override
	public void fillRowData() {
		rowData = new String[recordList.size()][4];
		for (int i = 0; i < recordList.size(); i++) {
			LessonRecordVO vo = recordList.get(i);
			rowData[i][0] = vo.getStu_id() + "";
			rowData[i][1] = vo.getStu_name();
			rowData[i][2] = vo.getScore() + "";
		}
	}

	@Override
	public void setTableWidth() {
		for (int k = 0; k < 4; k++) {
			int tableWidth;
			if (k == 0) {
				tableWidth = 115;
			} else if (k == 1) {
				tableWidth = 198;
			} else if (k == 2) {
				tableWidth = 263;
			}

			else {
				tableWidth = 131;
			}
			table.getColumnModel().getColumn(k).setPreferredWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMaxWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMinWidth(tableWidth);
		}
		tableScrollPane.setBounds(58, 120, 715, 365);
	}
}
