package mock.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mock.insteacherbl_mock.InsTeacherBl_Mock;

import presentation.insteacherui.Ins_CourseListPanel;
import presentation.insteacherui.Ins_CourseStuPanel;
import presentation.insteacherui.Ins_EditCourse;
import presentation.insteacherui.Ins_ReleasePanel;
import presentation.insteacherui.Ins_SetPlanPanel;
import presentation.mainui.ChangePassword;
import presentation.mainui.MainFrameUI;
import presentation.srcBag.SrcBag;
import businesslogic.insteacherbl.InsTeacher;
import businesslogicservice.insteacherblservice.InsTeacherBlService;
import businesslogicservice.userblservice.UserControllerService;

public class InsMainUI_Mock extends UserMainUI_Mock{

	InsTeacherBlService insTeacher;
	int click;
	
	JLabel btShowInsInfo;
	JLabel btEditCourse;
	JLabel btRelease;
	JLabel btSetPlan;
	JLabel btChangePassword;
	
	Ins_CourseListPanel courseListPanel;
	Ins_CourseStuPanel courseStuPanel;
	Ins_EditCourse editPanel;
	Ins_ReleasePanel releasePanel;
	Ins_SetPlanPanel setPlanPanel;
	
	JPanel infoSubPanel;
	ChangePassword changePassword;
	
	public InsMainUI_Mock(UserControllerService userController){

		super(userController);
		try {
			insTeacher = new InsTeacherBl_Mock();
		} catch (Exception e) {
			MainFrameUI_Mock.showError( );
		}
		
		JLabel mainMenuSideBar = new JLabel();
		mainMenuSideBar.setBounds(0, 0, 25, 381);
		ImageIcon mainSideBar = new ImageIcon(SrcBag.stuMainSideBarSrc);

		btShowInsInfo = new JLabel();
		btShowInsInfo.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.insMainMenuBgSrc1_0);
		btShowInsInfo.setIcon(mainMenuBtnBg1);
		btShowInsInfo.addMouseListener(new ShowInfoListener());

		btEditCourse = new JLabel();
		btEditCourse.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.insMainMenuBgSrc2_0);
		btEditCourse.setIcon(mainMenuBtnBg2);
		btEditCourse.addMouseListener(new EditCourseListener());

		btRelease = new JLabel();
		btRelease.setBounds(6, 162, 133, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.insMainMenuBgSrc3_0);
		btRelease.setIcon(mainMenuBtnBg3);
		btRelease.addMouseListener(new ReleaseListener());

		btSetPlan = new JLabel();
		btSetPlan.setBounds(6, 238, 133, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.insMainMenuBgSrc4_0);
		btSetPlan.setIcon(mainMenuBtnBg4);
		btSetPlan.addMouseListener(new SetPlanListener());

		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 315, 133, 56);
		ImageIcon mainMenuBtnBg5 = new ImageIcon(SrcBag.insMainMenuBgSrc5_0);
		btChangePassword.setIcon(mainMenuBtnBg5);
		btChangePassword.addMouseListener(new ChangePasswordListener());
		
		mainMenuPanel.add(btShowInsInfo);
		mainMenuPanel.add(btEditCourse);
		mainMenuPanel.add(btRelease);
		mainMenuPanel.add(btSetPlan);
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
	
	class ShowInfoListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			click = 1;
			initialButtonBg(click);
			infoSubPanel = createSubMenu(SrcBag.insSubMenuSrc1_0, SrcBag.insSubMenuSrc2_0, "student");
			removeAllPanel();
			subLabel1.addMouseListener(new SubMenuListener1());
			subLabel2.addMouseListener(new SubMenuListener2());
			infoSubPanel.setBounds(165, 133, 130, 91);
			add(infoSubPanel,0);
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
	
	class SubMenuListener2 implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			removeAllPanel();
			courseStuPanel = new Ins_CourseStuPanel(insTeacher);
			courseStuPanel.setBounds(201, 134, 851, 495);
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
	
	void removeAllPanel(){
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
