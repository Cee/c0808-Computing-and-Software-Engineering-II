package presentation.teacherui;

import businesslogicservice.teacherblservice.TeacherBlService;

import javax.security.auth.Refreshable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import presentation.mainui.MainFrameUI;
import presentation.mainui.UserMainUI;
import presentation.teacherui.Tea_ShowLesson.SearchListener;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import presentation.uielements.tablehead.LessonTableHead;
import presentation.uielements.tablehead.StudentTableHead;

import utility.ExportHelper;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import vo.StudentVO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
/**
 * 教师查看学生
 * @author luck
 *
 */
public class Tea_ShowStudents extends Tea_ShowPanel {
	LessonUniqueVO[] mylessons;
	JComboBox<LessonUniqueVO> comboBox;
	ArrayList<StudentVO> myStudents = new ArrayList<>();
	public Tea_ShowStudents(TeacherBlService teacher) {
		super(teacher);
		tableHead = new String[] { "", "", "", "",""};
		setBounds(201, 128, 851, 520);
		setThead();
		initialSearch();
		initialTable();	
		new Thread(){
			public void run(){
				MainFrameUI.loadingPanel.setMessage("正在获取您的课程...");
				MainFrameUI.showWating();
				initialComboBox();
				MainFrameUI.hideWating();
					
			}
		}.start();
		
	}

	public void initialSearch() {
		JLabel label = new JLabel("学号： ");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(240, 0, 89, 41);
		add(label);
		searchField = new JTextField();
		searchField.setBounds(308, 8, 120, 28);
		add(searchField);
		searchField.setColumns(10);
		MyButton button = new MyButton("查询");
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		button.setBounds(437, 6, 75, 29);
		add(button);
		button.addActionListener(new SearchListener());
		searchField.addKeyListener(new SearchKeyListener());
	}
	class SearchKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				search();
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
	}
	public void search(){
		int stu_id = 0 ;
		if (searchField.getText().equals("")){
			JOptionPane.showMessageDialog(null, "请输入搜索信息");
		}
		else {
			try {
				stu_id = Integer.parseInt(searchField.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "学生Id必须为数字且不能超过9位");
				return;
			}
			for (StudentVO vo:myStudents){
				if (vo.getStu_Id()==stu_id){
					int index = myStudents.indexOf(vo);
					table.getSelectionModel().setSelectionInterval(index, index);
					int max = tableScrollPane.getVerticalScrollBar().getMaximum();
					int min = tableScrollPane.getVerticalScrollBar().getMinimum();
					int size = myStudents.size();
					index = (max-min)/size*index;
					tableScrollPane.getVerticalScrollBar().setValue(index);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "没有该学生");
		}
	}
	class SearchListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			search();
		}
		
	}
	public void initialComboBox() {
		try {
			Iterator<LessonUniqueVO> lessons = teacher.showMyLesson();
			ArrayList<LessonUniqueVO> tempList = new ArrayList<>();
			while (lessons.hasNext()) {
				tempList.add(lessons.next());
			}
			mylessons = new LessonUniqueVO[tempList.size() + 1];
			mylessons[0] = new LessonUniqueVO(0,0, "请选择您的课程", 0, 0, 0, 0, null,
					null, null, 0, 0,0,0,0,null,1);
			for (int i = 0; i < tempList.size(); i++) {
				mylessons[i + 1] = tempList.get(i);
			}
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
		comboBox = new JComboBox(mylessons);
		comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		MyComboBox<LessonUniqueVO> myBox = new MyComboBox<>(comboBox, new Rectangle(76,10,162,21),"请选择你的课程");
		comboBox.addActionListener(new ComobListener());
		add(myBox);
	}

	class ComobListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LessonUniqueVO vo = (LessonUniqueVO) comboBox.getSelectedItem();
			if (vo.getLes_Id_Ab() != 0) {
				new Thread(){
					public void run(){
						LessonUniqueVO vo = (LessonUniqueVO) comboBox.getSelectedItem();
						MainFrameUI.loadingPanel.setMessage("正在获取您的学生...");
						MainFrameUI.showWating();
						try {
							Iterator<StudentVO>  students= teacher.showMyStudent(vo.getLes_Id());
							while (students.hasNext()){
								myStudents.add(students.next());
							}
						} catch (RemoteException e1) {
							MainFrameUI.showError();
							e1.printStackTrace();
						}			
						refresh();
						MainFrameUI.hideWating();
					}
				}.start();
			
			}
		
		} 
	}
	public void refresh(){
		fillRowData();
		table.refresh(rowData, tableHead);
		table.repaint();
	}
	@Override
	public void setThead() {
		StudentTableHead tHead = new StudentTableHead();
		tHead.setBounds(22, 31, 845, 96);
		add(tHead);
	}

	@Override
	public void fillRowData() {
		rowData = new String[myStudents.size()][5];
		int index=0;
		for (StudentVO vo:myStudents){
			rowData[index][0] = vo.getStu_Id()+"";
			rowData[index][1] = vo.getName();
			rowData[index][2] = vo.getInstitute();
			rowData[index][3] = vo.getGender();
			rowData[index][4] = " ";
			index++;
		}
	}


	@Override
	public void setTableWidth() {
		tableScrollPane.setBounds(30, 100, 600, 374);
		JLabel label = new JLabel("院系：");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		label.setBounds(28, 14, 54, 15);
		add(label);

		JButton btnxls = new MyButton("导出");
		btnxls.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnxls.setBounds(526, 5, 75, 29);
		btnxls.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (myStudents.isEmpty()){
					JOptionPane.showMessageDialog(null, "请先选择课程,或者您的课程还没有学生");
					return;
				}
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("导出为");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setDialogType(JFileChooser.SAVE_DIALOG);
				chooser.showDialog(null, null);
				String[] saveType = new String[] { "xls" }; //
				chooser.setFileFilter(new FileNameExtensionFilter("Excel表单文件(*.xls)",
						saveType));
				chooser.setAcceptAllFileFilterUsed(false);
				File file = chooser.getSelectedFile();
				try {
						ExportHelper.exportRecord(new FileOutputStream(file), myStudents);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "导出失败");
					e1.printStackTrace();
					return;
				}
				JOptionPane.showMessageDialog(null, "导出成功");
			}
		});
		add(btnxls);		
	}
}
