package Presentation_Layer;

	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JTextField;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import javax.swing.JPanel;
	import javax.swing.JTable;
	import javax.swing.JButton;
	import javax.swing.JTextPane;
	import javax.swing.border.EmptyBorder;

	import Business_Layer.Enrolment;
	
	import Business_Layer.StudentBll;

	import Business_Layer.TeachersBll;

	import java.awt.Font;
	import javax.swing.JLabel;
	import javax.swing.AbstractAction;
	import java.awt.event.ActionEvent;
	import javax.swing.Action;
	import java.awt.event.ActionListener;

public class View_project  extends JFrame{
	


	

		private JFrame frame;
		private JTextField name_login;
		private JTextField password_login;
		private JPanel contentPane;
		private JTable table;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_2;
		
		
		private TeachersBll tc=new TeachersBll();
		
		Enrolment enr=new Enrolment();
	
	   
		private StudentBll st=new StudentBll();
		
		
		
	
		
		
		//login
		private JPanel contentPane_login;
		private JLabel lblUsernameOrPassword;
		
		
		private JTable table_1;
		View_student v=null;
		View_admin a=null;
		Registration_student rs=null;
		Registration_teacher rt=null;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						View_project window = new View_project();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		
		public View_project() {
			initialize();
		
		}

		
		private void initialize() {
			
			
			frame = new JFrame();
			frame.getContentPane().setBackground(Color.BLACK);
			frame.getContentPane().setLayout(null);
			
			name_login = new JTextField();
			name_login.setBounds(88, 83, 159, 20);
			frame.getContentPane().add(name_login);
			name_login.setColumns(10);
			
			password_login = new JTextField();
			password_login.setBounds(88, 144, 159, 20);
			frame.getContentPane().add(password_login);
			password_login.setColumns(10);
			
			JButton btnNewButton = new JButton("Login Student");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					
					if(st.findAll(name_login.getText(), password_login.getText()))
						
						 v=new View_student();
					else
						login();
						
				}
			});
			
			btnNewButton.setBounds(292, 82, 112, 23);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Login Admin");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
					if(tc.findUser(name_login.getText(), password_login.getText()))
						a=new View_admin();
					else
						login();
				}
			});
			btnNewButton_1.setBounds(292, 127, 112, 23);
			frame.getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(88, 58, 159, 14);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(88, 119, 159, 14);
			frame.getContentPane().add(lblNewLabel_1);
			
			JButton btnNewButton_3 = new JButton("Register Student");
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rs=new Registration_student();
				}
			});
			btnNewButton_3.setBounds(267, 227, 137, 23);
			frame.getContentPane().add(btnNewButton_3);
			
			JButton btnNewButton_4 = new JButton("Register Teacher");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rt=new Registration_teacher();
				}
			});
			btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnNewButton_4.setBounds(267, 187, 137, 23);
			frame.getContentPane().add(btnNewButton_4);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		
		
		private void login() {
			
			setBounds(100, 100, 350, 200);
			contentPane_login = new JPanel();
			contentPane_login.setForeground(Color.WHITE);
			contentPane_login.setBackground(Color.BLACK);
			contentPane_login.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane_login);
			contentPane_login.setLayout(null);
			
			lblUsernameOrPassword = new JLabel("Username or password is incorrect");
			lblUsernameOrPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsernameOrPassword.setForeground(Color.WHITE);
			lblUsernameOrPassword.setBounds(42, 68, 267, 30);
			contentPane_login.add(lblUsernameOrPassword);
			setVisible(true);
			
		}

	}



