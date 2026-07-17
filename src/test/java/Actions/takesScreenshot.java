package Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class takesScreenshot {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/dual-handles-ticks-cui-slider/");
		driver.manage().window().maximize();

		TakesScreenshot ts= (TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"/screenshots/fullpage.png");
		//sourcefile.renameTo(targetfile);  //copying source file to target file
		FileUtils.copyFile(sourcefile, targetfile);
	}

}
