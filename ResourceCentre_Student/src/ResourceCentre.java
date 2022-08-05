import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		ArrayList<TimeTable> timetableList = new ArrayList<TimeTable>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Registration> registrationList = new ArrayList<Registration>();

		timetableList.add(new TimeTable("Math", "1hr 30 mins", 35, "6;30 PM", "8:30 PM", "Face to Face"));
		studentList.add(new Student("Matthew", "Male", 12345678, "matthew@gmail.com", "12/3/2004", "Singapore", "Nil"));
		studentList.add(new Student("Tom", "Male", 87654321, "tom@gmail.com", "15/2/2004", "Singapore", "Nil"));

		int option = 0;

		while (option != 7) {

			ResourceCentre.menu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllTuition(tuitionList);
				ResourceCentre.viewAllTimetable(timetableList);

			} else if (option == 2) {
				// Register for tuition timetable
				System.out.println("===REGISTRATION DETAILS===");
				Registration register = inputRegistration(timetableList);
				ResourceCentre.addRegistration(registrationList, register);


			} else if (option == 3) {
				System.out.println("===REGISTER STUDENT===");
				
				Student s = inputStudent();
				ResourceCentre.addStudent(studentList, s);
				System.out.println("Student successfully added.");
			} else if (option == 4) {
				// Add a new item
				ResourceCentre.setHeader("ADD");
				System.out.println("1. Tuition");
				System.out.println("2. Timetable");
				

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a Tuitions
					Tuition cc = inputTuition();
					ResourceCentre.addTuiton(tuitionList, cc);
					System.out.println("Tuition added");

				} else if (itemType == 2) {
					// Add a TimeTable
					TimeTable cb = inputTimetable();
					ResourceCentre.addTimetable(timetableList, cb);
					System.out.println("Timetable added");

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				// Delete item
				ResourceCentre.setHeader("DELETE");
				System.out.println("1. Tuition");
				System.out.println("2. Timetable");
				System.out.println("3. Student");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder

				} else if (itemType == 2) {
					// Loan Chromebook
					String tt = Helper.readString("Enter name of timetable > ");
					ResourceCentre.removeTimetable(timetableList, tt);
				}else if (itemType==3) {
					String name= Helper.readString("Enter the name of student to delete > ");
					ResourceCentre.removeStudent(studentList, name);
				}
				else {
					System.out.println("Invalid type");
				}

			} else if (option ==6) {
				ResourceCentre.viewAllStudents(studentList);
			}
		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Tuition/Timetable");
		System.out.println("2. Timetable registration");
		System.out.println("3. Register student");
		System.out.println("4. Add Tuition/Timetable");
		System.out.println("5. Delete Tuition/Timetable/Student");
		System.out.println("6. Display Student");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ================================= Option 1 View items (CRUD- Read)
	// =================================
	public static String retrieveAllTuition(ArrayList<Tuition> tuitionList) {
		String output = "";

		for (int i = 0; i < tuitionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s\n", tuitionList.get(i).getTuitionCode(),
					tuitionList.get(i).getTuitionTitle(), tuitionList.get(i).getTuitionDescription(),
					tuitionList.get(i).getSubjectGroupName(), tuitionList.get(i).getTuitionDuration(),
					tuitionList.get(i).getPreRequisite(),tuitionList.get(i).getTeacher(),tuitionList.get(i).getYearStart());
		}
		return output;
	}

	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s\n", "CODE", "TITLE", "SUBJECT GROUP",
				"DESCRIPTION", "DURATION", "PRE-REQUISITE", "TEACHER", "YEAR START");
		output += retrieveAllTuition(tuitionList);
		System.out.println(output);
	}

	public static String retrieveAllTimetable(ArrayList<TimeTable> timetableList) {
		String output = "";
		// write your code here
		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s %-20d %-20s\n", timetableList.get(i).getTitle(),
					timetableList.get(i).getDuration(), timetableList.get(i).getStart_time(),
					timetableList.get(i).getEnd_time(), timetableList.get(i).getMode(),
					timetableList.get(i).getPrice(), timetableList.get(i).showAvailability(timetableList.get(i).getStatus()));
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<TimeTable> timetableList) {
		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s\n", "TUITION NAME", "DURATION", "START TIME",
				"END TIME", "MODE", "PRICE","STATUS");
		output += retrieveAllTimetable(timetableList);
		System.out.println(output);
	}
	
	

	// ================================= Option 2 Register tuition timetable (CRUD -
	// Create)
	// =================================
	public static Registration inputRegistration(ArrayList<TimeTable> timetableList) {
		ResourceCentre.viewAllTimetable(timetableList);
		Registration reg = null;
		int regnum = Helper.readInt("Enter registration number > ");
		int regid = Helper.readInt("Enter registration id > ");
		int tuitionid = Helper.readInt("Enter tuition id >");
		String email = Helper.readString("Enter email > ");
		String status = Helper.readString("Enter Status >");
		String datetime = Helper.readString("Enter date time > ");
		
		Boolean isRegistered= doRegisterTimetable(timetableList, tuitionid);
		if (isRegistered == false) {
			System.out.println("Invalid tuitionId");
		} else {
			System.out.println("Registered for " + tuitionid);
			reg = new Registration(regnum, regid, tuitionid, email, status, datetime);
		}
		
		return reg;
		
	}
	public static Student inputStudent() {
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
	
	public static void addRegistration(ArrayList<Registration> RegistrationList, Registration r) {

		RegistrationList.add(r);

	}
	
	public static boolean doRegisterTimetable(ArrayList<TimeTable> timetableList, int tuitionId) {
		// write your code here
		boolean isRegistered = false;

		for (int i = 0; i < timetableList.size(); i++) {
			
			if (tuitionId == i && timetableList.get(i).getStatus() == true) {
				
				timetableList.get(i).setStatus(false);;
				
				isRegistered = true;
				
			}
		}
		return isRegistered;
	}
	


	// ================================= Option 3 Add an item (CRUD - Create)
	// =================================
	public static Tuition inputTuition() {
		String code = Helper.readString("Enter code > ");
		String title = Helper.readString("Enter title > ");
		String subjectGroup = Helper.readString("Enter SubjectGroup > ");
		String description = Helper.readString("Enter description > ");
		String duration = Helper.readString("Enter duration > ");
		String preRequisite = Helper.readString("Enter pre-requisite > ");
		String teacher = Helper.readString("Enter teacher > ");
		String yearStart = Helper.readString("Enter yearStart > ");

		Tuition t = new Tuition(code, title, subjectGroup, description, duration, preRequisite, teacher, yearStart);
		return t;

	}

	public static void addTuiton(ArrayList<Tuition> TuitionList, Tuition t) {

		TuitionList.add(t);

	}

	public static TimeTable inputTimetable() {
		// write your code here
		String title = Helper.readString("Enter tuition title > ");
		String duration = Helper.readString("Enter duration > ");
		int price = Helper.readInt("Enter price > ");
		String start_time = Helper.readString("Enter start time > ");
		String end_time = Helper.readString("Enter end time > ");
		String mode = Helper.readString("Enter mode > ");

		TimeTable tt = new TimeTable(title, duration, price, start_time, end_time, mode);
		return tt;

	}

	public static void addTimetable(ArrayList<TimeTable> timetableList, TimeTable tt) {
		// write your code here

		timetableList.add(tt);

	}
	
	public static void addStudent(ArrayList<Student> studentList, Student s) {
		studentList.add(s);
		
	}
	

	// ================================= Option 4 Loan an item (CRUD - Update)
	// =================================
	
	public static void removeTuition(ArrayList<Tuition> tuitionList, String code ) {
		int pos = -1;
		// write your code here
		for (int i = 0; i < tuitionList.size(); i++) {
			if(tuitionList.get(i).getTuitionCode().equalsIgnoreCase(code)) {
				pos = i;
			}
		}
		if(pos == -1) {
			System.out.println("Tuition not found");
		}else {
			tuitionList.remove(pos);
		}
	}
	
	public static void removeTimetable(ArrayList<TimeTable> timetableList, String name) {
		int pos = -1;
		// write your code here
		for (int i = 0; i < timetableList.size(); i++) {
			if(timetableList.get(i).getTitle().equalsIgnoreCase(name)) {
				pos = i;
			}
		}
		if(pos == -1) {
			System.out.println("Timetable not found");
		}else {
			timetableList.remove(pos);
		}
	}
	
	public static void removeStudent(ArrayList<Student> studentList, String name) {
		int position = -1;
		for (int i=0; i<studentList.size(); i++) {
			if (studentList.get(i).getName().equalsIgnoreCase(name)) {
				position=i;
			}
		}
		
		if (position == -1) {
			System.out.println("Invalid Student Name");
		}else {
			studentList.remove(position);
		}
		
	}
	
	//================================= Option 2 View Students (CRUD- Read) =======================================
	
	public static void viewAllStudents(ArrayList<Student> studentList) {
		ResourceCentre.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-10s %-10s %-20s %-15s %-10s %-20s\n", "NAME", "GENDER",
				"MOBILE", "EMAIL","DATEB OF BIRTH", "RESIDENCE", "INTEREST");
		output+=retrieveAllStudents(studentList);
		System.out.println(output);
		
	}
	

	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String output="";
		for (int i=0; i<studentList.size(); i++) {
			output += String.format("%-10s %-10s %-10d %-20s %-15s %-10s %-10s\n", studentList.get(i).getName(), studentList.get(i).getGender(),
					studentList.get(i).getMobile(), studentList.get(i).getEmail(),studentList.get(i).getDob(), studentList.get(i).getResidence(), studentList.get(i).getInterest());
		}
		return output;
	}
}


	

