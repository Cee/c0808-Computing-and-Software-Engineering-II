package presentation.adminui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import presentation.mainui.MainFrameUI;
import presentation.uielements.LoadingPanel;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import presentation.uielements.MyTable;
import utility.CurrentState;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.adminblservice.AdminblService;

public abstract class Admin_User extends JPanel {
	protected JTable table;
	protected AdminblService admin;
	protected String[] type = { "用户类别", "学生", "教师" };
	protected String[] institute;
	protected String[] grade = { "请选择年级", "大一", "大二", "大三", "大四" };
	protected JComboBox typeBox;
	protected JComboBox instituteBox;
	protected JComboBox gradeBox;
	protected JLabel tHead;
	protected String tableHead[] = { "", "", "", "", "", "", ""};
	protected JTextField textField;
	protected String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;\"";
	protected MyButton button;
	protected MyComboBox<String> gradeComboBox;
	protected int selectedType = -1;
	protected int searchI=0;
	protected int searchJ=0;
	JScrollPane tableScrollPane;
	public void search(){
		String searchString = textField.getText();
		int length = 0;
		switch (typeBox.getSelectedIndex()) {
		case 1:
			length = sList.size();
			break;
		case 2:
			length = tList.size();
			break;
		default:
			break;
		}
		for (;searchI< length;searchI++ ){
			for (;searchJ< 7; searchJ++){
				if (rowData[searchI][searchJ]!=null && rowData[searchI][searchJ].indexOf(searchString)>=0){
					table.getSelectionModel().setSelectionInterval(searchI, searchI);
					int max = tableScrollPane.getVerticalScrollBar().getMaximum();
					int min = tableScrollPane.getVerticalScrollBar().getMinimum();
					int size = length;
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
	protected  void fillrowData(String[][] rowdata) {
		table.setVisible(false);
		table.setModel(new MyModifyTableModel(rowdata,tableHead));
		setColumnWidth();
		table.setVisible(true);
		setOperationColumn();
	}
	public abstract TableModel getTableModel();
	
	public abstract void setThead();

	protected abstract void setOperationColumn();

	protected abstract void addListeners();

	public Admin_User(AdminblService admin) {
		this.admin = admin;
		setBounds(201, 128, 851, 495);
		setOpaque(false);
		setLayout(null);
		setThead();
		table = new JTable(getTableModel());
		table.setRowHeight(30);
		table.setGridColor(new Color(240, 240, 240));
		table.getColumnModel().setColumnMargin(2);
		table.setRowMargin(2);
		table.setOpaque(false);
		table.setBorder(null);
		setColumnWidth();
		
		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(64, 121, 720, 331);
		tableScrollPane.setViewportView(table);
		tableScrollPane.setBorder(null);
//		tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(tableScrollPane);
		textField = new JTextField();
		textField.setBounds(535, 25, 153, 31);
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		add(textField);
		textField.setColumns(10);

		button = new MyButton("查询");
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		button.setBounds(688, 25, 72, 30);
		add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		

		typeBox = new JComboBox(type);
		typeBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		MyComboBox<String> typeComboBox = new MyComboBox<>(typeBox, new Rectangle(64, 30, 81, 21), "用户类别");
		add(typeComboBox);
		typeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeBox.getSelectedIndex() == 1) {
					gradeComboBox.setVisible(true);
				} else {
					gradeComboBox.setVisible(false);
				}

			}
		});
		typeBox.addItemListener(new RefreshListener());

		institute = CurrentState.getInstitute();
		instituteBox = new JComboBox(institute);
		instituteBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		MyComboBox<String> insComboBox = new MyComboBox<>(instituteBox, new Rectangle(165, 30, 111, 21), "请选择院系");
		add(insComboBox);
		instituteBox.addItemListener(new RefreshListener());

		gradeBox = new JComboBox(grade);
		gradeBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		gradeComboBox = new MyComboBox<>(gradeBox, new Rectangle(301, 30, 104, 21), "请选择年级");
		add(gradeComboBox);
		gradeComboBox.setVisible(false);
		gradeBox.addItemListener(new RefreshListener());

		table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		table.setDefaultRenderer(Object.class, new MyTableStyle());
		
		addListeners();
	}

	protected void setColumnWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(16);
		table.getColumnModel().getColumn(1).setPreferredWidth(16);
		
	}

	class MyTableStyle extends DefaultTableCellRenderer {
		public MyTableStyle() {
			setHorizontalAlignment(CENTER);
		}
	}

	class RefreshListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				new Thread(){
					public void run(){
						refreshTable();
					}
				}.start();
			}
		}

	}
	String[][] rowData;
	public void setBg(){
		int count = table.getColumnModel().getColumnCount();
		for (int i = 0; i < count ; i ++){
			table.getColumnModel().getColumn(i).setCellRenderer(MyTable.dc);
		}
	}
	protected void refreshTable() {

		try {
			switch (typeBox.getSelectedIndex()) {
			case 1:
				if (instituteBox.getSelectedIndex() != 0
						&& gradeBox.getSelectedIndex() != 0) {
					int ins_id = CurrentState.getInsId((String) instituteBox
							.getSelectedItem());
					int grade = gradeBox.getSelectedIndex();
					MainFrameUI.loadingPanel.setMessage("正在读取信息...");
					MainFrameUI.showWating();
					Iterator<StudentVO> iter = admin.showStudentofins(ins_id,
							grade);
					sList = new ArrayList<StudentVO>();
					selectedType = 0 ;
					while (iter.hasNext()) {
						sList.add(iter.next());
					}
					
					rowData = new String[sList.size()][7];
					for (int i = 0; i < sList.size(); ++i) {
						rowData[i][2] = String
								.valueOf(sList.get(i).getStu_Id());
						rowData[i][3] = sList.get(i).getName();
						rowData[i][4] = sList.get(i).getGender();
						rowData[i][5] = sList.get(i).getInstitute();
						rowData[i][6] = sList.get(i).getTypeString();
					}
					MainFrameUI.hideWating();
					fillrowData(rowData);
					setBg();
					repaint();
				}
				break;
			case 2:
				if (instituteBox.getSelectedIndex() != 0) {
					int ins_id = CurrentState.getInsId((String) instituteBox
							.getSelectedItem());
					MainFrameUI.loadingPanel.setMessage("正在读取信息...");
					MainFrameUI.showWating();
					Iterator<TeacherVO> iter = admin.showTeacherofins(ins_id);
					tList = new ArrayList<TeacherVO>();
					selectedType=1;
					while (iter.hasNext()) {
						tList.add(iter.next());
					}
					rowData = new String[tList.size()][7];
					for (int i = 0; i < tList.size(); ++i) {
						rowData[i][2] = String
								.valueOf(tList.get(i).getTea_Id());
						rowData[i][3] = tList.get(i).getName();
						rowData[i][4] = tList.get(i).getGender();
						rowData[i][5] = tList.get(i).getInstitution();
						rowData[i][6] = tList.get(i).getTypeString();
					}
					MainFrameUI.hideWating();
					fillrowData(rowData);

					setBg();
					repaint();
				}

			}

		} catch (RemoteException e) {
			MainFrameUI.showError();
			MainFrameUI.hideWating();
			e.printStackTrace();
		}
	}
	protected ArrayList<StudentVO> sList;
	protected ArrayList<TeacherVO> tList;
}
