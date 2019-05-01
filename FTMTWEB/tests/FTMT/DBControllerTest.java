package FTMT;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DBControllerTest{

DBController dbc = new DBController();

String username = "testUser";
String password = "user";
String firstName = "John";
String lastName = "Miller";
char type = 'u';
char status = 'Y';

String name = "Fix Eclipse University";
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
University newUniv;
User newUser;
String[] emphases;

@Before
public void setUp() throws NullPointerException {
 newUniv = new University(name, state, location, control, numStudents, percFemales, satVerbal, 
   satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
   acadScale, socialScale, qualLife);
 dbc.addUniversity(newUniv);
 newUser = new User(firstName, lastName, username, password, type, status);
}


@Test
public void testEditUniversity() {
 dbc.addUniversity(newUniv);
 Assert.assertTrue("Quality of Life was edited for a given university",dbc.editUniversity(name, state, location,control, numStudents,  percFemales,satVerbal,
            satMath, expenses, percAid, numApply, percAdmit,percEnrolled, 
             acadScale, socialScale, 3)==1 );
 
 Assert.assertTrue("Quality of Life was edited back to original information",dbc.editUniversity(name, state, location,control, numStudents,  percFemales,satVerbal,
            satMath, expenses, percAid, numApply, percAdmit,percEnrolled, 
             acadScale, socialScale, 5)==1 );
 
}



@Test
public void testAddUniversity() {
 dbc.removeUniversity("Fix Eclipse University");
 Assert.assertTrue("New university was added to the database",dbc.addUniversity(newUniv) == 1);
 
}

@Test
public void testAddProfile() {
 
  
  assertEquals(1,dbc.addProfile(newUser));
  dbc.removeProfile(username);

}

@Test
public void testRemoveProfile() {
 dbc.addProfile(newUser);
 Assert.assertTrue("Profile for test user is now removed.", dbc.removeProfile(username) == 1);

 User notAdded = new User();
 
 Assert.assertTrue("Profile for test user could not be removed.", dbc.removeProfile(username) == -1 || dbc.removeProfile(username) == 0);
}

@Test
public void testSetProfileInfo() {
 
 dbc.addProfile(newUser);
Assert.assertTrue("Profile was updated by 1 difference", dbc.setProfileInfo(username, password, "BIGBOI", lastName, type, status)==1);
 dbc.removeProfile(username);
}

@Test
public void testGetProfile() {
	newUser = new User();
	dbc.addProfile(newUser);
	
	Admin newAdmin = new Admin();
	dbc.addProfile(newAdmin);
	
	assertTrue(Character.toUpperCase(dbc.getProfile(newUser.getUsername()).getType()) == 'U');
	assertTrue(Character.toUpperCase(dbc.getProfile(newAdmin.getUsername()).getType()) == 'A');
	
}

@Test
public void testCheckInfo() {

 Assert.assertTrue("Profile given is the correct username and password",dbc.checkInfo("admin2", "admin2") == true);
 Assert.assertTrue("Profile given is the correct username and password",dbc.checkInfo("admin2", "adminWRONG") == false);
 Assert.assertTrue("Profile given is the correct username and password",dbc.checkInfo("adminWRONG", "admin2") == false);
}

@Test
public void testSearchSchools() {
 emphases = new String[2];
 emphases[0] = "Test";
 Assert.assertTrue("Search schools returns an ArrayList object containing University objects",(dbc.searchSchools("-1", "MINNESOTA", "-1", "-1", "1000", "-1",
      "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
      "-1", "-1", "-1", "-1", emphases)) instanceof ArrayList<?>);
}

@Test
public void testViewUniversities() {
 Assert.assertTrue("View Universities returns an ArrayList object containing University objects",dbc.viewUniversities() instanceof ArrayList<?>);
}

@Test
public void testAddSavedSchool() {
 Assert.assertTrue("Given School was added to admin2's saved school list", dbc.addSavedSchool("admin2","Harvard")==1);
 dbc.removeSavedSchool("admin2", "Harvard");
}

@Test
public void testSchoolDist() {
 Assert.assertTrue(dbc.schoolDist(newUniv) instanceof Map<?,?>);
}

@Test
public void testRemoveSavedSchool() {
 dbc.addSavedSchool("admin2", "Harvard");
 Assert.assertTrue("Given School was removed from admin2's saved school list", dbc.removeSavedSchool("admin2","Harvard")==1);
}

@Test
public void testViewSavedSchools() {
 Assert.assertTrue("View saved school list returns an ArrayList object containing strings of University names",dbc.viewSavedSchools("admin2") instanceof ArrayList<?>);
}

@Test
public void testRemoveUniversity() {
 
 Assert.assertTrue("New university was now removed from the database",dbc.removeUniversity("Fix Eclipse University") == 1); 
 }

@Test
public void testViewAllProfiles() {
 Assert.assertTrue("View all profiles returns an ArrayList object containing accounts.",dbc.viewAllProfiles() instanceof ArrayList<?>);
}

@After
public void after()
{
 dbc.removeUniversity("Fix Eclipse University");
}


}