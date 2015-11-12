package mock.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mock.schteacherbl_mock.SchTeacherBl_Mock;
import presentation.mainui.ChangePassword;
import presentation.mainui.MainFrameUI;
import presentation.schteacherui.ModuleEditor;
import presentation.schteacherui.Sch_Frame;
import presentation.schteacherui.Sch_ManageSelection;
import presentation.schteacherui.Sch_ShowClassInfo;
import presentation.schteacherui.Sch_ShowPlan;
import presentation.schteacherui.Sch_ShowStudentInfo;
import presentation.schteacherui.Sch_ShowTeacherInfo;
import presentation.srcBag.SrcBag;
import businesslogic.schteacherbl.SchTeacher;
import businesslogicservice.schteacherblservice.SchTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;

public class SchMainUI_Mock extends UserMainUI_Mock{

	int click = 0;
	JLabel btFrame;
	JLabel btShowInfo;
	JLabel btChangePassword;
	JLabel btManageSelection;

	ChangePassword changePassword;
	SchTeacherBlService schTeacher;
	Sch_ManageSelection sch_ManageSelection;
	Sch_Frame sch_Frame;
	Sch_ShowTeacherInfo sch_ShowTeacherInfo;
	Sch_ShowStudentInfo sch_ShowStudentInfo;
	Sch_ShowPlan sch_ShowPlan;
	Sch_ShowClassInfo sch_ShowClassInfo;
	ModuleEditor moduleEditor;

	JPanel subMenu;
	JLabel subLabel1;
	JLabel subLabel2;
	JLabel subLabel3;
	JLabel subLabel4;

	public SchMainUI_Mock(UserControllerService userController) {
		super(userController);
		try {
			schTeacher = new SchTeacherBl_Mock();
		} catch (Exception e) {
			MainFrameUI_Mock.showError( );
		}

		JLabel mainMenuSideBar = new JLabel();
		mainMenuSideBar.setBounds(0, 0, 25, 381);
		ImageIcon mainSideBar = new ImageIcon(SrcBag.stuMainSideBarSrc);// need
																		// to
																		// change

		btFrame = new JLabel();
		btFrame.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.schMainMenuBgSrc1_0);
		btFrame.setIcon(mainMenuBtnBg1);
		btFrame.addMouseListener(new FrameListener());

		btShowInfo = new JLabel();
		btShowInfo.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.schMainMenuBgSrc2_0);
		btShowInfo.setIcon(mainMenuBtnBg2);
		btShowInfo.addMouseListener(new ShowInfoListener());

		btManageSelection = new JLabel();
		btManageSelection.setBounds(6, 162, 133, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.schMainMenuBgSrc3_0);
		btManageSelection.setIcon(mainMenuBtnBg3);
		btManageSelection.addMouseListener(new ManageSelectionListener());

		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 235, 133, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.stuMenuBgSrc5);
		btChangePassword.setIcon(mainMenuBtnBg4);
		btChangePassword.addMouseListener(new ChangePasswordListener());

		mainMenuPanel.add(btFrame);
		mainMenuPanel.add(btShowInfo);
		mainMenuPanel.add(btChangePassword);
		mainMenuPanel.add(btManageSelection);

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
		repaint();

	}

	public void clean() {
		btFrame.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc1_0));
		btShowInfo.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc2_0));
		btManageSelection.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc3_0));
		btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5));
		// subLabel1.setIcon(new ImageIcon(SrcBag.schSubMenuSrc1_0));
		// subLabel2.setIcon(new ImageIcon(SrcBag.schSubMenuSrc2_0));
		// subLabel3.setIcon(new ImageIcon(SrcBag.schSubMenuSrc3_0));
		// subLabel4.setIcon(new ImageIcon(SrcBag.schSubMenuSrc4_0));

	}

	class FrameListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			clean();
			click = 1;
			btFrame.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc1_1));
			removeAllPanel();
			sch_Frame = new Sch_Frame(schTeacher, moduleEditor);
			sch_Frame.setBounds(201, 128, 851, 539);
			add(sch_Frame, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btFrame.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc1_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 1) {
				btFrame.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc1_0));

			}
		}

	}

	class ShowInfoListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 2;
			clean();
			btShowInfo.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc2_1));
			removeAllPanel();
			subMenu = createSubMenu(SrcBag.schSubMenuSrc1_0,
					SrcBag.schSubMenuSrc2_0, SrcBag.schSubMenuSrc3_0,
					SrcBag.schSubMenuSrc4_0);
			subMenu.setBounds(165, 173, 130, 178);
			add(subMenu, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btShowInfo.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc2_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 2) {
				btShowInfo.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc2_0));
			}
		}

	}

	class ManageSelectionListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			click = 3;
			clean();
			btManageSelection
					.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc3_1));

			removeAllPanel();
			sch_ManageSelection = new Sch_ManageSelection(schTeacher);
			sch_ManageSelection.setBounds(201, 128, 851, 539);
			add(sch_ManageSelection, 0);
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			btManageSelection
					.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc3_1));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (click != 3) {
				btManageSelection.setIcon(new ImageIcon(
						SrcBag.schMainMenuBgSrc3_0));
			}

		}

	}

	class ChangePasswordListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 4;
			clean();
			btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5_1));

			removeAllPanel();
			changePassword = new ChangePassword(userController);
			changePassword.setBounds(201, 128, 851, 539);
			add(changePassword, 0);

			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5_1));

		}

		public void mouseExited(MouseEvent e) {
			if (click != 4) {
				btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5));
			}
		}

	}

	void removeAllPanel() {
		int count = getComponentCount();
		for (int i = 0; i < count; i++) {
			System.out.println(getComponent(i).getClass());

			if (getComponent(i).getClass().toString()
					.equals("class presentation.schteacherui.ModuleEditor")) {
				remove(getComponent(i));
				break;
			}
		}
		if (sch_Frame != null) {
			remove(sch_Frame);
		}
		if (sch_ShowStudentInfo != null) {
			remove(sch_ShowStudentInfo);
		}
		if (sch_ShowPlan != null) {
			remove(sch_ShowPlan);
		}
		if (sch_ShowTeacherInfo != null) {
			remove(sch_ShowTeacherInfo);
		}
		if (sch_ShowClassInfo != null) {
			remove(sch_ShowClassInfo);
		}
		if (changePassword != null) {
			remove(changePassword);
		}
		if (subMenu != null) {
			remove(subMenu);
		}
		if (sch_ManageSelection != null) {
			remove(sch_ManageSelection);
		}
	}

	JPanel createSubMenu(String src1, String src2, String src3, String src4) {

		JPanel subMenu = new JPanel();
		subMenu.setBounds(145, 125, 130, 178);
		subMenu.setOpaque(false);
		subMenu.setLayout(null);

		JLabel subMenuBgLabel = new JLabel();
		subMenuBgLabel.setBounds(0, 0, 130, 174);
		ImageIcon subMenuBg = new ImageIcon(SrcBag.subMenu_fourBgSrc);

		subLabel1 = new JLabel();
		subLabel1.setBounds(28, 5, 95, 39);
		ImageIcon subBtnBg1 = new ImageIcon(src1);
		subLabel1.setIcon(subBtnBg1);
		subLabel1.addMouseListener(new SubMenuListener1());
		subMenu.add(subLabel1);
		subMenuBgLabel.setIcon(subMenuBg);

		subLabel2 = new JLabel();
		subLabel2.setBounds(28, 47, 95, 39);
		ImageIcon subBtnBg2 = new ImageIcon(src2);
		subLabel2.setIcon(subBtnBg2);
		subLabel2.addMouseListener(new SubMenuListener2());
		subMenu.add(subLabel2);
		subMenu.add(subMenuBgLabel);

		subLabel3 = new JLabel();
		subLabel3.setBounds(28, 89, 95, 39);
		ImageIcon subBtnBg3 = new ImageIcon(src3);
		subLabel3.setIcon(subBtnBg3);
		subLabel3.addMouseListener(new SubMenuListener3());
		subMenu.add(subLabel3);
		subMenu.add(subMenuBgLabel);

		subLabel4 = new JLabel();
		subLabel4.setBounds(28, 131, 95, 39);
		ImageIcon subBtnBg4 = new ImageIcon(src4);
		subLabel4.setIcon(subBtnBg4);
		subLabel4.addMouseListener(new SubMenuListener4());
		subMenu.add(subLabel4);
		subMenu.add(subMenuBgLabel);

		return subMenu;
	}

	class SubMenuListener4 implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			try {
				sch_ShowClassInfo = new Sch_ShowClassInfo(schTeacher);
			} catch (RemoteException e1) {
				MainFrameUI_Mock.showError( );
				e1.printStackTrace();
			}
			sch_ShowClassInfo.setBounds(230, 84, 851, 539);
			add(sch_ShowClassInfo, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			subLabel4.setIcon(new ImageIcon(SrcBag.schSubMenuSrc4_1));
		}

		public void mouseExited(MouseEvent e) {
			subLabel4.setIcon(new ImageIcon(SrcBag.schSubMenuSrc4_0));

		}
	}

	class SubMenuListener3 implements MouseListener {
		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			try {
				sch_ShowTeacherInfo = new Sch_ShowTeacherInfo(schTeacher);
			} catch (RemoteException e1) {
				MainFrameUI_Mock.showError( );
				e1.printStackTrace();
			}
			sch_ShowTeacherInfo.setBounds(230, 84, 851, 539);
			add(sch_ShowTeacherInfo, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			subLabel3.setIcon(new ImageIcon(SrcBag.schSubMenuSrc3_1));

		}

		public void mouseExited(MouseEvent e) {
			subLabel3.setIcon(new ImageIcon(SrcBag.schSubMenuSrc3_0));

		}
	}

	class SubMenuListener2 implements MouseListener {
		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			sch_ShowStudentInfo = new Sch_ShowStudentInfo(schTeacher);
			sch_ShowStudentInfo.setBounds(230, 84, 851, 539);
			add(sch_ShowStudentInfo, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			subLabel2.setIcon(new ImageIcon(SrcBag.schSubMenuSrc2_1));

		}

		public void mouseExited(MouseEvent e) {
			subLabel2.setIcon(new ImageIcon(SrcBag.schSubMenuSrc2_0));

		}
	}

	class SubMenuListener1 implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			sch_ShowPlan = new Sch_ShowPlan(schTeacher);
			sch_ShowPlan.setBounds(230, 84, 851, 539);
			add(sch_ShowPlan, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			subLabel1.setIcon(new ImageIcon(SrcBag.schSubMenuSrc1_1));

		}

		public void mouseExited(MouseEvent e) {
			subLabel1.setIcon(new ImageIcon(SrcBag.schSubMenuSrc1_0));

		}
	}

}
