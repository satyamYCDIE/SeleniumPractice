package DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiBankCalc {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		String filepath = ("testdata/caldata2.xlsx");
		int rows=ExcelUtils.getRowCount(filepath, "Sheet1");

		for(int i=1;i<=rows;i++)
		{
			//Reading data from excel.......
			String dep=ExcelUtils.getCellData(filepath, "Sheet1", i , 0);
			String interestRate=ExcelUtils.getCellData(filepath, "Sheet1", i , 1);
			String len=ExcelUtils.getCellData(filepath, "Sheet1", i , 2);
			String freq=ExcelUtils.getCellData(filepath, "Sheet1", i , 3);
			String total=ExcelUtils.getCellData(filepath, "Sheet1", i , 4);
			String exp_value=ExcelUtils.getCellData(filepath, "Sheet1", i , 5);
			//System.out.println(dep+" "+interestRate+" "+len+" "+freq+" "+total);
			
			//passing above data in the application.....
			WebElement depamt=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			depamt.clear();
			depamt.sendKeys(dep);
			
			WebElement mnth=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			mnth.clear();
			mnth.sendKeys(len);
			
			WebElement intr=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			intr.clear();
			intr.sendKeys(interestRate);
			
			WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));   //select class object compounddrp will find elelment by id
			compoundrp.click();
			
			List<WebElement> options=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement option:options)
			{
				if(option.getText().equals(freq))
					option.click();
			}
			
//			driver.findElement(By.xpath("//span[@class='mat-mdc-select-min-line']")).clear();
//			Thread.sleep(3000);
//			Select choosecmptype=new Select(driver.findElement(By.xpath("//span[@class='mat-mdc-select-min-line']")));
//			choosecmptype.selectByVisibleText(freq);
//			
			//clicked on calculate......
			//driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement btn = wait.until(
			    ExpectedConditions.elementToBeClickable(By.id("CIT-chart-submit")));

			btn.click();
			
			//Validation......
			String act_value=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(Double.parseDouble(act_value)==Double.parseDouble(exp_value))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filepath, "Sheet1", i, 7);
			}
			Thread.sleep(3000);
			driver.navigate().refresh();
		}
		driver.close();
	}

}
