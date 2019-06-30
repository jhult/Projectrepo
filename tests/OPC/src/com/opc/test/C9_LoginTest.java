package com.opc.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.safc.configuration.BaseTest;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;
import com.opc.common.Browser;
import com.opc.common.Login;
import com.opc.locators.CloudHomePage;
import com.opc.locators.CloudMyServicePage;
import com.opc.locators.CloudSelectSignInPage;
import com.opc.util.Utility;


public class C9_LoginTest extends BaseTest1{
//	WebDriver driver, driver1;
	Select select;
	   

     @Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	   public void test(String browserName) {
 
    	 try{  
		   System.out.println(browserName);
		   /*----- Select Browser type to run -----*/
		   driver = Browser.browserToRun(driver1, browserName);
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		
		   /*----- Launch C9 site -----*/
		   driver.get(Config.APP_URL); 
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		   
		   /*----- Click on sign in  -----*/
		   Utility.selectSignInButton(driver);
  	       driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  	       Thread.sleep(5000);
		   
		   /*----- Select data center from drop down list    -----*/
		   Select select = new Select(driver.findElement(By.xpath("//select[@id='P106_DATA_CENTER']")));
		   select.selectByVisibleText(Config.DATA_CENTER_NAME);
		   
		   driver.findElement(By.xpath("//a[@id='login_button']")).click();
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		   Thread.sleep(5000);
		   
		   /*----- Login to MyService    -----*/
	       Login.loginToMyService(driver, Config.USERID, Config.PASSWORD, Config.DOMAIN);
	       driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	       Thread.sleep(10000);
	       
	       Assert.assertEquals(driver.findElement(CloudMyServicePage.MYSERVICES_HEADER).getText(), "My Services");

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