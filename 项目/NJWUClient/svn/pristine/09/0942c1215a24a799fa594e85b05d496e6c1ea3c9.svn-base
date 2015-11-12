package mock.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mock.teacherbl_mock.TeacherBl_Mock;
import presentation.mainui.ChangePassword;
import presentation.srcBag.SrcBag;
import presentation.teacherui.Tea_RecordScore;
import presentation.teacherui.Tea_ShowLesson;
import presentation.teacherui.Tea_ShowStudents;
import businesslogicservice.teacherblservice.TeacherBlService;
import businesslogicservice.userblservice.UserControllerService;

public class TeaMainUI_Mock extends UserMainUI_Mock {
	int click = 0;

	TeacherBlService teacher;

	JLabel btEditLesson;
	JLabel btShowStudents;
	JLabel btRecordScore;
	JLabel btChangePassword;

	JPanel tea_ShowLesson;
	JPanel changePassword;
	JPanel tea_ShowStudent;
	JPanel tea_EditLesson;
	JPanel tea_RecordScore;

	public TeaMainUI_Mock(UserControllerService userController) {

		super(userController);
		try {
			teacher = new TeacherBl_Mock();
		} catch (Exception e) {
			MainFrameUI_Mock.showError();
		}

		btEditLesson = new JLabel();
		btEditLesson.setBounds(6, 8, 134, 56);
		ImageIcon mainMenuBtnBg1 = new ImageIcon(SrcBag.teaMainMenuBgSrc1_0);
		btEditLesson.setIcon(mainMenuBtnBg1);
		btEditLesson.addMouseListener(new EditLessonListener());

		btShowStudents = new JLabel();
		btShowStudents.setBounds(6, 85, 134, 56);
		ImageIcon mainMenuBtnBg2 = new ImageIcon(SrcBag.teaMainMenuBgSrc2_0);
		btShowStudents.setIcon(mainMenuBtnBg2);
		btShowStudents.addMouseListener(new ShowStudentsListener());

		btRecordScore = new JLabel();
		btRecordScore.setBounds(6, 162, 134, 56);
		ImageIcon mainMenuBtnBg3 = new ImageIcon(SrcBag.teaMainMenuBgSrc3_0);
		btRecordScore.setIcon(mainMenuBtnBg3);
		btRecordScore.addMouseListener(new RecordScore());

		btChangePassword = new JLabel();
		btChangePassword.setBounds(6, 238, 134, 56);
		ImageIcon mainMenuBtnBg4 = new ImageIcon(SrcBag.teaMainMenuBgSrc4_0);
		btChangePassword.setIcon(mainMenuBtnBg4);
		btChangePassword.addMouseListener(new ChangePasswordListener());

		JLabel mainMenuSideBar = new JLabel();
		mainMenuSideBar.setBounds(0, 0, 25, 381);
		ImageIcon mainSideBar = new ImageIcon(SrcBag.stuMainSideBarSrc);
		mainMenuSideBar.setIcon(mainSideBar);

		JLabel mainMenuLabel = new JLabel();
		mainMenuLabel.setBounds(0, 0, 145, 381);
		ImageIcon mainMenuBg = new ImageIcon(SrcBag.mainMenuBgSrc);
		mainMenuLabel.setIcon(mainMenuBg);
		mainMenuPanel.add(mainMenuLabel);

		mainMenuLabel.add(mainMenuSideBar);
		mainMenuLabel.add(btEditLesson);
		mainMenuLabel.add(btShowStudents);
		mainMenuLabel.add(btRecordScore);
		mainMenuLabel.add(btChangePassword);

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
		if (tea_ShowLesson != null) {
			remove(tea_ShowLesson);
		}
		if (changePassword != null) {
			remove(changePassword);
		}
		if (tea_ShowStudent != null) {
			remove(tea_ShowStudent);
		}
		if (tea_EditLesson != null) {
			remove(tea_EditLesson);
		}
		if (tea_RecordScore != null) {
			remove(tea_RecordScore);
		}

	}

	class EditLessonListener implements MouseListener {

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
			if (click != 1)
				btEditLesson.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc1_0));
		}

	}

	class ShowStudentsListener implements MouseListener {
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
			if (click != 2)
				btShowStudents
						.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc2_0));
		}
	}

	class RecordScore implements MouseListener {
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
			if (click != 3)
				btRecordScore
						.setIcon(new ImageIcon(SrcBag.teaMainMenuBgSrc3_0));
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
				btChangePassword.setIcon(new ImageIcon(
						SrcBag.teaMainMenuBgSrc4_0));
		}
	}

}
