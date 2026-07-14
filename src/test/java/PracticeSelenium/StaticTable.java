package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Capturing the ROWS from the table....
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("The number of rows present in the table:"+rows);
		
		//Capturing the COLUMNS from the table....
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		System.out.println("The number of columns present in the table:"+cols);
		
		//read data from a specific row and column.....row=5 column=1
		//String BookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
		//System.out.println("The bookname fetched from the table:"+BookName);
		
		//Printing all the data from the table......
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"    ");
			}
			System.out.println();
		}
	}

}
