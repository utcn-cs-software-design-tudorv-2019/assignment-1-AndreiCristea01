package Presentation_Layer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.StudentDAO;

public class RegistrationStudent extends JFrame {

	private JPanel contentPane_rs;
	private JTextField name_rs;
	private JTextField cnp_rs;
	private JTextField username_rs;
	private JTextField password_rs;
	StudentDAO st = new StudentDAO();

	public RegistrationStudent() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane_rs = new JPanel();
		contentPane_rs.setBackground(Color.BLACK);
		contentPane_rs.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_rs);
		contentPane_rs.setLayout(null);

		JButton btnRegister_rs = new JButton("REGISTER");
		btnRegister_rs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st.Register(name_rs.getText(), cnp_rs.getText(), username_rs.getText(), password_rs.getText());
			}
		});
		btnRegister_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister_rs.setBounds(241, 115, 89, 23);
		contentPane_rs.add(btnRegister_rs);

		JLabel lblName_rs = new JLabel("Name");
		lblName_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName_rs.setForeground(Color.WHITE);
		lblName_rs.setBounds(39, 31, 46, 14);
		contentPane_rs.add(lblName_rs);

		name_rs = new JTextField();
		name_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		name_rs.setBounds(39, 45, 86, 20);
		contentPane_rs.add(name_rs);
		name_rs.setColumns(10);

		JLabel lblCnp_rs = new JLabel("CNP");
		lblCnp_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCnp_rs.setForeground(Color.WHITE);
		lblCnp_rs.setBounds(39, 84, 46, 14);
		contentPane_rs.add(lblCnp_rs);

		cnp_rs = new JTextField();
		cnp_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cnp_rs.setBounds(39, 99, 86, 20);
		contentPane_rs.add(cnp_rs);
		cnp_rs.setColumns(10);

		JLabel lblUsername_rs = new JLabel("Username");
		lblUsername_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername_rs.setForeground(Color.WHITE);
		lblUsername_rs.setBounds(39, 140, 86, 14);
		contentPane_rs.add(lblUsername_rs);

		username_rs = new JTextField();
		username_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		username_rs.setBounds(39, 156, 86, 20);
		contentPane_rs.add(username_rs);
		username_rs.setColumns(10);

		JLabel lblPassword_rs = new JLabel("Password");
		lblPassword_rs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword_rs.setForeground(Color.WHITE);
		lblPassword_rs.setBounds(39, 195, 86, 14);
		contentPane_rs.add(lblPassword_rs);

		password_rs = new JTextField();
		password_rs.setBounds(39, 211, 86, 20);
		contentPane_rs.add(password_rs);
		password_rs.setColumns(10);

	}

}
