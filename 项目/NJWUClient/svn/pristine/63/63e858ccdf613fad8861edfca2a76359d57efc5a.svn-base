package presentation.insteacherui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.mainui.ChangePassword;
import presentation.mainui.MainFrameUI;
import presentation.mainui.UserMainUI;
import presentation.srcBag.SrcBag;
import businesslogic.insteacherbl.InsTeacher;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
/**
 * 
 * @author Cee
 *
 */
public class InsMainUI extends UserMainUI{
	InsTeacherBlService insTeacher;
	/**
	 * 数值为被选中的菜单
	 */
	int click;
	/**
	 * 菜单
	 */
	JLabel mainMenuLabel;
	JLabel btShowInsInfo;
	JLabel btEditCourse;
	JLabel btRelease;
	JLabel btSetPlan;
	JLabel btChangePassword;
	JLabel subMenuBgLabel;
	JLabel subLabel1;
	JLabel subLabel2;
	
	/**
	 * Panel
	 */
	Ins_CourseListPanel courseListPanel;
	Ins_CourseStuPanel courseStuPanel;
	Ins_EditCourse editPanel;
	Ins_ReleasePanel releasePanel;
	Ins_SetPlanPanel setPlanPanel;
	public static Ins_SetPlanSubPanel setPlanSubPanel;
	JPanel infoSubPanel;
	ChangePassword changePassword;
	
	/**
	 * 菜单栏动画
	 */
	public void DrawAnimation(){
		int count = 0;
		String tail = ".png";
		

		ImageIcon mainMenuBg = new ImageIcon(SrcBag.gif5RowSequence+count+tail);
		mainMenuLabel.setIcon(mainMenuBg);
		
		btShowInsInfo = new JLabel();
		btShowInsInfo.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.insMenuBrSrcSequence1+count+tail);
		btShowInsInfo.setIcon(mainMenuBtnBg1);
		btShowInsInfo.addMouseListener(new ShowInfoListener());

		btEditCourse = new JLabel();
		btEditCourse.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.insMenuBrSrcSequence2+count+tail);
		btEditCourse.setIcon(mainMenuBtnBg2);
		btEditCourse.addMouseListener(new EditCourseListener());

		btRelease = new JLabel();
		btRelease.setBounds(6, 162, 134, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.insMenuBrSrcSequence3+count+tail);
		btRelease.setIcon(mainMenuBtnBg3);
		btRelease.addMouseListener(new ReleaseListener());

		btSetPlan = new JLabel();
		btSetPlan.setBounds(6, 238, 134, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.insMenuBrSrcSequence4+count+tail);
		btSetPlan.setIcon(mainMenuBtnBg4);
		btSetPlan.addMouseListener(new SetPlanListener());

		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 315, 134, 56);
		ImageIcon mainMenuBtnBg5 = new ImageIcon(SrcBag.insMenuBrSrcSequence5+count+tail);
		btChangePassword.setIcon(mainMenuBtnBg5);
		btChangePassword.addMouseListener(new ChangePasswordListener());
		
		mainMenuPanel.add(btShowInsInfo,0);
		mainMenuPanel.add(btEditCourse,0);
		mainMenuPanel.add(btRelease,0);
		mainMenuPanel.add(btSetPlan,0);
		mainMenuPanel.add(btChangePassword,0);
		
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
				mainMenuBtnBg1 = new ImageIcon(SrcBag.insMenuBrSrcSequence1+(count-6)+tail);
				btShowInsInfo.setIcon(mainMenuBtnBg1);
			}
			if (count >= 12 && count <= 24){
				mainMenuBtnBg2 = new ImageIcon(SrcBag.insMenuBrSrcSequence2+(count-12)+tail);
				btEditCourse.setIcon(mainMenuBtnBg2);
			}
			if (count >= 18 && count <= 30){
				mainMenuBtnBg3 = new ImageIcon(SrcBag.insMenuBrSrcSequence3+(count-18)+tail);
				btRelease.setIcon(mainMenuBtnBg3);	
			}
			if (count >= 24 && count <= 36){
				mainMenuBtnBg4 = new ImageIcon(SrcBag.insMenuBrSrcSequence4+(count-24)+tail);
				btSetPlan.setIcon(mainMenuBtnBg4);	
			}
			if (count >= 30 && count <= 42){
				mainMenuBtnBg5 = new ImageIcon(SrcBag.insMenuBrSrcSequence5+(count-30)+tail);
				btChangePassword.setIcon(mainMenuBtnBg5);	
			}
			repaint();
			count++;
		}
		
	}
	
	public InsMainUI(UserControllerService userController){

		super(userController);
		try {
			insTeacher = new InsTeacher(userController);
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


		mainMenuPanel.add(mainMenuLabel);

		add(mainMenuPanel);
		add(logOutPanel);
		add(panelBgLabel);
	}
	
	/**
	 * 二级菜单
	 * @param src1
	 * @param src2
	 */
	public void createSubMenu(String src1, String src2) {
		int count = 0;
		String tail = ".png";
		
		infoSubPanel = new JPanel();
		infoSubPanel.setBounds(145, 125, 130, 91);
		infoSubPanel.setBounds(165, 133, 130, 91);
		infoSubPanel.setOpaque(false);
		infoSubPanel.setLayout(null);

		
		subMenuBgLabel.setBounds(0, 0, 130, 91);
		ImageIcon subMenuBg = new ImageIcon(SrcBag.gif2RowSubSequence+count+tail);
		subMenuBgLabel.setIcon(subMenuBg);
		
		subLabel1.setBounds(28, 5, 95, 39);
		ImageIcon subBtnBg1 = new ImageIcon(src1+count+tail);
		subLabel1.setIcon(subBtnBg1);
		
		subLabel2.setBounds(28, 47, 95, 39);
		ImageIcon subBtnBg2 = new ImageIcon(src2+count+tail);
		subLabel2.setIcon(subBtnBg2);
		
	
		infoSubPanel.add(subMenuBgLabel,0);
		infoSubPanel.add(this.subLabel1,0);
		infoSubPanel.add(this.subLabel2,0);
		add(infoSubPanel,0);
		setComponentZOrder(infoSubPanel, 0);
		
		repaint();
		
		
		while(count <= 24){
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count <= 12){
				subMenuBg = new ImageIcon(SrcBag.gif2RowSubSequence+count+tail);
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
			repaint();
			count++;
		}

	}
	
	/**
	 * 查看信息的监听
	 * @author luck
	 *
	 */
	class ShowInfoListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 1;
			initialButtonBg(click);
			subMenuBgLabel = new JLabel();
			subLabel1 = new JLabel();
			subLabel2 = new JLabel();
			new Thread(){
				public void run(){
					createSubMenu(SrcBag.insSubMenuSequence1, SrcBag.insSubMenuSequence2);
				}
			}.start();
			
			removeAllPanel();
			
			System.out.println(subLabel1 == null);
			subLabel1.addMouseListener(new SubMenuListener1());
			subLabel2.addMouseListener(new SubMenuListener2());
			
			
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			btShowInsInfo.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc1_1));
		}
		public void mouseExited(MouseEvent e) {
			if(click != 1){
				btShowInsInfo.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc1_0));
			}
		}
	}
	/**
	 * 编辑课程的监听
	 * @author luck
	 *
	 */
	class EditCourseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 2;
			initialButtonBg(click);
			removeAllPanel();
			editPanel = new Ins_EditCourse(insTeacher);
			editPanel.setBounds(201, 130, 851, 495);
			add(editPanel,0);
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			btEditCourse.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc2_1));
		}
		public void mouseExited(MouseEvent e) {
			if(click != 2){
				btEditCourse.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc2_0));
			}
		}
	}
	/**
	 * 发布课程的监听
	 * @author luck
	 *
	 */
	class ReleaseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 3;
			initialButtonBg(click);
			removeAllPanel();
			releasePanel = new Ins_ReleasePanel(insTeacher);
			releasePanel.setBounds(201, 130, 851, 495);
			add(releasePanel,0);
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			btRelease.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc3_1));
		}
		public void mouseExited(MouseEvent e) {
			if(click != 3){
				btRelease.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc3_0));
			}
		}
	}
	/**
	 * 制定计划的监听
	 * @author luck
	 *
	 */
	class SetPlanListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 4;
			initialButtonBg(click);
			removeAllPanel();
			setPlanPanel = new Ins_SetPlanPanel(insTeacher);
			setPlanPanel.setBounds(201, 130, 851, 495);
			add(setPlanPanel,0);
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			btSetPlan.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc4_1));
		}
		public void mouseExited(MouseEvent e) {
			if(click != 4){
				btSetPlan.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc4_0));
			}
		}
	}
	/**
	 * 修改密码的监听
	 * @author luck
	 *
	 */
	class ChangePasswordListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 5;
			initialButtonBg(click);
			removeAllPanel();
			changePassword = new ChangePassword(userController);
			changePassword.setBounds(201, 128, 851, 495);
			add(changePassword, 0);
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			btChangePassword.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc5_1));
		}
		public void mouseExited(MouseEvent e) {
			if(click != 5){
				btChangePassword.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc5_0));
			}
		}
	}
	/**
	 * 二级菜单1监听
	 * @author luck
	 *
	 */
	class SubMenuListener1 implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			courseListPanel = new Ins_CourseListPanel(insTeacher);
			courseListPanel.setBounds(201, 134, 851, 495);
			add(courseListPanel,0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			subLabel1.setIcon(new ImageIcon(SrcBag.insSubMenuSrc1_1));
		}
		public void mouseExited(MouseEvent e) {
			subLabel1.setIcon(new ImageIcon(SrcBag.insSubMenuSrc1_0));
		}
	}
	/**
	 * 二级菜单2监听
	 * @author luck
	 *
	 */
	class SubMenuListener2 implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			courseStuPanel = new Ins_CourseStuPanel(insTeacher);
			courseStuPanel.setBounds(201, 134, 851, 600);
			add(courseStuPanel,0);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			subLabel2.setIcon(new ImageIcon(SrcBag.insSubMenuSrc2_1));
		}
		public void mouseExited(MouseEvent e) {
			subLabel2.setIcon(new ImageIcon(SrcBag.insSubMenuSrc2_0));
		}
	}
	/**
	 * 去除所有的Panel
	 */
	void removeAllPanel(){
		if(setPlanSubPanel!=null){
			remove(setPlanSubPanel);
		}
		if(infoSubPanel != null){
			remove(infoSubPanel);
		}
		if(changePassword != null){
			remove(changePassword);
		}
		if(courseListPanel != null){
			remove(courseListPanel);
		}
		if(courseStuPanel !=null){
			remove(courseStuPanel);
		}
		if(editPanel != null){
			remove(editPanel);
		}
		if(releasePanel != null){
			remove(releasePanel);
		}
		if(setPlanPanel != null){
			remove(setPlanPanel);
		}
	}
	
	void clean(){
		if(courseListPanel != null){
			remove(courseListPanel);
		}
		if(courseStuPanel !=null){
			remove(courseStuPanel);
		}
	}
	/**
	 * 初始化菜单
	 * @param click
	 */
	void initialButtonBg(int click){
		btShowInsInfo.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc1_0));
		btEditCourse.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc2_0));
		btRelease.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc3_0));
		btSetPlan.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc4_0));
		btChangePassword.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc5_0));
		if(click == 1){
			btShowInsInfo.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc1_1));
		}
		else if(click ==2){
			btEditCourse.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc2_1));
		}
		else if(click ==3){
			btRelease.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc3_1));
		}

		else if(click ==4){
			btSetPlan.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc4_1));
		}

		else if(click ==5){
			btChangePassword.setIcon(new ImageIcon(SrcBag.insMainMenuBgSrc5_1));
		}

	}
}
