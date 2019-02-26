/**
 * 
 */
package edu.csbsju.cs;

/**
 * @author jmunstert001
 *
 */
public class SimplePrint {
private String pName;
private int pAge;
	public SimplePrint(String pName, int pAge) {
	super();
	this.pName = pName;
	this.pAge = pAge;
}

	public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public int getpAge() {
	return pAge;
}

public void setpAge(int pAge) {
	this.pAge = pAge;
}

	/**
	 * 
	 */
	public SimplePrint() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
for(int i = 0; i<args.length;i++) 
{
System.out.println("args[ " + i + " ] = " + args[i]);	

}


	}

}
