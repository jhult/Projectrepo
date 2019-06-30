package com.opc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.safc.configuration.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class BaseTest1 extends BaseTest {
 
//	 public static WebDriver driver, driver1;

	DesiredCapabilities ds = new DesiredCapabilities();
	

	
//	@AfterSuite(alwaysRun = true)
//    public void tearDown() {
//        System.out.println("Inside @AfterSuite");
//        driver.quit();
//    }
	
/*	 @AfterClass
	   public void testCleanUp()   {
		// Close() - closes the current window
       //driver.close();
		 System.out.println("inside testCleanUp");	 
      //  Quit -closes all the open windows
		 driver.quit();
	 }*/
}
