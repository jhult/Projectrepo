package com.opc.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.opc.common.Browser;
import com.safc.configuration.BaseTest;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;
import com.safc.configuration.DbConnection;

public class DataDriven_Test extends BaseTest{
//	WebDriver driver, driver1;
	Select select;
	   

     @Test(dataProvider = "browserType", dataProviderClass = BrowserType.class)
	   public void test(String browserName) {
 
    	 try{
    		 
    	/* ----- Read and write using excel ----- */
    	 
    	 String user=DbConnection.readDataFromExcelFile("D:/SAFc/tests/OPC/data/TestData.xls", "Sheet1", 1, 0);
		 System.out.println(user);
		 
		 DbConnection.writeDataToExcelFile("D:/SAFc/tests/OPC/data/TestData.xls", "Sheet1", "valueToWrite", 10, 0);
		
		 String user1=DbConnection.readDataFromExcelFile("D:/SAFc/tests/OPC/data/TestData.xls", "Sheet1", 10, 0);
		 System.out.println(user1);
     
     
     } catch(Exception err) { 
    	 Assert.fail(err.getMessage());
     } 
    }
    	   @AfterClass
   	    public void testCleanUp()   {
     	  	    //  Quit -closes all the open windows
//    	      driver.quit();
   	    	
   	    //  closes the open android emulator	
//   	    	Utility.closeAndroidEmulator();
   	    }
   	 	   
   	 }	
		