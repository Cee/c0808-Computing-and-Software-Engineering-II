package presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogicservice.userblservice.UserControllerService;

import presentation.srcBag.SrcBag;
import javax.swing.SwingConstants;
/**
 * 用户主界面的父类
 * 包括菜单栏，上面的排头
 * 注销按钮
 * @author luck
 *
 */
public abstract class UserMainUI extends JPanel{
	int WIDTH = 1100;
	int HEIGHT = 670;
	protected JLabel panelBgLabel;
	protected JPanel mainMenuPanel;
	protected JPanel logOutPanel;
	public UserControllerService userController;
	JLabel logoutJLabel;
	public UserMainUI(UserControllerService userController){
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
	/**
	 * 注销的监听
	 * @author luck
	 *
	 */
	public class LogOutListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}
		
		public void mousePressed(MouseEvent e) {
			MainFrameUI.showMain(UserMainUI.this);
		}

		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	
	
	

}
