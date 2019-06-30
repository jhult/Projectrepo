package com.opc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.safc.configuration.BrowserType;
import com.safc.configuration.Config;

/**
 * @author ashish kumar
 *
 */
public class Browser {
//	public static WebDriver driver;
	public static int i = 1;
	public static String proxyUrl = "http://c9auto.us.oracle.com:8080/c9_routing.pac";
	
	
	public static WebDriver browserToRun(WebDriver driver1, String testOnBrowser) throws IOException, InterruptedException {
		WebDriver driver = driver1;
		
     		 /* ----- Setting up the browser to be used -----*/
		
		    if (testOnBrowser.equalsIgnoreCase("iexplore")){
		    	Browser.setIEDriverPath();	
		    	DesiredCapabilities capIE = BrowserType.setProxy(proxyUrl);		    	
		    	driver = new InternetExplorerDriver(capIE);
		    	driver.manage().window().maximize();
		    	BrowserType.handleIECertificate(driver, Config.APP_URL);
		    } else if (testOnBrowser.equalsIgnoreCase("firefox")){
//		    	driver = new FirefoxDriver();
		    	DesiredCapabilities cap = BrowserType.setProxy(proxyUrl);
		    	driver = new FirefoxDriver(cap);
		    	driver.manage().window().maximize();
		    }else if (testOnBrowser.equalsIgnoreCase("chrome")){
		    	Browser.setChromeDriverPath();
		    	//DesiredCapabilities cap = BrowserType.setProxy(proxyUrl);
				driver = new ChromeDriver();
				//driver.manage().window().maximize();
		    }
//		    window maximize function will not work with emulators
//		    driver.manage().window().maximize();

		    return driver;
	     
}
	
	
	public static void  setChromeDriverPath() throws IOException{
		// set chrome driver path
		String path = new File(".").getCanonicalPath();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tjaya\\eclipse-workspace\\lib\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", 	Config.CHROME_DRIVER_PATH);
		String fileName= path+"\\lib\\chromedriver.exe";
    	//System.setProperty("webdriver.chrome.driver", fileName);
    	
		
	}
	
	public static void setIEDriverPath() throws IOException{
		//  set IE driver path
			String path = new File(".").getCanonicalPath();
			String fileName= path+"\\lib\\IEDriverServer.exe";
	    	System.setProperty("webdriver.ie.driver", fileName);
	    	
//	    	DesiredCapabilities capabilities1 = DesiredCapabilities.internetExplorer();	    	
//	    	capabilities1.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
//	    	capabilities1.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
//	    	capabilities1.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//	    	capabilities1.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);	
	    	
//	    	return capabilities1;
		
	}
	
	/**
	 * To be used for launch grid instance
	 * set bat file path & give Thread.sleep time in this function more than total timeout given on launch bat file, 
	 * otherwise test will start execution before even env is fully up and hence test will fail.
	 * @throws InterruptedException 
	 */
		
				
				}
