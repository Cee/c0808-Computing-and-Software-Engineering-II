package presentation.schteacherui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import presentation.mainui.MainFrameUI;

import businesslogicservice.schteacherblservice.SchTeacherBlService;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Sch_Msg extends JPanel {
	SchTeacherBlService schTeacher;
	JTextArea textArea;
	public Sch_Msg(SchTeacherBlService schTeacher) {
		this.schTeacher = schTeacher;
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(121, 104, 485, 302);
		add(textArea);
		
		JButton btSend = new JButton("发布");
		btSend.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btSend.setBounds(232, 459, 100, 37);
		add(btSend);
		
		btSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = textArea.getText();
				if(message.equals("")){
					JOptionPane.showMessageDialog(null, "通知不能为空");
				} else {
					try {
						if (Sch_Msg.this.schTeacher.sendBroadCast(message)){
							JOptionPane.showMessageDialog(null, "发布成功");
						} else {
							JOptionPane.showMessageDialog(null, "发布失败");
						}
					} catch (RemoteException e1) {
						MainFrameUI.showError();
						e1.printStackTrace();
					}
				}
			}
		});
		JButton btClear = new JButton("清空");
		btClear.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btClear.setBounds(379, 459, 100, 37);
		add(btClear);
		btClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		JLabel lbName = new JLabel("通知发布");
		lbName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setBounds(216, 36, 273, 55);
		add(lbName);
	}
}
