package BLL;

import javax.swing.JTable;

import DAO.StudentDAO;
import Model.Student;

public class StudentBLL {
	
	Student student=null;
	StudentDAO st=new StudentDAO();
	
	public String getName() {
		
		return student.getName();
	}
public String getCNP() {
		
		return student.getCNP();
	}
	
	public boolean Login(String username, String password) {
		
		student=st.findAll(username, password);
		
		if(student==null)
			return false;
		
		return true;
	}
	
	public JTable findGrades() {
		
		
		return st.findGrades(student.getID());
	}
	
	public void updateById(String name, String cnp) {
		
		student.setName(name);
		student.setCNP(cnp);
		st.updateById(student);
		
	}
	public JTable findAllCourse() {
		
		return st.findAllCourse();
	}
	public Student getStudent() {
		return student;
	}

}
