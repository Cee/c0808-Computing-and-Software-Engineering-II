package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JTextField;
import javax.swing.JButton;

import databaseutility.Constant;
import databaseutility.DatabaseFactoryImpl;

public class Launcher_UI extends JFrame{
	private JTextField userName;
	private JTextField passWordFiled;
	private JTextField ipField;
	private JTextField portField;
	public Launcher_UI() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(400,400);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 392, 350);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setBounds(85, 71, 83, 33);
		panel.add(lblNewLabel);
		
		JLabel passWord = new JLabel("密码：");
		passWord.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		passWord.setBounds(97, 114, 83, 33);
		panel.add(passWord);
		
		JLabel label_1 = new JLabel("数据库配置");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setBounds(54, 43, 83, 33);
		panel.add(label_1);
		
		userName = new JTextField();
		userName.setBounds(149, 78, 101, 21);
		panel.add(userName);
		userName.setColumns(10);
		
		passWordFiled = new JTextField();
		passWordFiled.setColumns(10);
		passWordFiled.setBounds(149, 121, 101, 21);
		panel.add(passWordFiled);
		
		final JButton button = new JButton("开启");
		button.setBounds(109, 268, 67, 23);
		panel.add(button);
		
		
		final JButton button_1 = new JButton("停止");
		button_1.setBounds(183, 268, 67, 23);
		panel.add(button_1);
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					stop();
					button.setEnabled(true);
					button_1.setEnabled(false);
					JOptionPane.showMessageDialog(null, "服务已关闭");
				} catch (Exception e1) {
				}
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					start();
					JOptionPane.showMessageDialog(null, "成功开启");
					button_1.setEnabled(true);
					button.setEnabled(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "开启失败，请检查您的网络配置与数据库配置");
				}
				
			}
		});
		JLabel label_2 = new JLabel("网络配置");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(54, 152, 83, 33);
		panel.add(label_2);
		
		JLabel ip = new JLabel("IP：");
		ip.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ip.setBounds(109, 182, 83, 33);
		panel.add(ip);
		
		ipField = new JTextField();
		ipField.setColumns(10);
		ipField.setBounds(149, 189, 101, 21);
		panel.add(ipField);
		
		JLabel port = new JLabel("端口：");
		port.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		port.setBounds(97, 225, 83, 33);
		panel.add(port);
		
		portField = new JTextField();
		portField.setColumns(10);
		portField.setBounds(149, 232, 101, 21);
		panel.add(portField);
		
		userName.setText(Constant.userName);
		passWordFiled.setText(Constant.passWord);
		portField.setText(Constant.port+"");
		ipField.setText(Constant.ip);
		
		
		
		setVisible(true);
	}
	Registry registry;
	public void start() throws RemoteException, MalformedURLException{
		Constant.userName = userName.getText();
		Constant.passWord = passWordFiled.getText();
		registry = LocateRegistry.createRegistry(Integer.parseInt(portField.getText()));
		DatabaseFactoryImpl databaseFactoryImpl = new DatabaseFactoryImpl();
		Naming.rebind("//"+ipField.getText()+":1099/NJWU", databaseFactoryImpl);
	}
	public void stop() throws RemoteException, MalformedURLException, NotBoundException{
		System.exit(0);
	}
	public static void main(String[] args){
		new Launcher_UI();
	}
}
