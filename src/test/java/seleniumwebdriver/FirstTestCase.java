package seleniumwebdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase {

	public static void main(String[] args) 
	{
		//Launch Browser
		WebDriver driver=new ChromeDriver();
		
		//Open URL
		driver.get("https://www.google.com/");
		
		//validating Title of the page
		String act_title=driver.getTitle();
		
		if(act_title.equals("Google"))
		{
			System.out.println("Test case Passed");
		}
		else
		{
			System.out.println("Test case Failed");
		}
		
		//Closing Browser
		driver.close();
	}

}
