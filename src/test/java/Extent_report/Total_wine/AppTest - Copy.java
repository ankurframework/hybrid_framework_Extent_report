package Extent_report.Total_wine;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test(priority=-100)
	public void firstRunTest(){
		System.out.println("first run");
		}
	@Test(priority=-3)
	public void secondRunTest(){
		System.out.println("second run");
		}
	@Test(priority=-5,dependsOnMethods = "secondRunTest")
	public void thirdTest(){
		System.out.println("third run");
		}
}
