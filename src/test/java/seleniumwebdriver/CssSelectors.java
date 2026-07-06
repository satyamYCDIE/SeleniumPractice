package seleniumwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectors {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		driver.manage().window().maximize();
		//Using Tag and Class --> Tag.classname
		//driver.findElement(By.cssSelector("input.form-control")).sendKeys("SatyamVishakha");
		
		//Using tag and attributes --> Tag[Attribute="value"]
		//driver.findElement(By.cssSelector("input[name='newsletter']")).sendKeys("SatyamV");
		//driver.findElement(By.cssSelector("input[placeholder='Enter your email address']")).sendKeys("SatyaV");
		
		//Using tag class and attribute--> tag.class[attribute="Value"]
		driver.findElement(By.cssSelector("input.form-control[placeholder='Enter your email address']")).sendKeys("Ayushi");

	}

}
