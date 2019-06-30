package com.opc.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opc.common.Login;
import com.opc.locators.CloudHomePage;
import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;

public class Utility {
//	public static WebDriver driver;
	public static String CONFIGFILEPATH;
	
	/**
	 * To be used for selecting SignInButton.
	 * Have to provide : Browser Name.
	 * @throws InterruptedException 
	 */
	public static void selectSignInButton(WebDriver driver) throws InterruptedException {
		 String brwsrstr = getBrowserName(driver);
//		 System.out.println("BrowserName  " + brwsrstr);
		 if (brwsrstr.equals("android") || brwsrstr.equals("iPhone") ) {
			   //driver.findElement(By.xpath(".//*[@id='navExpand']/img")).click();
			   driver.findElement(By.xpath(".//*[@class='signInLink']/a")).click();
			   Thread.sleep(10000);			   
			   Utility.scrollToElement(driver, By.xpath(".//*[@id='opcMobileNav']/li[4]/a/span"));
			   Thread.sleep(10000);

		   } else {
			   driver.findElement(CloudHomePage.SIGNIN_BUTTON).click();
			   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			   Thread.sleep(5000);
			   }
	}
	
	/**
	 * To be used for selecting Service.
	 * Have to provide : Service Name , like Java, Java2, Database, Database2 etc.
	 */
	public static void selectService(WebDriver driver, String serviceName) {
		  int rowCount= driver.findElements(By.xpath(".//*[@id='R419671259673428305']/div[2]/table/tbody/tr")).size();
		  System.out.println("Inside SelectService, Rowcount= "+rowCount);
		  int i =1;
		  
		  while (i<=rowCount){
			if (Utility.isElementPresent(driver, By.xpath(".//*[@id='R419671259673428305']/div[2]/table/tbody/tr["+i+"]/td[2]/h4/a"))){
			  
			  String service= driver.findElement(By.xpath(".//*[@id='R419671259673428305']/div[2]/table/tbody/tr["+i+"]/td[2]/h4/a")).getText();
		      System.out.println(i + ": ServiceName: "+ service);  
		  	  if (service.equalsIgnoreCase(serviceName)){
				  System.out.println("ServiceName to launch: "+ service);
				  driver.findElement(By.xpath(".//*[@id='R419671259673428305']/div[2]/table/tbody/tr["+i+"]/td[2]/h4/a")).click();  
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  break;
			  }else i++ ;
			 }	else i++ ;		  
		  }
	}
	

	/**
	 * To be used In Java Service Console for selecting an Application Name.
	 * Have to provide : Already Deployed Application Name , like app1 , app2 etc.
	 * @throws InterruptedException 
	 */
	public static void selectApplicationName(WebDriver driver1, String applicationName) throws InterruptedException {
		WebDriver driver = driver1;
		  int rowCount= driver.findElements(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr")).size();
		  System.out.println(rowCount);
		  int i =1;
		  
		  while (i<=rowCount){
			  System.out.println("rowCount  " + i);
			  String appName= driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).getText();
//			  System.out.println("appName  " + appName);
			  if (appName.equalsIgnoreCase(applicationName)){
				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).click();  
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  System.out.println("ApplicationName:  " + appName);
				  break;
			  } else i++ ;			  
		  }
	}
	
	/**
	 * To be used In Java Service Console for Deleting an Application Name.
	 * Have to provide : Already Deployed Application Name , like app1 , app2 etc.
	 * @throws InterruptedException 
	 */
	public static void deleteApplicationName(WebDriver driver1, String applicationName) throws InterruptedException {
		WebDriver driver = driver1;
		  int rowCount= driver.findElements(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr")).size();
		  System.out.println("rowCount: " + rowCount);
		  int i =1;
		  
		  while (i<=rowCount){
			  System.out.println("rowCount  " + i);
			  String appName= driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).getText();
//			  System.out.println("appName  " + appName);
			  if (appName.equalsIgnoreCase(applicationName)){  
//				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).click();  
				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]")).click(); 
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  System.out.println("ApplicationName  " + appName);
				  
					/* ----- Delete Application -----*/
				    Thread.sleep(5000);
					driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:ctb2::icon']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
					
					System.out.println("Deleted Window launched");  
					Thread.sleep(5000);
//					driver.findElement(By.xpath(".//*[@id='emT:sdk_cnf_yes_id']")).click();
					driver.findElement(By.xpath("//button[@id='emT:sdk_cnf_yes_id']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
//					System.out.println("Deleted Application");  
				  break;
			  } else i++ ;			  
		  }
	}
	
	
	/**
	 * To be used In Java Service Console for Start an Application Name.
	 * Have to provide : Already Deployed Application Name , like app1 , app2 etc.
	 * @throws InterruptedException 
	 */
	public static void startApplicationName(WebDriver driver1, String applicationName) throws InterruptedException {
		WebDriver driver = driver1;
		  int rowCount= driver.findElements(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr")).size();
		  System.out.println(rowCount);
		  int i =1;
		  
		  while (i<=rowCount){
			  System.out.println("rowCount  " + i);
			  String appName= driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).getText();
//			  System.out.println("appName  " + appName);
			  if (appName.equalsIgnoreCase(applicationName)){
//				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).click();  
				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]")).click();  
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  System.out.println("ApplicationName:  " + appName);
				  
					/* ----- Start Application -----*/
				    String brwsrstr = getBrowserName(driver);
				    System.out.println("BrowserName  " + brwsrstr);
				    if (brwsrstr.equals("android")){
				    	Thread.sleep(5000);               
					    driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:t1::eoi']")).click();
						driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
						Thread.sleep(5000); 
				    }
				    
					Thread.sleep(5000);               
				    driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:ctb4::icon']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	

				  break;
			  } else i++ ;			  
		  }
	}
	
	/**
	 * To be used In Java Service Console for Start an Application Name.
	 * Have to provide : Already Deployed Application Name , like app1 , app2 etc.
	 * @throws InterruptedException 
	 */
	public static void stopApplicationName(WebDriver driver1, String applicationName) throws InterruptedException {
		WebDriver driver = driver1;
		  int rowCount= driver.findElements(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr")).size();
		  System.out.println(rowCount);
		  int i =1;
		  
		  while (i<=rowCount){
			  System.out.println("rowCount  " + i);
			  String appName= driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).getText();
//			  System.out.println("appName  " + appName);
			  if (appName.equalsIgnoreCase(applicationName)){
//				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).click();  
				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]")).click();   
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  System.out.println("ApplicationName:  " + appName);
				  
					/* ----- Start Application -----*/
				    Thread.sleep(5000);               
				    driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:ctb6::icon']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
					
					Thread.sleep(5000);
//					driver.findElement(By.xpath(".//*[@id='emT:sdk_cnf_yes_id']")).click();
					driver.findElement(By.xpath("//button[@id='emT:sdk_cnf_yes_id']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  break;
			  } else i++ ;			  
		  }
	}
	
	/**
	 * To be used In Java Service Console for Start an Application Name.
	 * Have to provide : Already Deployed Application Name , like app1 , app2 etc.
	 * @throws InterruptedException 
	 */
	public static void runApplicationName(WebDriver driver1, String applicationName) throws InterruptedException {
		WebDriver driver = driver1;
		  int rowCount= driver.findElements(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr")).size();
		  System.out.println(rowCount);
		  int i =1;
		  
		  while (i<=rowCount){
			  System.out.println("rowCount  " + i);
			  String appName= driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).getText();
//			  System.out.println("appName  " + appName);
			  if (appName.equalsIgnoreCase(applicationName)){
//				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]/span")).click();  
				  driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable::db']/table/tbody/tr["+i+"]/td[2]/div/table/tbody/tr/td[1]")).click();  
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  System.out.println("ApplicationName:  " + appName);
				  System.out.println(".//*[@id='emT:appsRegion:0:pcl1:appsTable:"+(i-1)+":cl1::icon']");
					/* ----- Access Application -----*/
				    Thread.sleep(5000);               
				    driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable:"+(i-1)+":cl1::icon']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
					Thread.sleep(10000); 
					
					driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:urlt1:0:urlLk']")).click();
//					driver.findElement(By.xpath(".//*[@id='emT:appsRegion:0:pcl1:appsTable:0:urlt1:0:urlLk']")).click();
					driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
					Thread.sleep(10000);
					
				  break;
			  } else i++ ;			  
		  }
	}
	   
	/**
	 * To be used for knowing browser details.
	 * Usage: String brwsrstr = getBrowserName(driver);
	 */
	public static String getBrowserName(WebDriver driver) {
		 
	   Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	   String brsrName = caps.getBrowserName();
	   String browserVersion = caps.getVersion();
	   System.out.println("BrowserName: "+ brsrName +" | "+ "Version: " +browserVersion +" | "+ "Platform: "+ caps.getPlatform());
	return brsrName;
	}
	   
	/**
	 * To be used for taking screenshot.
	 * Have to provide image filename with full path to save file.
	 */
	public static void takeScreenShot(WebDriver driver, String imageFileName) throws IOException {
		WebDriver argDriver;
		if(driver.getClass().getName().equals("org.openqa.selenium.remote.RemoteWebDriver")){
			argDriver = new Augmenter().augment(driver);
		    //System.out.println("Inside if");
		} else {
			argDriver = driver;
		    //System.out.println("Inside else");
		}
		File scrshtFile = ((TakesScreenshot)argDriver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrshtFile, new File(imageFileName));
		}
	
	/**
	 * To be used for scrolling to defined element.
	 * Have to provide :  By object & driver instance
	 * @throws InterruptedException 
	 */
	public static void scrollToElement(WebDriver driver, By by) throws InterruptedException {
		   	   WebElement target = driver.findElement(by);
			   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
			   Thread.sleep(500); //don't remove sleep, needed here else this function will not work
			   target.click();
			   Thread.sleep(10000);  
	}
	
	/**
	 * Only for mobile browser 
	 * To be used to set  Screen Orientation.
	 * Have to provide : PORTRAIT / LANDSCAPE
	 * Example : Utility.setScreenOrientation(driver,"PORTRAIT");
	 */
	public static void setScreenOrientation(WebDriver driver, String Orientation)  {  
		   String screenOrient = Orientation;
		   if (screenOrient.equalsIgnoreCase("PORTRAIT")){
			   ((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
   			} else if (screenOrient.equalsIgnoreCase("LANDSCAPE")){
   				((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
   			}
	}
	
	/**
	 * Only for mobile browser 
	 * To be used to know current Screen Orientation.
	 * Example : String str = Utility.getScreenOrientation(driver);
	 */
	public static String getScreenOrientation(WebDriver driver)  {
//		  System.out.println(((Rotatable) driver).getOrientation());
		  ScreenOrientation scrnOri = ((Rotatable) driver).getOrientation();
		  String screenOrientation = scrnOri.value();
	return screenOrientation;
	}
	
	/**
	 * To be used to handle Alert
	 * Have to provide driver
	 */
	public static void handleAlert(WebDriver driver) {
	    try {
	    
	    	WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(ExpectedConditions.alertIsPresent());
	        System.out.println("Alert Present");
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (NoAlertPresentException e) {
	        System.out.println("NoAlertPresent");
	    }
	}
	
	/**
	 * To be used for close android emulator instance
	 * set bat file path 
	 */
	public static void  closeAndroidEmulator(){
		// set bat file path
		   try {
			 String path="cmd /c start d:\\SAFc\\batfiles\\closeAndroid.bat";
			 Runtime rn=Runtime.getRuntime();
			 Process pr=rn.exec(path);
			 Thread.sleep(120000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * To be used to get DB URL for 13.1
	 * Usage:
	 */
	public static String getUrl(WebDriver driver, By by) {
//		String URL = driver.findElement(By.cssSelector("div.mysHeader a")).getAttribute("href");
				
		String fetchURL = driver.findElement(by).getAttribute("href");
		System.out.println("URL : " + fetchURL );
	    
		String URL  = fetchURL.substring( 23, fetchURL.length( ) - 3 );
		System.out.println("URL : " + URL);
		return URL;	    
	 }
	
	
	/**
	 * To be used to get DB URL for 13.2
	 * Usage:  
	 */
	public static String getDBUrl(WebDriver driver, By by) {
//		String URL = driver.findElement(By.cssSelector("div.mysHeader a")).getAttribute("href");
		
		String fetchURL = driver.findElement(by).getAttribute("title");
		System.out.println("URL : " + fetchURL);
		return fetchURL;	  
  
	 }
	
	/**
	 * To be used to getTryitUrl
	 * Usage:  
	 */
	public static String getTryitUrl() {
		String tryItUrl = "";
		return tryItUrl;	  
  
	 }
	
	/**
	 * To be used for verify element is present.
	 * Have to provide By object
	 */
	public static boolean isElementPresent(WebDriver driver, By by) {
		 try {
	            driver.findElement(by);
		        return true;
		     } catch (NoSuchElementException e) {
	         return false;
	         }
	 }


/* ------------------------ 13.2 Utility functions ---------------------------- */

	/**  @ Deprecated
	 * To be used for selecting Platform Service for 13.2
	 * Have to provide : Service Name , like Java, Database etc.
	 * @throws InterruptedException 
	 */
	
	/* public static void selectPlatformService(WebDriver driver, String serviceName) throws InterruptedException {
	  driver.findElement(By.xpath(".//*[@id='pt1:header:h:btn-env']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);
	  
	  driver.findElement(By.xpath(".//*[@id='pt1:sections:env-lf-btn']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);
	  
	  if (serviceName.equalsIgnoreCase("Database")){
		  
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:env-APEX']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(10000);
  
	  }else if (serviceName.equalsIgnoreCase("Java")){
		  
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:env-JAVA']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(10000);
	  }else if (serviceName.equalsIgnoreCase("Messaging")){
		  
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:env-Messaging']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(10000);
	  }else if (serviceName.equalsIgnoreCase("Storage")){
		  
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:env-Storage']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(10000);
	  }
	
	  
	  driver.findElement(By.xpath(".//*[@id='pt1:sections:lv-db:0:dbsvc-row:cnIt1:col-item-link']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);
	 
}
*/

	/**
	 * To be used for navigating to 13.2 MyService Page.
	 * Have to provide By object
	 * @throws InterruptedException 
	 */
	public static void myServicePage(WebDriver driver) throws InterruptedException {
		 /* ----- Click on SingIn Button -----*/	 			   
		 driver.findElement(By.xpath(".//*[@class='menu-signin']/a")).click();
	     driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	     Thread.sleep(15000);
	
	     
	     /* ---------- Click on SignIN to MyServices  ---------- */	
		 String brwsrstr = getBrowserName(driver);
     	 System.out.println("BrowserName  " + brwsrstr);
		// System.out.println(driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute("value"));
		 if (brwsrstr.equals("android")) {
			// System.out.println(driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute("value"));
			 String MyServcieURL =  driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute("value"); 
//			 String MyServcieURL = "http://slc06kxi.us.oracle.com:7897/mycloud/faces/dashboard.jspx";
			 /* ----- Navigating to My Services Window -----*/
			 driver.navigate().to(MyServcieURL);
			 //driver.findElement(By.xpath("//*[@class='signinButtonContainer']/a")).click();
			 Thread.sleep(10000);
		   }else {
//			  driver.navigate().to("https://myservices.dc1.c9qaga.us.oracle.com/mycloud/faces/dashboard.jspx ");
			  driver.findElement(By.xpath("//*[@class='signin-button-container']/a")).click();
			  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			  Thread.sleep(5000);
		   /* ----- Navigating to My Services Window -----*/
		    Set allWindowHandles = driver.getWindowHandles();
		   int win = allWindowHandles.size();
		   System.out.println("no. of windows open  "  + win);
		   String window1 = (String) allWindowHandles.toArray()[1];
		   driver.switchTo().window(window1);	
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   Thread.sleep(10000);
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
   	       System.out.println("New windows PageTitle  "+ driver.getTitle());
		   driver.manage().window().maximize();
		   String CurrentPageURL = driver.getCurrentUrl();
		   BrowserType.handleIECertificate(driver, CurrentPageURL);
		   Thread.sleep(10000);
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);

	 }
	}
	  

	/**
	 * To be used for navigating to 13.2 MyAccountPage.
	 * Have to provide By object
	 * @throws InterruptedException 
	 */
	public static void myAccountPage(WebDriver driver) throws InterruptedException {
	
		/* ----- Click on SingIn Button -----*/	 			   
		driver.findElement(By.xpath(".//*[@class='menu-signin']/a/img")).click();
		driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		Thread.sleep(15000);
    
		  /* ---------- Click on SignIN to MyAccount  ---------- */	
		 String brwsrstr = getBrowserName(driver);
//		 System.out.println("BrowserName  " + brwsrstr);
		 if (brwsrstr.equals("android")) {
			 //System.out.println(driver.findElement(By.xpath("//a[contains (@href,'https://myaccount')]")).getAttribute("href"));
			  String MyAccountURL =  driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute("href"); 
			 //Giving direct utl
			 // String MyAccountURL =  "https://myaccount.c9qaga.us.oracle.com/mycloud/faces/dashboard.jspx";		
			 //String MyAccountURL =  "https://cloud2.c9edgga.oraclecorp.com/mycloud/faces/dashboard.jspx";			
			 /* ----- Navigating to My Account Window -----*/
			 driver.navigate().to(MyAccountURL);
			 Thread.sleep(10000);
		   }
		 else {
			 /* ---------- Click on SignIN to MyAccount  ---------- */	   
				//driver.findElement(By.xpath("//*[@class='signinButtonContainer']/a")).click();
				//driver.findElement(By.xpath("//a[contains (@href,'https://myaccount')]")).click();
		        //driver.findElement(By.xpath("//a[starts-with(@href,'https://myaccount')]"));
				 //String MyAccountURL =  "https://cloud2.c9edgga.oraclecorp.com/mycloud/faces/dashboard.jspx";			
				 /* ----- Navigating to My Account Window -----*/
//				 driver.navigate().to("https://myaccount.c9qaga.us.oracle.com/");
				 driver.findElement(By.partialLinkText("My Account")).click();
			     driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				 Thread.sleep(15000);
			   
			   /* ----- Navigating to My Account Window -----*/
				Set allWindowHandles = driver.getWindowHandles();
		       int win = allWindowHandles.size();
		 	   System.out.println("no. of windows open  "  + win);
		 	   String window1 = (String) allWindowHandles.toArray()[1];
//		 	   System.out.println("windows title  "  + (String) allWindowHandles.toArray()[1]);
		  	   driver.switchTo().window(window1);	
		       driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		       Thread.sleep(5000);
		       driver.manage().window().maximize();
		        System.out.println("New windows Pagetitle  "+ driver.getTitle());
		        driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			   String CurrentPageURL = driver.getCurrentUrl();
			   BrowserType.handleIECertificate(driver, CurrentPageURL);	   
			   Thread.sleep(15000);
	  
		   

 }
}

	/**
	 * To be used to add an user on Security Tab.
	 * Have to provide By object
	 * @throws InterruptedException 
	 */

	public static void adduser(WebDriver driver) throws InterruptedException {
		  /* ----------------------Click on securities tab------------------------*/    
		  driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-security']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(5000);
	
		  /*---------------------------------Click on Add-------------------------------*/
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:cbAdd']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(5000);  
		  
		  /*--------------------Enter all mandatory field details-----------------------*/
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it1::content']")).clear();
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it1::content']")).click();
		  Random randomGenerator=  new Random();
	      int randomInt = randomGenerator.nextInt(100);
	      System.out.println("Random Value : " +randomInt  );
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it1::content']")).sendKeys("a"+randomInt);
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it2::content']")).clear();
		  //driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it2::content']")).click();
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it2::content']")).sendKeys("a"+randomInt);
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it3::content']")).clear();
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:it3::content']")).sendKeys("a"+randomInt+"@gmail.com");
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:cb2']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(5000); 
			
		  String msg= driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:ot2']")).getText();
		  //String msg = driver.findElement(By.xpath(".//*[@class='x15j']")).getText();
		  System.out.println(msg);
	      msg.startsWith("The following user was added:");
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(1000); 
	      System.out.println("success"); 
}

	/**
	 * To be used for modifying the user on Security Tab.
	 * Have to provide By object
	 * @throws InterruptedException 
	 */

	public static void modify(WebDriver driver) throws InterruptedException {
	      /* -----------------Click on securities tab-----------------------*/
        
          driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-security']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  
		  /*-------------select any user-> menu-> modify---------------------*/
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:user-lv:0:cil1']")).click();
			  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(5000);  
		  
          /*--------------------click on modify-------------------------------*/
		  driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:editBtn']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		  Thread.sleep(5000); 

	  } 


	/**
	 * To be used for reset the password on Security Tab.
	 * Have to provide By object
	 * @throws InterruptedException 
	 */


	public static void resetpwd(WebDriver driver) throws InterruptedException {
		/*---------------- Click on Securities tab--------------------------*/
		driver.findElement(By.xpath(".//*[@id='pt1:header:h:bb-navbtns:bbmm-btn-security']")).click();
	    driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	    Thread.sleep(10000);
		  
		/*--------------------click on user-> menu---------------------------*/
		 driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:user-lv:0:cil1']")).click();
		  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	       Thread.sleep(15000);
		/*---------------------------------Click on reset------------------------*/
		driver.findElement(By.xpath(".//*[@id='pt1:sections:currentTabContents:resetBtn']")).click();
		driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		Thread.sleep(15000);  
		}   
	
	 public static void SelectSignintoMyservices(WebDriver driver) throws InterruptedException {
		 String brwsrstr = getBrowserName(driver);
//		 System.out.println("BrowserName  " + brwsrstr);
		 if (brwsrstr.equals("android") || brwsrstr.equals("iPhone") ) {
			   driver.findElement(By.xpath("//a[contains (@class,'cloudButton')]")).click();
			   Thread.sleep(20000);
			   String Url = driver.getCurrentUrl();
			   System.out.println("SIGN IN to myservuces PAGE URL:" + Url);
			   driver.get("https://myservices.dc1.c9qaga.us.oracle.com/mycloud/faces/dashboard.jspx");
			   Thread.sleep(15000);
			  // Utility.scrollToElement(driver, By.xpath(".//*[@id='opcMobileNav']/li[4]/a/span"));


		   } else {
			      driver.findElement(By.xpath("//a[contains (@class,'cloudButton')]")).click();
				  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
				  Thread.sleep(250000);
				  /* ----- Navigating to My Services Window -----*/
				   Set allWindowHandles = driver.getWindowHandles();
				   int win = allWindowHandles.size();
				   System.out.println("no. of windows open  "  + win);
				   String window1 = (String) allWindowHandles.toArray()[1]; 
				   driver.switchTo().window(window1);	
				   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS); 
				   Thread.sleep(10000);
			   }
	}
	
   
	 public static void SelectJSCmenu(WebDriver driver) throws InterruptedException {
		  
	     /* ---------- Click on SignIN to MyServices  ---------- */	
		 String brwsrstr = getBrowserName(driver);
//		 System.out.println("BrowserName  " + brwsrstr);
		// System.out.println(driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute("value"));
		// if (brwsrstr.equals("android")) {
			 
			 /*--Click Menu Icon link----*/
			// driver.findElement(By.xpath("//*[@class='signinButtonContainer']/a")).click();
			//driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			// Thread.sleep(5000);
			 
			 /*--Select Logout----------*/
			 driver.findElement(By.xpath(".//*[@id='emT:file_log_out']/div/table/tbody/tr/td[2]/a")).click();
			 driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			 Thread.sleep(5000);
			 
			// System.out.println(driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute(" "));
			 //String MyServcieURL =  driver.findElement(By.xpath(".//*[@class='signinDropDownLabel']/select/option[1]")).getAttribute("value"); 
			 String MyServcieURL = "https://clouddc.dc2.c9edgga.oraclecorp.com/mycloud/faces/dashboard.jspx";
			 /* ----- Navigating to My Services Window -----*/
			 driver.navigate().to(MyServcieURL);
			 //driver.findElement(By.xpath("//*[@class='signinButtonContainer']/a")).click();
			 Thread.sleep(10000);
		   //}else {
			 //driver.findElement(By.xpath("//a[contains (@class,'cloudButton')]")).click();
			// driver.findElement(By.xpath("//*[@class='signinButtonContainer']/a")).click();
			// driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			// Thread.sleep(5000);
			 
		  
	 }
	 
	 public static void waitForPageLoaded1(WebDriver driver) {

	     ExpectedCondition<Boolean> expectation = new
	ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	          System.out.println(((JavascriptExecutor)driver).executeScript("return document.readyState"));
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver,30);
	      try {
	              wait.until(expectation);
	      } catch(Throwable error) {
	              Assert.assertFalse(true,"Timeout waiting for Page Load Request to complete.");
	      }
	 } 

	 /**
		 * To be used for modifying the user on Security Tab.
		 * Have to provide By object
		 * @throws InterruptedException 
		 */
	 public static void handleIECertificate(WebDriver driver) throws InterruptedException {
		 String CurrentPageURL = driver.getCurrentUrl();
		 BrowserType.handleIECertificate(driver, CurrentPageURL);
		 driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
		 Thread.sleep(10000);
		 
		}
	 

		/**
	     * To be used for selecting list item [<ul><li>text</li><li>text</li></ul>]
	     * Have to provide By object including /ul/li
	     * Example :  Utility.selectList(driver, "Customers" , By.xpath(".//*[@class='offerNavBarLayout']/div/div/ul/li"));
	     */

	     public static void selectList(WebDriver driver, String listText, By by) throws InterruptedException {
	     Thread.sleep(5000);
	       List<WebElement> list = driver.findElements(by);
	     //  System.out.println("List Size:- " + list.size());

	       for(WebElement we : list) {
//	              System.out.println("List Text:- " + we.getText());
	              if(we.getText().contains(listText)){
	            	  if(we.getText().contains("Products & Services")){
	            		  driver.findElement(By.xpath("//a[@data-dropdown='offersMenu']")).click();
	            	  }else {
	            		  we.click(); 
	            	  }
	                    
	                    break;
	                }
	              
	          }
	     }
	            
		/**
	      * To be used for selecting list item [<ul><li>text</li><li>text</li></ul>]
	      * Have to provide By object including /ul/li
	      * Example :  Utility.selectList(driver, "Customers" , By.xpath(".//*[@class='offerNavBarLayout']/div/div/ul/li"));
	      */

	      public static void selectSideNavigation(WebDriver driver, String listText) throws InterruptedException {

	        List<WebElement> list = driver.findElements(By.xpath(".//*[@class='resourcesSideNav']/ul/li"));
	   //     System.out.println("List Size:- " + list.size());
	        int i =1;
	        
	        while (i<=list.size()){
				if (Utility.isElementPresent(driver, By.xpath(".//*[@class='resourcesSideNav']/ul/li["+i+"]/a"))){			  
				  String navoption= driver.findElement(By.xpath(".//*[@class='resourcesSideNav']/ul/li["+i+"]/a")).getText();
		//	      System.out.println(i + ": Option: "+ navoption);  
			      
			  	  if (listText.equalsIgnoreCase(navoption)){
		//			  System.out.println("Option to click: "+ navoption);
					  driver.findElement(By.xpath(".//*[@class='resourcesSideNav']/ul/li["+i+"]/a")).click();  
					  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
					  break;
				  }else i++ ;
				 }	else i++ ;		  
			  }
	      }


	      /**
			 * To be used for modifying the user on Security Tab.
			 * Have to provide By object
			 * @throws InterruptedException 
			 */
		 public static void javaConsolePage(WebDriver driver) throws InterruptedException {
			 if (Utility.isElementPresent(driver, By.xpath(".//*[@id='emT:pnlc3:svcsTbl:0:cl1::icon']"))){	
				  driver.findElement(By.xpath(".//*[@id='emT:pnlc3:svcsTbl:0:cl1::icon']")).click();
				  Thread.sleep(20000);
			  }else if (Utility.isElementPresent(driver, By.xpath(".//*[@id='emT:r1:0:saveAndCont']"))){	
				  driver.findElement(By.xpath(".//*[@id='emT:r1:0:hicon::content']")).click();
				  Thread.sleep(2000);
				  driver.findElement(By.xpath(".//*[@id='emT:r1:0:saveAndCont']")).click();
				  Thread.sleep(20000);
			  }
			 
			}
	      
	 /**
		 * To be used for logout from MY services & My Account 
		 * Have to provide By object
		 * @throws InterruptedException 
		 */
	 public static void logOut(WebDriver driver) {
		 
 	 driver.navigate().refresh();
 	 driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
 	 ((JavascriptExecutor) driver).executeScript("document.getElementById('pt1:header:h:logout').click();");
		 
 		 driver.manage().deleteAllCookies();
		}


/* ------------------------ 14.1 Utility functions ---------------------------- */

/**
 * To be used for selecting Platform Service for 14.1
 * Have to provide : Service Name, like Java, Database etc.
 * @throws InterruptedException 
 */

public static void selectPlatformService(WebDriver driver, String serviceName) throws InterruptedException {
//  driver.findElement(By.xpath(".//*[@id='pt1:header:h:btn-env']")).click();
//  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  Thread.sleep(15000);
  
  driver.findElement(By.xpath(".//*[@id='pt1:sections:env-lf-btn']")).click();
  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  Thread.sleep(20000);
  
  if (serviceName.equalsIgnoreCase("Database")){
	  Utility.scrollToElement(driver, By.xpath(".//*[@id='pt1:sections:paas-APEX']"));
//	  driver.findElement(By.xpath(".//*[@id='pt1:sections:paas-APEX']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);

  }else if (serviceName.equalsIgnoreCase("Java")){
	  
	  driver.findElement(By.xpath(".//*[@id='pt1:sections:paas-JAVA']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);
  }else if (serviceName.equalsIgnoreCase("Messaging")){
	  
	  driver.findElement(By.xpath(".//*[@id='pt1:sections:paas-Messaging']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);
  }else if (serviceName.equalsIgnoreCase("Storage")){
	  
	  driver.findElement(By.xpath(".//*[@id='pt1:sections:paas-Storage']")).click();
	  driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	  Thread.sleep(10000);
  }  
  
//  driver.findElement(By.xpath(".//*[@id='pt1:sections:lv-db:0:dbsvc-row:cnIt1:col-item-link']")).click();
  	driver.findElement(By.xpath(".//*[@id='pt1:sections:lv-db:0:cnIt1:col-item-link']")).click();
  	driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
  	Thread.sleep(10000);
 
}


/**
 * To be used for selectExistingSSHPublicKey [<ul><li>text</li><li>text</li></ul>]
 * Have to provide By object including /ul/li
 * Example :  Utility.selectExistingSSHPublicKey(driver, "automationTest_SSHPublicKey" , By.xpath(".//*[@id='pt1:sections:r222:3:sshKeys::leadUl']/li"));
 */

 public static void selectExistingSSHPublicKey(WebDriver driver, String listText, By by) throws InterruptedException {

   List<WebElement> list = driver.findElements(by);
 //  System.out.println("List Size:- " + list.size());

   for(WebElement we : list) {
//          System.out.println("List Text:- " + we.getText());
          if(we.getText().contains(listText)){
        	  if(we.getText().contains("Products & Services")){
        		  driver.findElement(By.xpath("//a[@menu_id='offer_menu']")).click();
        	  }else {
        		  we.click(); 
        	  }
                
                break;
            }
          
      }
 }
 
 public static void reLogin(WebDriver driver) throws InterruptedException {
 /* ----- Providing Login Credentials -----*/	
// Login.loginToMyService(driver, Config.USERID, Config.PASSWORD, Config.DOMAIN);
// driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
// driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
// Thread.sleep(10000);
 }
 
 public static void myServiceNewUI(WebDriver driver) throws InterruptedException {
 if ( Utility.isElementPresent(driver, By.xpath(".//*[@id='title-section']/a/span"))){
		 System.out.println("New MYServices UI");
		 String str = driver.findElement(By.xpath(".//*[@id='title-section']/a/span[@data-bind='text: txtLinkOriginalDashboard']")).getText();
		 System.out.println(str);
		 if (str.contains("Switch to original Dashboard")){  
			 driver.findElement(By.xpath(".//*[@id='title-section']/a/span[@data-bind='text: txtLinkOriginalDashboard']")).click();
			 Thread.sleep(10000);
		 }
	}
 }
 
}

