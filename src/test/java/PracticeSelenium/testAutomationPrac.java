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
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		//List<WebElement> links=driver.findElements(By.tagName("a"));
		//System.out.println("The number of tag links in the page is:"+links.size());
		WebElement menu = driver.findElement(By.xpath("//div[@id='Wikipedia1']"));

		List<WebElement> links = menu.findElements(By.tagName("a"));

		for (WebElement link : links) 
		{
		    link.click();
		}
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
