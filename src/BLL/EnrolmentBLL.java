package BLL;

import DAO.EnrolmentDAO;
import DAO.StudentDAO;
import Model.Student;
import Model.Teachers;

public class EnrolmentBLL {
	EnrolmentDAO enr=new EnrolmentDAO();
	Student student=null;
    Teachers teacher=null;
	
	public EnrolmentBLL(StudentBLL st) {
		
		student=st.getStudent();
	}
public EnrolmentBLL(TeacherBLL tc) {
		
		teacher=tc.getTeacher();
	}
	public void enroll(int id) {
		
		enr.enroll(student.getID(), id);
	}
	public void deleteEnroll(int id) {
		
		enr.deleteEnroll(student.getID(), id);
	}
	public void createCourse(int id,String date,String Name) {
		
		enr.createCourse(id, date, Name,teacher.getID());
	}

	public void updateGrade(int student, int exam, int grade) {
		
		enr.updateGrade(student, exam, grade);
	}
}
