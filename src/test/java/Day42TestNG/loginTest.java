package Day42TestNG;

import org.testng.annotations.Test;

public class loginTest {
	
	@Test
	void loginByEmail()
	{
		System.out.println("This is login via email:");
	}

	@Test
	void loginByFacebook()
	{
		System.out.println("This is login via Facebook:");
	}
	
	@Test
	void loginByTwitter()
	{
		System.out.println("This is login via Twitter:");
	}
}
