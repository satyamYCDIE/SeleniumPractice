package Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomPrac {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://uitestingplayground.com/shadowdom");
		driver.manage().window().maximize();
		
		//This Element is inside single shadow DOM.
		
		SearchContext shadow = driver.findElement(By.cssSelector("guid-generator")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#editField")).sendKeys("Hi Vishu!");

	}

}
