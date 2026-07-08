package seleniumwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingXpath {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().window().maximize();
		
		//Xpath with single attribute
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address']")).sendKeys("AbeYrr");

		//Xpath with multiple attribute
		driver.findElement(By.xpath("//input[@name='newsletter'][@class='form-control']")).sendKeys("Vittu");
		
		//Xpath with inner text()
		//driver.findElement(By.xpath("//a[text()='Blog']")).click();
		
		//checking heading and getting the text of the heading.....
		boolean displaystatus=driver.findElement(By.xpath("//h5[text()='OpenCart']")).isDisplayed();
		System.out.println(displaystatus);
		
		String textvalue=driver.findElement(By.xpath("//h5[text()='OpenCart']")).getText();
		System.out.println(textvalue);
		
		//Xpath using contains......
		driver.findElement(By.xpath("//input[contains(@class,'form')]")).sendKeys("Ankit");
		
		//Xpath using starts-with.....
		driver.findElement(By.xpath("//input[starts-with(@class,'form')]")).sendKeys("Sonu");
	}

}
