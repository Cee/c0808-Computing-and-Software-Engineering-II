package mock.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.srcBag.SrcBag;
import businesslogicservice.userblservice.UserControllerService;

public class UserMainUI_Mock extends JPanel {
	int WIDTH = 1100;
	int HEIGHT = 670;
	protected JLabel panelBgLabel;
	protected JPanel mainMenuPanel;
	protected JPanel logOutPanel;
	public UserControllerService userController;
	JLabel logoutJLabel;
	protected JLabel subLabel1;
	protected JLabel subLabel2;
	public UserMainUI_Mock(UserControllerService userController){
		this.userController = userController;
		setBounds(0,0,WIDTH,HEIGHT);
		setLayout(null);
		setOpaque(false);
		
		mainMenuPanel = new JPanel();
		mainMenuPanel.setBounds(15,140,145,600);
		mainMenuPanel.setLayout(null);
		
		ImageIcon bg = new ImageIcon(SrcBag.mainBgSrc);
		panelBgLabel = new JLabel();
		panelBgLabel.setIcon(bg);
		panelBgLabel.setBounds(0,0,WIDTH,HEIGHT);
		
		logOutPanel = new JPanel();
		logOutPanel.setBounds(800, 35, 154, 85);
		logOutPanel.setLayout(null);
		logOutPanel.setOpaque(false);
		
		JLabel welcomJLabel = new JLabel("欢迎您,"+userController.getName());
		welcomJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		welcomJLabel.setForeground(Color.WHITE);
		welcomJLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		welcomJLabel.setBounds(0, 6, 134, 16);
		logOutPanel.add(welcomJLabel);
		
		logoutJLabel = new JLabel("<HTML><U>注销登录</U></HTML>");
		logoutJLabel.setForeground(new Color(204, 153, 102));
		logoutJLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		logoutJLabel.setBounds(72, 34, 62, 16);
		logOutPanel.add(logoutJLabel);
		logoutJLabel.addMouseListener(new LogOutListener());
	}
	public class LogOutListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}
		
		public void mousePressed(MouseEvent e) {
			MainFrameUI_Mock.showMain(UserMainUI_Mock.this);
		}

		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	
	protected JPanel createSubMenu(String src1, String src2, String type) {
		JPanel subMenu = new JPanel();
		subMenu.setBounds(145, 125, 130, 91);
		subMenu.setOpaque(false);
		subMenu.setLayout(null);

		JLabel subMenuBgLabel = new JLabel();
		subMenuBgLabel.setBounds(0, 0, 130, 91);
		ImageIcon subMenuBg = new ImageIcon(SrcBag.subMenu_twoBgSrc);

		subLabel1 = new JLabel();
		subLabel1.setBounds(28, 5, 95, 39);
		ImageIcon subBtnBg1 = new ImageIcon(src1);
		subLabel1.setIcon(subBtnBg1);
		subMenu.add(subLabel1);
		subMenuBgLabel.setIcon(subMenuBg);

		subLabel2 = new JLabel();
		subLabel2.setBounds(28, 47, 95, 39);
		ImageIcon subBtnBg2 = new ImageIcon(src2);
		subLabel2.setIcon(subBtnBg2);
		subMenu.add(subLabel2);
		subMenu.add(subMenuBgLabel);

		return subMenu;
	}
}
