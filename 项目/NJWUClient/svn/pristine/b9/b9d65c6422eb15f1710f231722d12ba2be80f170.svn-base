package presentation.teacherui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import presentation.uielements.MyTable;
import presentation.uielements.MyTableScrollerPane;
import presentation.uielements.tablehead.RecordHead;
import vo.LessonRecordVO;
import vo.LessonUniqueVO;
import businesslogicservice.teacherblservice.TeacherBlService;
/**
 * 录入成绩界面
 * 
 * @author luck
 *
 */
public class Tea_RecordScore extends Tea_ShowPanel{
	final static String REDO = "<Html><Font color=\"blue\">重新登记</Font></Html>";
	final static String SAVE = "<Html><Font color=\"blue\">保存</Font></Html>";;
	MyTable anotherTable;
	JScrollPane anotherTablePane;
	String[][] anotherRowData;
	ArrayList<LessonRecordVO> unRecordedcList = new ArrayList<>();
	ArrayList<LessonRecordVO> recordedList = new ArrayList<>();
	LessonUniqueVO[] myLessons;
	int les_id=0;
	JComboBox<LessonUniqueVO> comboBox;
	public Tea_RecordScore(TeacherBlService teacher) {
		super(teacher);
		tableHead = new String[] { "", "", "", "" };
		new Thread(){
			public void run(){
				MainFrameUI.loadingPanel.setMessage("正在获取您的课程...");
				MainFrameUI.showWating();
				initialComboBox();
				initialTable();			
				MainFrameUI.hideWating();
			}
		
		}.start();
		
	}
	/**
	 * 初始化ComboBox
	 */
	public void initialComboBox() {
		try {
			Iterator<LessonUniqueVO> lessons = teacher.showMyLesson();
			ArrayList<LessonUniqueVO> tempList = new ArrayList<>();
			while (lessons.hasNext()) {
				tempList.add(lessons.next());
			}
			myLessons = new LessonUniqueVO[tempList.size() + 1];
			myLessons[0] = new LessonUniqueVO(0,0, "请选择您的课程", 0, 0, 0, 0, null,
					null, null, 0, 0,0,0,0,null,1);
			for (int i = 0; i < tempList.size(); i++) {
				myLessons[i + 1] = tempList.get(i);
			}
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
		comboBox = new JComboBox(myLessons);
		comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		MyComboBox<LessonUniqueVO> myBox = new MyComboBox<>(comboBox, new Rectangle(76,10,162,21),"请选择你的课程");
		comboBox.addActionListener(new CombListener());
		add(myBox);
	}
	/**
	 * 获取数据
	 */
	
	public void getData(){
		try {
			Iterator<LessonRecordVO> records = teacher.chooseLesson(les_id);
			unRecordedcList.clear();
			recordedList.clear();
			while (records.hasNext()){
				LessonRecordVO vo = records.next();
				if (vo.getScore()==0){
					unRecordedcList.add(vo);
				} else {
					recordedList.add(vo);
				}
			}
		} catch (RemoteException e1) {
			MainFrameUI.showError();
			e1.printStackTrace();
		}		
	}
	/**
	 * Combox监听
	 * @author luck
	 *
	 */
	class CombListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			LessonUniqueVO lesson = (LessonUniqueVO) comboBox.getSelectedItem();
			les_id = lesson.getLes_Id();
			if (lesson.getLes_Id_Ab() != 0) {
				new Thread(){
					public void run(){
						MainFrameUI.loadingPanel.setMessage("正在获取您的学生...");
						MainFrameUI.showWating();
						getData();
						refresh();	
						MainFrameUI.hideWating();
						table.requestFocus();
					}
					
				}.start();
			}
	
		}
	}
	/*
	 * 更新信息
	 */
	public void update(){
		Iterator<LessonRecordVO> records = teacher.showNewScore();
		unRecordedcList.clear();
		recordedList.clear();
		while (records.hasNext()){
			LessonRecordVO vo = records.next();
			if (vo.getScore()==0){
				unRecordedcList.add(vo);
			} else {
				recordedList.add(vo);
			}
		}
		refresh();
	}
	/**
	 * 刷新
	 */
	public void refresh(){
		fillRowData();
		table.refresh(rowData, tableHead,2);
		table.getSelectionModel().setSelectionInterval(0, 0);
		anotherTable.refresh(anotherRowData,tableHead);
	}
	/**
	 * 表格的键盘监听
	 * @author luck
	 *
	 */
	class TableKeyListener implements KeyListener{
		String value="";
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				value = "";
				save(row, column);
			} else {
				if (e.getKeyChar()>=48&&e.getKeyChar()<=57){
					value = value+e.getKeyChar();
					table.setValueAt(value, row, 2);
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					value = value.substring(0, value.length()-1);
					table.setValueAt(value, row, 2);

				}
			} 
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
	}
	/**
	 * 保存
	 * @param row
	 * @param column
	 */
	public void save(int row, int column){
		int stu_id = Integer.parseInt(rowData[row][0]);
		int score = -1;
		try {
			score = Integer.parseInt((String) table.getModel().getValueAt(row, 2));
			if (score>100){
				JOptionPane.showMessageDialog(null, "分数最大为100");
				return;
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请确保您输入的是数字");
			return ;
		}
		try {
			if(teacher.addScore(stu_id,score)){
				update();
			} else {
				JOptionPane.showMessageDialog(null, "更新失败");
			}
			
		} catch (RemoteException e1) {
			MainFrameUI.showError();
			e1.printStackTrace();
		}
	}
	/**
	 * 表格的鼠标监听
	 * @author luck
	 *
	 */
	class TableListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column =table.getSelectedColumn();
			int score = -1;
			if (rowData[row][column].equals(SAVE)){
				
				save(row, column);
			} 
		}			

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
		}
	}
	/**
	 * 另外一个表格的监听
	 * @author luck
	 *
	 */
	class AnotherTableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = anotherTable.getSelectedRow();
			int column =anotherTable.getSelectedColumn();
			int score = -1;
			if (anotherRowData[row][column].equals(REDO)){
				int stu_id = Integer.parseInt(anotherRowData[row][0]);
				try {
					if(teacher.addScore(stu_id,0)){
						update();
					} else {
						JOptionPane.showMessageDialog(null, "更新失败");
					}
				} catch (RemoteException e1) {
					MainFrameUI.showError();
					e1.printStackTrace();
				}
			}	
			table.requestFocus();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
	}
	@Override
	public void setThead() {
		RecordHead tHead = new RecordHead();
		tHead.setBounds(4, 33, 845,110);
		add(tHead);
		
		MyButton btSubmit = new MyButton("提交");
		btSubmit.setBounds(642, 451, 75, 23);
		btSubmit.addActionListener(new SubmitListener());
		add(btSubmit);
		
		MyButton btClear = new MyButton("撤销此次修改");
		btClear.setBounds(725, 451, 116, 23);
		btClear.addActionListener(new ClearListener());
		add(btClear);
		
		JLabel label = new JLabel("课程名：");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		label.setBounds(12, 13, 54, 15);
		add(label);
	}

	@Override
	public void fillRowData() {
		rowData = new String[unRecordedcList.size()][4];
		anotherRowData = new String[recordedList.size()][5];
		int index=0;
		for (LessonRecordVO record: unRecordedcList){
			rowData[index][0] = record.getStu_id()+"";
			rowData[index][1] = record.getStu_name();
			rowData[index][2] = record.getScore()+"";
			rowData[index][3] = SAVE;
			index++;
		}
		index = recordedList.size()-1;
		for (LessonRecordVO record: recordedList){
			anotherRowData[index][0] = record.getStu_id()+"";
			anotherRowData[index][1] = record.getStu_name();
			anotherRowData[index][2] = record.getScore()+"";
			anotherRowData[index][3] = REDO;
			index--;
		}
	}

	@Override
	public void initialTable() {
		fillRowData();
		table = new MyTable(rowData, tableHead,2);
		table.addMouseListener(new TableListener());
		table.addKeyListener(new TableKeyListener());
		tableScrollPane = new MyTableScrollerPane(table);
		tableScrollPane.setBounds(14, 135, 410, 306);
		add(tableScrollPane);
		anotherTable= new MyTable(anotherRowData,tableHead);
		anotherTable.addMouseListener(new AnotherTableListener());
		anotherTablePane = new MyTableScrollerPane(anotherTable);
		anotherTablePane.setBounds(422, 135, 419, 306);
		add(anotherTablePane);
		table.requestFocus();
	}
	class ClearListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(){
				public void run(){
					MainFrameUI.loadingPanel.setMessage("正在处理请求...");
					MainFrameUI.showWating();
					getData();
					refresh();
					MainFrameUI.hideWating();
				}
			}.start();
			
		}
		
	}
	class SubmitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(){
				public void run(){
					MainFrameUI.loadingPanel.setMessage("正在保存成绩...");
					MainFrameUI.showWating();
					try {
						if(teacher.recordScore()){
							MainFrameUI.hideWating();
							JOptionPane.showMessageDialog(null, "保存成功");
							MainFrameUI.loadingPanel.setMessage("正在更新数据...");
							MainFrameUI.showWating();
							getData();
							refresh();
							MainFrameUI.hideWating();
						}else {
							MainFrameUI.hideWating();
							JOptionPane.showMessageDialog(null, "保存失败...");
						}
					} catch (RemoteException e1) {
						MainFrameUI.showError();
						e1.printStackTrace();
					}
				}
				
			}.start();
			
		}
		
	}
	@Override
	public void setTableWidth() {
	}
}
