package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		
		//Method 1 by sending value through Sendkeys.......
//		WebElement Pdate=driver.findElement(By.xpath("//input[@id='datepicker']"));
//		Pdate.click();
//		Pdate.sendKeys("08/26/2026");
		
		//Method 2 using date picker.......
		String year="2027";
		String month="Oct";
		String date="5";
	}

}
