package com.qa141.myaccount;

/* Test case to verify all the links that are present in the MY Account Page
 * Login to MyAccount
 * Verify Dashboard is current active page and verify Dashboard headerName.
 * Click on Applications Tab and verify Application page is displayed using headerName.
 * Click on Security and verify Security page displayed using headerName.
 * Click on Orders and verify Order page is displayed using headerName 
 * Click on Platform services and verify platform services page is displayed using headerName * 
 */

import java.util.Set;
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
import com.opc.locators.CloudHomePage;
import com.opc.util.Utility;
import com.safc.configuration.BaseTest;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;
import com.safc.configuration.DbConnection;



public class C9_MYA_02_VerifyAllLinks_Test extends BaseTest{
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
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);

			/*----- Verify Header on My Account Landing page  ------*/	      
			System.out.println("Header: -"+ driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText());     
			Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pt1:header:h:macct-app-name']")).getText().contains("My Account"), "My Account");

			/************-------Works with 14.1------------------------------**********************************/
			/*----- Verify Dashboard is current active page and Verify Dashboard headerName------*/	
			// Verify Dashboard is current active page	       
			Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-dashboard']")).isDisplayed());

			// Verify Dashboard headerName
			// System.out.println(driver.findElement(By.xpath(".//*[@id='pt1:sections:j_id_id1pc3']/span")).getText());
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pt1:sections:j_id_id1pc3']/span")).getText(), "Dashboard");

			//14.1.10 MATS env

			/*----- Verify Header Dashboard link ------*/

			System.out.println(driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-dashboard']/span")).getText());
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-dashboard']/span")).getText(), "Dashboard");

			/*----- Verify Header order link ------*/		     
			// driver.findElement(By.xpath(".//*[@id='pt1:header:h:btn-orderslist']")).click();	 
			//  driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			// Thread.sleep(5000);	       
			// System.out.println(driver.findElement(By.xpath(".//*[@id='pt1:sections:pgl']/span")).getText());     
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pt1:sections:pgl']/span")).getText(), "Orders");   

			//15.1.6 Xptah changes

			/*----- Verify Header order link ------*/		     
			driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-orderslist']")).click();	 
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(5000);	       
			System.out.println(driver.findElement(By.xpath(".//*[@id='pt1:sections:pgl']/span[2]")).getText());     
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pt1:sections:pgl']/span[2]")).getText(), "Orders");   



			/*----- Verify Header Security link ------*/			     
			driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-accountadmin']")).click();	
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(5000);	       
			System.out.println(driver.findElement(By.xpath(".//*[@id='pt1:sections:subtitle']")).getText());
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pt1:sections:subtitle']")).getText(), "Account Administrators");           



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
