import java.util.ArrayList;

public class ResourceCentreStudent {
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Matthew", "Male", 12345678, "matthew@gmail.com", "12/3/2004", "Singapore", "Nil"));
		studentList.add(new Student("Tom", "Male", 87654321, "tom@gmail.com", "15/2/2004", "Singapore", "Nil"));
		
		int option=0;
		while (option !=4) {
			ResourceCentreStudent.menu();
			option=Helper.readInt("Enter an option > ");
			
			if (option==1) {
				Student s = inputStudent();
				ResourceCentreStudent.addStudent(studentList, s);
				System.out.println("Student successfully added.");
				
			}else if (option==2) {
				ResourceCentreStudent.viewAllStudents(studentList);
				
			}else if (option ==3) {
				//Delete Student Option Here.
				
			}else if (option == 4) {
				System.out.println("Goodbye");
				
			}else {
				System.out.println("Invalid option");
			}
		}
		
	}

	private static void menu() {
		ResourceCentreStudent.setHeader("RESOURCE CENTRE STUDENT APP");
		System.out.println("1. Add Students");
		System.out.println("2. View Students");
		System.out.println("3. Delete students");
		System.out.println("4. Quit");
		Helper.line(80, "-");
		
	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}
	
	private static Student inputStudent() {
		String name= Helper.readString("Enter Student name > ");
		String gender=Helper.readString("Enter Student gender (Male/Female) > ");
		int mobile= Helper.readInt("Enter Student phone number > ");
		String email= Helper.readString("Enter Student email > ");
		String dob= Helper.readString("Enter Student date of birth (dd/mm/yy) > ");
		String residence= Helper.readString("Enter Student residence > ");
		String interest= Helper.readString("Enter Student interest > ");
		
		Student s = new Student(name, gender, mobile, email, dob, residence, interest);
		return s;
	}
	
	//================================= Option 1 Adding Students (CRUD - Create) =================================
	
	private static void addStudent(ArrayList<Student> studentList, Student s) {
		studentList.add(s);
		
	}
	
	//================================= Option 2 View Students (CRUD- Read) =======================================
	
	private static void viewAllStudents(ArrayList<Student> studentList) {
		ResourceCentreStudent.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-10s %-10s %-20s %-15s %-10s %-20s\n", "NAME", "GENDER",
				"MOBILE", "EMAIL","DATEB OF BIRTH", "RESIDENCE", "INTEREST");
		output+=retrieveAllStudents(studentList);
		System.out.println(output);
		
	}
	

	private static String retrieveAllStudents(ArrayList<Student> studentList) {
		String output="";
		for (int i=0; i<studentList.size(); i++) {
			output += String.format("%-10s %-10s %-10d %-20s %-15s %-10s %-10s\n", studentList.get(i).getName(), studentList.get(i).getGender(),
					studentList.get(i).getMobile(), studentList.get(i).getEmail(),studentList.get(i).getDob(), studentList.get(i).getResidence(), studentList.get(i).getInterest());
		}
		return output;
	}
	

}
