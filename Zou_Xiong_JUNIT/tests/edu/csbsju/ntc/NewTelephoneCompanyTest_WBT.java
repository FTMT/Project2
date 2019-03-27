package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;

	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();
		
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testInvalidStarTime() {
	    
	    ntc.setStartTime(-5);
	    ntc.setDuration(10);
	    
	   throw new UnsupportedOperationException("Invalid START TIME");
	}

	
		
	

	@Test(expected=UnsupportedOperationException.class)
	public void testInvalidDuration() {
		ntc.setStartTime(1800);
	    ntc.setDuration(0);
	    throw new UnsupportedOperationException("Invalid Duration");
	}

	@Test
	public void testDiscountSt_DiscountDu() {
		int Result2 = 500;
	    ntc.setStartTime(Result2);
	
	    int Result = 100;
	    ntc.setDuration(Result);
	    
	    double expResult = 1768.0;
	    assertTrue(" DiscountSt_DiscountDu is true" + ntc.getStartTime() + ntc.getDuration(), expResult == ntc.computeCharge());
	    
	    
		
	}

	@Test
	public void testDiscountSt() {
		 ntc.setStartTime(0);
		 ntc.setDuration(60);
		 double expResult = 1248.0;
		 assertTrue(" DiscountSt is true" + ntc.getStartTime() + ntc.getDuration(), expResult == ntc.computeCharge());
		
	}

	@Test
	public void testDiscountDu() {
		 ntc.setStartTime(800);
		 ntc.setDuration(65);
		 double expResult = 2298.4;
		 assertTrue(" DiscountDu is true" + ntc.getStartTime() + ntc.getDuration(), expResult == ntc.computeCharge());
	}

	@Test
	public void testNoDiscount() {
		ntc.setStartTime(1000);
		 ntc.setDuration(40);
		 double expResult = 1664.0;
		 assertTrue(" NoDiscount is true" + ntc.getStartTime() + ntc.getDuration(), expResult == ntc.computeCharge());
		
	}

}
