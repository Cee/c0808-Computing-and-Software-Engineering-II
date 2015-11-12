package presentation.adminui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import utility.ExportHelper;
import businesslogicservice.adminblservice.AdminblService;
/**
 * 删除用户的面板
 * @author Xc
 *
 */
public class Admin_Delete extends Admin_User {
	/**
	 * 某行是否已选择
	 */
	boolean selectList[];

	public Admin_Delete(AdminblService admin) {
		super(admin);
		/**
		 * 全选框
		 */
		JCheckBox checkBox = new JCheckBox();
		checkBox.setOpaque(false);
		checkBox.setBorder(null);
		checkBox.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		checkBox.setBounds(83, 80, 128, 23);
		add(checkBox, 0);
		checkBox.addActionListener(new CheckBoxListener());

		/**
		 * 提交按钮
		 */
		MyButton btSubmit = new MyButton("提交");
		btSubmit.setBounds(580, 462, 81, 23);
		add(btSubmit);
		
		/**
		 * 导出按钮
		 */
		MyButton btExport = new MyButton("导出");
		btExport.setBounds(675, 462, 81, 23);
		add(btExport);	
		btExport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * 如果没有选择，提示选择名单
				 */
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
						deleteSelected();		
					}
				}.start();
			}
		});
		add(btSubmit);
	}
	/**
	 * 全选框的监听
	 * @author luck
	 *
	 */
	class CheckBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JCheckBox box = (JCheckBox) e.getSource();
			if (box.isSelected()) {
				selectAll();
			} else {
				disSelectAll();
			}
		}
	}

	/**
	 * 全选
	 */
	private void selectAll() {
		for (int i = 0; i < selectList.length; ++i) {
			selectList[i] = true;
			table.setValueAt("√", i, 0);
		}
	}
	
	/**
	 * 取消全选
	 */
	private void disSelectAll() {
		for (int i = 0; i < selectList.length; ++i) {
			selectList[i] = false;
			table.setValueAt("", i, 0);
		}
	}

	@Override
	public void setThead() {
		tHead = new JLabel("<HTML>" + "<table>" + "<th" + thCss + ">   全选</th>"
				+ "<th" + thCss + ">学工号</th>" + "<th" + thCss + ">姓  名</th>"
				+ "<th" + thCss + ">性  别</th>" + "<th" + thCss + ">院  系</th>"
				+ "<th" + thCss + ">用户类型</th>" + "</table>" + "</HTML>");
		tHead.setFont((new Font("Microsoft YaHei", Font.PLAIN, 12)));
		tHead.setBounds(64, 44, 827, 96);
		add(tHead);
	}

	@Override
	protected void setOperationColumn() {
		for (int i = 0; i < table.getRowCount(); ++i) {
			table.setValueAt("", i, 0);
			table.setValueAt(DELETE, i, 1);
		}
	}
	private final String DELETE = "<Html><font color=\"blue\">删除</font></Html>";
	@Override
	protected void addListeners() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				final int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				if (column == 1) {
					new Thread() {
						public void run() {
							Admin_Delete.this.delete(row);
						}
					}.start();

				} else if (column == 0) {
					selectList[row] = !selectList[row];
					table.setValueAt(
							revertCheck((String) table.getValueAt(row, 0)),
							row, 0);
				}
			}
		});

	}

	/**
	 * 删除某一行的用户
	 * @param row
	 */
	private void delete(int row) {
		int id = Integer.parseInt((String) table.getValueAt(row, 2));
		MainFrameUI.loadingPanel.setMessage("正在删除用户...");
		MainFrameUI.showWating();
		switch (typeBox.getSelectedIndex()) {
		case 1:// 学生
			try {
				if (admin.delStudent(id))
					MainFrameUI.hideWating();
				JOptionPane.showMessageDialog(null, "删除成功");
			} catch (RemoteException e) {
				e.printStackTrace();
				MainFrameUI.hideWating();
				MainFrameUI.showError();
			}
			break;
		case 2:// 老师
			try {
				if (admin.delTeacher(id))
					MainFrameUI.hideWating();
				JOptionPane.showMessageDialog(null, "删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				MainFrameUI.hideWating();
				MainFrameUI.showError();
			}
		}
		refreshTable();
	}

	/**
	 * 删除选定的行的用户
	 */
	private void deleteSelected() {
		for (int row = 0; row < table.getRowCount(); ++row) {
			if (selectList[row]) {
				int id = Integer.parseInt((String) table.getValueAt(row, 2));
				MainFrameUI.loadingPanel.setMessage("正在删除...");
				MainFrameUI.showWating();
				switch (typeBox.getSelectedIndex()) {
				case 1:// 学生
					try {
						if (!admin.delStudent(id)) {
							MainFrameUI.hideWating();
							JOptionPane.showMessageDialog(null, "删除失败");
							return;
						}
					} catch (RemoteException e) {
						e.printStackTrace();
						MainFrameUI.hideWating();
						MainFrameUI.showError();
					}
					break;
				case 2:// 老师
					try {
						if (!admin.delTeacher(id)) {
							MainFrameUI.hideWating();
							JOptionPane.showMessageDialog(null, "删除失败");
							return;
						}
					} catch (Exception e) {
						e.printStackTrace();
						MainFrameUI.hideWating();
						MainFrameUI.showError();
					}
				}
			}
		}
		MainFrameUI.hideWating();
		JOptionPane.showMessageDialog(null, "删除成功");
		refreshTable();
	}

	@Override
	protected void fillrowData(String[][] rowdata) {
		table.setModel(new DefaultTableModel(rowdata, tableHead) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		setOperationColumn();
		setColumnWidth();
		selectList = new boolean[table.getRowCount()];
		disSelectAll();
	}

	@Override
	public TableModel getTableModel() {
		return new DefaultTableModel(new String[0][7], new String[] { "", "",
				"", "", "", "", "" });
	}

	/**
	 * 取消和选择之间进行切换
	 * @param oldStr
	 * @return
	 */
	public String revertCheck(String oldStr) {
		if (oldStr.equals("√")) {
			return "";
		} else {
			return "√";
		}
	}
}
