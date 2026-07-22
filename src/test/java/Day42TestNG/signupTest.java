package Day42TestNG;

import org.testng.annotations.Test;


public class signupTest {
	
	@Test(priority=1,groups= {"regression"})
	void signUpEmail()
	{
		System.out.println("Sign up via email");
	}

	@Test(priority=2,groups= {"regression"})
	void signupFacebook()
	{
		System.out.println("sign up via Facebook:");
	}
	
	@Test(priority=3,groups= {"regression"})
	void signupTwitter()
	{
		System.out.println("Sign up via Twitter:");
	}
}
