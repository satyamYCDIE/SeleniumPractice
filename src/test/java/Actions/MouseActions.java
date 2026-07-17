package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jquery-az.com/");
		driver.manage().window().maximize();

		WebElement Programming=driver.findElement(By.xpath("//a[normalize-space()='Programming']"));
		WebElement VBA=driver.findElement(By.xpath("//a[normalize-space()='VBA']"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(Programming).moveToElement(VBA).click().build().perform();
	}

}
