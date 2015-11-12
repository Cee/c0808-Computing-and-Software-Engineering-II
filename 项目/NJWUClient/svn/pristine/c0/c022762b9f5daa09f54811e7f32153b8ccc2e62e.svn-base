package mock.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mock.userbl_mock.UserController_Mock;

import presentation.adminui.AdminMainUI;
import presentation.insteacherui.InsMainUI;
import presentation.schteacherui.SchMainUI;
import presentation.srcBag.SrcBag;
import presentation.studentui.StuMainUI;
import presentation.teacherui.TeaMainUI;
import presentation.uielements.GrayPanel;
import presentation.uielements.LoadingPanel;
import presentation.uielements.MyButton;
import utility.Constant;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserControllerService;

public class MainFrameUI_Mock extends JFrame {

		public static LoadingPanel loadingPanel = new LoadingPanel("正在登录....");
		public static GrayPanel grayPanel = new GrayPanel();
		JPanel panel;
		JLabel bgLabel;
		private JPasswordField passwordField;
		private JTextField textField;
		private UserControllerService userController;
		static JPanel loginUI = new JPanel();
		public static UserMainUI_Mock userMainUI;
		MyButton confirmButton;
		MyButton cancelButton;
		
		public MainFrameUI_Mock() {
			int X, Y;
			int WIDTH = 1100;
			int HEIGHT = 670;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			X = this.getToolkit().getScreenSize().width;
			Y = this.getToolkit().getScreenSize().height;
			setBounds((X - WIDTH) / 2, (Y - HEIGHT) / 2 - 27, WIDTH, HEIGHT);

			panel = new JPanel();
			panel.setBounds(0, 0, WIDTH, HEIGHT);
			getContentPane().add(panel);

			ImageIcon bg = new ImageIcon(SrcBag.loginBgSrc);
			panel.setLayout(null);
			ImageIcon loginIcon = new ImageIcon(SrcBag.loginSrc);

			loginUI.setBounds(0, 10, 1100, 670);
			loginUI.setLayout(null);
			loginUI.setOpaque(false);

			JLabel label = new JLabel("系统登录");
			label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 26));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(418, 270, 297, 37);
			loginUI.add(label);

			JLabel loginLabel = new JLabel();
			loginLabel.setBounds(247, 185, 668, 413);
			loginLabel.setIcon(loginIcon);
			loginLabel.setVisible(true);

			JLabel label_1 = new JLabel("学工号：");
			label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
			label_1.setBounds(398, 341, 84, 37);
			loginUI.add(label_1);

			JLabel label_2 = new JLabel("密码：");
			label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
			label_2.setBounds(416, 390, 66, 45);
			loginUI.add(label_2);

			passwordField = new JPasswordField();
			passwordField.setBounds(482, 396, 262, 37);
			passwordField.setOpaque(false);
			loginUI.add(passwordField);
			passwordField.addKeyListener(new PasswordEnterListener());
			
			textField = new JTextField();
			textField.setBounds(482, 341, 262, 37);
			loginUI.add(textField);
			textField.setColumns(10);
			textField.addKeyListener(new TextEnterListener());
			textField.requestFocus();
			
			confirmButton = new MyButton("确认");
			confirmButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
			confirmButton.setBounds(458, 466, 113, 40);
			confirmButton.addActionListener(new ConfirmListener());
			loginUI.add(confirmButton);
			
			cancelButton = new MyButton("取消");
			cancelButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
			cancelButton.setBounds(609, 466, 113, 40);
			loginUI.add(cancelButton);
			loginUI.add(loginLabel);

			JLabel exitLabel = new JLabel();
			exitLabel.setBounds(26, 594, 78, 56);
			ImageIcon exitIcon = new ImageIcon(SrcBag.exitSrc);
			exitLabel.setIcon(exitIcon);
			exitLabel.addMouseListener(new ExitListener());
			panel.add(exitLabel);

			panel.add(loginUI);
			// panel.add(userMainUI);
			// userMainUI.setVisible(false);

			bgLabel = new JLabel();
			bgLabel.setBounds(0, 0, WIDTH, HEIGHT);
			bgLabel.setIcon(bg);
			panel.add(bgLabel);
			setResizable(false);
			setUndecorated(true);
			setVisible(true);
			add(grayPanel,0);
			loadingPanel.setBounds(450,300,loadingPanel.getWidth(),loadingPanel.getHeight());
			add(loadingPanel,0);		
			loadingPanel.setVisible(false);
			grayPanel.setVisible(false);
		}
		
		public static void showWating(){
			System.out.println("显示等待...");
			loadingPanel.setVisible(true);
			grayPanel.setVisible(true);	
		}
		public static void hideWating(){
			System.out.println("隐藏等待...");
			loadingPanel.setVisible(false);
			grayPanel.setVisible(false);	
		}
		public static void disableAll(){
			loginUI.setVisible(false);
			showWating();
		}
		public static void enableAll(){
			loginUI.setVisible(true);
			hideWating();
		}
		class TextEnterListener implements KeyListener{
			
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					passwordField.requestFocus();
				}
			}

			public void keyReleased(KeyEvent e) {	
			}
			
		}
		
		class PasswordEnterListener implements KeyListener{
			
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					disableAll();
					new Thread(){
						@Override
						public void run(){
							checkToLogin();
						}
					}.start();
				}
			}

			public void keyReleased(KeyEvent e) {	
			}
			
		}
		
		class ExitListener implements MouseListener {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		}
		
		public void hideAll() {
			loginUI.setVisible(false);
		}

		public static void showMain(JPanel panel) {
			if (panel != null)
				panel.setVisible(false);
			loginUI.setVisible(true);
		}

		public static void showError() {
			JOptionPane.showMessageDialog(null, "网络连接出现故障");
			showMain(userMainUI);
		}

		public void showPanel(JPanel panelToShow) {
			panel.add(panelToShow, 1);
			panel.repaint();
			panelToShow.setVisible(true);
		}

		class ConfirmListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				disableAll();
				new Thread(){
					@Override
					public void run(){
						checkToLogin();
					}
				}.start();
				
			}
		}
		
		private void checkToLogin(){
			loadingPanel.setMessage("正在登陆中...");
			userController = new UserController_Mock();
			String userID = textField.getText();
			int id;
			try {
				id = Integer.parseInt(userID);
			} catch (Exception e2) {
				enableAll();
				JOptionPane.showMessageDialog(null, "用户id必须为纯数字");
				return;
			}
			char[] password = passwordField.getPassword();
			int userType = Constant.UserType.NO_LOGIN;
			try {
				userType = userController.login(id, password);
			} catch (Exception e1) {
				showError();
				e1.printStackTrace();
			}
			switch (userType) {
			case Constant.UserType.ADMIN:
				userMainUI = new AdminMainUI_Mock(userController);
				break;
			case Constant.UserType.STUDENT:
				userMainUI = new StudentMainUI_Mock(userController);
				break;
			case Constant.UserType.TEACHER:
				userMainUI = new TeaMainUI_Mock(userController);
				break;
			case Constant.UserType.INS_TEACHER:
				userMainUI = new InsMainUI_Mock(userController);
				break;
			case Constant.UserType.SCH_TEACHER:
				userMainUI = new SchMainUI_Mock(userController);
				break;
			case Constant.UserType.NO_LOGIN:
				enableAll();
				return;
			default:
				enableAll();
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
				return;
			}
			hideAll();
			hideWating();
			showPanel(userMainUI);
		}
	
}