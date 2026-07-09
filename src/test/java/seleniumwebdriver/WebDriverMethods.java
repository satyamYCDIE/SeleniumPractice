package seleniumwebdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		//using get method......
		driver.get("https://www.opencart.com/index.php?route=common/home");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Linkedin")).click();
		
		//using getTitle method......
		System.out.println(driver.getTitle());
		
		//using currentUrl method.....
		System.out.println(driver.getCurrentUrl());
		
		//Using pageSource method.....
		//System.out.println(driver.getPageSource());
		
		//using getWindowHandle method.....
		//String windowId=driver.getWindowHandle();
		//System.out.println(windowId);
		
		//using getWindowHandles method.....
		Set<String> windowIds=driver.getWindowHandles();
		System.out.println(windowIds);
		
		driver.close();
	}

}
 