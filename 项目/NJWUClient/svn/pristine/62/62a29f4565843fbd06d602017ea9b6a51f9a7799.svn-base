package mock.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mock.adminbl_mock.Admin_Mock;
import presentation.adminui.Admin_Delete;
import presentation.adminui.Admin_Modify;
import presentation.adminui.Admin_Register;
import presentation.mainui.MainFrameUI;
import presentation.srcBag.SrcBag;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.userblservice.UserControllerService;

public class AdminMainUI_Mock extends UserMainUI_Mock{
	private int click = 0;
	AdminblService admin;
	JLabel btRegister;
	JLabel btModify;
	JLabel btDelete;
	Admin_Register admin_Register;
	Admin_Modify admin_Modify;
	Admin_Delete admin_Delete;

	public void clear() {
		btRegister.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc1));
		btModify.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc2));
		btDelete.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc3));
	}

	public AdminMainUI_Mock(UserControllerService userController) {
		super(userController);
		try {
			admin = new Admin_Mock();
		} catch (Exception e) {
			MainFrameUI_Mock.showError();
		}
		JLabel mainMenuSideBar = new JLabel();
		mainMenuSideBar.setBounds(0, 0, 25, 381);
		ImageIcon mainSideBar = new ImageIcon(SrcBag.stuMainSideBarSrc);// need
																		// to
																		// change

		btRegister = new JLabel();
		btRegister.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.adminMenuBgSrc1);
		btRegister.setIcon(mainMenuBtnBg1);
		btRegister.addMouseListener(new registerListener());

		btModify = new JLabel();
		btModify.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.adminMenuBgSrc2);
		btModify.setIcon(mainMenuBtnBg2);
		btModify.addMouseListener(new modifyListener());

		btDelete = new JLabel();
		btDelete.setBounds(6, 162, 133, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.adminMenuBgSrc3);
		btDelete.setIcon(mainMenuBtnBg3);
		btDelete.addMouseListener(new deleteListener());

		mainMenuPanel.add(btRegister);
		mainMenuPanel.add(btModify);
		mainMenuPanel.add(btDelete);

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

	class registerListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			clear();
			btRegister.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc1_1));
			click = 1;
			removeAllPanel();
			admin_Register = new Admin_Register(admin);
			admin_Register.setBounds(201, 128, 851, 495);
			add(admin_Register, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btRegister.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc1_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 1) {
				btRegister.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc1));
			}
		}

	}

	class modifyListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			clear();
			btModify.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc2_1));
			click = 2;
			removeAllPanel();
			admin_Modify = new Admin_Modify(admin);
			admin_Modify.setBounds(201, 128, 851, 495);
			add(admin_Modify, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btModify.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc2_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 2) {
				btModify.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc2));
			}
		}

	}

	class deleteListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			clear();
			click = 3;
			btDelete.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc3_1));
			removeAllPanel();
			admin_Delete = new Admin_Delete(admin);
			admin_Delete.setBounds(201, 128, 851, 495);
			add(admin_Delete, 0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btDelete.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc3_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 3) {
				btDelete.setIcon(new ImageIcon(SrcBag.adminMenuBgSrc3));
			}

		}

	}

	void removeAllPanel() {
		if (admin_Register != null) {
			remove(admin_Register);
		}
		if (admin_Modify != null) {
			remove(admin_Modify);
		}
		if (admin_Delete != null) {
			remove(admin_Delete);
		}
	}

}
