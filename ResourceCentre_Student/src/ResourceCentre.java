import java.util.ArrayList;

public class ResourceCentre {

	/**
	 * 
	 */
	private static final int OPTION_VIEW_REGISTRATION = 7;
	/**
	 * 
	 */
	private static final int OPTION_VIEW_STUDENT = 6;
	/**
	 * 
	 */
	private static final int OPTION_DELETE = 5;
	/**
	 * 
	 */
	private static final int OPTION_ADD = 4;
	/**
	 * 
	 */
	private static final int OPTION_REGISTER_STUDENT = 3;
	/**
	 * 
	 */
	private static final int OPTION_REGISTRATION = 2;
	/**
	 * 
	 */
	private static final int OPTION_VIEW = 1;
	/**
	 * 
	 */
	private static final int OPTION_EXIT = 8;


	public static void main(String[] args) {

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		ArrayList<TimeTable> timetableList = new ArrayList<TimeTable>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Registration> registrationList = new ArrayList<Registration>();

		tuitionList.add(new Tuition("CC0011", "Math","Math","Math","1hr 30 mins","3.0 GPA","Jean Lim","2022","Face-to-Face"));
		timetableList.add(new TimeTable("Math", "1hr 30 mins", 35, "6;30 PM", "8:30 PM", "Face to Face"));
		studentList.add(new Student("Matthew", "Male", 12345678, "matthew@gmail.com", "12/3/2004", "Singapore", "Nil"));
		studentList.add(new Student("Tom", "Male", 87654321, "tom@gmail.com", "15/2/2004", "Singapore", "Nil"));
		registrationList.add(new Registration(12,12,5,"Louispas@gmail.com","Reserved","12/2/2022"));
		
		int option = 0;

		while (option != OPTION_EXIT) {

			ResourceCentre.menu();

			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				ResourceCentre.viewAllTuition(tuitionList);
				ResourceCentre.viewAllTimetable(timetableList);

			} else if (option == OPTION_REGISTRATION) {
				// Register for tuition timetable
				System.out.println("===REGISTRATION DETAILS===");
				Registration register = inputRegistration(timetableList);
				ResourceCentre.addRegistration(registrationList, register);


			} else if (option == OPTION_REGISTER_STUDENT) {
				System.out.println("===REGISTER STUDENT===");
				
				Student s = inputStudent();
				ResourceCentre.addStudent(studentList, s);
				System.out.println("Student successfully added.");
			} else if (option == OPTION_ADD) {
				// Add a new Tuition/Timetable
				ResourceCentre.setHeader("ADD");
				System.out.println("1. Tuition");
				System.out.println("2. Timetable");
				

				int itemType = Helper.readInt("Enter option to select list > ");

				if (itemType == 1) {
					// Add a Tuition
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

			} else if (option == OPTION_DELETE) {
				// Delete item
				ResourceCentre.setHeader("DELETE");
				System.out.println("1. Tuition");
				System.out.println("2. Timetable");
				System.out.println("3. Student");
				System.out.println("4. Registration");

				int itemType = Helper.readInt("Enter option to select list > ");

				if (itemType == 1) {
					// Delete Tuition
					String t = Helper.readString("Enter code of tuition > ");
					ResourceCentre.removeTuition(tuitionList, t);
				} else if (itemType == 2) {
					// Delete Timetable
					String tt = Helper.readString("Enter name of timetable > ");
					ResourceCentre.removeTimetable(timetableList, tt);
				}else if (itemType==3) {
					String name= Helper.readString("Enter the name of student to delete > ");
					ResourceCentre.removeStudent(studentList, name);
				}else if (itemType==4) {
					String email=Helper.readString("Enter registration email to delete > ");
					ResourceCentre.removeRegistration(registrationList, email);
				}
				else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_VIEW_STUDENT) {
				ResourceCentre.viewAllStudents(studentList);
			} else if (option == OPTION_VIEW_REGISTRATION) {
				ResourceCentre.viewAllRegistration(registrationList);
			}
		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Tuition/Timetable");
		System.out.println("2. Timetable registration");
		System.out.println("3. Register student");
		System.out.println("4. Add Tuition/Timetable");
		System.out.println("5. Delete Tuition/Timetable/Student/Registration");
		System.out.println("6. Display Student");
		System.out.println("7. Display Registration");
		System.out.println("8. Quit");
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
			avail = "OPEN";
		} else {
			avail = "REGISTERED";
		}
		return avail;
	}

	// ================================= Option 1 View Tuition/ Timetable (CRUD- Read) =================================
	public static String retrieveAllTuition(ArrayList<Tuition> tuitionList) {
		String output = "";

		for (int i = 0; i < tuitionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s %-20s\n", tuitionList.get(i).getTuitionCode(),
					tuitionList.get(i).getTuitionTitle(), tuitionList.get(i).getTuitionDescription(),
					tuitionList.get(i).getSubjectGroupName(), tuitionList.get(i).getTuitionDuration(),
					tuitionList.get(i).getPreRequisite(),tuitionList.get(i).getTeacher(),tuitionList.get(i).getYearStart(),tuitionList.get(i).getMode());
		}
		return output;
	}

	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		ResourceCentre.setHeader("TUITION LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s %-20s\n", "CODE", "TITLE", "SUBJECT GROUP",
				"DESCRIPTION", "DURATION", "PRE-REQUISITE", "TEACHER", "YEAR START", "MODE");
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
	
	

	// ================================= Option 2 Register tuition timetable (CRUD -Create) =================================
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

	//================================= Option 3 Register Student (CRUD -Create) =================================
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
	
	public static void addStudent(ArrayList<Student> studentList, Student s) {
		studentList.add(s);
		
	}
	
	
	


	// ================================= Option 4 Add a Tuition/ Timetable (CRUD - Create) =================================
	public static Tuition inputTuition() {
		String code = Helper.readString("Enter code > ");
		String title = Helper.readString("Enter title > ");
		String subjectGroup = Helper.readString("Enter SubjectGroup > ");
		String description = Helper.readString("Enter description > ");
		String duration = Helper.readString("Enter duration > ");
		String preRequisite = Helper.readString("Enter pre-requisite > ");
		String teacher = Helper.readString("Enter teacher > ");
		String yearStart = Helper.readString("Enter yearStart > ");
		String mode = Helper.readString("Enter Mode >");

		Tuition t = new Tuition(code, title, subjectGroup, description, duration, preRequisite, teacher, yearStart, mode);
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
	
	
	

	// ================================= Option 5 Remove a Tuition/ Timetable/ Student/ Registration (CRUD - Update) =================================
	
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
	
	private static void removeRegistration(ArrayList<Registration> registrationList, String email) {
		int position = -1;
		for (int i=0; i<registrationList.size(); i++) {
			if (registrationList.get(i).getEmail().equalsIgnoreCase(email)) {
				position=i;
			}
		}
		
		if (position == -1) {
			System.out.println("Invalid email");
		}else {
			registrationList.remove(position);
		}
		
	}
	
	//================================= Option 6 View Students (CRUD- Read) =======================================
	
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

	//================================= Option 7 View Registrations (CRUD- Read) =======================================

	public static void viewAllRegistration(ArrayList<Registration> registrationList) {
		ResourceCentre.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-10s %-10s %-20s %-15s %-10s\n", "REG_NUM", "REG_ID",
				"TUITION_ID", "EMAIL","STATUS", "DATE");
		output+=retrieveAllRegistrations(registrationList);
		System.out.println(output);
		
	}
	

	public static String retrieveAllRegistrations(ArrayList<Registration> registrationList) {
		String output="";
		for (int i=0; i<registrationList.size(); i++) {
			output += String.format("%-10s %-10s %-10d %-20s %-15s %-10s\n", registrationList.get(i).getNum(), registrationList.get(i).getRegid(),
					registrationList.get(i).getTuitionid(), registrationList.get(i).getEmail(),registrationList.get(i).getStatus(), registrationList.get(i).getDatetime());
		}
		return output;
	}
}

