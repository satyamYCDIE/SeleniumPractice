package Actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		int BrokenLinksCount=0,NotbrokenlinksCount=0;
		
		for(WebElement linkElement:links)
		{
			String hrefattValue=linkElement.getAttribute("href");
			
			if(hrefattValue==null || hrefattValue.isEmpty())
			{
				System.out.println("We can not check this link");
				continue;
			}
			try
			{
			URL linkURL = new URL(hrefattValue); //converting href string value to URL format
			HttpURLConnection conn= (HttpURLConnection) linkURL.openConnection(); //opening connection
			conn.connect();
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefattValue+"=====>Broken link");
				BrokenLinksCount++;
			}
			else
			{
				System.out.println(hrefattValue+"======>Not Broken link");
				NotbrokenlinksCount++;
			}
			}
			catch(Exception e)
			{
			}
		}
		System.out.println("No of broken links:"+BrokenLinksCount);
		System.out.println("No of not broken links:"+NotbrokenlinksCount);
		driver.quit();
	}

}
