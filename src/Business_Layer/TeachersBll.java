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
import Data_Layer.Teachers;

public class TeachersBll {

	protected static final Logger LOGGER = Logger.getLogger(TeachersBll.class.getName());
	
	static Teachers teacher=null;
	
	
	public int getid() {
		
		return teacher.getID();
	}
	public static JTable findByDate(String start,String end,int id) {
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
					+ " where exam.date>('"+start+"') and exam.date<('"+end+"') and students.idstudents="+id);
			while(rs.next()) {
				data[i][0]=rs.getString("name");
				data[i][1]=Integer.toString(rs.getInt("grades"));
				i++;
				
				
			}
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"TeacherBill:findBydate " + e.getMessage());
		} finally {
		
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}

		return new JTable(data,Column);
	}
	
	
	
public static void Register(String name, String username,String password) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement updateStatement = null;
		
		try {
			updateStatement = dbConnection.createStatement();
			
			updateStatement.executeUpdate("insert into teachers(name,username,password) value('"+name+"','"+username+"','"+password+"')");
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentBll:register " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	public static boolean findUser(String username, String password) {
		
		
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement findStatement=null;
		ResultSet rs=null;
		
		try {
			findStatement=dbConnection.createStatement();
			rs = findStatement.executeQuery("SELECT * FROM teachers where username='"+username+"' and password='"+password+"'");
			while(rs.next()) {
				teacher=new Teachers(rs.getInt("idteachers"),rs.getString("name"),rs.getString("username"),rs.getString("password"));
				
				
				if(teacher!=null)
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
	
	public static JTable findMyCourse(int teacher) {
		String[][] data =new String[100][100];
		
		data[0][0]="Course";
		data[0][1]="Id Course";
		int i=1;
		String[] Column= {"Name","grade"};
		//JTable table=new JTable(data,Column);
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement findStatement=null;
		ResultSet rs=null;
		
		try {
			
			findStatement=dbConnection.createStatement();
			rs = findStatement.executeQuery("SELECT exam.name, exam.exams"
					+ " from teachers_has_exam"
					+ " inner join teachers on teachers.idteachers=teachers_has_exam.teachers_idteachers"
					+ " inner join exam on exams=teachers_has_exam.exam_exams"
					+ " where teachers.idteachers="+teacher);
			while(rs.next()) {
				data[i][0]=rs.getString("name");
				data[i][1]=Integer.toString(rs.getInt("exams"));
				i++;
				
				
			}
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"TeachersBll:MyCourse " + e.getMessage());
		} finally {
		
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}

		return new JTable(data,Column);
	}
	public static JTable findStudents(int id) {
		String[][] data =new String[100][100];
		
		data[0][0]="Name";
		data[0][1]="Id";
		data[0][2]="Grade";
		int i=1;
		String[] Column= {"Name","grade","id"};
		//JTable table=new JTable(data,Column);
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement findStatement=null;
		ResultSet rs=null;
		try {
			findStatement=dbConnection.createStatement();
			rs = findStatement.executeQuery("SELECT  students.name,students.idstudents, students_has_exam.grades"
					+ " from students_has_exam"
					+ " inner join students on students.idstudents=students_has_exam.students_idstudents"
					+ " inner join exam on exams=students_has_exam.exam_exams"
					+ " where exam.exams="+id);
			while(rs.next()) {
				data[i][0]=rs.getString("name");
				data[i][1]=Integer.toString(rs.getInt("idstudents"));
				data[i][2]=Integer.toString(rs.getInt("grades"));
				i++;
				
				
			}
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING,"TeachersBll:MyCourse " + e.getMessage());
		} finally {
		
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}

		return new JTable(data,Column);
	}
	
	
}
