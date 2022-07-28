import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Tuition> camcorderList = new ArrayList<Tuition>();
		ArrayList<TimeTable> chromebookList = new ArrayList<TimeTable>();

		camcorderList.add(new Tuition("CC001", "Sony HDR-CX405", 35));
		camcorderList.add(new Tuition("CC002", "Panasonic HC-MDH2", 10));
		chromebookList.add(new TimeTable("CB001", "ASUS Chromebook ", "Win 10"));
		chromebookList.add(new TimeTable("CB002", "HP Chromebook", "Win 10"));

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllCamcorder(camcorderList);
				ResourceCentre.viewAllChromebook(chromebookList);

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
					ResourceCentre.addCamcorder(camcorderList, cc);
					System.out.println("Camcorder added");

				} else if (itemType == 2) {
					// Add a Chromebook
					TimeTable cb = inputChromebook();
					ResourceCentre.addChromebook(chromebookList, cb);
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
					ResourceCentre.loanCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);
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
					ResourceCentre.returnCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(chromebookList);
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
	public static String retrieveAllCamcorder(ArrayList<Tuition> camcorderList) {
		String output = "";

		for (int i = 0; i < camcorderList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", camcorderList.get(i).getAssetTag(),
					camcorderList.get(i).getDescription(), 
					ResourceCentre.showAvailability(camcorderList.get(i).getIsAvailable()),
					camcorderList.get(i).getDueDate(),camcorderList.get(i).getOpticalZoom());
		}
		return output;
	}
	public static void viewAllCamcorder(ArrayList<Tuition> camcorderList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retrieveAllCamcorder(camcorderList);	
		System.out.println(output);
	}

	public static String retrieveAllChromebook(ArrayList<TimeTable> chromebookList) {
		String output = "";
		// write your code here
		return output;
	}
	public static void viewAllChromebook(ArrayList<TimeTable> chromebookList) {
		
		String output = retrieveAllChromebook(chromebookList);
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
		ResourceCentre.viewAllCamcorder(camcorderList);
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
		ResourceCentre.viewAllCamcorder(camcorderList);
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
