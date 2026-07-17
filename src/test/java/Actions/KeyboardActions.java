package Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("I LOVE YOU VISHU");
		
		act.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
		
		act.keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND).perform();
		
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		act.keyDown(Keys.COMMAND).sendKeys("V").keyDown(Keys.COMMAND).perform();
		
	}

}
