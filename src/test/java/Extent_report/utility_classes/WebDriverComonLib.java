package Extent_report.utility_classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverComonLib {
	public void waitforPageload(){
		Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		}
		public void waitforElementPresent(WebElement wb){
			WebDriverWait wait=new WebDriverWait(Browser.driver, 20);
			wait.until(ExpectedConditions.visibilityOf(wb));
		}
		public void maximize(){
			Browser.driver.manage().window().maximize();
		}
		public void type(WebElement editWb,String data){
			waitforElementPresent(editWb);
		editWb.sendKeys(data);
		}
		public void click(WebElement clickWb){
			waitforElementPresent(clickWb);
	clickWb.click();
		}
		public void select(WebElement selectWb,int index){
			Select sel=new Select(selectWb);
			sel.selectByIndex(index);
		}
		public void select(WebElement selectWb,String data){
			Select sel=new Select(selectWb);
			sel.selectByVisibleText(data);
		}
	

}
