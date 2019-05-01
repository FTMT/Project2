/**
 * 
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
public class UserTest {
 
 private User newUser;
 private User user;

 /**
  * @throws java.lang.Exception
  */
 @Before
 public void setUp() throws Exception {
  user = new User();
  
  newUser = new User("Tianyu","Zou","TZ","123",'u','y');
 }

 /**
  * Test method for {@link FTMT.User#login(java.lang.String, java.lang.String)}.
  */
 @Test
 public void testLogin() {
  String username = user.getUsername();
  String password = user.getPassword();
  int result = user.login(username,password);
  assertEquals(1, result);
  
  username = "WrongUsername";
  password = user.getPassword();
  result = user.login(username,password);
  assertEquals(0, result);
  
  username = user.getUsername();
  password = "WrongPassword";
  result = user.login(username,password);
  assertEquals(0, result);
 }

 /**
  * Test method for {@link FTMT.User#setFirstName(java.lang.String)}.
  */
 @Test
 public void testSetFirstName() {
  newUser.setFirstName("SOON");
  assertEquals("SOON", newUser.getFirstName());
  
  newUser.setFirstName("soon");
  assertEquals("soon", newUser.getFirstName());
 }

 /**
  * Test method for {@link FTMT.User#setLastName(java.lang.String)}.
  */
 @Test
 public void testSetLastName() {
  newUser.setLastName("Eternal");
  assertEquals("Eternal", newUser.getLastName());
  
  newUser.setLastName("Kramer");
  assertEquals("Kramer", newUser.getLastName());
 }

 /**
  * Test method for {@link FTMT.User#setUsername(java.lang.String)}.
  */
 @Test
 public void testSetUsername() {
  newUser.setUsername("James");
  assertEquals("James", newUser.getUsername());
  
  newUser.setUsername("GoodUser");
  assertEquals("GoodUser", newUser.getUsername());
 }

 /**
  * Test method for {@link FTMT.User#setPassword(java.lang.String)}.
  */
 @Test
 public void testSetPassword() {
  newUser.setPassword("123456");
  assertEquals("123456", newUser.getPassword());
  
  newUser.setPassword("NoAnswers");
  assertEquals("NoAnswers", newUser.getPassword());
 }

 /**
  * Test method for {@link FTMT.User#setType(char)}.
  */
 @Test
 public void testSetType() {
  newUser.setType('A');
  assertEquals('A', newUser.getType());
  
  newUser.setType('U');
  assertEquals('U', newUser.getType());
 }

 /**
  * Test method for {@link FTMT.User#setStatus(char)}.
  */
 @Test
 public void testSetStatus() {
  newUser.setStatus('Y');
  assertEquals('Y', newUser.getStatus());

  newUser.setStatus('N');
  assertEquals('N', Character.toUpperCase(newUser.getStatus()));
  
  newUser.setStatus('R');
  assertEquals('Y', newUser.getStatus());
 }

 /**
  * Test method for {@link FTMT.User#getFirstName()}.
  */
 @Test
 public void testGetFirstName() {
  String fn = newUser.getFirstName();
  String expected = "Tianyu";
  assertEquals("Get first name " + expected,expected, fn);
  
  newUser.setFirstName("Will");
  fn = newUser.getFirstName();
  expected = "Will";
  assertEquals("Get first name " + expected,expected, fn);
 }

 /**
  * Test method for {@link FTMT.User#getLastName()}.
  */
 @Test
 public void testGetLastName() {
  String ln = newUser.getLastName();
  String expected = "Zou";
  assertEquals("Get last name " + expected,expected, ln);
  
  newUser.setLastName("Cooper");
  ln = newUser.getLastName();
  expected = "Cooper";
  assertEquals("Get last name " + expected,expected, ln);
 }

 /**
  * Test method for {@link FTMT.User#getUsername()}.
  */
 @Test
 public void testGetUsername() {
  String un = newUser.getUsername();
  String expected = "TZ";
  assertEquals("Get username " + expected,expected, un);
 }

 /**
  * Test method for {@link FTMT.User#getPassword()}.
  */
 @Test
 public void testGetPassword() {
  String ps = newUser.getPassword();
  
  String expected = "123";
  
  assertEquals("Get password " + expected,expected, ps);
 }

 /**
  * Test method for {@link FTMT.User#getType()}.
  */
 @Test
 public void testGetType() {
  char type = user.getType();
  assertTrue("Get type ",type == 'u');
 }

 /**
  * Test method for {@link FTMT.User#getStatus()}.
  */
 @Test
 public void testGetStatus() {
  char status = user.getStatus();
  assertTrue("Get status ",status == 'y');
  
  user.setStatus('n');
  status = user.getStatus();
  assertTrue("Get status ",status == 'n');
  
  user.setStatus('y');
 }

 
 

 /**
  * Test method for {@link FTMT.User#toString()}.
  */
 @Test
 public void testToString() {
  assertTrue("Working Correctly", newUser.toString() instanceof String);
  assertEquals("User [username: " + newUser.getUsername() + ", password: " + newUser.getPassword() + ", firstName: "
	+ newUser.getFirstName() + ", lastName: " + newUser.getLastName() + ", type: "  + newUser.getType() + ", status: " + newUser.getStatus() + "]", newUser.toString());
 }

 /**
  * Test method for {@link FTMT.User#User()}.
  */
 @Test
 public void testUser() {
  User blankUser = new User();
	 
  assertTrue("First name is true", user.getFirstName() instanceof String);
  assertEquals("firstName", blankUser.getFirstName());
  assertTrue("Last name is true",user.getLastName() instanceof String);
  assertEquals("lastName", blankUser.getLastName());
  assertTrue("User name is true",user.getUsername() instanceof String);
  assertEquals("username", blankUser.getUsername());
  assertTrue("Password is true",user.getPassword() instanceof String);
  assertEquals("password", blankUser.getPassword());
  assertEquals("Type is true",'U',Character.toUpperCase(user.getType()));
  assertEquals("Status is true",'Y',Character.toUpperCase(user.getStatus()));
  
 }
 
 /**
     * Test method for {@link FTMT.User#User(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
     */
    @Test
    public void testUserStringStringStringStringCharChar() {
     assertEquals("First name is true", "Tianyu",newUser.getFirstName());
     assertEquals("Last name is true","Zou",newUser.getLastName());
     assertEquals("User name is true","TZ",newUser.getUsername());
     assertEquals("Password is true","123",newUser.getPassword());
     assertEquals("Type is true",'u',newUser.getType());
     assertEquals("Status is true",'y',newUser.getStatus());
  
     User freshUser = new User("First_Name", "Last_Name", "User_Name", "Pass_Word", 'U', 'Y');
     System.out.println("User: " + freshUser.toString());
     assertEquals("First_Name", freshUser.getFirstName());
     assertEquals("Last_Name", freshUser.getLastName());
     assertEquals("User_Name", freshUser.getUsername());
     assertEquals("Pass_Word", freshUser.getPassword());
     assertEquals('U', Character.toUpperCase(freshUser.getType()));
     assertEquals('Y', Character.toUpperCase(freshUser.getStatus()));
    }


 /**
  * Test method for {@link FTMT.User#isLoggedIn()}.
  */
 @Test
 public void testIsLoggedIn() {
  assertTrue("Account is not logged in", newUser.isLoggedIn() == false);
 }

 /**
  * Test method for {@link FTMT.User#setLoggedIn(boolean)}.
  */
 @Test
 public void testSetLoggedIn() {
  newUser.setLoggedIn(false);
  assertFalse(newUser.isLoggedIn());
  
  newUser.setLoggedIn(true);
  assertTrue(newUser.isLoggedIn());
  
  newUser.setLoggedIn(false);
 }

 /**
  * Test method for {@link FTMT.User#isMatched()}.
  */
 @Test
 public void testIsMatched() {
  assertTrue("Account is matched", newUser.isMatched() == false);
 }

 /**
  * Test method for {@link FTMT.User#setMatched(boolean)}.
  */
 @Test
 public void testSetMatched() {
  newUser.setMatched(false);
  assertFalse(newUser.isMatched());
  
  newUser.setMatched(true);
  assertTrue(newUser.isMatched());
  
  newUser.setMatched(false);
 }

}
