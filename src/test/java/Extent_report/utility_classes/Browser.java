package Extent_report.utility_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Browser {
public static WebDriver driver;
public static WebDriver getBrowser(){
	
if(Constants.browser.equals("firefox")){
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
    driver=new FirefoxDriver();



}else if(Constants.browser.equals("IE"))	
{
	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
	
   driver=new InternetExplorerDriver();	
}
else if(Constants.browser.equals("chrome")){
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();                         
}
return driver;
	
}
}
