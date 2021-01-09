package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.registejdbc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField idt;
	private JPasswordField password1;
	private JPasswordField password2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(29, 61, 72, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(29, 159, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setBounds(29, 260, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		
		
		idt = new JTextField();
		idt.setBounds(152, 62, 152, 24);
		contentPane.add(idt);
		idt.setColumns(10);
		
		password1 = new JPasswordField();
		password1.setBounds(152, 156, 152, 24);
		contentPane.add(password1);
		
		password2 = new JPasswordField();
		password2.setBounds(152, 257, 152, 24);
		contentPane.add(password2);
		
		//注册
				JButton btnNewButton = new JButton("\u6CE8\u518C");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = idt.getText();
						String passwordf= password1.getText();
						String passwordf1= password2.getText();
						
						if(id.equals("")) {
							JOptionPane.showMessageDialog(null, "用戶名不能为空", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
						}else if(!passwordf.equals(passwordf1)) {
							JOptionPane.showMessageDialog(null, "密码不一致", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
						}else 
						{
							
							if(registejdbc.tores(id, passwordf)==1)
							JOptionPane.showMessageDialog(null, "注册成功", "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);
							clo();
						}
					}
				});
				btnNewButton.setBounds(125, 350, 144, 27);
				contentPane.add(btnNewButton);
	}
	public void clo() {
		this.dispose();
		login lo = new login();
		
	}
}
