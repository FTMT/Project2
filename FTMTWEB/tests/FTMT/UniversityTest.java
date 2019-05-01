/**
 * UniversityTest.java
 * 
 * Tests the methods of the University class
 * 
 */
package FTMT;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wcooper001
 *
 */
public class UniversityTest {
	String name;
	  String state;
	  String location;
	  String control;
	  int numStudents;
	  double percFemales;
	  double satVerbal;
	  double satMath;
	  double expenses;
	  double percAid;
	  double percAdmit;
	  double percEnrolled;
	  int acadScale;
	  int socialScale;
	  int qualLife;
	  int numApply;
	  
	University university = new University();
	String[] info;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String name = "Jesus university";
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
		  university = new University(name, state, location, control, numStudents, percFemales, satVerbal, 
				satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
				acadScale, socialScale, qualLife);
		 info = new String[16];
		
	}


	/**
	 * Test method for {@link FTMT.University#toString()}.
	 * 
	 * String
	 */
	@Test
	public void testToString() {
			
		Assert.assertTrue("University to string prints correctly when called on specific university", 
				this.university.toString().equals("University [name: Jesus university, state: Texas, location: Houston, "
						+ "control: Private, numStudents: 777, percFemales: 0.01, satVerbal: 800.0, satMath: 800.0, expenses: 1.0, "
						+ "percAid: 100.0, percAdmit: 1.0, percEnrolled: 3.0, acadScale: 3, socialScale: 4, qualLife: 5, numApply: 100]"));
	}
	
	/**
	 * Test method for {@link FTMT.University#setName(java.lang.String)}.
	 * 
	 * String
	 */
	@Test
	public void testSetName() {
		 this.university.setName("College University");
		assertEquals("College University", this.university.getName());
		
		this.university.setName("School University");
		assertEquals("School University", this.university.getName());
		
		this.university.setName("Ancient University");
		assertEquals("Ancient University", this.university.getName());
		
	}

	/**
	 * Test method for {@link FTMT.University#setState(java.lang.String)}.
	 * 
	 * String
	 */
	@Test
	public void testSetState() {
		 this.university.setState("NEW YORK");
		assertEquals("NEW YORK", this.university.getState());
		
		this.university.setState("NEW JERSEY");
		assertEquals("NEW JERSEY", this.university.getState());
		
		this.university.setState("ALASKA");
		assertEquals("ALASKA", this.university.getState());
	}


	/**
	 * Test method for {@link FTMT.University#setLocation(java.lang.String)}.
	 * 
	 * SUBURBAN, URBAN, SMALL-CITY, -1
	 */
	@Test
	public void testSetLocation() {
		  this.university.setLocation("SUBURBAN");
		assertEquals("SUBURBAN", this.university.getLocation());
		
		this.university.setLocation("URBAN");
		assertEquals("URBAN", this.university.getLocation());
		
		this.university.setLocation("SMALL-CITY");
		assertEquals("SMALL-CITY", this.university.getLocation());
		
		this.university.setLocation("OTHER");
		assertEquals("-1", this.university.getLocation());
		
		this.university.setLocation("-1");
		assertEquals("-1", this.university.getLocation());
	} 

	/**
	 * Test method for {@link FTMT.University#setControl(java.lang.String)}.
	 * 
	 * STATE, PRIVATE, CITY, -1
	 */
	@Test
	public void testSetControl() {
		this.university.setControl("STATE");
		assertEquals("STATE", this.university.getControl());
		
		this.university.setControl("PRIVATE");
		assertEquals("PRIVATE", this.university.getControl());
		
		this.university.setControl("CITY");
		assertEquals("CITY", this.university.getControl());
		
		this.university.setControl("OTHER");
		assertEquals("-1", this.university.getControl());
		
		this.university.setControl("-1");
		assertEquals("-1", this.university.getControl());
	}

	/**
	 * Test method for {@link FTMT.University#setNumStudents(int)}.
	 */
	@Test
	public void testSetNumStudents() {
		this.university.setNumStudents(8000);
		assertEquals(8000, this.university.getNumStudents());
		
		this.university.setNumStudents(80);
		assertEquals(80, this.university.getNumStudents());
		
		this.university.setNumStudents(-800);
		assertEquals(0, this.university.getNumStudents());
	}

	/**
	 * Test method for {@link FTMT.University#setPercFemales(double)}.
	 */
	@Test
	public void testSetPercFemales() {
		 this.university.setPercFemales(30.0);
		Assert.assertTrue("This university has 30% females",this.university.getPercFemales()==30.0 );
		
		this.university.setPercFemales(90.0);
		Assert.assertTrue("This university has 90% females",this.university.getPercFemales()==90.0 );
		
		this.university.setPercFemales(110.0);
		Assert.assertTrue("This university has 100% females",this.university.getPercFemales()==100.0 );
		
		this.university.setPercFemales(-20.0);
		Assert.assertTrue("This university has 0% females",this.university.getPercFemales()==0.0 );
		
		this.university.setPercFemales(0.0);
		Assert.assertTrue("This university has 0% females",this.university.getPercFemales()==0.0 );
	}

	/**
	 * Test method for {@link FTMT.University#setSatVerbal(double)}.
	 */
	@Test
	public void testSetSatVerbal() {
		this.university.setSatVerbal(900);
		Assert.assertTrue("SAT VERBAL is now set to 800", this.university.getSatVerbal() == 800);
		
		this.university.setSatVerbal(700);
		Assert.assertTrue("SAT VERBAL is now set to 700", this.university.getSatVerbal() == 700);
		
		this.university.setSatVerbal(80);
		Assert.assertTrue("SAT VERBAL is now set to 80", this.university.getSatVerbal() == 80);
		
		this.university.setSatVerbal(-100);
		Assert.assertTrue("SAT VERBAL is now set to 0", this.university.getSatVerbal() == 0);
	}
	
	/**
	 * Test method for {@link FTMT.University#setNumApply(int)}.
	 */
	@Test
	public void testSetNumApply() {
		this.university.setNumApply(900);
		Assert.assertTrue("NumApply is now set to 900", this.university.getNumApply() == 900);
		
		this.university.setNumApply(700);
		Assert.assertTrue("NumApply is now set to 700", this.university.getNumApply() == 700);
		
		this.university.setNumApply(80);
		Assert.assertTrue("NumApply is now set to 80", this.university.getNumApply() == 80);
		
		this.university.setNumApply(-100);
		Assert.assertTrue("NumApply is now set to 0", this.university.getNumApply() == 0);
	}

	/**
	 * Test method for {@link FTMT.University#setSatMath(double)}.
	 */
	@Test
	public void testSetSatMath() {
		this.university.setSatMath(800);
		Assert.assertTrue("SAT MATH is now set to 800", this.university.getSatMath() == 800);
		
		this.university.setSatMath(200);
		Assert.assertTrue("SAT MATH is now set to 200", this.university.getSatMath() == 200);
		
		this.university.setSatMath(-10);
		Assert.assertTrue("SAT MATH is now set to 0", this.university.getSatMath() == 0);
		
		this.university.setSatMath(8000);
		Assert.assertTrue("SAT MATH is now set to 800", this.university.getSatMath() == 800);
		
	}

	/**
	 * Test method for {@link FTMT.University#setExpenses(double)}.
	 */
	@Test
	public void testSetExpenses() {
		this.university.setExpenses(30000);
		Assert.assertTrue("University expenses was set to 30,000", this.university.getExpenses()==30000);
		
		this.university.setExpenses(6000);
		Assert.assertTrue("University expenses was set to 6,000", this.university.getExpenses()==6000);
		
		this.university.setExpenses(1);
		Assert.assertTrue("University expenses was set to 1", this.university.getExpenses()==1);
		
		this.university.setExpenses(-178);
		Assert.assertTrue("University expenses was set to 0", this.university.getExpenses()==0);
	}

	/**
	 * Test method for {@link FTMT.University#setPercAid(double)}.
	 */
	@Test
	public void testSetPercAid() {
		this.university.setPercAid(50);
		Assert.assertTrue("The percent who need aid is now set to 50", this.university.getPercAid()==50);
		
		this.university.setPercAid(-10);
		assertTrue("The percent who need aid is now set to 0", 0 == this.university.getPercAid());
		
		this.university.setPercAid(90);
		assertTrue("The percent who need aid is now set to 90",90 == this.university.getPercAid());
		
		this.university.setPercAid(3000);
		assertTrue("The percent who need aid is now set to 100",100 == this.university.getPercAid());
	}


	/**
	 * Test method for {@link FTMT.University#setPercAdmit(double)}.
	 */
	@Test
	public void testSetPercAdmit() {
		this.university.setPercAdmit(2);
		Assert.assertTrue("Percent admitted is now set to 2 percent", this.university.getPercAdmit() == 2);

		this.university.setPercAdmit(-10);
		assertTrue("Percent admitted is now set to 0 percent", 0 == this.university.getPercAdmit());
		
		this.university.setPercAdmit(90);
		assertTrue("Percent admitted is now set to 90 percent", 90 == this.university.getPercAdmit());
		
		this.university.setPercAdmit(3000);
		assertTrue("Percent admitted is now set to 100 percent", 100 == this.university.getPercAdmit());
	}

	/**
	 * Test method for {@link FTMT.University#setPercEnrolled(double)}.
	 */
	@Test
	public void testSetPercEnrolled() {
		this.university.setPercEnrolled(7);
		Assert.assertTrue("The percent who enrolled is now set to 7", this.university.getPercEnrolled()==7);
		
		this.university.setPercEnrolled(-10);
		assertTrue("The percent who enrolled is now set to 0", 0 == this.university.getPercEnrolled());
		
		this.university.setPercEnrolled(90);
		assertTrue("The percent who enrolled is now set to 90", 90 == this.university.getPercEnrolled());
		
		this.university.setPercEnrolled(3000);
		assertTrue("The percent who enrolled is now set to 100", 100 == this.university.getPercEnrolled());
	}

	/**
	 * Test method for {@link FTMT.University#setAcadScale(int)}.
	 */
	@Test
	public void testSetAcadScale() {
		this.university.setAcadScale(9);
		assertEquals(1, this.university.getAcadScale());
		
		this.university.setAcadScale(1);
		assertEquals(1, this.university.getAcadScale());
		
		this.university.setAcadScale(3);
		assertEquals(3, this.university.getAcadScale());
		
		this.university.setAcadScale(5);
		assertEquals(5, this.university.getAcadScale());
		
		this.university.setAcadScale(-1);
		assertEquals(1, this.university.getAcadScale());
		
		this.university.setAcadScale(0);
		assertEquals(1, this.university.getAcadScale());
	}

	/**
	 * Test method for {@link FTMT.University#setSocialScale(int)}.
	 */
	@Test
	public void testSetSocialScale() {
		this.university.setSocialScale(1);
		assertEquals(1, this.university.getSocialScale());
		
		this.university.setSocialScale(3);
		assertEquals(3, this.university.getSocialScale());
		
		this.university.setSocialScale(5);
		assertEquals(5, this.university.getSocialScale());
		
		this.university.setSocialScale(-1);
		assertEquals(1, this.university.getSocialScale());
		
		this.university.setSocialScale(0);
		assertEquals(1, this.university.getSocialScale());
		
		this.university.setSocialScale(7);
		assertEquals(1, this.university.getSocialScale());
	}

	/**
	 * Test method for {@link FTMT.University#setQualLife(int)}.
	 */
	@Test
	public void testSetQualLife() {
		this.university.setQualLife(1); 
		assertEquals(1, this.university.getQualLife());
		
		this.university.setQualLife(3);
		assertEquals(3, this.university.getQualLife());
		
		this.university.setQualLife(5);
		assertEquals(5, this.university.getQualLife());
		
		this.university.setQualLife(-1);
		assertEquals(1, this.university.getQualLife());
		
		this.university.setQualLife(0);
		assertEquals(1, this.university.getQualLife());
		
		this.university.setQualLife(7);
		assertEquals(1, this.university.getQualLife());
	}


	/**
	 * Test method for {@link FTMT.University#setInfo(java.lang.String[])}.
	 * 
	 * Uses same set methods as above
	 */
	@Test
	public void testSetInfo() {
		info[0] = "NameTest"; 	// Name
		info[1] = "StateTest";	// State
		info[2] = "SMALL-CITY"; // Location
		info[3] = "PRIVATE";	// Control
		info[4] = "500";		// numStudents
		info[5] = "40";			// percFemale
		info[6] = "500";		// satVerbal
		info[7] = "400";		// satMath
		info[8] = "14000";		// Expenses
		info[9] = "40";			// percAid
		info[10] = "400";		// numApply
		info[11] = "70";		// percAdmit
		info[12] = "60";		// percEnrolled
		info[13] = "3";			// acadScale
		info[14] = "4";			// socialScale
		info[15] = "4";			// qualLife
		this.university.setInfo(info);
		
		assertTrue(info.equals(this.university.getInfo()));
		assertTrue(info[0].equals(this.university.getName()));
		assertTrue(info[1].equals(this.university.getState()));
		assertTrue(info[2].equals(this.university.getLocation()));
		assertTrue(info[3].equals(this.university.getControl()));
		assertTrue(Integer.parseInt(info[4]) == this.university.getNumStudents());
		assertTrue(Integer.parseInt(info[5]) == this.university.getPercFemales());
		assertTrue(Integer.parseInt(info[6]) == this.university.getSatVerbal());
		assertTrue(Integer.parseInt(info[7]) == this.university.getSatMath());
		assertTrue(Integer.parseInt(info[8]) == this.university.getExpenses());
		assertTrue(Integer.parseInt(info[9]) == this.university.getPercAid());
		assertTrue(Integer.parseInt(info[10]) == this.university.getNumApply());
		assertTrue(Integer.parseInt(info[11]) == this.university.getPercAdmit());
		assertTrue(Integer.parseInt(info[12]) == this.university.getPercEnrolled());
		assertTrue(Integer.parseInt(info[13]) == this.university.getAcadScale());
		assertTrue(Integer.parseInt(info[14]) == this.university.getSocialScale());
		assertTrue(Integer.parseInt(info[15]) == this.university.getQualLife());
	}

}