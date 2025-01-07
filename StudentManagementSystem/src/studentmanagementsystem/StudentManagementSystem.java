package studentmanagementsystem;

import java.util.Scanner;

public class StudentManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner sc = new Scanner(System.in)) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			DatabaseHandler dbHandler = new DatabaseHandler();
			boolean running = true;
			
			while(running) {
				System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Search Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                
                switch(choice) {
                	
                	case 1 :
                		System.out.print("Enter name : ");
                		String name = sc.next();
                		System.out.println("Enter age : ");
                		int age = sc.nextInt();
                		System.out.println("Enter grade : ");
                		String grade = sc.next();
                		System.out.println("Enter attendance : ");
                		int attendance = sc.nextInt();
                		dbHandler.addStudent(new Student(0, name, age, grade, attendance));
                		System.out.println("Student added successfully");
                		break;
                		
                		
                	case 2 : 
                		dbHandler.viewStudent();
                		break;
                		
                		
                	case 3 : 
                		System.out.println("Enter student id to update : ");
                		int updateId = sc.nextInt();
                		System.out.println("Enter new name : ");
                		String newName = sc.next();
                		System.out.println("Enter new age : ");
                		int newAge = sc.nextInt();
                		System.out.println("Enter new grade : ");
                		String newGrade = sc.next();
                   		System.out.println("Enter new attendance : ");
                   		int newAttendance = sc.nextInt();
                   		dbHandler.updateStudent(updateId, newName, newAge, newGrade, newAttendance);
                   		System.out.println("Student updated successfully");
                   		break;
                   		
                   		
                	case 4 : 
                		System.out.println("Enter student id to delete : ");
                		int deleteId = sc.nextInt();
                		dbHandler.deleteStudent(deleteId);
                		System.out.println("Student deleted successfully");
                		break;
                		
                		
                	case 5 : 
                		System.out.println("Enter student id to search : ");
                		int searchId = sc.nextInt();
                		dbHandler.searchStudent(searchId);
                		break;
                		
                		
                	case 6 : 
                		running = false;
                		break;
                		
                		
                	default : 
                		System.out.println("Invalid choice. Try again.");
                } 
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
