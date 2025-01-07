package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {

	private static final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private Connection con;

	// Constructor to establish the connection
	public DatabaseHandler() throws SQLException {
		con = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void addStudent(Student student) throws SQLException {
		String query = "insert into Students (name, age, grade, attendance) values (?, ?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getAge());
			stmt.setString(3, student.getGrade());
			stmt.setInt(4, student.getAttendance());
			stmt.executeUpdate();
		}
	}

	
	// Method to view all students
	public void viewStudent() throws SQLException {
		String query = "select * from Students";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				System.out.println(
						"ID: " + rs.getInt("id") + 
						", Name: " + rs.getString("name") + 
						", Age: " + rs.getInt("age") + 
						", Grade: " + rs.getString("grade") + 
						", Attendance: " + rs.getInt("attendance"));
			}
		}
	}
	
	// Method to update student details
	public void updateStudent(int id, String name, int age, String grade, int attendance) throws SQLException {
		String query = "update Students set name=?, age=?, grade=?, attendance=? where id=?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, grade);
			stmt.setInt(4, attendance);
			stmt.setInt(5, id);
			stmt.executeUpdate();
		}
	}
	
	// Method to delete a student
	public void deleteStudent(int id) throws SQLException {
		String query = "delete from Students where id=?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}
	
	public void searchStudent(int id) throws SQLException {
		String query = "select * from Students where id=?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					System.out.println(
							"ID: " + rs.getInt("id") + 
							", Name: " + rs.getString("name") + 
							", Age: " + rs.getInt("age") + 
							", Grade: " + rs.getString("grade") + 
							", Attendance: " + rs.getInt("attendance"));
				} else {
					System.out.println("Student not found");
				}
			}
		}
	}
	
	
	
}
