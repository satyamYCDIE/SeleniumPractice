package PracticeSelenium;

import java.time.Duration;
import java.util.List;

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
		String month="June";
		String date="29";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//Selecting month and year....
		while(true)
		{
			
		String currYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		String currMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		//System.out.println(currYear+""+currMonth);
		
		if(currYear.equals(year) && currMonth.equals(month))
			{
				break;
			}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		//selecting date......
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		
		for(WebElement dt:dates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}

}
