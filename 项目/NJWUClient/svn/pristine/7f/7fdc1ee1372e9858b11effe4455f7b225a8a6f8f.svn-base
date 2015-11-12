package presentation.teacherui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.tablehead.LessonTableHead;
import vo.LessonUniqueVO;
import businesslogicservice.teacherblservice.TeacherBlService;
/*
 * 教师查看课程
 */
public class Tea_ShowLesson extends Tea_ShowPanel {
	private final String command = "<Html><font color=\"blue\">编辑详细</font></Html>";
	private ArrayList<LessonUniqueVO> myLessons = new ArrayList<>();

	public Tea_ShowLesson(TeacherBlService teacher) {
		super(teacher);
		initialSearch();
		tableHead = new String[] { "", "", "", "", "", "" };
		new Thread(){
			public void run(){
				MainFrameUI.loadingPanel.setMessage("正在获取您的课程...");
				MainFrameUI.showWating();
				refresh();
				fillRowData();
				initialTable();
				MainFrameUI.hideWating();
				table.addMouseListener(new TableListener());			
			}
		}.start();
	
	}

	public void initialSearch() {
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
		button.addActionListener(new SearchListener());
		add(button);
		searchField.addKeyListener(new KeySearchListener());
	}

	class KeySearchListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			search();
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

	}

	public void search() {
		int les_id = -1;
		try {
			les_id = Integer.parseInt(searchField.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "课程号必须为数字且不能超过8位");
		}
		for (LessonUniqueVO lesson : myLessons) {
			if (lesson.getLes_Id_Ab() == les_id) {
				TeaMainUI.tea_EditLesson = new Tea_EditLesson(Tea_ShowLesson.this, teacher,
						lesson, true);
				TeaMainUI.tea_EditLesson.setBounds(201, 128, 851, 495);
				Tea_ShowLesson.this.setVisible(false);
				MainFrameUI.userMainUI.add(TeaMainUI.tea_EditLesson, 0);
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "没有该课程");

	}

	class SearchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			search();

		}

	}

	@Override
	public void setThead() {
		LessonTableHead tHead = new LessonTableHead();
		tHead.setBounds(4, 33, 845, 96);
		add(tHead);
	}

	public void refresh() {
		myLessons.clear();
		try {
			Iterator<LessonUniqueVO> lessons = teacher.showMyLesson();
			while (lessons.hasNext()) {
				myLessons.add(lessons.next());
			}
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
	}


	class TableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (rowData[table.getSelectedRow()][table.getSelectedColumn()]
					.equals(command)) {
				TeaMainUI.tea_EditLesson = new Tea_EditLesson(Tea_ShowLesson.this, teacher,
						myLessons.get(table.getSelectedRow()), true);
				TeaMainUI.tea_EditLesson.setBounds(201, 128, 851, 495);
				Tea_ShowLesson.this.setVisible(false);
				MainFrameUI.userMainUI.add(TeaMainUI.tea_EditLesson, 0);
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}
	@Override
	public void fillRowData() {
		rowData = new String[myLessons.size()][6];
		int index = 0;
		for (LessonUniqueVO lesson : myLessons) {
			rowData[index][0] = lesson.getLessonId();
			rowData[index][1] = lesson.getLessonName();
			rowData[index][2] = lesson.getStu_num();
			rowData[index][3] = lesson.getTime();
			rowData[index][4] = lesson.getLocation();
			rowData[index][5] = command;
			index++;
		}
	}

	@Override
	public void setTableWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(0).setMaxWidth(115);
		table.getColumnModel().getColumn(0).setMinWidth(115);

		table.getColumnModel().getColumn(1).setPreferredWidth(261);
		table.getColumnModel().getColumn(1).setMaxWidth(261);
		table.getColumnModel().getColumn(1).setMinWidth(261);

		table.getColumnModel().getColumn(2).setPreferredWidth(117);
		table.getColumnModel().getColumn(2).setMaxWidth(117);
		table.getColumnModel().getColumn(2).setMinWidth(117);
		for (int i = 3; i <= 4; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(132);
			table.getColumnModel().getColumn(i).setMaxWidth(132);
			table.getColumnModel().getColumn(i).setMinWidth(132);
		}
		tableScrollPane.setBounds(11, 100, 839, 374);
	
	}
}
