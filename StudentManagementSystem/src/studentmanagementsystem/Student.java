package studentmanagementsystem;

public class Student {
	private int id;
	private String name;
	private int age;
	private String grade;
	private int attendance;
	
	// constructor
	public Student() {
		
	}
	
	public Student(int id, String name, int age, String grade, int attendance) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.attendance = attendance;
	}
	
	// getter/setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade() {
		this.grade = grade;
	}
	
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance() {
		this.attendance = attendance;
	}
	
	@Override
	public String toString() {
		return "Student [ID=" + id + ", Name=" + name + ", Age=" + age +
                ", Grade=" + grade + ", Attendance=" + attendance + "]";
	}
	
	
	
	
}
