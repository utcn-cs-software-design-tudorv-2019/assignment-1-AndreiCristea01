package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

import java.util.logging.Logger;

public class EnrolmentDAO {
	protected static final Logger LOGGER = Logger.getLogger(EnrolmentDAO.class.getName());

	public static void enroll(int student, int exam) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		Statement updateStatement = null;

		try {
			updateStatement = dbConnection.createStatement();

			updateStatement.executeUpdate("insert into students_has_exam(students_idstudents,exam_exams,grades) value("
					+ student + "," + exam + ",0)");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enrolment:enroll " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}

	}

	public static void deleteEnroll(int student, int exam) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		Statement updateStatement = null;

		try {
			updateStatement = dbConnection.createStatement();

			updateStatement.executeUpdate(
					"delete from students_has_exam where students_idstudents=" + student + " and exam_exams=" + exam);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enrolment:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}

	}

	public static void updateGrade(int student, int exam, int grade) {

		Connection dbConnection = ConnectionFactory.getConnection();
		Statement updateStatement = null;

		try {
			updateStatement = dbConnection.createStatement();

			updateStatement.executeUpdate("UPDATE students_has_exam SET grades=" + grade + " where students_idstudents="
					+ student + " and exam_exams=" + exam);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enroll:UpdateGrade " + e.getMessage());
		} finally {

			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}

	public static void createCourse(int id_exam, String date, String Name, int id_teacher) {

		Connection dbConnection = ConnectionFactory.getConnection();
		Statement updateStatement = null;

		try {
			updateStatement = dbConnection.createStatement();

			updateStatement.executeUpdate(
					"insert into exam(exams,date,name) value(" + id_exam + ",'" + date + "','" + Name + "') ");
			updateStatement.executeUpdate("insert into teachers_has_exam(teachers_idteachers,exam_exams) value("
					+ id_teacher + "," + id_exam + ")");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enroll:createCourse " + e.getMessage());
		} finally {

			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}

}
