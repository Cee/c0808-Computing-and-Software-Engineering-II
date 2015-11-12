package presentation.uielements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.srcBag.SrcBag;
/**
 * 缓冲时候暗下去
 * @author luck
 *
 */
public class GrayPanel extends JPanel{
	int WIDTH = 1100;
	int HEIGHT = 670;
	public GrayPanel(){
		setBounds(0,0,WIDTH,HEIGHT);
		setLayout(null);
		JLabel bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon(SrcBag.greyBg));
		bgLabel.setOpaque(false);
		setOpaque(false);
		bgLabel.setBounds(0,0,getWidth(),getHeight());
		add(bgLabel);
	}
	
}
