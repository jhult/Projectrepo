package com.qa.scenario.test;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opc.common.Browser;
import com.safc.configuration.BaseTest;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;
import com.safc.configuration.DbConnection;

public class NewTest extends BaseTest {
	// WebDriver driver, driver1;
	Select select;

	@Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	public void test(String browserName) {

		try {
			//// System.setOut(new PrintStream(new FileOutputStream(".\\log\\console.txt")));
			//System.out.println("This is System class!!!");
	        //test = extent.createTest(this.getClass().getSimpleName());
	        //test=extent.getStartedReporters();

			String ssopassword =DbConnection.readDataFromExcelFile(".\\data\\TestData.xls", "Sheet1", 1, 4) ;

			System.out.println("*-----Environment Used for testing------ *" + "\n" + Config.APP_URL + "\n" + "\n");
			System.out.println("Executing TestCase:-  " + this.getClass().getSimpleName());
			System.out.println(browserName);
			System.out.println(ssopassword);
			
			  
			  driver = Browser.browserToRun(driver1, browserName);
			  driver.get("https://paytm.com/");
			 
             driver.close();
		
		} catch (Exception err) {
			Assert.fail(err.getMessage());
		}
	}
}
