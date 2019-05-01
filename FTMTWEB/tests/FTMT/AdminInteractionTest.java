/**
 * AdminInteractionTest.java
 * 
 * Tests the methods of the AdminInteraction class
 */
package FTMT;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author wcooper001
 *
 */
public class AdminInteractionTest {
	DBController dbC = new DBController();
	
 @SuppressWarnings("unused")
 private AdminInteraction interaction;

 /**
  * @throws java.lang.Exception
  */
 @Before
 public void setUp() throws Exception {
  interaction = new AdminInteraction();
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#viewUniversities()}.
  */
 @SuppressWarnings("unlikely-arg-type")
 @Test
 public void testViewUniversities() {
  
     
     
  equals(interaction.viewUniversities());
  
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#editProfile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
  */
 
 @Test
 public void testEditProfile() {
  String username = "jtiger";
  String password = "user";
  String firstName = "Joseph";
  String lastName = "Tiger";
  char type = 'u';
  char status = 'Y';
  User user = (User) dbC.getProfile(username);
  
  interaction.editProfile(firstName, lastName, username, password, type, status);
    
  assertTrue("Profile was edited by admin ", interaction.editProfile("firstNameNew", lastName, username, password, type,status) == 1);
  assertTrue("Error occurs while editing", interaction.editProfile("firstNameNew", lastName, "WRONG_USERNAME", password, type,status) == 0);
  
  interaction.editProfile(username, password, firstName, lastName, type,status);
  
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#login(java.lang.String, java.lang.String)}.
  */
 @Test
 public void testLogin() {
  String username = "admin1";
  String password = "admin1";
  int expResult= 2;
  int expResult2= 0;
  int expResult3= 1;
  assertEquals("This account is actived and logedin:" + expResult,expResult,interaction.login(username, password));
  
  assertEquals("This account is matched but inactive:" + expResult3,expResult3,interaction.login("luser", "user"));
  assertEquals("Does not match:" + expResult2,expResult2,interaction.login("ashe", "Arrows"));
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#AdminInteraction()}.
  */
 @Test
 public void testAdminInteraction() {
  
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#addUniversity(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, double, double, double, double, double, int, double, double, int, int, int)}.
  */
 @Test
 public void testAddUniversity() {
  String name = "Jesus";
  String state = "MN";
  String location = "ST";
  String control = "s";
  int numStudents = 2330;
  double percFemales = 56.8;
  double satVerbal = 20;
  double satMath = 10;
  double expenses = 22;
  double percAid = 99;
  int numApply = 900;
  double percAdmit = 90;
  double percEnrolled = 85;
  int acadScale = 4;
  int socialScale = 4;
  int qualLife = 4;
  
  int expResult = -1;
   
  assertEquals("The university that you added was not unique" + expResult,expResult,interaction.addUniversity(name, state, location, control, numStudents, percFemales, satVerbal,
      satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
      acadScale, socialScale, qualLife));
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#removeUniversity(java.lang.String)}.
  */
 @Test
 public void testRemoveUniversity() {
  String name = "Jesus College";
  assertEquals("No schools were removed" , 0, interaction.removeUniversity(name));
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#viewProfile(java.lang.String)}.
  */
 @Test
 public void testViewProfile() {
  String username = "jtiger";
  
  
  assertTrue("View specific ",interaction.viewProfile(username) instanceof String);   
   }
 

 /**
  * Test method for {@link FTMT.AdminInteraction#viewAllProfiles()}.
  */
 @Test
 public void testViewAllProfiles() {
  
  assertTrue("View all profiles ",interaction.viewAllProfiles() instanceof ArrayList);   
   
  
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#getUniversity(java.lang.String)}.
  */
 @Test
 public void testGetUniversity() {
  String name = "ADELPHI";
  interaction.getUniversity(name);
  assertTrue("get the university ADELPHI as a Univeristy object",interaction.getUniversity(name) instanceof University);  
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#editUniversity(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, double, double, double, double, double, int, double, double, int, int, int)}.
  */
 @Test
 public void testEditUniversity() {
  String name = "ARIZONA STATE";
  String state = "ARIZONA";
  String location = "-1";
  String control = "STATE";
  int numStudents = 40000;
  double percFemales = 50;
  double satVerbal = 450;
  double satMath = 500;
  double expenses = 16181;
  double percAid = 50;
  int numApply = 17000;
  double percAdmit = 80;
  double percEnrolled = 60; 
  int acadScale = 3;
  int qualLife = 5;
  int socialScale = 4;
     int expected = 1;
     assertEquals("1 thing was edited" + expected, expected,interaction.editUniversity(name, state, location, control, numStudents, percFemales, satVerbal, satMath, expenses, 
      percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, qualLife));
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#addProfile(FTMT.Account)}.
  */
 @Test
 public void testAddProfile() {
  
	 
	 int expResult = 0;
  User newUser = new User("First", "Last", "???", "NO", 'U', 'Y');
  assertEquals("Nothing is added to the Dblibrary" + expResult,expResult,interaction.addProfile(newUser));
 }

 /**
  * Test method for {@link FTMT.AdminInteraction#getEmphases(java.lang.String)}.
  */
 @Test
 public void testGetEmphases() {
  String univName  = "ABILENE CHRISTIAN UNIVERSITY";
  
  assertTrue("get the emphases",interaction.getEmphases(univName) instanceof ArrayList); 
 }

}
