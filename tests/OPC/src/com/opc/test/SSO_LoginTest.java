package com.opc.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.opc.common.Browser;
import com.opc.common.Login;
import com.opc.locators.CloudHomePage;
import com.opc.locators.CloudMyServicePage;
import com.opc.locators.CloudSelectSignInPage;
import com.opc.util.Utility;
import com.safc.configuration.BaseTest;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;
import com.safc.configuration.DbConnection;

public class SSO_LoginTest extends BaseTest{
//	WebDriver driver, driver1;
	Select select;
	
     @Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	   public void test(String browserName) {
 
    	 try{ 
    		 
    	   String ssopassword = DbConnection.readDataFromExcelFile("D:/SAFc/tests/OPC/data/TestData.xls", "Sheet1", 1, 4)	; 
      	   
      	   System.out.println(browserName);
  		   driver = Browser.browserToRun(driver1, browserName);
  		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  			  
  		   driver.get(Config.APP_URL); 
  		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  		   Thread.sleep(5000);
  		   
  		   /* ----- Click on SingIn Button -----*/	 			   
    	   Utility.selectSignInButton(driver);
    	   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
    	   Thread.sleep(5000);
    	       
  		   Select select = new Select(driver.findElement(CloudSelectSignInPage.DATACENTER_DROPDOWNlIST));
  		   select.selectByVisibleText(Config.DATA_CENTER_NAME);
  		   
//  	   driver.findElement(CloudSelectSignInPage.SIGNINTO_MYACCOUNT_BUTTON).click();
  		   
  		   Utility.scrollToElement(driver, By.xpath(".//*[@id='B2211625422946433']"));	  
  		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  		   Thread.sleep(5000);
  		   
  	       Login.ssoLogin(driver, "ashish.d.kumar@oracle.com", ssopassword);
  	       driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  	       Thread.sleep(5000);
  	       
  	       /*----- Verify Header on My Account Landing page  ------*/
  	       Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='myServicesHeader']/h1")).getText(), "My Account");
  	       driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
   
    	 } catch(Exception err) { 
    	 Assert.fail(err.getMessage());
     } 
    }
	    @AfterClass
	    public void testCleanUp()   {
	  	    //  Quit -closes all the open windows
//	      driver.quit();
	    	
	    //  closes the open android emulator	
//	    	Utility.closeAndroidEmulator();
	    }
	 	   
	 }	