package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingTableData {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//counting number of pages.....
		int pages=driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		
		for(int p=1;p<=pages;p++)
		{
			Thread.sleep(3000); //not needed just wanted to see click on checkbox and data capturing......
			
			driver.findElement(By.xpath("//ul[@id='pagination']//li["+p+"]")).click(); //clicking on particular page....
			
			for(int r=1;r<=5;r++)
			{
				for(int c=1;c<=3;c++)
				{
				String data=driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+"\t");
				driver.findElement(By.xpath("//tbody/tr["+r+"]/td[4]/input[1]")).click();
				}
				System.out.println();
			}
			
		}
	}

}
