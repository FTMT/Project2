/**
 * AdminTest.java
 * 
 * Tests the methods of the Admin class
 *
 */
package FTMT;

import static org.junit.Assert.*;

import org.junit.*;

public class AdminTest {
	DBController dbC = new DBController();
	String firstName, lastName, username, password;
	char type, status;
	Admin ad = new Admin(firstName, lastName, username, password, type, status);


	@Test
	public void testSetFirstName() {
		ad.setFirstName("firstName");
		assertEquals("firstName", ad.getFirstName());
	}

	@Test
	public void testSetLastName() {
		ad.setLastName("lastName");
		assertEquals("lastName", ad.getLastName());
	}

	@Test
	public void testSetUsername() {
		this.ad.setUsername("userName");
		assertEquals("userName", this.ad.getUsername());
	}

	@Test
	public void testSetPassword() {
		this.ad.setPassword("testPass");
		assertEquals("testPass", this.ad.getPassword());
		
		this.ad.setPassword("12345");
		assertEquals("12345", this.ad.getPassword());
	}

	@Test
	public void testSetType() {
		this.ad.setType('U');
		assertEquals('U', this.ad.getType());
		
		this.ad.setType('A');
		assertEquals('A', this.ad.getType());
	}

	@Test
	public void testSetStatus() {
		this.ad.setStatus('N');
		assertEquals('N', this.ad.getStatus());
		
		this.ad.setStatus('Y');
		assertEquals('Y', this.ad.getStatus());
	}

	@Test
	public void testSetMatched() {
		this.ad.setMatched(true);
		assertTrue(this.ad.isMatched());
		
		this.ad.setMatched(false);
		assertFalse(this.ad.isMatched());
	}

	@Test
	public void testSetLoggedIn() {
		this.ad.setLoggedIn(true);
		assertTrue(this.ad.isLoggedIn());
		
		this.ad.setLoggedIn(false);
		assertFalse(this.ad.isLoggedIn());
	}
	


}
