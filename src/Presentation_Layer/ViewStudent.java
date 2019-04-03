package Presentation_Layer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.EnrolmentBLL;
import BLL.StudentBLL;
import DAO.EnrolmentDAO;
import DAO.StudentDAO;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudent extends JFrame {

	private JPanel contentPane_s;
	private JTextField name_s;
	private JTextField cnp_s;
	private JTextField id_course_s;
	private StudentBLL st = new StudentBLL();

	EnrolmentBLL enr =null;
	private Validator validator = new Validator();
	private ViewValidator valid = null;

	private JTable table_1;

	public ViewStudent(StudentBLL stud) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		st=stud;
		enr=new EnrolmentBLL(st);
		setVisible(true);
		setBounds(100, 100, 500, 400);
		contentPane_s = new JPanel();
		contentPane_s.setBackground(Color.BLACK);
		contentPane_s.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_s);
		contentPane_s.setLayout(null);
		JPanel panel_s = new JPanel();

		JButton btnViewGrades_s = new JButton("View Grades");
		btnViewGrades_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_s.removeAll();

				table_1 = st.findGrades();
				table_1.setForeground(Color.BLACK);
				panel_s.add(table_1);
				panel_s.updateUI();

			}
		});
		btnViewGrades_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewGrades_s.setBounds(123, 45, 103, 23);
		contentPane_s.add(btnViewGrades_s);

		JButton btnNewButton_s = new JButton("Information");
		btnNewButton_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				name_s.setText(st.getName());
				cnp_s.setText(st.getCNP());
			}
		});
		btnNewButton_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_s.setBounds(10, 45, 103, 23);
		contentPane_s.add(btnNewButton_s);

		JButton btnNewButton_1s = new JButton("Update info");
		btnNewButton_1s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validator.cnp_valid(cnp_s.getText())) {
					
					st.updateById(name_s.getText(),cnp_s.getText());
				} else
					valid = new ViewValidator();

			}
		});
		btnNewButton_1s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1s.setBounds(10, 11, 103, 23);
		contentPane_s.add(btnNewButton_1s);

		JButton btnEnroll_s = new JButton("Enroll");
		btnEnroll_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enr.enroll( Integer.parseInt(id_course_s.getText()));
			}

		});
		btnEnroll_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEnroll_s.setBounds(123, 11, 103, 23);
		contentPane_s.add(btnEnroll_s);

		JLabel lblNewLabel_s = new JLabel("Name");
		lblNewLabel_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_s.setForeground(Color.WHITE);
		lblNewLabel_s.setBounds(10, 114, 46, 14);
		contentPane_s.add(lblNewLabel_s);

		JButton btnNewButton_2s = new JButton("All Course");
		btnNewButton_2s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				panel_s.removeAll();

				table_1 = st.findAllCourse();
				table_1.setForeground(Color.BLACK);
				panel_s.add(table_1);
				panel_s.updateUI();

			}
		});
		btnNewButton_2s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2s.setBounds(123, 79, 103, 23);
		contentPane_s.add(btnNewButton_2s);

		name_s = new JTextField();
		name_s.setBounds(10, 135, 103, 20);
		contentPane_s.add(name_s);
		name_s.setColumns(10);

		JLabel lblCnp_s = new JLabel("CNP");
		lblCnp_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCnp_s.setForeground(Color.WHITE);
		lblCnp_s.setBounds(10, 166, 46, 14);
		contentPane_s.add(lblCnp_s);

		cnp_s = new JTextField();
		cnp_s.setBounds(10, 191, 103, 20);
		contentPane_s.add(cnp_s);
		cnp_s.setColumns(10);

		JLabel lblIdCourse_s = new JLabel("ID Course");
		lblIdCourse_s.setForeground(Color.WHITE);
		lblIdCourse_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdCourse_s.setBounds(123, 115, 103, 14);
		contentPane_s.add(lblIdCourse_s);

		id_course_s = new JTextField();
		id_course_s.setBounds(123, 135, 103, 20);
		contentPane_s.add(id_course_s);
		id_course_s.setColumns(10);

		panel_s.setBackground(Color.BLACK);
		panel_s.setBounds(236, 11, 238, 310);
		contentPane_s.add(panel_s);

		JButton btnNewButton_3s = new JButton("Delete Enr");
		btnNewButton_3s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enr.deleteEnroll( Integer.parseInt(id_course_s.getText()));
			}
		});
		btnNewButton_3s.setBounds(10, 80, 103, 23);
		contentPane_s.add(btnNewButton_3s);

	}
	

}
