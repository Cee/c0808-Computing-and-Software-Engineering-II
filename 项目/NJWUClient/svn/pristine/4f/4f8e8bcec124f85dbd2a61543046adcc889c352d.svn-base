package presentation.insteacherui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.security.auth.Refreshable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import vo.LessonUniqueVO;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import javax.swing.JButton;

/**
 * 院系教务老师查看课程列表
 * @author luck
 *
 */
public class Ins_CourseListPanel extends Ins_ShowPanel {
	/**
	 * 保存课程id，用于删除
	 */
	ArrayList<Integer> idList = new ArrayList<>();
	public Ins_CourseListPanel(InsTeacherBlService insTeacher){
		super(insTeacher);
		MainFrameUI.loadingPanel.setMessage("正在获取课程...");
		MainFrameUI.showWating();
		new Thread(){
			public void run(){
			refresh();	
			}
		}.start();
	}
	
	/**
	 * 填充表格
	 */
	private void fillRowList(){
		rowList.clear();
		idList.clear();
		try {
			Iterator<LessonUniqueVO> lessons = insTeacher.showLesson();
			while (lessons.hasNext()){
				LessonUniqueVO lesson = lessons.next();
				String[] row= new String[7];
				row[0] =  lesson.getLessonId();
				row[1] = lesson.getLessonName();
				row[2] = lesson.getTeacherName();
				row[3] = lesson.getTime();
				row[4] = lesson.getLocation();
				row[5] = lesson.getCreditString();
				idList.add(lesson.getLes_Id());
				rowList.add(row);
			}
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
	}
	/**
	 * 刷新
	 */
	private void refresh() {
		fillRowList();
		MainFrameUI.hideWating();
		tableHead = new String[]{ "", "", "", "", "", ""};
		fillRowData();
		initialTable();
		table.refresh(rowData, tableHead);
		table.setVisible(false);
		table.setVisible(true);
	}
	/**
	 * 初始化表头
	 */
	@Override
	public void setThead() {
		String thCss = " style=\"background-color:#d2bbd2;width:89px;height:40px;\"";
		String thCss_1 = " style=\"background-color:#d2bbd2;width:200px;height:34px;\"";
		String thCss_2 = " style=\"background-color:#d2bbd2;width:100px;height:34px;\"";
		String thCss_3 = " style=\"background-color:#d2bbd2;width:50px;height:34px;\"";
		JLabel tHead = new JLabel(
				"<HTML>" +
				"<table>" +
					"<th"+thCss+">课程号</th>" +
					"<th"+thCss_1+">课程名</th>" +
					"<th"+thCss+">任课老师</th>" +
					"<th"+thCss_2+">上课时间</th>" +		
					"<th"+thCss_2+">上课地点</th>" +
					"<th"+thCss_3+">学 分</th>" +
				"</table>" +
				"</HTML>");
		tHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tHead.setBounds(6, 6, 827, 72);
		add(tHead);		
		/**
		 * 删除按钮
		 */
		MyButton btDelete = new MyButton("删除");
		btDelete.setBounds(749, 461, 84, 23);
		add(btDelete,0);
		btDelete.addActionListener(new ActionListener() {
			/**
			 * 删除选中行
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row!=-1){
					if(JOptionPane.showConfirmDialog(null, "您确定删除该课程?")==0){
						try {
							if (insTeacher.deleteLesson(idList.get(row))){
								JOptionPane.showMessageDialog(null, "删除成功");
								fillRowList();
								fillRowData();
								table.refresh(rowData, tableHead);
							} else {
								JOptionPane.showMessageDialog(null, "删除失败");
								
							}
			
						} catch (RemoteException e1) {
							MainFrameUI.showError();
							e1.printStackTrace();
						} 
					}
				}
			}

		
		});
	}

	@Override
	public void fillRowData() {
		rowData = new String[rowList.size()][6];
		for (int i = 0; i < rowList.size(); i++) {
			rowData[i][0] = rowList.get(i)[0];
			rowData[i][1] = rowList.get(i)[1];
			rowData[i][2] = rowList.get(i)[2];
			rowData[i][3] = rowList.get(i)[3];
			rowData[i][4] = rowList.get(i)[4];
			rowData[i][5] = rowList.get(i)[5];
		}		
	}


	/**
	 * 调整表头宽度
	 */
	@Override
	public void setTableWidth() {
		tableScrollPane.setBounds(8, 70, 843, 365);
		for (int k = 0; k < 6; k++) {
			int tableWidth;
			if (k == 0) {
				tableWidth = 115;
			} 
			else if (k ==1) {
				tableWidth = 261;
			}
			else if(k == 2){
				tableWidth = 117;
			}
			else if(k == 3){
				tableWidth = 132;
			}
			else if(k == 4){
				tableWidth = 133;
			}
			else{
				tableWidth = 71;
			}
			table.getColumnModel().getColumn(k).setPreferredWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMaxWidth(tableWidth);
			table.getColumnModel().getColumn(k).setMinWidth(tableWidth);
		}
		
	}
}
