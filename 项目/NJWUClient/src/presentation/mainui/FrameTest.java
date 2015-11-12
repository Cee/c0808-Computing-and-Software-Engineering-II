package presentation.mainui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FrameTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		MainFrameUI mFrameUI = new MainFrameUI();
	}
}
