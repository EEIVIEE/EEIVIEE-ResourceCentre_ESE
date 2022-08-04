import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		ArrayList<TimeTable> timetableList = new ArrayList<TimeTable>();

		timetableList.add(new TimeTable("Math", "1hr 30 mins",35, "6;30 PM", "8:30 PM", null));

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllTimetable(timetableList);

			} else if (option == 2) {
				// Add a new item
				ResourceCentre.setHeader("ADD");			
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a camcorder
					Tuition cc = inputCamcorder();
					ResourceCentre.addCamcorder(tuitionList, cc);
					System.out.println("Camcorder added");

				} else if (itemType == 2) {
					// Add a Chromebook
					TimeTable cb = inputChromebook();
					ResourceCentre.addChromebook(timetableList, cb);
					System.out.println("Chromebook added");

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Loan item
				ResourceCentre.setHeader("LOAN");			
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder
					ResourceCentre.loanCamcorder(tuitionList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(timetableList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Return item
				ResourceCentre.setHeader("RETURN");				
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder
					ResourceCentre.returnCamcorder(tuitionList);
				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(timetableList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Loan item");
		System.out.println("4. Return item");
		System.out.println("5. Quit");
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

	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllTuition(ArrayList<Tuition> tuitionList) {
		String output = "";

		for (int i = 0; i < tuitionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", tuitionList.get(i).getAssetTag(),
					tuitionList.get(i).getDescription(), 
					ResourceCentre.showAvailability(tuitionList.get(i).getIsAvailable()),
					tuitionList.get(i).getDueDate(),tuitionList.get(i).getOpticalZoom());
		}
		return output;
	}
	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retrieveAllTuition(tuitionList);	
		System.out.println(output);
	}

	public static String retrieveAllTimetable(ArrayList<TimeTable> timetableList) {
		String output = "";
		// write your code here
		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s %-20d\n", timetableList.get(i).getTuition(),
					timetableList.get(i).getDuration(), 
					timetableList.get(i).getStart_time(),
					timetableList.get(i).getEnd_time(),
					timetableList.get(i).getMode(),
					timetableList.get(i).getPrice());
		}
		return output;
	}
	public static void viewAllTimetable(ArrayList<TimeTable> chromebookList) {
		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n", "TUITION NAME", "DURATION",
				"START TIME", "END TIME","MODE","PRICE");
		output += retrieveAllTimetable(chromebookList);
		System.out.println(output);
	}

	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Tuition inputCamcorder() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Tuition cc= new Tuition(tag, description, zoom);
		return cc;
		
	}
	public static void addCamcorder(ArrayList<Tuition> camcorderList, Tuition cc) {
		
		camcorderList.add(cc);
		
	}
	
	public static TimeTable inputChromebook() {	
		TimeTable cb =null;
		// write your code here

		return cb;
		
	}	
	public static void addChromebook(ArrayList<TimeTable> chromebookList, TimeTable cb) {
		// write your code here
	}
	
	//================================= Option 3 Loan an item (CRUD - Update) =================================
	public static boolean doLoanCamcorder(ArrayList<Tuition> camcorderList, String tag, String dueDate) {
		
		boolean isLoaned = false;

		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					&& camcorderList.get(i).getIsAvailable() == true) {
				
				camcorderList.get(i).setIsAvailable(false);
				camcorderList.get(i).setDueDate(dueDate);
				
				isLoaned = true;
				
			}
		}
		return isLoaned;
	}
	public static void loanCamcorder(ArrayList<Tuition> camcorderList) {
		ResourceCentre.viewAllTuition(camcorderList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned =doLoanCamcorder(camcorderList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " loaned out");
		}
	}
	
	public static boolean doLoanChromebook(ArrayList<TimeTable> chromebookList, String tag, String dueDate) {
		// write your code here
		return true;
	}
	public static void loanChromebook(ArrayList<TimeTable> chromebookList) {
		// write your code here
		
		
	}
	
	//================================= Option 4 Return an item (CRUD - Update)=================================
	public static boolean doReturnCamcorder(ArrayList<Tuition> camcorderList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					&& camcorderList.get(i).getIsAvailable() == false) {
				camcorderList.get(i).setIsAvailable(true);
				camcorderList.get(i).setDueDate("");
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	public static void returnCamcorder(ArrayList<Tuition> camcorderList) {
		ResourceCentre.viewAllTuition(camcorderList);
		String tag = Helper.readString("Enter asset tag > ");
		Boolean isReturned = doReturnCamcorder(camcorderList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " returned");
		}
	}

	public static boolean doReturnChromebook(ArrayList<TimeTable> chromebookList,String tag){
		boolean isReturned = false;
		// write your code here
		return isReturned;
	}
	public static void returnChromebook(ArrayList<TimeTable> chromebookList) {
		// write your code here
	
	}


}
