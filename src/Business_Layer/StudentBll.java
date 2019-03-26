package Business_Layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;

import Data_Layer.ConnectionFactory;
import Data_Layer.Student;


public class StudentBll {
	
	protected static final Logger LOGGER = Logger.getLogger(StudentBll.class.getName());
	static Student student=null;

	public int getId() {
		
		return student.getID();
		
	}
	public String getname() {
		
		return student.getName();
	}
	public String getcnp() {
		
		return student.getCNP();
	}
	public void setname(String name) {
		
		student.setName(name);
	}
	public void setcnp(String name) {
		
		student.setCNP(name);
	}
public static void Register(String name, String cnp, String username,String password) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement updateStatement = null;
		
		try {
			updateStatement = dbConnection.createStatement();
			
			updateStatement.executeUpdate("insert into students(name,cnp,username,password) value('"+name+"','"+cnp+"','"+username+"','"+password+"')");
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentBll:register " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public static boolean findAll(String username,String password) {
	
		
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement findStatement=null;
		ResultSet rs=null;
		student=null;
		try {
			findStatement=dbConnection.createStatement();
			rs = findStatement.executeQuery("SELECT * FROM students where username='"+username+"' and password='"+password+"'");
			while(rs.next()) {
				student=new Student(rs.getString("cnp"),rs.getString("name"),rs.getInt("idstudents"),rs.getString("username"),rs.getString("password"));
				if(student!=null)
					return true;
				
				
			}
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentBll:findAll " + e.getMessage());
		} finally {
		
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}

		return false;
	
	}
public static void updateById() {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement updateStatement = null;
		
		try {
			updateStatement = dbConnection.createStatement();
			
			updateStatement.executeUpdate("UPDATE students SET name='"+student.getName()+"',cnp='"+student.getCNP()+"'"+"where idstudents="+student.getID());
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentBll:updateById " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
public static JTable findGrades(int student) {
	String[][] data =new String[100][100];
	
	data[0][0]="Course";
	data[0][1]="Grade";
	int i=1;
	String[] Column= {"Name","grade"};
	//JTable table=new JTable(data,Column);
	Connection dbConnection = ConnectionFactory.getConnection();
	Statement findStatement=null;
	ResultSet rs=null;
	try {
		findStatement=dbConnection.createStatement();
		rs = findStatement.executeQuery("SELECT exam.name, students_has_exam.grades"
				+ " from students_has_exam"
				+ " inner join students on students.idstudents=students_has_exam.students_idstudents"
				+ " inner join exam on exams=students_has_exam.exam_exams"
				+ " where students.idstudents="+student);
		while(rs.next()) {
			data[i][0]=rs.getString("name");
			data[i][1]=Integer.toString(rs.getInt("grades"));
			i++;
			
			
		}
	}catch (SQLException e) {
		LOGGER.log(Level.WARNING,"StudentBill:grades " + e.getMessage());
	} finally {
	
		ConnectionFactory.close(rs);
		ConnectionFactory.close(findStatement);
		ConnectionFactory.close(dbConnection);
	}

	return new JTable(data,Column);
}
	public static JTable findAllCourse() {
		String[][] data =new String[100][100];
		
		data[0][0]="Course";
		data[0][1]="Id Course";
		int i=1;
		String[] Column= {"Name","grade"};
		
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement findStatement=null;
		ResultSet rs=null;
		try {
			findStatement=dbConnection.createStatement();
			rs = findStatement.executeQuery("select name,exams from exam");
			while(rs.next()) {
				data[i][0]=rs.getString("name");
				data[i][1]=Integer.toString(rs.getInt("exams"));
				i++;
				
				
			}
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentBll:grades " + e.getMessage());
		} finally {
		
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}

		return new JTable(data,Column);

}
}
