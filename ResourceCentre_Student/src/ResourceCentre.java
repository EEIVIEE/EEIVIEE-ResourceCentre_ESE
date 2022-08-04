import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		ArrayList<TimeTable> timetableList = new ArrayList<TimeTable>();

		timetableList.add(new TimeTable("Math", "1hr 30 mins", 35, "6;30 PM", "8:30 PM", null));

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllTimetable(timetableList);

			} else if (option == 2) {
				//Register for tuition timetable
				System.out.println("Registration details");

			} else if (option == 3) {
				// Add a new item
				ResourceCentre.setHeader("ADD");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Tuition");
				System.out.println("2. Timetable");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a camcorder
					Tuition cc = inputTuition();
					ResourceCentre.addTuiton(tuitionList, cc);
					System.out.println("Camcorder added");

				} else if (itemType == 2) {
					// Add a Chromebook
					TimeTable tt = inputTimetable();
					ResourceCentre.addTimetable(timetableList, tt);
					System.out.println("Chromebook added");

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Loan item
				ResourceCentre.setHeader("DELETE");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Tuition");
				System.out.println("2. Timetable");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Delete Tuition

				} else if (itemType == 2) {
					// Delete Timetable
					String Tuition = Helper.readString("Enter name of the Tuition > ");
					ResourceCentre.removeTimetable(timetableList, Tuition);
				} else {
					System.out.println("Invalid type");
				}
				

			} else if (option == 5) {
				// Return item
				ResourceCentre.setHeader("RETURN");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");

				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder

				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(timetableList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 6) {
				System.out.println("Bye!");
			} else {
				System.out.println("invalid option");
			}
		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Timetable registration");
		System.out.println("3. Add item");
		System.out.println("4. Delete item");
		System.out.println("5. Return item");
		System.out.println("6. Quit");
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
					tuitionList.get(i).getTuitionTitle(), 
					tuitionList.get(i).getTuitionDescription(),
					tuitionList.get(i).getSubjectGroupName(),
					tuitionList.get(i).getTuitionDuration(),
					tuitionList.get(i).getPreRequisite(),
					tuitionList.get(i).getTeacher(),
					tuitionList.get(i).getYearStart());


		}
		return output;
	}

	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllTuition(tuitionList);
		System.out.println(output);
	}

	public static String retrieveAllTimetable(ArrayList<TimeTable> timetableList) {
		String output = "";
		// write your code here
		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s %-20d\n", timetableList.get(i).getTitle(),
					timetableList.get(i).getDuration(), timetableList.get(i).getStart_time(),
					timetableList.get(i).getEnd_time(), timetableList.get(i).getMode(),
					timetableList.get(i).getPrice());
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<TimeTable> chromebookList) {
		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n", "TUITION NAME", "DURATION", "START TIME",
				"END TIME", "MODE", "PRICE");
		output += retrieveAllTimetable(chromebookList);
		System.out.println(output);
	}

	// ================================= Option 2 Add an item (CRUD - Create)
	// =================================
	public static Tuition inputTuition() {
		String code = Helper.readString("Enter asset tag > ");
		String title = Helper.readString("Enter description > ");
		String subjectGroup = Helper.readString("Enter optical zoom > ");
		String description = Helper.readString("Enter optical zoom > ");
		String duration = Helper.readString("Enter optical zoom > ");
		String preRequisite = Helper.readString("Enter optical zoom > ");
		String teacher = Helper.readString("Enter optical zoom > ");
		String yearStart = Helper.readString("Enter optical zoom > ");

		Tuition t = new Tuition(code, title, subjectGroup, description, duration, preRequisite, teacher, yearStart);
		return t;

	}

	public static void addTuiton(ArrayList<Tuition> TuitionList, Tuition t) {

		TuitionList.add(t);

	}

	public static TimeTable inputTimetable() {
		// write your code here
		String title = Helper.readString("Enter Tuition Title > ");
		String duration = Helper.readString("Enter duration > ");
		int price = Helper.readInt("Enter price > ");
		String start_time = Helper.readString("Enter Start Time > ");
		String end_time = Helper.readString("Enter End Time > ");
		String mode = Helper.readString("Enter Mode > ");

		TimeTable tt = new TimeTable(title, duration, price, start_time, end_time, mode);
		return tt;

	}

	public static void addTimetable(ArrayList<TimeTable> timetableList, TimeTable tt) {
		// write your code here

		timetableList.add(tt);

	}

	// ================================= Option 3 Delete an item (CRUD - Update)
	// =================================
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
	
	

	// ================================= Option 4 Return an item (CRUD -
	// Update)=================================

	public static boolean doReturnChromebook(ArrayList<TimeTable> chromebookList, String tag) {
		boolean isReturned = false;
		// write your code here
		return isReturned;
	}

	public static void returnChromebook(ArrayList<TimeTable> chromebookList) {
		// write your code here

	}

}
