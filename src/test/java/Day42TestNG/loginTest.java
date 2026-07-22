package Day42TestNG;

import org.testng.annotations.Test;

public class loginTest {
	
	@Test(priority=1,groups= {"sanity"})
	void loginByEmail()
	{
		System.out.println("This is login via email:");
	}

	@Test(priority=2,groups= {"sanity"})
	void loginByFacebook()
	{
		System.out.println("This is login via Facebook:");
	}
	
	@Test(priority=3,groups= {"sanity"})
	void loginByTwitter()
	{
		System.out.println("This is login via Twitter:");
	}
}
