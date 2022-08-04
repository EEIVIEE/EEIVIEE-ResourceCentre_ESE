import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreStudentTest {
	//prepare test data
	private Student s1;
	private Student s2;
	private Student s3;
	
	private ArrayList<Student> studentList;
	
	public ResourceCentreStudentTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//prepare test data
		s1=new Student("Matthew", "Male", 12345678, "matthew@gmail.com", "12/3/2004", "Singapore", "Nil");
		s2=new Student("Tom", "Male", 87654321, "tom@gmail.com", "15/2/2004", "Singapore", "Nil");
		s3=new Student("Mary", "Male", 12533467, "mary@gmail.com", "24/6/2004", "Singapore", "Nil");
		
		studentList=new ArrayList<Student>();
	}
	
	@Test
	public void testAddStudent() {
		assertNotNull("Test if there is a valid Student arrayList to add to", studentList);
		
		ResourceCentreStudent.addStudent(studentList, s1);
		assertEquals(1,studentList.size());
		
		assertSame(s1, studentList.get(0));
		
		ResourceCentreStudent.addStudent(studentList, s2);
		ResourceCentreStudent.addStudent(studentList, s3);
		
		assertEquals("Test that the studentList size is 3", 3, studentList.size());
		assertSame("Test that the student that is added is the same as the third item of the studentList", s3, studentList.get(2));
	}
	
	@Test
	public void testRetrieveAllStudents() {
		assertNotNull("Test if there is a valid student Array list to add to", studentList);
		
		String allStudents = ResourceCentreStudentl.studentList);
		String testOutput="";
		assertEquals(testOutput, allStudents);
		
		ResourceCentreStudent.addStudent(studentList, s1);
		ResourceCentreStudent.addStudent(studentList, s2);
		assertEquals("Test if studentList size is 2", 2, studentList.size());
		
		allStudents=ResourceCentreStudent.retrieveAllStudents(studentList);
		
		testOutput=String.format("%-10s %-10s %-10d %-20s %-15s %-10s %-10s\n", "Matthew", "Male", 12345678, "matthew@gmail.com", "12/3/2004", "Singapore", "Nil");
		testOutput+=String.format("%-10s %-10s %-10d %-20s %-15s %-10s %-10s\n", "Tom", "Male", 87654321, "tom@gmail.com", "15/2/2004", "Singapore", "Nil");
		
		assertEquals(testOutput, allStudents);
	}
	
	@Test
	public void testRemoveStudent() {
		assertNotNull("Test if there is a valid student to remove", studentList);
		
		ResourceCentreStudent.addStudent(studentList, s1);
		
		ResourceCentreStudent.removeStudent(studentList, "Matthew");
		assertEquals(0, studentList);
	}

	@After
	public void tearDown() throws Exception {
		s1=null;
		s2=null;
		s3=null;
		studentList=null;
	}


}
