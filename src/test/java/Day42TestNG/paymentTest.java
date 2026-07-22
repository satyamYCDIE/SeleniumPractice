package Day42TestNG;

import org.testng.annotations.Test;


public class paymentTest {
	
	@Test(priority=1,groups= {"sanity","regression"})
	void paymentInRupees()
	{
		System.out.println("Paid in Rupees:");
	}

	@Test(priority=2,groups= {"sanity","regression"})
	void paymentInDollar() 
	{
		System.out.println("Paid in Dollar:");
	}
}
