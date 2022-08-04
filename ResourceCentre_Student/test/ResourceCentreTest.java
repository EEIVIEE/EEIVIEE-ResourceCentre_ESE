import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// C206 AY2022 SEM1 - Eclipse 21-09 JDK16
public class ResourceCentreTest {
	// prepare test data
	private Tuition cc1;
	private Tuition cc2;
	private Tuition cc3;
	private TimeTable cb1;
	private TimeTable cb2;
	private TimeTable cb3;
	
	private ArrayList<Tuition> tuitionList;
	private ArrayList<TimeTable> timetableList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Tuition("CC0011", "Math","Math","Math","1hr 30 mins","3.0 GPA","Jean Lim","2022");
		cc2 = new Tuition("CC0012", "Math","Math","Math","1hr 30 mins","3.0 GPA","Jean Lim","2022");
		cc3 = new Tuition("CC0013", "Math","Math","Math","1hr 30 mins","3.0 GPA","Jean Lim","2022");
		cb1 = new TimeTable("Math", "1hr 30 mins",35, "6:30 PM", "8:30 PM", null);
		cb2 = new TimeTable("English", "1hr 30 mins",35, "6:30 PM", "8:30 PM", null);
		cb3 = new TimeTable("Science", "1hr 30 mins",35, "6:30 PM", "8:30 PM", null);
		
		
		tuitionList= new ArrayList<Tuition>();
		timetableList= new ArrayList<TimeTable>();
	}

	
	@Test
	public void testAddTuition() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", tuitionList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addTuiton(tuitionList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, tuitionList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, tuitionList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addTuiton(tuitionList, cc2);
		ResourceCentre.addTuiton(tuitionList, cc3);
		assertEquals("Test that Camcorder arraylist size is 3?", 3, tuitionList.size());
		assertSame("Test that Camcorder is added same as 3rd item of the list?", cc3, tuitionList.get(2));
	}
	@Test
	public void testAddTimetable() {
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid Camcorder arraylist to add to", timetableList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addTimetable(timetableList, cb1);		
				assertEquals("Test if that Camcorder arraylist size is 1?", 1, timetableList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Camcorder is added same as 1st item of the list?", cb1, timetableList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addTimetable(timetableList, cb2);
				ResourceCentre.addTimetable(timetableList, cb3);
				assertEquals("Test that Camcorder arraylist size is 3?", 3, timetableList.size());
				assertSame("Test that Camcorder is added same as 3rd item of the list?", cb3, timetableList.get(2));
	}
	
	@Test
	public void testRetrieveAllTuition() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", tuitionList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
		String allTuition= ResourceCentre.retrieveAllTuition(tuitionList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allTuition);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addTuiton(tuitionList, cc1);
		ResourceCentre.addTuiton(tuitionList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, tuitionList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allTuition= ResourceCentre.retrieveAllTuition(tuitionList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s\n","CC0011", "Math","Math","Math","1hr 30 mins","3.0 GPA","Jean Lim","2022");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s\n","CC0012", "Math","Math","Math","1hr 30 mins","3.0 GPA","Jean Lim","2022");

	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allTuition);
		
	}
	@Test
	public void testRetrieveAllTimetable() {
		// Test if Item list is not null but empty, so that can add a new item
				assertNotNull("Test if there is valid Camcorder arraylist to add to", timetableList);
				
				//test if the list of camcorders retrieved from the SourceCentre is empty
				String allTimetable= ResourceCentre.retrieveAllTimetable(timetableList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allTimetable);
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
				ResourceCentre.addTimetable(timetableList, cb1);
				ResourceCentre.addTimetable(timetableList, cb2);
				assertEquals("Test if that Camcorder arraylist size is 2?", 2, timetableList.size());
				
				//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
				allTimetable= ResourceCentre.retrieveAllTimetable(timetableList);

				testOutput = String.format("%-10s %-30s %-10s %-10s %-20s %-20d\n","Math", "1hr 30 mins", "6:30 PM", "8:30 PM", null,35);
				testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20d\n","English", "1hr 30 mins", "6:30 PM", "8:30 PM", null, 35);
				
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allTimetable);
				
	}
	
	@Test
	public void testRemoveTuition() {
		//boundary
		assertNotNull("test if there is valid Tuition arraylist to loan from", tuitionList);
		
		ResourceCentre.addTuiton(tuitionList, cc1);
		// normal
		ResourceCentre.removeTuition(tuitionList, "CC0011");
		assertEquals("test if there is no longer a valid Tuition to loan from",0, tuitionList.size());
		
	}
	
	@Test
	public void testRemoveTimetable() {
		//boundary
		assertNotNull("test if there is valid Timetable arraylist to loan from", timetableList);
		
		ResourceCentre.addTimetable(timetableList, cb1);
		// normal
		ResourceCentre.removeTimetable(timetableList, "Math");
		
		assertEquals("test if there is no longer a valid Timetable to loan from",0, timetableList.size());
		
	}


	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		tuitionList = null;
		timetableList = null;

	}

}
