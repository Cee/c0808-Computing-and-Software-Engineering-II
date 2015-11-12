package presentation.adminui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentation.mainui.MainFrameUI;
import presentation.mainui.UserMainUI;
import presentation.srcBag.SrcBag;
import businesslogic.adminbl.Admin;
import businesslogicservice.adminblservice.AdminblService;
import businesslogicservice.userblservice.UserControllerService;

public class AdminMainUI extends UserMainUI {
	private int click = 0;
	AdminblService admin;
	JLabel mainMenuLabel;
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
	
	public void DrawAnimation(){
		int count = 0;
		String tail = ".png";
		mainMenuLabel = new JLabel();
		mainMenuLabel.setBounds(0, 0, 158, 238);
		mainMenuPanel.add(mainMenuLabel,0);
		ImageIcon mainMenuBg = new ImageIcon(SrcBag.gif3RowSequence+count+tail);
		mainMenuLabel.setIcon(mainMenuBg);
		btRegister = new JLabel();
		btRegister.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.adminMenuBrSrcSequence1+count+tail);
		btRegister.setIcon(mainMenuBtnBg1);
		btRegister.addMouseListener(new registerListener());
		mainMenuPanel.add(btRegister,0);
		btModify = new JLabel();
		btModify.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.adminMenuBrSrcSequence2+count+tail);
		btModify.setIcon(mainMenuBtnBg2);
		btModify.addMouseListener(new modifyListener());
		mainMenuPanel.add(btModify,0);
		btDelete = new JLabel();
		btDelete.setBounds(6, 162, 133, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.adminMenuBrSrcSequence3+count+tail);
		btDelete.setIcon(mainMenuBtnBg3);
		btDelete.addMouseListener(new deleteListener());
		mainMenuPanel.add(btDelete,0);
		add(mainMenuPanel);
		setComponentZOrder(mainMenuPanel, 0);
		repaint();
		
		while(count <= 31){
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count <= 13){
				mainMenuBg = new ImageIcon(SrcBag.gif3RowSequence+count+tail);
				mainMenuLabel.setIcon(mainMenuBg);
			}
			if (count >= 6 && count <= 19){
				mainMenuBtnBg1 = new ImageIcon(SrcBag.adminMenuBrSrcSequence1+(count-6)+tail);
				btRegister.setIcon(mainMenuBtnBg1);
			}
			if (count >= 12 && count <= 25){
				mainMenuBtnBg2 = new ImageIcon(SrcBag.adminMenuBrSrcSequence2+(count-12)+tail);
				btModify.setIcon(mainMenuBtnBg2);
			}
			if (count >= 18 && count <= 31){
				mainMenuBtnBg3 = new ImageIcon(SrcBag.adminMenuBrSrcSequence3+(count-18)+tail);
				btDelete.setIcon(mainMenuBtnBg3);	
			}
			repaint();
			count++;
		}
	}
	public AdminMainUI(UserControllerService userController) {
		super(userController);
		try {
			admin = new Admin(userController);
		} catch (Exception e) {
			MainFrameUI.showError();
		}
		JLabel mainMenuSideBar = new JLabel();
		mainMenuSideBar.setBounds(0, 0, 25, 381);
		ImageIcon mainSideBar = new ImageIcon(SrcBag.stuMainSideBarSrc);

	
		add(logOutPanel);
		add(panelBgLabel);
		

		new Thread(){
			public void run(){
				DrawAnimation();
			}
		}.start();
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
			setComponentZOrder(mainMenuPanel, 0);
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