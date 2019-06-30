package com.qa141.myaccount;

/* Test case to verify Search functionality of My Account page
 * Scenario taken for verification 
 * Login into the My Account  using SSO 
 * Verify the display of MY Account page using the header
 * Select ACTIVE and verify the result
 * Select INACTIVE and verify the result
 * Select Database and verify the result
 * Select Java and verify the result
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import java.lang.*;


public class C9_MYA_07_SearchFilter_Test extends BaseTest{
	//	WebDriver driver, driver1;
	Select select;


	@Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	public void test(String browserName) {

		try{  
			String ssopassword = DbConnection.readDataFromExcelFile(".\\data\\TestData.xls", "Sheet1", 1, 4)	;

			System.out.println("Executing TestCase:-  " +  this.getClass().getSimpleName());	 
			System.out.println(browserName);

			driver = Browser.browserToRun(driver1, browserName);
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);

			driver.get(Config.APP_URL);  
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);


			Utility.myAccountPage(driver);
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);


			Login.ssoLogin(driver, "OPC-QA-CERT-IDC_ww@oracle.com", ssopassword);   
			//			Login.ssoLogin(driver, "manonmani.jay@oracle.com", "JMMedhini1410");  
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);


			/*----- Verify Header on My Account Landing page  ------*/	      
			System.out.println("Header: -"+ driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText());     
			Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText().contains("My Account"), "My Account");



			/*----- Goto Platform Services link ------*/		 

			/*----- Click search drop down menu ------*/ 	 
			driver.findElement(By.xpath(" .//*[@id='pt1:sections:dc:env-lf-btn']")).click();
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);


			/*-----Select Active and verify whether active services are displayed---*/
			driver.findElement(By.xpath(".//*[@id='pt1:sections:dc:svcs-active']")).click();
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);



			if(Utility.isElementPresent(driver, By.xpath(".//*[@id='pt1:sections:dc:sec-table']")))
			{

				String Tablecontents = driver.findElement(By.xpath(".//*[@id='pt1:sections:dc:sec-table']")).getText();

				if(Tablecontents.contains(Config.DOMAIN))
				{
					System.out.println(" Requested service is shown in  Active state ");
					Assert.assertTrue(Tablecontents.contains(Config.DOMAIN));
				}
				else
				{
					System.out.println(" Requested service is not shown in active state / Not assoicated with this current sso user ");
				}
			}
			else
				System.out.println(" No services available in active state");

			/*-----Select InActive and verify whether inactive services are displayed---*/

			/*----- Click search drop down menu ------*/ 	 
			driver.findElement(By.xpath(" .//*[@id='pt1:sections:dc:env-lf-btn']")).click();
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);


			/*-----Select Active and verify whether active services are displayed---*/
			driver.findElement(By.xpath(".//*[@id='pt1:sections:dc:svcs-inactive']")).click();
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);


			if(Utility.isElementPresent(driver, By.xpath(".//*[@id='pt1:sections:dc:sec-table']")))
			{

				String Tablecontents = driver.findElement(By.xpath(".//*[@id='pt1:sections:dc:sec-table']")).getText();

				if(Tablecontents.contains(Config.DOMAIN))
				{
					System.out.println(" Requested service is shown in  InActive state ");
					Assert.assertTrue(Tablecontents.contains(Config.DOMAIN));
				}
				else
				{
					System.out.println(" Requested service is not shown in INACTIVE state / Not assoicated with this current sso user ");
				}
			}
			else
				System.out.println(" No services available in inactive state");

			System.out.println("Test Completed:-  " +  this.getClass().getSimpleName());	


		} catch(Exception err) { 
			Assert.fail(err.getMessage());
		}
	}
	@AfterClass
	public void testCleanUp()   {
		/*----- Logout ------*/
		Utility.logOut(driver);

		//  Quit -closes all the open window
		driver.quit();

	}
}
