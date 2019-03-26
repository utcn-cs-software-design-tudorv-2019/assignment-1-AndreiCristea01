package Presentation_Layer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class View_validator extends JFrame{
	private JPanel contentPane_login;
	private JLabel lblUsernameOrPassword;
	
	public View_validator() {
		
		setBounds(100, 100, 350, 200);
		contentPane_login = new JPanel();
		contentPane_login.setForeground(Color.WHITE);
		contentPane_login.setBackground(Color.BLACK);
		contentPane_login.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_login);
		contentPane_login.setLayout(null);
		
		lblUsernameOrPassword = new JLabel("wrong information");
		lblUsernameOrPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsernameOrPassword.setForeground(Color.WHITE);
		lblUsernameOrPassword.setBounds(93, 68, 197, 30);
		contentPane_login.add(lblUsernameOrPassword);
		setVisible(true);
	}

}
