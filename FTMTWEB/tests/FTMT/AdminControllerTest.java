/**
 * AdminControllerTest.java
 * 
 * Tests the methods of the AdminController class
 */
package FTMT;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author wcooper001
 *
 */
public class AdminControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	String adminUsername, userUsername;
	Admin admin;
	DBController dbController;
	AdminController adminCtrl;
	String oldName = "Jesus University";
	String newName = "Monster Tiger University";
	String state = "Texas";
	String location = "Houston";
	String control = "Private";
	int numStudents = 777;
	double percFemales = 00.01;
	double satVerbal = 800.00;
	double satMath = 800.00;
	double expenses = 1.00;
	double percAid = 100;
	int numApply = 100;
	double percAdmit = 1.00;
	double percEnrolled = 3.00;
	int acadScale = 3;
	int socialScale = 4;
	int qualLife = 5;
	University oldUniv = new University(oldName, state, location, control, numStudents, percFemales, satVerbal, 
			satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
			acadScale, socialScale, qualLife);
	University newUniv = new University(newName, state, location, control, numStudents, percFemales, satVerbal, 
			satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
			acadScale, socialScale, qualLife);
	
	
	@Before
	public void setUp() throws Exception {
		dbController = new DBController();
		admin = new Admin("admin2","admin2","admin2","admin2",(char)'a',(char)'y');
		dbController.addProfile(admin);
		userUsername = "juser";
		adminUsername = "admin2";
		adminCtrl = new AdminController();
	}

	/**
	 * Test method for {@link FTMT.AdminController#viewProfile(java.lang.String)}.
	 */
	@Test 
	public void testViewProfile() {
		admin = new Admin("admin2","admin2","admin2","admin2",(char)'a',(char)'y');
		dbController.addProfile(admin);
		
		Assert.assertTrue("Users information for juser should be ", adminCtrl.viewProfile(userUsername).contains(userUsername));
		
		Assert.assertTrue("Admins information for juser should be ", adminCtrl.viewProfile(admin.getUsername()).contains(admin.getUsername()));
		
	}

	/**
	 * Test method for {@link FTMT.AdminController#editProfile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testEditProfile() {
		Assert.assertTrue("Profile was edited from admin to user : ", adminCtrl.editProfile("admin1", "admin1", "admin1", "admin1", (char)'U' , (char)'Y') == 1 );
		Assert.assertFalse("Profile was unable to be edited due to already being a user : ", adminCtrl.editProfile("admin1", "admin1", "admin1", "admin1", (char)'U' , (char)'Y') == 0 );
		Assert.assertTrue("Profile was edited correctly back to an Admin: ", adminCtrl.editProfile("admin1", "admin1", "admin1", "admin1", (char)'A' , (char)'Y') == 1 );
	}

	
	/**
	 * Test method for {@link FTMT.AdminController#viewUniversities()}.
	 */
	@Test
	public void testViewUniversities() {
		Assert.assertTrue("Admin is able to view the list of universities. The 2nd University should be Adelphi", adminCtrl.viewUniversities().get(1).getName().equals("ADELPHI"));
				
	}

	/**
	 * Test method for {@link FTMT.AdminController#addUniversity(FTMT.University)}.
	 */
	@Test
	public void testAddUniversity() {
		Assert.assertTrue("University name was already taken and has returned false", adminCtrl.addUniversity(oldUniv) == -1);
		Assert.assertTrue("University name was not taken and has been added", adminCtrl.addUniversity(newUniv) == 1);
		
	}

	

	/**
	 * Test method for {@link FTMT.AdminController#getUniversity(java.lang.String)}.
	 */
	@Test
	public void testGetUniversity() {
		Assert.assertTrue("University Adelphi was retrieved as a University object", adminCtrl.getUniversity("ADELPHI") instanceof University);
	}

	/**
	 * Test method for {@link FTMT.AdminController#editUniversity(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, double, double, double, double, double, int, double, double, int, int, int)}.
	 */
	@Test
	public void testEditUniversity() {
		Assert.assertTrue("University Jesus University was edited properly", adminCtrl.editUniversity(oldName, state, location, control, numStudents, percFemales, satVerbal, satMath, expenses, percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, 4) == 1);
		adminCtrl.editUniversity(oldName, state, location, control, numStudents, percFemales, satVerbal, satMath, expenses, percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, qualLife);
	}




/**
 * Test method for {@link FTMT.AdminController#removeUniversity(java.lang.String)}.
 */
@Test
public void testRemoveUniversity() {
	Assert.assertTrue("University with name of Monster Tiger got removed correctly", adminCtrl.removeUniversity("Monster Tiger University") == 1);
	Assert.assertTrue("University with name of Monster Tiger was unable to be removed due to it not existing anyore", adminCtrl.removeUniversity("Monster Tiger University") == 0);
}

	/**
	 * Test method for {@link FTMT.AdminController#addProfile(FTMT.Account)}.
	 */
	@Test
	public void testAddProfile() {
		Admin newAdmin = new Admin("firstAdmin", "lastAdmin", "adminName", "adminPass", 'A', 'Y');
		
		int result1 = adminCtrl.addProfile(newAdmin);
		int result2 = adminCtrl.addProfile(admin);
		
		Assert.assertTrue("Profile for newAdmin was added correctly", result1 == 1);
		Assert.assertTrue("Admin2 was unable to be added again due to already being added", result2== 0 || result2==-1);
		
		dbController.removeProfile("adminName");
	}
	
	
	/**
	 * Test method for {@link FTMT.AdminController#removeProfile(FTMT.Account)}.
	 */
	@Test
	public void testRemoveProfile() {
		
		dbController.addProfile(admin);
		Assert.assertTrue("Profile admin2 was properly removed" , adminCtrl.removeProfile("admin2")==1);
		Assert.assertTrue("Profile admin2 was unable to be removed because there is no admin2" , adminCtrl.removeProfile("admin2")== 0 || adminCtrl.removeProfile("admin2")== 0);
		dbController.addProfile(admin);
	}
	

	/**
	 * Test method for {@link FTMT.AdminController#viewAllProfiles()}.
	 */
	@Test
	public void testViewAllProfiles() {
		Assert.assertTrue("View all profiles method returned an ArrayList object to iterate over", adminCtrl.viewAllProfiles() instanceof ArrayList);
	}

	/**
	 * Test method for {@link FTMT.AdminController#getEmphases(java.lang.String)}.
	 */
	@Test
	public void testGetEmphases() {
		Assert.assertTrue("University emphases was returned as an ArrayList object to iterate over", adminCtrl.getEmphases("ADELPHI") instanceof ArrayList);
	}
	
	/**
	 * Test method for {@link FTMT.AdminController#deactivateProfile(java.lang.String, char type)}.
	 */
	@Test
	public void testDeactivateProfile() {
		User user = new User();
		Assert.assertTrue("Profile not Deactivated", adminCtrl.deactivateProfile("username", 'U') == 1);
		Assert.assertTrue("Profile already deactivated", adminCtrl.deactivateProfile("username", 'U') == 1);
	}

}
