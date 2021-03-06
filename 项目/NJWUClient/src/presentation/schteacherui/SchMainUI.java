package presentation.schteacherui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.mainui.ChangePassword;
import presentation.mainui.MainFrameUI;
import presentation.mainui.UserMainUI;
import presentation.srcBag.SrcBag;
import businesslogic.schteacherbl.SchTeacher;
import businesslogicservice.userblservice.UserControllerService;
/**
 * 学校教务老师主界面
 * @author luck
 *
 */
public class SchMainUI extends UserMainUI {

	int click = 0;
	/**
	 * 不同的菜单
	 */
	JLabel btFrame;
	JLabel btShowInfo;
	JLabel btChangePassword;
	JLabel btManageSelection;
	JLabel btPublish;
	JLabel mainMenuLabel;

	/**
	 * 可能打开的不同界面
	 */
	ChangePassword changePassword;
	SchTeacher schTeacher;
	Sch_ManageSelection sch_ManageSelection;
	Sch_Frame sch_Frame;
	Sch_ShowTeacherInfo sch_ShowTeacherInfo;
	Sch_ShowStudentInfo sch_ShowStudentInfo;
	Sch_ShowPlan sch_ShowPlan;
	Sch_ShowClassInfo sch_ShowClassInfo;
	Sch_Msg sch_Msg;
	ModuleEditor moduleEditor;

	JPanel subMenu;
	JLabel subLabel1;
	JLabel subLabel2;
	JLabel subLabel3;
	JLabel subLabel4;
	
	/**
	 * 菜单栏动画
	 */
	public void DrawAnimation(){
		int count = 0;
		String tail = ".png";
		
		ImageIcon mainMenuBg = new ImageIcon(SrcBag.gif5RowSequence+count+tail);
		mainMenuLabel.setIcon(mainMenuBg);
		mainMenuPanel.add(mainMenuLabel);
		
		btFrame = new JLabel();
		btFrame.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.schMenuBrSrcSequence1+count+tail);
		btFrame.setIcon(mainMenuBtnBg1);
		btFrame.addMouseListener(new FrameListener());

		btShowInfo = new JLabel();
		btShowInfo.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.schMenuBrSrcSequence2+count+tail);
		btShowInfo.setIcon(mainMenuBtnBg2);
		btShowInfo.addMouseListener(new ShowInfoListener());

		btManageSelection = new JLabel();
		btManageSelection.setBounds(6, 162, 134, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.schMenuBrSrcSequence3+count+tail);
		btManageSelection.setIcon(mainMenuBtnBg3);
		btManageSelection.addMouseListener(new ManageSelectionListener());

		btPublish = new JLabel();
		btPublish.setBounds(6, 239, 134, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.schMenuBrSrcSequence5+count+tail);
		btPublish.setIcon(mainMenuBtnBg4);
		btPublish.addMouseListener(new PublishListener());

		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 315, 133, 56);
		ImageIcon mainMenuBtnBg5 = new ImageIcon(SrcBag.stuMenuBrSrcSequence5+count+tail);
		btChangePassword.setIcon(mainMenuBtnBg5);
		btChangePassword.addMouseListener(new ChangePasswordListener());
		
		mainMenuPanel.add(btFrame,0);
		mainMenuPanel.add(btShowInfo,0);
		mainMenuPanel.add(btChangePassword,0);
		mainMenuPanel.add(btManageSelection,0);
		mainMenuPanel.add(btPublish,0);
		
		add(mainMenuPanel);
		setComponentZOrder(mainMenuPanel, 0);
		repaint();
		
		while(count <= 42){
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count <= 13){
				mainMenuBg = new ImageIcon(SrcBag.gif5RowSequence+count+tail);
				mainMenuLabel.setIcon(mainMenuBg);
			}
			if (count >= 6 && count <= 18){
				mainMenuBtnBg1 = new ImageIcon(SrcBag.schMenuBrSrcSequence1+(count-6)+tail);
				btFrame.setIcon(mainMenuBtnBg1);
			}
			if (count >= 12 && count <= 24){
				mainMenuBtnBg2 = new ImageIcon(SrcBag.schMenuBrSrcSequence2+(count-12)+tail);
				btShowInfo.setIcon(mainMenuBtnBg2);
			}
			if (count >= 18 && count <= 30){
				mainMenuBtnBg3 = new ImageIcon(SrcBag.schMenuBrSrcSequence3+(count-18)+tail);
				btManageSelection.setIcon(mainMenuBtnBg3);	
			}
			if (count >= 24 && count <= 36){
				mainMenuBtnBg4 = new ImageIcon(SrcBag.schMenuBrSrcSequence5+(count-24)+tail);
				btPublish.setIcon(mainMenuBtnBg4);	
			}
			if (count >= 30 && count <= 42){
				mainMenuBtnBg5 = new ImageIcon(SrcBag.schMenuBrSrcSequence4+(count-30)+tail);
				btChangePassword.setIcon(mainMenuBtnBg5);	
			}
			repaint();
			count++;
		}
	}
	
	class PublishListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			click = 4;
			clean();
			btPublish
					.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc5_1));

			removeAllPanel();
			sch_Msg = new Sch_Msg(schTeacher);
			sch_Msg.setBounds(201, 128, 851, 539);
			add(sch_Msg, 0);
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			btPublish
					.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc5_1));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (click != 4) {
				btPublish.setIcon(new ImageIcon(
						SrcBag.schMainMenuBgSrc5_0));
			}

		}
		
	}
	
	/**
	 * 构造函数 安排组件
	 * @param userController
	 */
	public SchMainUI(UserControllerService userController) {
		super(userController);
		try {
			schTeacher = new SchTeacher(userController);
		} catch (Exception e) {
			MainFrameUI.showError( );
		}

		mainMenuLabel = new JLabel();
		mainMenuLabel.setBounds(0, 0, 145, 381);
		
		new Thread(){
			public void run(){
				DrawAnimation();
			}
		}.start();
		
	
		add(logOutPanel);
		add(panelBgLabel);
		repaint();

	}
	/**
	 * 点击任意一个菜单，所有其他归位
	 */
	public void clean() {
		btFrame.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc1_0));
		btShowInfo.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc2_0));
		btManageSelection.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc3_0));
		btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5));
		btPublish.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc5_0));
		// subLabel1.setIcon(new ImageIcon(SrcBag.schSubMenuSrc1_0));
		// subLabel2.setIcon(new ImageIcon(SrcBag.schSubMenuSrc2_0));
		// subLabel3.setIcon(new ImageIcon(SrcBag.schSubMenuSrc3_0));
		// subLabel4.setIcon(new ImageIcon(SrcBag.schSubMenuSrc4_0));

	}

	
	/**
	 * 教学框架监听
	 * @author luck
	 *
	 */
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
	/**
	 * 查看信息监听
	 * 调出子菜单
	 * @author luck
	 *
	 */
	class ShowInfoListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			click = 2;
			clean();
			btShowInfo.setIcon(new ImageIcon(SrcBag.schMainMenuBgSrc2_1));
			removeAllPanel();
			subMenu = new JPanel();
			subLabel1 = new JLabel();
			subLabel2 = new JLabel();
			subLabel3 = new JLabel();
			subLabel4 = new JLabel();
			new Thread(){
				public void run(){
					createSubMenu(SrcBag.schSubMenuSequence1, 
							SrcBag.schSubMenuSequence2,
							SrcBag.schSubMenuSequence3,
							SrcBag.schSubMenuSequence4);
				}
			}.start();
			
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
	/**
	 * 管理选课监听
	 * @author luck
	 *
	 */
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
	/**
	 * 修改密码监听
	 * @author luck
	 *
	 */
	class ChangePasswordListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 5;
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
			if (click != 5) {
				btChangePassword.setIcon(new ImageIcon(SrcBag.stuMenuBgSrc5));
			}
		}

	}
	/**
	 * 去除所有的Panel
	 */
	void removeAllPanel() {
		if (sch_Msg!=null){
			remove(sch_Msg);
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
	/**
	 * 二级菜单
	 * @param src1
	 * @param src2
	 * @param src3
	 * @param src4
	 */
	void createSubMenu(String src1, String src2, String src3, String src4) {

		int count = 0;
		String tail = ".png";
		
		subMenu.setBounds(163, 165, 130, 180);
		subMenu.setOpaque(false);
		subMenu.setLayout(null);

		JLabel subMenuBgLabel = new JLabel();
		subMenuBgLabel.setBounds(0, 0, 130, 180);
		ImageIcon subMenuBg = new ImageIcon(SrcBag.gif4RowSubSequence+count+tail);
		subMenuBgLabel.setIcon(subMenuBg);

		subLabel1.setBounds(28, 5, 95, 39);
		ImageIcon subBtnBg1 = new ImageIcon(src1+count+tail);
		subLabel1.setIcon(subBtnBg1);
		subLabel1.addMouseListener(new SubMenuListener1());

		subLabel2.setBounds(28, 47, 95, 39);
		ImageIcon subBtnBg2 = new ImageIcon(src2+count+tail);
		subLabel2.setIcon(subBtnBg2);
		subLabel2.addMouseListener(new SubMenuListener2());

		subLabel3.setBounds(28, 89, 95, 39);
		ImageIcon subBtnBg3 = new ImageIcon(src3+count+tail);
		subLabel3.setIcon(subBtnBg3);
		subLabel3.addMouseListener(new SubMenuListener3());

		
		subLabel4.setBounds(28, 131, 95, 39);
		ImageIcon subBtnBg4 = new ImageIcon(src4+count+tail);
		subLabel4.setIcon(subBtnBg4);
		subLabel4.addMouseListener(new SubMenuListener4());
		
		subMenu.add(subMenuBgLabel,0);
		subMenu.add(subLabel1,0);
		subMenu.add(subLabel2,0);
		subMenu.add(subLabel3,0);
		subMenu.add(subLabel4,0);
		
		add(subMenu,0);
		setComponentZOrder(subMenu, 0);
		
		repaint();
		
		while(count <= 36){
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count <= 12){
				subMenuBg = new ImageIcon(SrcBag.gif4RowSubSequence+count+tail);
				subMenuBgLabel.setIcon(subMenuBg);
			}
			if (count >= 6 && count <= 18){
				subBtnBg1 = new ImageIcon(src1+(count-6)+tail);
				subLabel1.setIcon(subBtnBg1);
			}
			if (count >= 12 && count <= 24){
				subBtnBg2 = new ImageIcon(src2+(count-12)+tail);
				subLabel2.setIcon(subBtnBg2);
			}
			if (count >= 18 && count <= 30){
				subBtnBg3 = new ImageIcon(src3+(count-18)+tail);
				subLabel3.setIcon(subBtnBg3);
			}
			if (count >= 24 && count <= 36){
				subBtnBg4 = new ImageIcon(src4+(count-24)+tail);
				subLabel4.setIcon(subBtnBg4);
			}
			repaint();
			count++;
		}

	}
	/**
	 * 二级菜单的监听
	 * @author luck
	 *
	 */
	class SubMenuListener4 implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			try {
				sch_ShowClassInfo = new Sch_ShowClassInfo(schTeacher);
			} catch (RemoteException e1) {
				MainFrameUI.showError( );
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
				MainFrameUI.showError( );
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
