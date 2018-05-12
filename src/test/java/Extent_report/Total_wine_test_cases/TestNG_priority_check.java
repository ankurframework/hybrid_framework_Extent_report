package Extent_report.Total_wine_test_cases;

import org.testng.annotations.Test;

public class TestNG_priority_check {
	
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
