package Presentation_Layer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.EnrolmentBLL;
import BLL.TeacherBLL;
import DAO.EnrolmentDAO;
import DAO.TeachersDAO;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ViewAdmin extends JFrame {

	private JPanel contentPane_t;
	private JTable table;
	private TeacherBLL tc = new TeacherBLL();

	EnrolmentBLL enr = null;
	private JTextField id_course_t;
	private JTextField id_student_t;
	private JTextField grade_t;
	private JTextField course_name_t;
	private JTextField date_t;
	int id_c = 40;
	private JTextField start_date;
	private JTextField end_date;
	private Validator valid = new Validator();
	ViewValidator view_v = null;

	public ViewAdmin(TeacherBLL teacher) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tc=teacher;
		enr=new EnrolmentBLL(tc);
		setVisible(true);
		setBounds(100, 100, 500, 400);
		contentPane_t = new JPanel();
		contentPane_t.setForeground(Color.WHITE);
		contentPane_t.setBackground(Color.BLACK);
		contentPane_t.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_t);
		contentPane_t.setLayout(null);

		JPanel panel_t = new JPanel();
		panel_t.setBackground(Color.BLACK);
		panel_t.setBounds(226, 11, 248, 284);
		contentPane_t.add(panel_t);

		table = new JTable();

		JButton btnNewButton_t = new JButton("My Courses");
		btnNewButton_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_t.removeAll();
				table = tc.findMyCourse();
				panel_t.add(table);
				panel_t.updateUI();
			}
		});
		btnNewButton_t.setBounds(10, 11, 110, 23);
		contentPane_t.add(btnNewButton_t);

		JButton btnNewButton_1t = new JButton("Students");
		btnNewButton_1t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_t.removeAll();
				table = tc.findStudents(Integer.parseInt(id_course_t.getText()));
				panel_t.add(table);
				panel_t.updateUI();
			}
		});
		btnNewButton_1t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1t.setBounds(10, 45, 110, 23);
		contentPane_t.add(btnNewButton_1t);

		id_course_t = new JTextField();
		id_course_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id_course_t.setBounds(130, 30, 86, 22);
		contentPane_t.add(id_course_t);
		id_course_t.setColumns(10);

		JButton btnNewButton_2t = new JButton("Update Grade");
		btnNewButton_2t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (valid.grade_valid(Integer.parseInt(grade_t.getText()))) {
					enr.updateGrade(Integer.parseInt(id_student_t.getText()), Integer.parseInt(id_course_t.getText()),
							Integer.parseInt(grade_t.getText()));
					panel_t.removeAll();
					table = tc.findStudents(Integer.parseInt(id_course_t.getText()));
					panel_t.add(table);
					panel_t.updateUI();
				} else
					view_v = new ViewValidator();
			}
		});
		btnNewButton_2t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2t.setBounds(10, 79, 110, 23);
		contentPane_t.add(btnNewButton_2t);

		JLabel lblIdCourse_t = new JLabel("ID Course");
		lblIdCourse_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdCourse_t.setForeground(Color.WHITE);
		lblIdCourse_t.setBounds(130, 11, 86, 19);
		contentPane_t.add(lblIdCourse_t);

		JLabel lblNewLabel_t = new JLabel("ID Student");
		lblNewLabel_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_t.setForeground(Color.WHITE);
		lblNewLabel_t.setBounds(130, 50, 86, 18);
		contentPane_t.add(lblNewLabel_t);

		id_student_t = new JTextField();
		id_student_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id_student_t.setBounds(130, 69, 86, 22);
		contentPane_t.add(id_student_t);
		id_student_t.setColumns(10);

		JLabel Grade_t = new JLabel("Grade");
		Grade_t.setForeground(Color.WHITE);
		Grade_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Grade_t.setBounds(130, 91, 86, 21);
		contentPane_t.add(Grade_t);

		grade_t = new JTextField();
		grade_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		grade_t.setBounds(130, 111, 86, 21);
		contentPane_t.add(grade_t);
		grade_t.setColumns(10);
		
		JLabel lblNewLabel_2t = new JLabel("Date Course");
		lblNewLabel_2t.setForeground(Color.WHITE);
		lblNewLabel_2t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2t.setBounds(130, 176, 86, 14);
		contentPane_t.add(lblNewLabel_2t);

		JButton add_course_t = new JButton("Add Course");
		add_course_t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_c++;

				enr.createCourse(id_c, date_t.getText(), course_name_t.getText());
			}
		});
		add_course_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add_course_t.setBounds(10, 113, 110, 23);
		contentPane_t.add(add_course_t);

		JLabel lblNewLabel_1_t = new JLabel("Course Name");
		lblNewLabel_1_t.setForeground(Color.WHITE);
		lblNewLabel_1_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_t.setBounds(130, 132, 86, 23);
		contentPane_t.add(lblNewLabel_1_t);

		course_name_t = new JTextField();
		course_name_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		course_name_t.setBounds(130, 154, 86, 20);
		contentPane_t.add(course_name_t);
		course_name_t.setColumns(10);

		

		date_t = new JTextField();
		date_t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date_t.setBounds(130, 194, 86, 20);
		contentPane_t.add(date_t);
		date_t.setColumns(10);

		JLabel lblNewLabel_t2 = new JLabel("Start Date");
		lblNewLabel_t2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_t2.setForeground(Color.WHITE);
		lblNewLabel_t2.setBounds(130, 218, 86, 14);
		contentPane_t.add(lblNewLabel_t2);

		start_date = new JTextField();
		start_date.setBounds(130, 233, 86, 20);
		contentPane_t.add(start_date);
		start_date.setColumns(10);

		JLabel lblNewLabel = new JLabel("End Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(130, 257, 86, 14);
		contentPane_t.add(lblNewLabel);

		end_date = new JTextField();
		end_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		end_date.setBounds(130, 275, 86, 20);
		contentPane_t.add(end_date);
		end_date.setColumns(10);

		JButton find_date = new JButton("Find_by_Date");
		find_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_t.removeAll();
				//table = tc.findByDate(start_date.getText(), end_date.getText(),
				//		Integer.parseInt(id_student_t.getText()));
				panel_t.add(table);
				panel_t.updateUI();
			}
		});
		find_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		find_date.setBounds(10, 147, 110, 23);
		contentPane_t.add(find_date);
	}
}
