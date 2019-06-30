package com.qa141.myaccount;

/* Test case to verify login and logout functionality of My Account page
 * Scenario taken for verification 
 * Login into the My Account  using SSO 
 * Verify the display of MY Account page using the header
 * Logout of the application
 * Verify the confirmation message upon successful logout
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.opc.common.Browser;
import com.opc.common.Login;
import com.opc.util.Utility;
import com.safc.configuration.BaseTest;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;
import com.safc.configuration.DbConnection;

public class C9_MYA_06_Security_Test extends BaseTest {
	// WebDriver driver, driver1;
	Select select;

	@Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	public void test(String browserName) {

		try {
			String ssopassword = DbConnection.readDataFromExcelFile(
					".\\data\\TestData.xls", "Sheet1", 1, 4);

			System.out.println("Executing TestCase:-  "
					+ this.getClass().getSimpleName());
			System.out.println(browserName);

			driver = Browser.browserToRun(driver1, browserName);
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);

			driver.get(Config.APP_URL);
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts()
			.pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);

			Utility.myAccountPage(driver);
			driver.manage().timeouts()
			.pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);

			Login.ssoLogin(driver, "OPC-QA-CERT-IDC_ww@oracle.com", ssopassword);
			driver.manage().timeouts()
			.pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);

			/*----- Verify Header on My Account Landing page  ------*/	      
			System.out.println("Header: -"+ driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText());     
			Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText().contains("My Account"), "My Account");

			System.out.println("Test Completed:-  "
					+ this.getClass().getSimpleName());

		} catch (Exception err) {
			Assert.fail(err.getMessage());

		}
	}

	@AfterClass
	public void testCleanUp() {

		/*----- Logout ------*/
		Utility.logOut(driver);
		// Quit -closes all the open window
		driver.quit();

	}
}
