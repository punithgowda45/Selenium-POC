package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IConst{
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void openapp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,ETO);
		driver.manage().window().maximize();
		driver.get(app_url);
	}
	
	@AfterMethod
	public void closeapp() {
		driver.quit();
	}
	
	public boolean isalertpresent() {
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
	}
		
	}
	
public void screenshot() throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
		File dest=new File("./images/error" + filename + ".png");
		FileUtils.copyFile(scr, dest);
		System.out.println("Screenshot taken");
		
	}
	
	
}
