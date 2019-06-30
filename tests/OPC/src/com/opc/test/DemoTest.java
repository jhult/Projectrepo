package com.opc.test;

import java.util.concurrent.TimeUnit;

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

public class DemoTest extends BaseTest{
//	WebDriver driver, driver1;
	Select select;
	   

     @Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	   public void test(String browserName) {
 
    	 try{ System.out.println(browserName);
    	 /* ----- write your script within try area ----- */
    	 
     
     
     } catch(Exception err) { 
    	 Assert.fail(err.getMessage());
     } 
    }
    	   @AfterClass
   	    public void testCleanUp()   {
     	  	    //  Quit -closes all the open windows
    	      driver.quit();
   	    	

   	    }
   	 	   
   	 }	
