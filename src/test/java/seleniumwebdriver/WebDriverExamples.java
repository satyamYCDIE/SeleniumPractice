package seleniumwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExamples {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
		System.out.println(title.isDisplayed());
		
		boolean checkRadio=driver.findElement(By.xpath("//input[@id='male']")).isEnabled();
		System.out.println(checkRadio);
		
		WebElement male_Rd=driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		male_Rd.click();
		System.out.println(male_Rd.isSelected());
	}

}
