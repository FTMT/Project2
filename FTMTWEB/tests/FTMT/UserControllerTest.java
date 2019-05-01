/**
 * UserControllerTest.java
 * 
 * Tests the methods of the UserController class
 * 
 */
package FTMT;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

/**
 * @author wcooper001
 *
 */
public class UserControllerTest {

	User user = new User();
	DBController dbC = new DBController();
	UserController uCtrl = new UserController();
	
	
	int added = dbC.addProfile(user);
	
	@Before
	public void setUp() throws Exception
	{
		user = new User("firstName", "lastName", "username", "password", 'u', 'y');
		dbC.addProfile(user);
	}

	/**
	 * Test method for {@link FTMT.UserController#searchSchools(String name, String state, String location, String control, int numStudentsLow, 
	 * 			int numStudentsHigh, double percFemalesLow, double percFemalesHigh, double satVerbalLow, double satVerbalHigh, double satMathLow, 
	 * 			double satMath, double expensesLow, double expensesHigh, 
	 * 			double percAidLow, double percAidHigh, int numApplyLow, int numApplyHigh, double percAdmitLow, double percAdmitHigh, 
	 * 			double percEnrolledLow, double percEnrolledHigh, int acadScaleLow, int acadScaleHigh, int socialScaleLow, int socialScaleHigh, 
	 * 			int qualLifeLow, int qualLifeHigh, String[] emphases}.
	 */
	@Test
	public void testSearchSchools() {
	ArrayList<University> univList;
	University exp = new University();
	boolean bool = false;
	
	  // Name (String A-Z)
		univList = uCtrl.searchSchools("ADELPHI", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("ADELPHI");
		assertTrue(univList.size() > 0);				// Make sure it found results
		for (University school : univList) 				// Iterate through the list of results
		{
			if (school.getName().equals(exp.getName())) // Find if there is a matching expected value
				bool = true; 								// Set the assert value to true
		}				
		assertTrue(bool);								// Make sure the expected match was found
		bool = false;									// Reset the assert value to false
		
		
	  // State (String A-Z; States)
		univList = uCtrl.searchSchools("", "NEW YORK", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("BARUCH");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
		
	  // Location (String; SUBURBAN, URBAN, SMALL-CITY, -1)
			// Suburban
		univList = uCtrl.searchSchools("", "", "SUBURBAN", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("BRANDEIS");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Urban
		univList = uCtrl.searchSchools("", "", "URBAN", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("BARNARD");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Small-City
		univList = uCtrl.searchSchools("", "", "SMALL-CITY", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("BUCKNELL");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Unknown (-1)
		univList = uCtrl.searchSchools("", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("ADELPHI");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
		
	  // Control (String; PRIVATE, STATE, CITY, -1)
			// Private
		univList = uCtrl.searchSchools("", "", "", "PRIVATE", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("BUTLER");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// State
		univList = uCtrl.searchSchools("", "", "", "STATE", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("FLORIDA STATE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// City
		univList = uCtrl.searchSchools("", "", "", "CITY", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("CCNY");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
		
	  // numStudents (int; 0 <= i)
			// 15000 < i < 15050
		univList = uCtrl.searchSchools("", "", "", "", "15000", "15050", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("BOSTON COLLEGE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 40000 < i < 40050
		univList = uCtrl.searchSchools("", "", "", "", "40000", "40050", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("MICHIGAN STATE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (-1050 < i < -1000)
		univList = uCtrl.searchSchools("", "", "", "", "-1000", "-1050", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // percFemales (double; 0 <= i <= 100)
			// 50 < i < 55
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "50", "55", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("DEPAUL UNIVERSITY");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 10 < i < 15
		univList = uCtrl.searchSchools("", "", "", "",  "-1", "-1", "10", "15", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("ECOLE POLYTECHNIQUE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i > 100) 
		univList = uCtrl.searchSchools("", "", "", "",  "-1", "-1", "105", "110", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i < 0) 
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-10", "-5", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // satVerbal (double; 0 <= i <= 800)
			// 600 < i < 605
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "600", "605", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("HOLY CROSS");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 450 < i < 455
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "450", "455", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("HUNTINGTON COLLEGE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i > 800)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "900", "910", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-100", "-90", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // satMath (double; 0 <= i <= 800)
			// 600 < i < 605
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "600", "605", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("EMORY");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 400 < i < 405
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "400", "405", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("LESLEY");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i > 800)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "900", "950", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-100", "-90", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // expenses (double; 0 <= i)
			// 10000 < i < 11000
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "10000", "11000", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("MESA");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 20000 < i < 21000
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "500", "505", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("OHIO STATE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-20", "-15", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // percAid (int; 0 <= i <= 100)
			// 50 < i < 55
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "50", "55", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("NOTRE DAME");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 80 < i < 85
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "80", "85", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("PRATT");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-30", "-25", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i > 100)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "145", "150", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // numApply (int; 0 <= i)
			// 5400 < i < 6000
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "5400", "6000", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("OREGON STATE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 40000 < i < 40005
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "16000", "18000", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("MICHIGAN STATE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-50", "-45", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // percAdmit (int; 0 <= i <= 100)
			// 35 < i < 40
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"35", "40", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("ADELPHI");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 85 < i < 90
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"85", "90", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("ADELPHI");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i > 100)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"125", "130", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-35", "-30", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // percEnrolled (int; 0 <= i <= 100)
			// 60 < i < 70
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "60", "70", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("OHIO STATE");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// 15 < i < 25 
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "15", "25", "-1", "-1", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("UNIVERSITY OF CHICAGO");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i > 100)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "110", "115", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-20", "-15", "-1", "-1", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // acadScale (int; 0 < i < 5)
			// 2 < i < 3
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "2", "3", "-1", "-1", "-1", "-1", null);
		exp = dbC.getUniversity("SETON HALL");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-3", "-2", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i > 5)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "7", "8", "-1", "-1", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
		
	  // socialScale (int; 0 < i < 5)
			// 3 < i < 4
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "3", "4", "-1", "-1", null);
		exp = dbC.getUniversity("ADELPHI");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "-3", "-2", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i > 100)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", 
				"-1", "-1", "-1", "-1", "-1", "-1", "8", "9", "-1", "-1", null);
		assertTrue(univList instanceof ArrayList<?>);
		
	  // qualLife (int; 0 < i < 5)
			// 4 < i < 5
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "4", "5", null);
		exp = dbC.getUniversity("ADELPHI");
		assertTrue(univList.size() > 0);
		for (University school : univList)
		{
			if (school.getName().equals(exp.getName()))
				bool = true;
		}				
		assertTrue(bool);
		bool = false;
		
			// Invalid (i < 0)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-5", "-4", null);
		assertTrue(univList instanceof ArrayList<?>);
		
			// Invalid (i > 100)
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "14", "15", null);
		assertTrue(univList instanceof ArrayList<?>);
		
	  // Emphases (String[]; CHEMISTRY[p], COMPUTER-SCIENCE[p], COLLEGE[f])
			// CHEM (Exp. - BRANDEIS)  |  CSCI (Exp. - EMORY)
		String [] input = new String [5];
		boolean bool1 = false;
		boolean bool2 = false;
		
		String exp1 = "BRANDEIS";
		String exp2 = "EMORY";
		
		input[0] = "COMPUTER-SCIENCE";
		input[1] = "CHEMISTRY";
		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
		"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", input);
		
		for (University school : univList)
		{
			if (school.getName().equals(exp1))
			{
				bool1 = true;
			}
			
			if (school.getName().equals(exp2))
			{
				bool2 = true;
			}
		}
		
		assertTrue(bool1);
		assertTrue(bool2);

	// ENGINEERING (Exp. - ARIZONA STATE)
		bool1 = false;
		
		input[0] = "ENGINEERING";
		input[1] = null;
		
		exp1 = "ARIZONA STATE";

		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", input);
				
		for (University school : univList)
		{
			if (school.getName().equals(exp1))
			{
				bool1 = true;
			}
		}
				
		assertTrue(bool1);

	// LEARNING (Exp. - Invalid)
		input[0] = "LEARNING";

		univList = uCtrl.searchSchools("", "", "", "", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", input);
				
		assertTrue(univList instanceof ArrayList<?>);
	}

	/**
	 * Test method for {@link FTMT.UserController#viewProfile(java.lang.String)}.
	 */
	@Test
	public void testViewProfile() {
		user = uCtrl.editProfile("username", "password", "firstName", "lastName", 'u', 'y');
		assertTrue(uCtrl.viewProfile(user.getUsername()).contains(user.getUsername()));
	}
	
	@Test
	public void testSavedSchoolStringtoName() {
		String result = uCtrl.savedSchoolStringtoName("BUTLER (added on: 3/21/19 1:00)");
		
		assertTrue(result.equals("BUTLER"));
	}

	/**
	 * Test method for {@link FTMT.UserController#editProfile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testEditProfile() {

		user  = uCtrl.editProfile(user.getUsername(), user.getPassword(), "firstNameEdited", "lastNameEdited", 'u', 'y');

		assertEquals("username", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals("lastNameEdited", user.getLastName());
		assertEquals("firstNameEdited", user.getFirstName());
		assertEquals('u', user.getType());
		assertEquals('y', user.getStatus());
	}

	/**
	 * Test method for {@link FTMT.UserController#viewSchool(java.lang.String)}.
	 */
	@Test
	public void testViewSchool() {
		University school = uCtrl.viewSchool("CORNELL");
		
		assertEquals("CORNELL", school.getName());
		assertEquals("NEW YORK", school.getState());
		assertEquals("SMALL-CITY", school.getLocation());
		assertEquals("PRIVATE", school.getControl().toUpperCase());
		assertEquals(25000, school.getNumStudents());
		assertEquals(45, school.getPercFemales(), 1);
		assertEquals(600, school.getSatVerbal(), 1);
		assertEquals(650, school.getSatMath(), 1);
		assertEquals(42037, school.getExpenses(), 1);
		assertEquals(50, school.getPercAid(), 1);
		assertEquals(30, school.getPercAdmit(), 1);
		assertEquals(50, school.getPercEnrolled(), 1);
		assertEquals(5, school.getAcadScale(), 1);
		assertEquals(3, school.getSocialScale(), 1);
		assertEquals(2, school.getQualLife(), 1);
		assertEquals(17000, school.getNumApply(), 1);
		
		
		University invalidSchool = uCtrl.viewSchool("Not a School University");
		
		assertTrue(invalidSchool == null);
	}

	/**
	 * Test method for {@link FTMT.UserController#addSavedSchool(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddSavedSchool() {
		String school1 = "BUTLER";
		String school2 = "CLARKSON UNIVERSITY";
		
		boolean bool1 = false;
		boolean bool2 = false;
		
		int result1 = uCtrl.addSavedSchool(user.getUsername(), school1);
		int result2 = uCtrl.addSavedSchool(user.getUsername(), school2);
		
		ArrayList<String> univs = uCtrl.viewSavedSchools(user.getUsername());
		
		for (String school : univs)
		{
			if (school.contains(school1))
				bool1 = true;
			if (school.contains(school2))
				bool2 = true;
		}
		
		assertTrue("Didn't find BUTLER", bool1);
		assertTrue("Didn't find CLARKSON UNIVERSITY", bool2);
	}

	/**
	 * Test method for {@link FTMT.UserController#removeSavedSchool(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemoveSavedSchool() {
		String school1 = "CCNY";
		int result1 = uCtrl.addSavedSchool(user.getUsername(), school1);
		
		int result2 = uCtrl.removeSavedSchool(user.getUsername(), school1);
		
		ArrayList<String> univs = uCtrl.viewSavedSchools(user.getUsername());
		String found = univs.get(0);
		
		assertFalse(found.contains("CCNY"));
	}

	/**
	 * Test method for {@link FTMT.UserController#viewSavedSchools(java.lang.String)}.
	 */
	@Test
	public void testViewSavedSchools() {
		String schoolName1 = "AUGSBURG";
		String schoolName2 = "ADELPHI";
		String schoolName3 = "BENNINGTON";
		
		boolean[] boolList = new boolean[3];
		
		boolean bool1 = false;
		boolean bool2 = false;
		boolean bool3 = false;
		
		uCtrl.addSavedSchool(user.getUsername(), schoolName1);
		uCtrl.addSavedSchool(user.getUsername(), schoolName2);
		uCtrl.addSavedSchool(user.getUsername(), schoolName3);
		
		ArrayList<String> univs = uCtrl.viewSavedSchools(user.getUsername());
		String[] results = new String [5];
		results[0] = schoolName1;
		results[1] = schoolName2;
		results[2] = schoolName3;
		
		int i = 0;
		
		for (String school : univs)
		{
			if (school.contains(results[0]))
			{
				bool1 = true;
			}
			if (school.contains(results[1]))
			{
				bool2 = true;
			}
			if (school.contains(results[2]))
			{
				bool3 = true;
			}
		}
		assertTrue(bool1);
		assertTrue(bool2);
		assertTrue(bool3);
	}

	/**
	 * Test method for {@link FTMT.UserController#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUser() {
		user = uCtrl.editProfile("username", "password", "firstName", "lastName", 'u', 'y');
		User resUser = (User)uCtrl.getUser("username");
		assertTrue(resUser.toString().equals(user.toString()));
	}

	/**
	 * Test method for {@link FTMT.UserController#viewRecSchools(FTMT.University)}.
	 */
	@Test
	public void testViewRecSchools() {
		String name = "BOSTON UNIVERSITY";
		
		University univ = dbC.getUniversity(name);
		
		ArrayList <University> list = uCtrl.viewRecSchools(univ);
		ArrayList <University> expList = new ArrayList<University>();
		
		expList.add(dbC.getUniversity("BENNINGTON"));
		expList.add(dbC.getUniversity("AUBURN"));
		expList.add(dbC.getUniversity("BAYLOR UNIVERSITY"));
		expList.add(dbC.getUniversity("BARUCH"));
		expList.add(dbC.getUniversity("ADELPHI"));
		expList.add(dbC.getUniversity("AMERICAN UNIVERSITY OF BEIRUT"));
		expList.add(dbC.getUniversity("BARNARD"));
		expList.add(dbC.getUniversity("BARD"));
		expList.add(dbC.getUniversity("ABILENE CHRISTIAN UNIVERSITY"));
		expList.add(dbC.getUniversity("ARIZONA STATE"));
		expList.add(dbC.getUniversity("BOSTON COLLEGE"));
		expList.add(dbC.getUniversity("AUGSBURG"));
		
		
		for (int i = 0; i < expList.size(); i++)
		{
			assertEquals(expList.get(i).getName(), list.get(i).getName());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		dbC.removeProfile(user.getUsername());
	}

}
