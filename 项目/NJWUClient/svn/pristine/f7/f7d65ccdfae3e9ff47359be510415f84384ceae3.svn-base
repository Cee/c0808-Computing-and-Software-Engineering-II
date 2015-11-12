package presentation.insteacherui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.tablehead.PlanTableHead;
import vo.LessonAbstractVO;
import vo.ModuleVO;
import vo.PlanVO;
import vo.TypeVO;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
/**
 * 
 * @author 小c
 *
 */
public class Ins_SetPlanPanel extends Ins_ShowPanel {
	private final static String EDIT = "编辑";
	private final static String SAVE = "保存";
	private PlanVO plan;
	private ArrayList<LessonAbstractVO> list = new ArrayList<>();
	private static JComboBox<ModuleVO> moduleBox;
	private static JComboBox<TypeVO> typeBox;
	private ArrayList<ModuleVO> moduleList = new ArrayList<>();
	private ArrayList<TypeVO> typeList = new ArrayList<>();

	MyButton btEditor;
	ModuleVO[] modules;
	TypeVO[] types;
	ArrayList<LessonAbstractVO> editedLogs = new ArrayList<>();
	
	class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Ins_SetPlanPanel.this.setVisible(false);
			InsMainUI.setPlanSubPanel = new Ins_SetPlanSubPanel(
					Ins_SetPlanPanel.this, insTeacher, null);
			InsMainUI.setPlanSubPanel.setBounds(201, 130, 851, 495);
			MainFrameUI.userMainUI.add(InsMainUI.setPlanSubPanel, 0);
		}

	}

	class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "未选中课程");
				return;
			}
			LessonAbstractVO lesson = list.get(row);

			try {
				if (insTeacher.deletePlan(lesson.getLes_Id_Ab())) {
					JOptionPane.showMessageDialog(null, "删除成功");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
				refresh();
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (RemoteException e1) {
				MainFrameUI.showError();
				e1.printStackTrace();
			}

		}

	}

	class EditListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "未选中课程");
				return;
			}
			LessonAbstractVO lesson = list.get(row);
			Ins_SetPlanPanel.this.setVisible(false);
			InsMainUI.setPlanSubPanel = new Ins_SetPlanSubPanel(
					Ins_SetPlanPanel.this, insTeacher, lesson);
			InsMainUI.setPlanSubPanel.setBounds(201, 130, 851, 495);
			MainFrameUI.userMainUI.add(InsMainUI.setPlanSubPanel, 0);
			// 以下为直接在表格上编辑的监听+。= 先不管了
			// if (btEditor.getText().equals(EDIT)){
			// btEditor.setText(SAVE);
			// table.setModel(new DefaultTableModel(rowData,tableHead){
			// @Override
			// public boolean isCellEditable(int row,int column){
			// if (column==0||column==1){
			// return true;
			// }
			// return false;
			// }
			// });
			// setTableWidth();
			// setOperation();
			// } else {
			// btEditor.setText(EDIT);
			// try {
			// refresh();
			// } catch (RemoteException e1) {
			// MainFrameUI.showError(MainFrameUI.userMainUI);
			// e1.printStackTrace();
			// }
			// setTableWidth();
			// }
		}

	}

	public Ins_SetPlanPanel(InsTeacherBlService insTeacher) {
		super(insTeacher);
		tableHead = new String[] { "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "" };
		btEditor = new MyButton(EDIT);
		btEditor.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		btEditor.setBounds(311, 457, 98, 28);
		btEditor.addActionListener(new EditListener());
		add(btEditor);

		MyButton btAdd = new MyButton("新增");
		btAdd.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btAdd.setBounds(419, 457, 98, 28);
		add(btAdd);
		btAdd.addActionListener(new AddListener());

		MyButton btDelete = new MyButton("删除");
		btDelete.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btDelete.setBounds(531, 457, 98, 28);
		btDelete.addActionListener(new DeleteListener());
		add(btDelete);
		new Thread(){
			public void run(){
				MainFrameUI.loadingPanel.setMessage("正在获取教学计划...");
				MainFrameUI.showWating();
				refresh();
				initialTable();
				MainFrameUI.hideWating();
			}
		}.start();
		
	}

	class EditButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JLabel lblNewLabel = new JLabel(
					"<HTML><table><th style=\"background-color:#d2bbd2;width:33px;height:83px;\"></th></table></HTML>");
			lblNewLabel.setBounds(812, 15, 33, 83);
			add(lblNewLabel, 0);
			// ((DefaultTableModel)table.getModel()).addColumn("");
			// 加了一行所有定好的列宽度就全变了我也不知道为毛(╯‵□′)╯︵┻━┻
			// 另外，详细编辑课程的界面在Ins_SetPlanSubPanel，就是点击最后一列的编辑就会进入到这门课程的详细编辑页面，详见人机交互文档P18、19
			repaint();
		}
	}

	@Override
	public void setThead() {
		PlanTableHead tHead = new PlanTableHead();
		tHead.setBounds(0, 6, 827, 92);
		add(tHead);

	}

	public void setOperation() {
		moduleBox = new JComboBox<ModuleVO>(modules);
		moduleBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		moduleBox.addActionListener(new BoxListener());
		table.getColumnModel().getColumn(0)
				.setCellEditor(new DefaultCellEditor(moduleBox));
	}

	class BoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ModuleVO moduleVO = (ModuleVO) moduleBox.getSelectedItem();
			ArrayList<TypeVO> temp = new ArrayList<>();
			for (TypeVO type : typeList) {
				if (type.getModule_Id() == moduleVO.getModule_Id()) {
					temp.add(type);
				}
			}
			types = new TypeVO[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				types[i] = temp.get(i);
			}
			int row = table.getSelectedRow();
			table.setValueAt(types[0].toString(), row, 1);
			typeBox = new JComboBox<TypeVO>(types);
			table.getColumnModel().getColumn(1)
					.setCellEditor(new DefaultCellEditor(typeBox));
		}
	}

	public void refresh()  {
		try {
			Iterator<ModuleVO> modules = insTeacher.getAllModules();
			while (modules.hasNext()) {
				moduleList.add(modules.next());
			}
			this.modules = new ModuleVO[moduleList.size()];
			for (int i = 0; i < moduleList.size(); i++) {
				this.modules[i] = moduleList.get(i);
			}
			Iterator<TypeVO> types = insTeacher.getAllTypes();
			while (types.hasNext()) {
				typeList.add(types.next());
			}
			plan = insTeacher.showPlan();
			Iterator<LessonAbstractVO> iter = plan.getLessons();
			while (iter.hasNext()) {
				LessonAbstractVO lessonAbstractVO = iter.next();
				list.add(lessonAbstractVO);
			}
			fillRowData();
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
		
	}

	@Override
	public void fillRowData() {
		rowData = new String[list.size()][18];// 每行每列的数据设置在这里！！！！
		int index = 0;
		for (LessonAbstractVO item : list) {
			rowData[index][0] = item.getModule();
			rowData[index][1] = item.getType();
			rowData[index][2] = item.getCompulsoryString();
			rowData[index][3] = item.getLes_Id_Ab() + "";
			rowData[index][4] = item.getName();
			rowData[index][5] = item.getCredit();
			String termString = item.getTerm();
			String[] terms = termString.split(";");
			for (String eachTerm : terms) {
				int term = Integer.parseInt(eachTerm);
				if (term > 2 && term < 5)
					term++;
				if (term >= 5 && term < 7)
					term = term + 2;
				if (term >= 7 && term < 9)
					term = term + 3;
				if (term >= 9)
					term = 3 * (term - 8);
				rowData[index][5 + term] = "√";
			}
			index++;
		}
	}

	public void setTableWidth() {
		tableScrollPane.setBounds(6, 100, 830, 340);
		for (int k = 0; k < 17; k++) {
			int tableWidth;
			if (k == 0) {
				tableWidth = 93;
			} else if (k == 1) {
				tableWidth = 94;
			} else if (k == 2) {
				tableWidth = 35;
			} else if (k == 3) {
				tableWidth = 75;
			} else if (k == 4) {
				tableWidth = 175;
			} else if (k == 5) {
				tableWidth = 35;
			} else {
				tableWidth = 27;
			}
			table.getColumnModel().getColumn(k).setPreferredWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMaxWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMinWidth(tableWidth);
		}
	}
}
