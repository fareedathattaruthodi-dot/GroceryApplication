package automationCore;


	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;



import utilities.ScreenShotUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

	public class Base {
		Properties pro;
		FileInputStream file;
		public WebDriver driver;
		@BeforeMethod(alwaysRun=true)
		@Parameters("browsers")
		public void browserInitialisation(String browsers) throws IOException {
			pro=new Properties();
			file=new FileInputStream(Constant.CONFIGFILE);
			pro.load(file);
			if(browsers.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browsers.equalsIgnoreCase("firefox"))
			{
				
				driver=new FirefoxDriver();
			}
			else if(browsers.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver();
				driver=new EdgeDriver();
			}
			
			
		 
			driver.get(pro.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
		@AfterMethod(alwaysRun=true)
		public void driverQuit(ITestResult iTestResult) throws IOException {

			if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenShotUtility screenShot = new ScreenShotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
			}
			//driver.quit();

			}
		
	

}
