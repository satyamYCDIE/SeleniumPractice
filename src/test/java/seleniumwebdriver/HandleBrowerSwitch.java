package seleniumwebdriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowerSwitch {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowsIds=driver.getWindowHandles();
		
		/*List<String> windowList=new ArrayList(windowsIds);
		
		String parentId=windowList.get(0);
		String childId=windowList.get(1);
		
		//switch to child Id.......
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		//Switch to parent Id.....
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());*/
		
		//Approach 2........using for loop
		for(String winid:windowsIds)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM: All in One HR Software for Businesses | OrangeHRM"))
			{
				driver.close();
			}
		}
	}

}
