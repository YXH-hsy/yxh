package application;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.loginjdbc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 *启动应用程序
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * 创建框架
	 */
	public login() {
		setTitle("\u767B\u5F55");
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(37, 47, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(37, 117, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(82, 44, 218, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(82, 114, 218, 21);
		contentPane.add(passwordField);
		
		//登录
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = passwordField.getText();
				int ans = loginjdbc.tologin(id, password);
				if(ans==1) {
					
					System.out.println("e");				
					Main.main(null);
					clo();
		            
				}else if(ans==-1) {
					JOptionPane.showMessageDialog(null, "用戶不存在", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
				}else {                                    
					JOptionPane.showMessageDialog(null, "密码错误", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
				}  
				
			}     
		});
		btnNewButton.setBounds(142, 177, 113, 27);
		contentPane.add(btnNewButton);
		
		//注册
		JButton btnNewButton_1 = new JButton("\u7ACB\u5373\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register re = new register();
				re.setVisible(true);
				clo();
			}
		});
		btnNewButton_1.setBounds(305, 213, 113, 27);
		contentPane.add(btnNewButton_1);
	}
	public void clo() {
		this.dispose();
	}
}
