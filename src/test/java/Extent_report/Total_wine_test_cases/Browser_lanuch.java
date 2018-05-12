package Extent_report.Total_wine_test_cases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Extent_report.utility_classes.Browser;
import Extent_report.utility_classes.Constants;
import Extent_report.utility_classes.WebDriverComonLib;
import junit.framework.Assert;


public class Browser_lanuch {

   static WebDriver driver;
   WebDriverComonLib clib;
   ExtentReports extent;
   ExtentTest logger;

   @BeforeTest
   public void reportSetup(){
	   
	   //make boolean value true if user doesn't want to append old reports
	   extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\Extentreport.html", true);
	   extent.addSystemInfo("Host Name", "Ankur")
	         .addSystemInfo("Brower", Constants.browser)
	         .addSystemInfo("url",Constants.url);
	   extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	   clib = new WebDriverComonLib();
   }
   
   
   @Test
   public void browserLaunchTest()
   {    
	    logger = extent.startTest("Browser launch test");
	    driver = Browser.getBrowser();
		driver.get(Constants.url);
		clib.waitforPageload();
		clib.maximize();
		driver.quit();
		logger.log(LogStatus.PASS, "Browser launched successfully"); 
		
	}
   
   @Test
   public void passTest(){
	logger = extent.startTest("Pass test");
	Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "Test case is pass"); 
   }
   @Test
   public void failTest() throws InterruptedException{
	logger = extent.startTest("fail test");
    driver = Browser.getBrowser();
	driver.get(Constants.url);
	clib.waitforPageload();
	clib.maximize();
	Thread.sleep(10000);
	driver.findElement(By.id("btnYes")).click();
	Assert.assertTrue(false);
	logger.log(LogStatus.FAIL, "Test case is failing"); 
   }
   @Test
   public void skipTest(){
	logger = extent.startTest("skip test");
	logger.log(LogStatus.SKIP, "Test case is skipped"); 
   }
   public String  getScreenshot(WebDriver driver, String ScreenshotName) throws IOException{
	   String dateName = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File source = ts.getScreenshotAs(OutputType.FILE);
//	   String destination = System.getProperty("user.dir") + "//Screenshot//" + dateName+".png"; // for image
	   String destination = System.getProperty("user.dir") + "//Screenshot//" + dateName+".mp4"; //for video

	   File finalDestination = new File(destination);
	   FileUtils.copyFile(source, finalDestination);
	   return destination;
   }
   
   @AfterMethod
   public void getResult(ITestResult result) throws IOException{
	   
	    if(result.getStatus()==ITestResult.FAILURE){
		   logger.log(LogStatus.FAIL, "test case failed "+result.getName());
		   logger.log(LogStatus.FAIL, "test case failed "+result.getThrowable());
		   String screenshotpath =getScreenshot(driver, result.getName());
		 //  logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));//for image
		   logger.log(LogStatus.FAIL, logger.addScreencast(screenshotpath)); // for video  
	   }	
	   else if(result.getStatus()==ITestResult.SKIP){
		   logger.log(LogStatus.FAIL, "test case failed "+result.getName());

	   }
	    extent.endTest(logger);
   }
   
   
   @AfterTest
   public void endReport(){
	   extent.flush();
	   extent.close();
	   driver.quit();

	      }
   
   

}
