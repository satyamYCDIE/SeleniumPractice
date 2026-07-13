package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownPrac {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement drpCountryEle =driver.findElement(By.xpath("//select[@id='country']"));
		Select drpCountry= new Select(drpCountryEle);
		
		//selecting value using dropdown functions......
		//drpCountry.selectByVisibleText("Germany");
		//drpCountry.selectByValue("australia");
		drpCountry.selectByIndex(8);
	}

}
