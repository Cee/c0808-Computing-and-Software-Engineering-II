package presentation.uielements;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import presentation.srcBag.SrcBag;

import java.awt.Font;
import java.awt.Color;
/**
 * 缓冲的lael
 * @author luck
 *
 */
public class LoadingPanel extends JPanel{
	public void setMessage(String message){
		lbMessage.setText(message);
	}
	
	public LoadingPanel(String message) {
		setLayout(null);
		
		JLabel lbLoadingIcon = new JLabel("New label");
		ImageIcon loadingImage = new ImageIcon(SrcBag.loading);
		
		lbLoadingIcon.setBounds(59, 20, loadingImage.getIconWidth(), loadingImage.getIconHeight());
		lbLoadingIcon.setIcon(loadingImage);
		add(lbLoadingIcon);
		lbLoadingIcon.setOpaque(false);
		
		lbMessage = new JLabel(message);
		lbMessage.setForeground(new Color(0, 0, 0));
		lbMessage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		lbMessage.setBounds(59, 173, 150, 30);
		lbMessage.setOpaque(false);
		add(lbMessage);
		setOpaque(false);
		
		setSize(336, 289);
	}
	JLabel lbMessage ;
}
