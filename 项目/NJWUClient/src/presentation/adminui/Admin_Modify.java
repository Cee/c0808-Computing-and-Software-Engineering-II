package presentation.adminui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import utility.CurrentState;
import utility.ExportHelper;
import vo.StudentVO;
import vo.TeacherVO;
import businesslogicservice.adminblservice.AdminblService;

/**
 * 修改用户的面板
 * @author Xc
 */
public class Admin_Modify extends Admin_User {

	public static String EDIT_DETAIL = "<Html><font color=\"blue\">编辑详情</font><Html>";
	public static String CANCEL = "<Html><font color=\"blue\">撤销更改</font><Html>";
	public static String SUBMIT = "<Html><font color=\"blue\">提交更改</font><Html>";

	public Admin_Modify(AdminblService admin) {
		super(admin);

		MyButton btSubmit = new MyButton("提交");
		btSubmit.setBounds(580, 462, 81, 23);
		add(btSubmit);
		MyButton btExport = new MyButton("导出");
		btExport.setBounds(675, 462, 81, 23);
		add(btExport);	
		btExport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedType==-1){
					JOptionPane.showMessageDialog(null, "请选择名单"); 
				} else {
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
						if (selectedType==0)
							ExportHelper.exportStudent(new FileOutputStream(file), sList);
						else 
							ExportHelper.exportTeacher(new FileOutputStream(file), tList);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "导出失败");
						e1.printStackTrace();
						return;
					}
					JOptionPane.showMessageDialog(null, "导出成功");
				}
			}
		});
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run(){
						submitAll();		
					}
				}.start();
				
			}
		});
		repaint();
	}

	/**
	 * 对某一行的更改进行撤销
	 * @param r
	 */
	void cancel(int r) {
		((MyModifyTableModel) table.getModel()).cancelRow(r);
	}

	/**
	 * 提交某行的数据
	 * @param row
	 */
	void submit(int row) {
		MainFrameUI.loadingPanel.setMessage("正在提交修改...");
		MainFrameUI.showWating();
		if (((MyModifyTableModel) table.getModel()).isRowEdited(row)) {
			String idString = (String) table.getValueAt(row, 2);
			int id = Integer.parseInt(idString);
			String name = (String) table.getValueAt(row, 3);
			String gender = (String) table.getValueAt(row, 4);
			String institute = (String) table.getValueAt(row, 5);
			int ins_id = CurrentState.getInsId(institute);
			int grade = gradeBox.getSelectedIndex();
			String typeString = (String) table.getValueAt(row, 6);
			int type = CurrentState.getTypeId(typeString);
			try {
				switch (typeBox.getSelectedIndex()) {
				case 1: // 学生
					StudentVO studentVO = new StudentVO(id, name,
							idString.toCharArray(), grade, ins_id, institute,
							gender);

					if (!admin.modifyStudent(studentVO)) {
						MainFrameUI.hideWating();
						JOptionPane.showMessageDialog(null, "修改失败");
						return;
					}

					break;
				case 2: // 老师
					TeacherVO teacherVO = new TeacherVO(id, ins_id, name,
							idString.toCharArray(), institute, type, gender);

					if (!admin.modifyTeacher(teacherVO)) {
						MainFrameUI.hideWating();
						JOptionPane.showMessageDialog(null, "修改失败");
						return;
					}

					break;
				}
				MainFrameUI.hideWating();
				JOptionPane.showMessageDialog(null, "修改成功");
				table.setValueAt("", row, 0);
				table.setValueAt("", row, 1);
				
			} catch (Exception e) {
				e.printStackTrace();
				MainFrameUI.hideWating();
				MainFrameUI.showError();
			}

		}
		refreshTable();
	}

	/**
	 * 将所有修改提交
	 */
	void submitAll() {
		MainFrameUI.loadingPanel.setMessage("正在提交修改...");
		MainFrameUI.showWating();
		for (int i = 0; i < table.getRowCount(); ++i) {
			if (((MyModifyTableModel) table.getModel()).isRowEdited(i)) {
				String idString = (String) table.getValueAt(i, 2);
				int id = Integer.parseInt(idString);
				String name = (String) table.getValueAt(i, 3);
				String gender = (String) table.getValueAt(i, 4);
				String institute = (String) table.getValueAt(i, 5);
				int ins_id = CurrentState.getInsId(institute);
				int grade = gradeBox.getSelectedIndex();
				String typeString = (String) table.getValueAt(i, 6);
				int type = CurrentState.getTypeId(typeString);
				switch (typeBox.getSelectedIndex()) {
				case 1: // 学生
					StudentVO studentVO = new StudentVO(id, name,
							idString.toCharArray(), grade, ins_id, institute,
							gender);
					try {
						if (!admin.modifyStudent(studentVO)) {
							MainFrameUI.hideWating();
							JOptionPane.showMessageDialog(null, "修改失败");
							return;
						}

					} catch (RemoteException e) {

						e.printStackTrace();
					}
					break;
				case 2: // 老师
					TeacherVO teacherVO = new TeacherVO(id, ins_id, name,
							idString.toCharArray(), institute, type, gender);
					try {
						if (!admin.modifyTeacher(teacherVO)) {
							MainFrameUI.hideWating();
							JOptionPane.showMessageDialog(null, "修改失败");
							return;
						}

					} catch (RemoteException e) {

						e.printStackTrace();
					}
					break;
				}

			}
		}
		MainFrameUI.hideWating();
		JOptionPane.showMessageDialog(null, "修改成功");
		((MyModifyTableModel) table.getModel()).submitAll();
		refreshTable();
	}

	@Override
	public void setThead() {
		tHead = new JLabel("<HTML>" + "<table>" + "<th" + thCss + ">操  作</th>"
				+ "<th" + thCss + ">学工号</th>" + "<th" + thCss + ">姓  名</th>"
				+ "<th" + thCss + ">性  别</th>" + "<th" + thCss + ">院  系</th>"
				+ "<th" + thCss + ">用户类型</th>" + "</table>" + "</HTML>");
		tHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tHead.setBounds(64, 44, 827, 96);
		add(tHead);
	}

	@Override
	protected void setOperationColumn() {
		int row = table.getRowCount();
		for (int i = 0; i < row; ++i) {
			table.getModel().setValueAt("", i, 0);
			table.getModel().setValueAt("", i, 1);

		}

		JComboBox genderBox = new JComboBox(new String[] { "男", "女" });
		genderBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		table.getColumnModel().getColumn(4)
				.setCellEditor(new DefaultCellEditor(genderBox));

		String[] ins = new String[institute.length - 1];
		for (int j = 0; j < ins.length; ++j) {
			ins[j] = institute[j + 1];
		}
		JComboBox insBox = new JComboBox(ins);
		insBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		table.getColumnModel().getColumn(5)
				.setCellEditor(new DefaultCellEditor(insBox));

	}
	/**
	 * 对组件添加监听
	 */
	protected void addListeners() {
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int column = table.getSelectedColumn();
				int row = table.getSelectedRow();
				actCellAt(row, column);
			}
		});
	}

	/**
	 * 执行某个单元格的动作，
	 * 仅对第一、第二列反应
	 * @param row
	 * @param column
	 */
	private void actCellAt(final int row, int column) {
		if (column <= 1) {
			String message = (String) table.getValueAt(row, column);
			if (message.equals(SUBMIT)) {
				new Thread(){
					public void run(){
						submit(row);			
					}
				}.start();
			} else if (message.equals(CANCEL)) {
				cancel(row);
			}
		}
	}

	@Override
	public TableModel getTableModel() {
		return new MyModifyTableModel(tableHead);
	}

}
