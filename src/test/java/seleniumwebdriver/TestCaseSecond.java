package seleniumwebdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseSecond {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("newsletter")).sendKeys("satyam20sarha@gmail.com");
		
		//driver.findElement(By.linkText("Blog")).click();
		//driver.findElement(By.partialLinkText("Blog")).click();
		
		//using TagName
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("The number of tag links in the page is:"+links.size());
		
		List<WebElement> image = driver.findElements(By.tagName("img"));
		System.out.println("The number of images present int the page are:"+image.size());
		
		driver.close();
	}

}
