package PracticeSelenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testAutomationPrac {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//provided string and searched......
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000); // to wait for sometime to load the links.....
		
		//find all the anchor tag within that specific UI for Wikipedia11.......
		WebElement menu = driver.findElement(By.xpath("//div[@id='Wikipedia1']"));

		List<WebElement> links = menu.findElements(By.tagName("a"));
		
		//clicking on the each link using for loop....
		for (WebElement link : links) 
		{
		    link.click();
		}
		
		//getting windows ID and handling them by ID and title and closing them by title...... 
		Set<String> windowsIds=driver.getWindowHandles();
		
		for(String winid:windowsIds)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			
			if(title.equals("Selenium disulfide - Wikipedia")|| title.equals("Selenium dioxide - Wikipedia"))
			{
				driver.close();
			}
		}

	}

}
