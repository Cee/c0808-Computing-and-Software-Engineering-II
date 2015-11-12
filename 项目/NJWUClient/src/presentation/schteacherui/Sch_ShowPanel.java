package presentation.schteacherui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import presentation.uielements.UserShowPanel;
import utility.CurrentState;
import vo.LessonAbstractVO;
import vo.LessonUniqueVO;
import vo.StudentVO;
import vo.TeacherVO;
import vo.VO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;

public abstract class Sch_ShowPanel extends UserShowPanel {
	int searchI=0;
	int searchJ=0;
	protected final int STUDENT = 0;
	protected final int TEACHER = 1;
	protected final int LESSON =2;
	protected final int PLAN = 3;
	protected JTextField textField;
	ArrayList<String[]> rowList = new ArrayList<>();
	JLabel label_Institute;
	JComboBox<String> comboBox_Ins;
	MyComboBox<String> myInsBox;
	SchTeacherBlService schTeacher;
	int ins_id;
	int grade;
	int showType;
	int columnNum=4;
	public Sch_ShowPanel(SchTeacherBlService schTeacher,int columnNum){
		this.columnNum = columnNum;
		this.schTeacher = schTeacher;
		tableHead = new String[columnNum];
		for (int i = 0 ; i < tableHead.length; i++){
			tableHead[i] = "";
		}	
		addComboBox();
		addSearch();
		rowData = new String[1][columnNum];
		fillRowData();
		initialTable();
	}
	public void addComboBox(){
		label_Institute = new JLabel("院系:");
		label_Institute.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_Institute.setBounds(10, 70, 60, 28);
		add(label_Institute);
		String institutes[] = CurrentState.getInstitute();
		comboBox_Ins = new JComboBox<String>(institutes);
		comboBox_Ins.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		myInsBox = new MyComboBox<>(comboBox_Ins, new Rectangle(65, 70, 124, 31), institutes[0]);
		comboBox_Ins.setSelectedIndex(0);
		add(myInsBox);
		comboBox_Ins.addActionListener(new comboBoxListener());
	}
	
	protected void refresh(int type) throws RemoteException{
		ArrayList<VO> infos = new ArrayList<>();
		switch (type) {
		case STUDENT:
			Iterator<StudentVO> studentIter = schTeacher.showStudentList(ins_id,grade);
			while (studentIter.hasNext()){
				infos.add(studentIter.next());
			}
			break;
		case TEACHER:
			Iterator<TeacherVO> teacherIter = schTeacher.showTeacherList(ins_id);
			while (teacherIter.hasNext()){
				infos.add(teacherIter.next());
			}
			break;
		case LESSON:
			Iterator<LessonUniqueVO> lessonIter = schTeacher.showLessonList(ins_id);
			while (lessonIter.hasNext()){
				infos.add(lessonIter.next());
			}
			break;
		case PLAN:
			Iterator<LessonAbstractVO> lessonIterator = schTeacher.showPlan(ins_id).getLessons();
			while (lessonIterator.hasNext()) {
				infos.add(lessonIterator.next());
			}
			break;
		default:
			return;
		}
		getRowList(infos);
		rowData = new String[rowList.size()][columnNum];// 每行每列的数据设置在这里！！！！
		fillRowData();
		table.refresh(rowData,tableHead);
		setTableWidth();
	}
	protected void getResponse(){
		if (ins_id != (CurrentState.getInsId((String) comboBox_Ins
				.getSelectedItem()))){
				ins_id = (CurrentState.getInsId((String) comboBox_Ins
						.getSelectedItem()));
				try {
					refresh(showType);
				} catch (RemoteException e1) {
					MainFrameUI.showError( );
					e1.printStackTrace();
				}
			}
	}
	class comboBoxListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(){
				public void run(){
					MainFrameUI.loadingPanel.setMessage("正在读取数据...");
					MainFrameUI.showWating();
					getResponse();		
					MainFrameUI.hideWating();
				}
			}.start();
			
		}
	}
	@Override
	public void setThead() {
		String thCss = " style=\"background-color:#d2bbd2;width:179px;height:40px;text-align:center\"";
		JLabel tHead = new JLabel(
				"<HTML>" +
				"<table contenteditable=\"true\">" + 
					"<tr>" +
					"<th"+thCss+">学工号</th>" +
					"<th"+thCss+">姓   名</th>" +
					"<th"+thCss+">性   别</th>" +
					"<th"+thCss+">用户类型</th>" +
					"</tr>"+
				"</table>" +
				"</HTML>");
		tHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tHead.setBounds(10, 105, 704, 40);
		add(tHead);		
	}
	public void addSearch(){
		textField = new JTextField();
		textField.setBounds(517, 73, 94, 21);
		add(textField);
		textField.setColumns(10);
		
		MyButton btSearch = new MyButton("查询");
		btSearch.setBounds(621, 72, 78, 23);
		add(btSearch);		
		btSearch.addActionListener(new SearchListener());
	}

	@Override
	public void fillRowData() {
		for (int i = 0; i < rowList.size(); i++) {
			for (int j = 0 ; j<columnNum; j++){
				rowData[i][j]= rowList.get(i)[j];
			}
		}
	}
	class SearchListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			search();
		}
		
	}
	
	public void search(){
		String searchString = textField.getText();
		for (;searchI< rowList.size();searchI++ ){
			for (;searchJ< columnNum; searchJ++){
				if (rowData[searchI][searchJ]!=null && rowData[searchI][searchJ].indexOf(searchString)>=0){
					table.getSelectionModel().setSelectionInterval(searchI, searchI);
					int max = tableScrollPane.getVerticalScrollBar().getMaximum();
					int min = tableScrollPane.getVerticalScrollBar().getMinimum();
					int size = rowList.size();
					int location = (max-min)/size*searchI;
					tableScrollPane.getVerticalScrollBar().setValue(location);
					searchJ++;
					return;
				}
			}
			searchJ=0;
		}
		searchI=0;
		searchJ=0;
	}
	protected abstract void getRowList(ArrayList<VO> infos) ;
	
	public void setTableWidth() {
		tableScrollPane.setBounds(12, 145, 718, 360);
	}

}
