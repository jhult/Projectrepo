package com.qa141.myaccount;

/* Test case to verify all the information displayed in the UI
 * Scenario taken for verification 
 * Verify whether status information being displayed is proper
 * Login to MyAccount
 * Go to Dashoard and click on an service
 * Verify the status information of the service being selected */

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

public class C9_MYA_03_VerifyUI_Test extends BaseTest {
	// WebDriver driver, driver1;
	Select select;

	@Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	public void test(String browserName) {

		try {
			String ssopassword = DbConnection.readDataFromExcelFile(
					".\\data\\TestData.xls", "Sheet1", 1, 4);
			System.out.println(browserName);

			driver = Browser.browserToRun(driver1, browserName);
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);

			driver.get(Config.APP_URL);
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(15000);

			/* ---------- SignIN to MyAccount ---------- */
			Utility.myAccountPage(driver);
			Thread.sleep(15000);

			Login.ssoLogin(driver, "OPC-QA-CERT-IDC_ww@oracle.com", ssopassword);
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(15000);

		     /*----- Verify Header on My Account Landing page  ------*/	      
					System.out.println("Header: -"+ driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText());     
					Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText().contains("My Account"), "My Account");
					
					
			/*----- Verify Dashboard button ------*/
			Assert.assertTrue(Utility.isElementPresent(
					driver,
					By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-dashboard']")));
			driver.manage().timeouts()
			.implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			System.out.println(" Verify Dashboard button ");

			/*----- Click the platform application if present ------*/

			if (Utility
					.isElementPresent(
							driver,
							By.xpath(".//*[@id='pt1:sections:j_id_id79pc3']/div/table/thead/tr/th[1]/span"))) {
				System.out.println(" PLatform services present ");

				/*-- To check whether the requested service being listed---*/

				String TableContents = driver
						.findElement(
								By.xpath(".//*[@id='pt1:sections:j_id_id79pc3']/div/table/tbody/tr/td[1]"))
								.getText();
				String PlatformServices = driver
						.findElement(
								By.xpath(".//*[@id='pt1:sections:j_id_id79pc3']/div/table/thead/tr/th[1]/span"))
								.getText();
				String noofservices = PlatformServices.substring(0, 1);
				int num = Integer.parseInt(noofservices);
				System.out.println("no ofserices in number" + num);

				for (int i = 1; i <= num; i++) {
					TableContents = driver
							.findElement(
									By.xpath(".//*[@id='pt1:sections:j_id_id79pc3']/div/table/tbody/tr["
											+ i + "]/td[1]")).getText();

					if (TableContents.endsWith("Identity Domain: "
							+ Config.DOMAIN)) {
						System.out.println(TableContents);
						System.out.println("Requsted domain present");
					} else
						System.out
						.println("Requested service not associated with this current sso");

				}

			} else

				System.out.println("No Services associated with this SSO");

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

		// Quit -closes all the open windows
		driver.quit();

		// closes the open android emulator
		// Utility.closeAndroidEmulator();

	}

}
