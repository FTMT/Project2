/**
 * AccountControllerTest.java
 * 
 * Tests the methods of the AccountController class
 */
package FTMT;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wcooper001
 *
 */
public class AccountControllerTest {
	AccountController aCtrl = new AccountController();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		AccountController aCtrl = new AccountController();
	}

	/**
	 * Test method for {@link FTMT.AccountController#login(java.lang.String, java.lang.String)}.
	 * 
	 * @return 0 if unmatched, 1 if matched but inactive, 2 if matched and active
	 */
	@Test
	public void testLogin() {
		int result = this.aCtrl.login("jmiller", "user");
		assertEquals(result, 2);
		
		int result1 = this.aCtrl.login("luser", "user");
		assertEquals(result1, 1);
		
		int result2 = this.aCtrl.login("Wrong_Username", "Wrong_Password");
		assertEquals(result2, 0);
	}

}
