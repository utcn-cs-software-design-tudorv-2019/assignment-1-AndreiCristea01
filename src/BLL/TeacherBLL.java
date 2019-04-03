package BLL;

import javax.swing.JTable;

import DAO.TeachersDAO;
import Model.Teachers;

public class TeacherBLL {
	
	Teachers teacher=null;
	TeachersDAO tc=new TeachersDAO();
	
	public boolean Login(String username, String password) {
		
		teacher=tc.findUser(username, password);
		
		return true;
		
	}
	public JTable findMyCourse() {
		
		return tc.findMyCourse(teacher.getID());
		
	}

	public JTable findStudents(int id) {
		
		return tc.findStudents(id);
	}
	public Teachers getTeacher() {
		
		return teacher;
	}
	 
}
