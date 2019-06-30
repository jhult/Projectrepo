package com.opc.test;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class AssociateDb extends BaseTest{
//	WebDriver driver, driver1;
	Select select;
	   

     @Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	   public void test(String browserName) {
 
    	 try{ 
    		 System.out.println("Executing TestCase:-  " +  this.getClass().getSimpleName());	 
    		 
   		  driver = Browser.browserToRun(driver1, browserName);
   			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
   			 
   			
   			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
      		 
   			capabilities.setBrowserName("firefox");
   			
   			capabilities.setPlatform(Platform.LINUX);
   	 
   			RemoteWebDriver driver = new RemoteWebDriver(new URL(
   					"http://10.242.88.81:5555/wd/hub"), capabilities);

   			
   		driver.get(Config.APP_URL); 
   		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
   		  
   		  
   		 /* ----- Login to My service -----*/
   		  Login.loginToMyService(driver, Config.USERID, Config.PASSWORD, Config.DOMAIN);
   		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   		   
   		  
   	     /*----- Verify Header on My services page  ------*/
   	 // System.out.println(driver.findElement(By.xpath(".//*[@id='pt1:header:h:msvc-app-name']")).getText());
   	  Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pt1:header:h:msvc-app-name']")).getText().contains("My Services"), "My Services");
      
   	  
   		
   	  /* ----- Navigating to Service -----*/	
  	driver.navigate().refresh();
		  Utility.selectPlatformService(driver, "java");
//      Utility.selectAssociateDB(driver);
   		
    	
    	
     } catch(Exception err) { 
    	 Assert.fail(err.getMessage());
     } 
    }
    	   @AfterClass
   	    public void testCleanUp()   {
     	  	    //  Quit -closes all the open windows
    	    //  driver.quit();
   	    	

   	    }
   	 	   
   	 }	
