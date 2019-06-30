package com.qa141.myaccount;

/* Test case to verify Field level check for the input fields
 * * Scenario taken for verification 
 * Login into the My Account  using SSO 
 * Try to add AA with FIRSTNAME containing Special characters
 *  Try to add AA with FIRSTNAME containing Space at starting
 * check for the error message being displayed 
 *  */

import java.util.Set;
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

public class C9_MYA_04_FieldLevelCheck_Test extends BaseTest {
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
			System.out
			.println("Header: -"
					+ driver.findElement(
							By.xpath(".//*[@id='pt1:header:h:macct-app-name']"))
							.getText());
			Assert.assertTrue(
					driver.findElement(
							By.xpath(".//*[@id='pt1:header:h:macct-app-name']"))
							.getText().contains("My Account"), "My Account");

			/*----- Verify Add Account administrator function ------*/

			/*----click Security tab---*/

			driver.findElement(
					By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-accountadmin']"))
					.click();
			driver.manage().timeouts()
			.pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts()
			.pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(5000);

			System.out.println("After asecurityy ");
			/*----click Add button---*/

			if (driver.findElement(By.xpath(".//*[@id='pt1:sections:cb1']"))
					.isEnabled()) {

				/*----click Add button---*/
				driver.findElement(By.xpath(".//*[@id='pt1:sections:cb1']"))
				.click();
				driver.manage()
				.timeouts()
				.pageLoadTimeout(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);
				Thread.sleep(15000);

				/* ----- Navigating to My Services Window ----- */
				Set allWindowHandles = driver.getWindowHandles();
				int win = allWindowHandles.size();
				System.out.println("no. of windows open  " + win);
				String window1 = (String) allWindowHandles.toArray()[1];
				// System.out.println("windows title  " + (String)
				// allWindowHandles.toArray()[1]);
				driver.switchTo().window(window1);
				driver.manage()
				.timeouts()
				.implicitlyWait(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);
				driver.manage()
				.timeouts()
				.pageLoadTimeout(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);
				Thread.sleep(10000);
				// System.out.println("new windows title  "+ driver.getTitle());

				/*----Provide FIRSTNAME with spaces----*/
				// FirstName Field
				driver.findElement(
						By.xpath(".//*[@id='pt1:sections:it1::content']"))
						.clear();
				driver.findElement(
						By.xpath(".//*[@id='pt1:sections:it1::content']"))
						.sendKeys("          FIRST       NAME");

				/*----click Add button---*/

				driver.findElement(By.xpath(".//*[@id='pt1:sections:cb2']"))
				.click();
				driver.manage()
				.timeouts()
				.pageLoadTimeout(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);
				Thread.sleep(5000);

				/*---verify the error messagge------*/
				Assert.assertTrue(driver
						.findElement(
								By.xpath(".//*[@class='AFNoteWindowContent']/div/table/tbody/tr[1]/td[2]"))
								.getText().contains("Error: The format is incorrect."));
				Thread.sleep(1000);

				// System.out.println(driver.findElement(By.xpath(".//*[@class='AFNoteWindowContent']/div/table")).getText());
				System.out
				.println("ERROR message displayed for values with spaces");

				/*----Provide invalid input -special characters for the FIRSTNAME----*/

				// FirstName Field
				driver.findElement(
						By.xpath(".//*[@id='pt1:sections:it1::content']"))
						.clear();
				driver.findElement(
						By.xpath(".//*[@id='pt1:sections:it1::content']"))
						.sendKeys("!#@$@$@$");
				Thread.sleep(5000);

				/*----click Add button---*/

				driver.findElement(By.xpath(".//*[@id='pt1:sections:cb2']"))
				.click();
				driver.manage()
				.timeouts()
				.pageLoadTimeout(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);
				Thread.sleep(5000);

				Assert.assertTrue(driver
						.findElement(
								By.xpath(".//*[@class='AFNoteWindowContent']/div/table/tbody/tr[1]/td[2]"))
								.getText().contains("Error: The format is incorrect."));
				Thread.sleep(1000);
				System.out
				.println("Error message displayed for field vlaues with special characters");

				/*----- Verify cancel------*/
				driver.findElement(By.xpath(".//*[@id='pt1:sections:cb3']"))
				.click();
				driver.manage()
				.timeouts()
				.implicitlyWait(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);
				driver.manage()
				.timeouts()
				.pageLoadTimeout(Config.WAIT_FOR_SECONDS,
						TimeUnit.SECONDS);

				Thread.sleep(5000);
				System.out.println("ADD AA window is closed");

			}
			System.out.println("Test Completed:-  "
					+ this.getClass().getSimpleName());

		} catch (Exception err) {
			Assert.fail(err.getMessage());
		}
	}

	@AfterClass
	public void testCleanUp() {
		// Quit -closes all the open window
		/*----- Logout ------*/
		//Utility.logOut(driver);
		 driver.quit();

	}
}
