package presentation.teacherui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.mainui.ChangePassword;
import presentation.mainui.MainFrameUI;
import presentation.mainui.UserMainUI;
import presentation.srcBag.SrcBag;
import businesslogic.teacherbl.Teacher;
import businesslogicservice.teacherblservice.TeacherBlService;
import businesslogicservice.userblservice.UserControllerService;
/**
 * 任课老师的主界面
 * @author luck
 *
 */
public class TeaMainUI extends UserMainUI{

	int click=0;
	
	TeacherBlService teacher;
	
	JLabel btEditLesson;
	JLabel btShowStudents;
	JLabel btRecordScore;
	JLabel btChangePassword;
	JLabel mainMenuLabel;

	JPanel tea_ShowLesson;
	JPanel changePassword;
	JPanel tea_ShowStudent;
	static JPanel tea_EditLesson;
	JPanel tea_RecordScore;
	
	public void DrawAnimation(){
		
		int count = 0;
		String tail = ".png";
		
		ImageIcon mainMenuBg = new ImageIcon(SrcBag.gif4RowSequence);
		mainMenuLabel.setIcon(mainMenuBg);
		
		btEditLesson = new JLabel();
		btEditLesson.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.teaMenuBrSrcSequence1+count+tail);
		btEditLesson.setIcon(mainMenuBtnBg1);
		btEditLesson.addMouseListener(new EditLessonListener());
		
		btShowStudents = new JLabel();
		btShowStudents.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.teaMenuBrSrcSequence2+count+tail);
		btShowStudents.setIcon(mainMenuBtnBg2);
		btShowStudents.addMouseListener(new ShowStudentsListener());
		
		btRecordScore = new JLabel();
		btRecordScore.setBounds(6, 162, 134, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.teaMenuBrSrcSequence3+count+tail);
		btRecordScore.setIcon(mainMenuBtnBg3);
		btRecordScore.addMouseListener(new RecordScore());
		
		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 238, 134, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.teaMenuBrSrcSequence4+count+tail);
		btChangePassword.setIcon(mainMenuBtnBg4);
		btChangePassword.addMouseListener(new ChangePasswordListener());
		
		mainMenuLabel.add(btEditLesson,0);
		mainMenuLabel.add(btShowStudents,0);
		mainMenuLabel.add(btRecordScore,0);
		mainMenuLabel.add(btChangePassword,0);
		
		add(mainMenuPanel);
		setComponentZOrder(mainMenuPanel, 0);
		repaint();
		
		while(count <= 36){
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count <= 13){
				mainMenuBg = new ImageIcon(SrcBag.gif4RowSequence+count+tail);
				mainMenuLabel.setIcon(mainMenuBg);
			}
			if (count >= 6 && count <= 18){
				mainMenuBtnBg1 = new ImageIcon(SrcBag.teaMenuBrSrcSequence1+(count-6)+tail);
				btEditLesson.setIcon(mainMenuBtnBg1);
			}
			if (count >= 12 && count <= 24){
				mainMenuBtnBg2 = new ImageIcon(SrcBag.teaMenuBrSrcSequence2+(count-12)+tail);
				btShowStudents.setIcon(mainMenuBtnBg2);
			}
			if (count >= 18 && count <= 30){
				mainMenuBtnBg3 = new ImageIcon(SrcBag.teaMenuBrSrcSequence3+(count-18)+tail);
				btRecordScore.setIcon(mainMenuBtnBg3);	
			}
			if (count >= 24 && count <= 36){
				mainMenuBtnBg4 = new ImageIcon(SrcBag.teaMenuBrSrcSequence4+(count-24)+tail);
				btChangePassword.setIcon(mainMenuBtnBg4);	
			}
			repaint();
			count++;
		}
		
		
	}
	
	public TeaMainUI(UserControllerService userController) {
		
		super(userController);
		try {
			teacher = new Teacher(userController);
		} catch (Exception e) {
			MainFrameUI.showError();
		}
		
		
		mainMenuLabel = new JLabel();
		mainMenuLabel.setBounds(0, 0, 145, 305);
		mainMenuPanel.add(mainMenuLabel,0);

		new Thread(){
			public void run(){
				DrawAnimation();
			}
		}.start();
		add(mainMenuPanel);
		add(logOutPanel);
		add(panelBgLabel);
	}
	
	public void clean() {
		btEditLesson.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc1_0));
		btShowStudents.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc2_0));
		btRecordScore.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc3_0));
		btChangePassword.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc4_0));
	}
	private void removeAllPanel() {
		if (tea_ShowLesson!=null){
			remove(tea_ShowLesson);
		}
		if (changePassword!=null){
			remove(changePassword);
		}
		if (tea_ShowStudent!=null){
			remove(tea_ShowStudent);
		}
		if (tea_EditLesson!=null){
			remove(tea_EditLesson);
		}
		if (tea_RecordScore!=null){
			remove(tea_RecordScore);
		}
		
	}
	class EditLessonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			click = 1;
			clean();
			removeAllPanel();
			btEditLesson.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc1_1));
			tea_ShowLesson = new Tea_ShowLesson(teacher);
			tea_ShowLesson.setBounds(201, 128, 851, 495);
			add(tea_ShowLesson, 0);
			repaint();
		}

		

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			btEditLesson.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc1_1));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (click!=1)
				btEditLesson.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc1_0));			
		}
		
	}
	class ShowStudentsListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			click = 2;
			clean();
			removeAllPanel();

			btShowStudents.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc2_1));
			tea_ShowStudent = new Tea_ShowStudents(teacher);
			tea_ShowStudent.setBounds(201, 128, 851, 495);
			add(tea_ShowStudent, 0);
			repaint();
		}

		

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			btShowStudents.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc2_1));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (click!=2)
				btShowStudents.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc2_0));			
		}		
	}
	
	class RecordScore implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			click = 3;
			clean();
			removeAllPanel();
			btRecordScore.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc3_1));
			tea_RecordScore = new Tea_RecordScore(teacher);
			tea_RecordScore.setBounds(201, 128, 851, 495);
			add(tea_RecordScore, 0);
			repaint();
		}

		

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			btRecordScore.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc3_1));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (click!=3)
				btRecordScore.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc3_0));			
		}		
	}
	
	class ChangePasswordListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			click = 4;
			clean();
			btChangePassword.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc4_1));
			removeAllPanel();
			changePassword = new ChangePassword(userController);
			changePassword.setBounds(201, 128, 851, 495);
			add(changePassword, 0);
			repaint();
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			btChangePassword.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc4_1));
		}

		public void mouseExited(MouseEvent e) {
			if (click != 4)
				btChangePassword.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc4_0));
		}
	}
}
