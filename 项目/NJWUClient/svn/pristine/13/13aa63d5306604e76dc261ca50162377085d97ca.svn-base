package mock.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mock.studentbl_mock.StudentBl_Mock;
import presentation.mainui.ChangePassword;
import presentation.srcBag.SrcBag;
import presentation.studentui.Stu_ShowAcademy;
import presentation.studentui.Stu_ShowPlan;
import presentation.studentui.Stu_ShowSchedule;
import presentation.studentui.Stu_ShowScore;
import presentation.studentui.Stu_ShowSelect;
import vo.PlanVO;
import businesslogicservice.studentblservice.StudentBlService;
import businesslogicservice.userblservice.UserControllerService;

public class StudentMainUI_Mock extends UserMainUI_Mock{
	public static final int SELECT = 0;
	public static final int BYSELECT = 1;
	int chooseType = -1;
	Stu_ShowPlan stu_ShowPlan;
	Stu_ShowSchedule stu_ShowSchedule;
	JPanel subMenu_credit;
	JPanel subMenu_course;
	ChangePassword changePassword;

	Stu_ShowScore stu_ShowScore;
	Stu_ShowAcademy stu_ShowAcademy;
	Stu_ShowSelect stu_ShowSelect;

	StudentBlService student;
	JLabel btShowPlan;
	JLabel btShowSchedule;
	JLabel btShowScore;
	JLabel btSelect;
	JLabel btChangePassword;

	JPanel courseTypePanel;
	String type;
	JLabel type_General;
	JLabel type_Elective;
	JLabel type_Cross;

	JPanel termPanel;

	int click = 0;

	/**
	 * Create the panel.
	 */
	public StudentMainUI_Mock(UserControllerService userController) {

		super(userController);
		try {
			student = new StudentBl_Mock();
		} catch (Exception e) {
			MainFrameUI_Mock.showError();
		}
		JLabel mainMenuSideBar = new JLabel();
		mainMenuSideBar.setBounds(0, 0, 25, 381);
		ImageIcon mainSideBar = new ImageIcon(SrcBag.stuMainSideBarSrc);

		btShowPlan = new JLabel();
		btShowPlan.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.stuMenuBgSrc1);
		btShowPlan.setIcon(mainMenuBtnBg1);
		btShowPlan.addMouseListener(new showPlanListener());

		btShowSchedule = new JLabel();
		btShowSchedule.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.stuMenuBgSrc2);
		btShowSchedule.setIcon(mainMenuBtnBg2);
		btShowSchedule.addMouseListener(new showScheduleListener());

		btShowScore = new JLabel();
		btShowScore.setBounds(6, 162, 133, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.stuMenuBgSrc3);
		btShowScore.setIcon(mainMenuBtnBg3);
		btShowScore.addMouseListener(new showScoreListener());

		btSelect = new JLabel();
		btSelect.setBounds(6, 238, 133, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.stuMenuBgSrc4);
		btSelect.setIcon(mainMenuBtnBg4);
		btSelect.addMouseListener(new SelectListener());

		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 315, 133, 56);
		ImageIcon mainMenuBtnBg5 = new ImageIcon(SrcBag.stuMenuBgSrc5);
		btChangePassword.setIcon(mainMenuBtnBg5);
		btChangePassword.addMouseListener(new ChangePasswordListener());

		mainMenuPanel.add(btShowPlan);
		mainMenuPanel.add(btShowSchedule);
		mainMenuPanel.add(btShowScore);
		mainMenuPanel.add(btSelect);
		mainMenuPanel.add(btChangePassword);

		mainMenuSideBar.setIcon(mainSideBar);
		mainMenuPanel.add(mainMenuSideBar);

		JLabel mainMenuLabel = new JLabel();
		mainMenuLabel.setBounds(0, 0, 145, 381);
		ImageIcon mainMenuBg = new ImageIcon(SrcBag.mainMenuBgSrc);
		mainMenuLabel.setIcon(mainMenuBg);
		mainMenuPanel.add(mainMenuLabel);

		add(mainMenuPanel);
		add(logOutPanel);
		add(panelBgLabel);
	}

	public void clean() {
		btShowPlan.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc1));
		btShowSchedule.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc2));
		btShowScore.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc3));
		btSelect.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc4));
		btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5));
	}

	class showPlanListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 1;
			removeAllPanel();
			clean();
			btShowPlan.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc1_1));
			
			new Thread(){
				public void run(){
					MainFrameUI_Mock.loadingPanel.setMessage("正在获取教学计划...");
					MainFrameUI_Mock.showWating();
					PlanVO plan = null;		
					try {
						plan = student.showPlan();
					} catch (RemoteException e1) {
						e1.printStackTrace();
						MainFrameUI_Mock.showError();
					}
					stu_ShowPlan = new Stu_ShowPlan(plan);
					stu_ShowPlan.setBounds(201, 128, 851, 495);
					add(stu_ShowPlan, 0);
					repaint();			
					MainFrameUI_Mock.hideWating();
				}
			}.start();
		
		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			btShowPlan.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc1_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 1)
				btShowPlan.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc1));
		}
	}

	class showScheduleListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 2;
			clean();
			btShowSchedule.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc2_1));
			removeAllPanel();
			new Thread(){
				public void run(){
					MainFrameUI_Mock.loadingPanel.setMessage("正在获取课程信息...");
					MainFrameUI_Mock.showWating();
					try {
						stu_ShowSchedule = new Stu_ShowSchedule(student.show_myLesson());
					} catch (RemoteException e1) {
						e1.printStackTrace();
						MainFrameUI_Mock.showError();
					}
					stu_ShowSchedule.setBounds(201, 128, 851, 495);
					add(stu_ShowSchedule, 0);
					MainFrameUI_Mock.hideWating();
					repaint();			
				}
			}.start();
		
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btShowSchedule.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc2_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 2)
				btShowSchedule.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc2));
		}
	}

	class showScoreListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 3;
			clean();
			btShowScore.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc3_1));
			removeAllPanel();
			type = "credit";
			subMenu_credit = createSubMenu(SrcBag.stuSubMenuSrc1,
					SrcBag.stuSubMenuSrc2, "credit");
			subLabel1.addMouseListener(new SubMenuListener1());
			subLabel2.addMouseListener(new SubMenuListener2());
			subMenu_credit.setBounds(165, 285, 130, 91);
			add(subMenu_credit, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btShowScore.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc3_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 3)
				btShowScore.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc3));
		}
	}

	class SelectListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 4;
			clean();
			btSelect.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc4_1));
			removeAllPanel();
			type = "course";
			subMenu_course = createSubMenu(SrcBag.stuSubMenuSrc3,
					SrcBag.stuSubMenuSrc4, "course");
			subLabel1.addMouseListener(new SubMenuListener1());
			subLabel2.addMouseListener(new SubMenuListener2());
			subMenu_course.setBounds(165, 360, 130, 91);
			add(subMenu_course, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			btSelect.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc4_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 4)
				btSelect.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc4));
		}
	}

	class ChangePasswordListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 5;
			clean();
			btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5_1));
			removeAllPanel();
			changePassword = new ChangePassword(userController);
			changePassword.setBounds(201, 128, 851, 495);
			add(changePassword, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 5)
				btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5));
		}
	}

	class SubMenuListener1 implements MouseListener {
		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			if (type.equals("credit")) {
				removeAllPanel();
				termPanel = createTermPanel();
				termPanel.setBounds(170, 190, 120, 1344);
				add(termPanel, 0);
				new Thread(){
					public void run(){
						MainFrameUI_Mock.loadingPanel.setMessage("正在获取您的分数...");
						MainFrameUI_Mock.showWating();
						try {
							stu_ShowScore = new Stu_ShowScore(student.show_myScore());
						} catch (RemoteException e1) {
							MainFrameUI_Mock.showError();
							e1.printStackTrace();
						}
						stu_ShowScore.setBounds(300, 83, 851, 495);
						add(stu_ShowScore, 0);
						repaint();			
						MainFrameUI_Mock.hideWating();
					}
				}.start();
			
			} else if (type.equals("course")) {
				chooseType = SELECT;
				removeAllPanel();
				JPanel courseTypePanel = courseType();
				courseTypePanel.setBounds(160, 178, 120, 179);
				add(courseTypePanel, 0);
				repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if (type.equals("credit")) {
				subLabel1.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc1_1));
			} else if (type.equals("course")) {
				subLabel1.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc3_1));
			}
		}

		public void mouseExited(MouseEvent e) {
			if (type.equals("credit")) {
				subLabel1.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc1));
			} else if (type.equals("course")) {
				subLabel1.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc3));

			}

		}
	}

	class SubMenuListener2 implements MouseListener {
		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			if (type.equals("credit")) {
				removeAllPanel();
				new Thread(){
					public void run(){
						MainFrameUI_Mock.loadingPanel.setMessage("正在获取您的学业审核...");
						MainFrameUI_Mock.showWating();
						try {
							stu_ShowAcademy = new Stu_ShowAcademy(
									student.show_myScore());
						} catch (RemoteException e1) {
							MainFrameUI_Mock.showError();
							e1.printStackTrace();
						}
						stu_ShowAcademy.setBounds(230, 84, 851, 495);
						add(stu_ShowAcademy, 0);
						repaint();
						MainFrameUI_Mock.hideWating();
					}
				}.start();
				
			} else if (type.equals("course")) {
				chooseType = BYSELECT;
				removeAllPanel();
				JPanel courseTypePanel = courseType();
				courseTypePanel.setBounds(160, 178, 120, 179);
				add(courseTypePanel, 0);
			}
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if (type.equals("credit")) {
				subLabel2.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc2_1));
			} else if (type.equals("course")) {
				subLabel2.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc4_1));
			}
		}

		public void mouseExited(MouseEvent e) {
			if (type.equals("credit")) {
				subLabel2.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc2));
			} else if (type.equals("course")) {
				subLabel2.setIcon(new ImageIcon(SrcBag.stuSubMenuSrc4));
			}

		}
	}

	class CourseTypeListener implements MouseListener {
		String cssString = " style=\"background-color:#d200d2;width:89px;height:40px;\">";
		String generalString;
		String electiveString;
		String crossString;
		int choose = 0;

		public void changeColor() {
			cssString = " style=\"background-color:#bfaac3;width:89px;height:40px;\">";
			generalString = "<HTML><table><th" + cssString
					+ "通识通修课</th></table></HTML>";
			electiveString = "<HTML><table><th" + cssString
					+ "公选课</th></table></HTML>";
			crossString = "<HTML><table><th" + cssString
					+ "跨专业课程</th></table></HTML>";
		}

		public void originColor() {
			cssString = " style=\"background-color:#d2bbd2;width:89px;height:40px;\">";
			generalString = "<HTML><table><th" + cssString
					+ "通识通修课</th></table></HTML>";
			electiveString = "<HTML><table><th" + cssString
					+ "公选课</th></table></HTML>";
			crossString = "<HTML><table><th" + cssString
					+ "跨专业课程</th></table></HTML>";
		}

		public void clean() {
			originColor();
			type_Cross.setText(crossString);
			type_Elective.setText(electiveString);
			type_General.setText(generalString);
		}

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			removeSubPanel();
			clean();
			changeColor();
			if (e.getSource().equals(type_General)) {
				type_General.setText(generalString);
				choose = 1;
				stu_ShowSelect = new Stu_ShowSelect(student, 1, chooseType);
				stu_ShowSelect.setBounds(270, 128, 851, 495);
				add(stu_ShowSelect, 0);
				repaint();
			} else if (e.getSource().equals(type_Elective)) {
				choose = 2;
				type_Elective.setText(electiveString);
				stu_ShowSelect = new Stu_ShowSelect(student, 9, chooseType);
				stu_ShowSelect.setBounds(270, 128, 851, 495);
				add(stu_ShowSelect, 0);
				repaint();
			} else if (e.getSource().equals(type_Cross)) {
				choose = 3;
				type_Cross.setText(crossString);
				stu_ShowSelect = new Stu_ShowSelect(student, 5, chooseType);
				stu_ShowSelect.setBounds(270, 128, 851, 495);
				add(stu_ShowSelect, 0);
				repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			changeColor();
			if (e.getSource().equals(type_General)) {
				type_General.setText(generalString);
			} else if (e.getSource().equals(type_Elective)) {
				type_Elective.setText(electiveString);
			} else if (e.getSource().equals(type_Cross)) {
				type_Cross.setText(crossString);
			}
		}

		public void mouseExited(MouseEvent e) {
			originColor();
			if (e.getSource().equals(type_General) && choose != 1) {
				type_General.setText(generalString);
			} else if (e.getSource().equals(type_Elective) && choose != 2) {
				type_Elective.setText(electiveString);
			} else if (e.getSource().equals(type_Cross) && choose != 3) {
				type_Cross.setText(crossString);
			}
		}
	}

	void removeAllPanel() {
		if (stu_ShowPlan != null) {
			remove(stu_ShowPlan);
		}
		if (stu_ShowSchedule != null) {
			remove(stu_ShowSchedule);
		}
		if (subMenu_credit != null) {
			remove(subMenu_credit);
		}
		if (subMenu_course != null) {
			remove(subMenu_course);
		}
		if (changePassword != null) {
			remove(changePassword);
		}
		if (stu_ShowAcademy != null) {
			remove(stu_ShowAcademy);
		}
		if (stu_ShowScore != null) {
			remove(stu_ShowScore);
		}
		if (courseTypePanel != null) {
			remove(courseTypePanel);
		}
		if (stu_ShowSelect != null) {
			remove(stu_ShowSelect);
		}
		if (termPanel != null) {
			remove(termPanel);
		}
		repaint();
	}

	void removeSubPanel() {
		if (stu_ShowSelect != null) {
			remove(stu_ShowSelect);
		}
		if (stu_ShowScore != null) {
			remove(stu_ShowScore);
		}
		repaint();
	}

	JPanel courseType() {
		courseTypePanel = new JPanel();
		courseTypePanel.setLayout(null);
		courseTypePanel.setOpaque(false);
		courseTypePanel.setBounds(140, 95, 120, 179);

		String cssString = " style=\"background-color:#d2bbd2;width:89px;height:40px;\">";

		type_General = new JLabel("<HTML><table><th" + cssString
				+ "通识通修课</th></table></HTML>");
		CourseTypeListener listener = new CourseTypeListener();
		type_General.setBounds(0, 6, 108, 60);
		type_General.addMouseListener(listener);
		courseTypePanel.add(type_General);

		type_Elective = new JLabel("<HTML><table><th" + cssString
				+ "公选课</th></table></HTML>");
		type_Elective.setBounds(0, 63, 108, 60);
		type_Elective.addMouseListener(listener);
		courseTypePanel.add(type_Elective);

		type_Cross = new JLabel("<HTML><table><th" + cssString
				+ "跨专业课程</th></table></HTML>");
		type_Cross.setBounds(0, 120, 108, 60);
		type_Cross.addMouseListener(listener);
		courseTypePanel.add(type_Cross);

		return courseTypePanel;
	}

	JPanel createTermPanel() {
		termPanel = new JPanel();
		termPanel.setLayout(null);
		termPanel.setOpaque(false);
		final JLabel terms[] = new JLabel[8];
		final String[] numbers = new String[] { "一", "二", "三", "四", "五", "六",
				"七", "八" };
		String cssString = " style=\"background-color:#d2bbd2;width:89px;height:40px;\">";

		JLabel chooseTerm = new JLabel("<HTML><table><th" + cssString
				+ "请选择学期</th></table></HTML>");
		chooseTerm.setBounds(6, 0, 108, 60);
		termPanel.add(chooseTerm);
		MouseListener termListener = new MouseListener() {
			int chooseItem = 0;

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				terms[chooseItem].setForeground(new Color(153, 102, 51));
				for (int i = 0; i < 8; i++) {
					if (e.getSource() == terms[i]) {
						chooseItem = i;
						stu_ShowScore.refresh(i + 1);
						break;
					}
				}
			}

			public void mouseExited(MouseEvent e) {
				for (int i = 0; i < 8; i++) {
					if (e.getSource() == terms[i] && chooseItem != i) {
						terms[i].setForeground(new Color(153, 102, 51));
						break;
					}
				}
			}

			public void mouseEntered(MouseEvent e) {
				for (int i = 0; i < 8; i++) {
					if (e.getSource() == terms[i]) {
						terms[i].setForeground(new Color(0, 0, 250));
						break;
					}
				}
			}

			public void mouseClicked(MouseEvent e) {

			}
		};
		for (int i = 0; i < 8; i++) {
			terms[i] = new JLabel("<HTML><U>第" + numbers[i] + "学期</U></HTML>");
			terms[i].setBounds(6, 45 + i * 30, 108, 60);
			terms[i].setForeground(new Color(153, 102, 51));
			terms[i].setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
			terms[i].setHorizontalAlignment(SwingConstants.CENTER);
			terms[i].addMouseListener(termListener);
			termPanel.add(terms[i]);
		}
		terms[0].setForeground(new Color(0, 0, 250));
		return termPanel;
	}


}
