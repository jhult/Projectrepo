package com.safc.configuration;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;










public class BrowserType
{
  @DataProvider(name = "browserType")
  public static Object[][] browserData() { return getBrowser(); }







  
  public static Object[][] getBrowser() {
    if (Config.BROWSER_TYPE.equalsIgnoreCase("iexplore"))
      return new Object[][] { { "iexplore" } }; 
    if (Config.BROWSER_TYPE.equalsIgnoreCase("firefox"))
      return new Object[][] { { "firefox" } }; 
    if (Config.BROWSER_TYPE.equalsIgnoreCase("chrome"))
      return new Object[][] { { "chrome" } }; 
    if (Config.BROWSER_TYPE.equalsIgnoreCase("android"))
      return new Object[][] { { "android" } }; 
    if (Config.BROWSER_TYPE.equalsIgnoreCase("ios"))
      return new Object[][] { { "ios" } }; 
    if (Config.BROWSER_TYPE.equalsIgnoreCase("all")) {
      return new Object[][] { { "iexplore" }, { "firefox" }, { "chrome" } };
    }
    
    System.out.println("Please configure browser (iexplore,firefox,chrome,android,ios) in config.properties file. ");
    return new Object[][] { {} };
  }



  
  public static DesiredCapabilities setProxy(String proxyAutoconfigUrl) {
    Proxy proxy = new Proxy();
    proxy.setProxyType(Proxy.ProxyType.PAC);
    proxy.setProxyAutoconfigUrl(proxyAutoconfigUrl);


    
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName(Config.BROWSER_TYPE);
    if (proxyAutoconfigUrl != null) {
      capabilities.setCapability("proxy", proxy);
    }
    
    return capabilities;
  }


  
  public static void handleIECertificate(WebDriver driver, String PageURL) {
    if (PageURL.equalsIgnoreCase(Config.APP_URL)) {
      driver.get(PageURL);
      driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
    } 
    
    String PageTitle = driver.getTitle();
    System.out.println("PageTitle:- " + PageTitle);
    
    if (PageTitle.contains("Certificate")) {
      driver.navigate().to("javascript:document.getElementById('overridelink').click()");
      
      if (isAlertPresent(driver)) {
        
        Alert alert = driver.switchTo().alert();
        
        System.out.println("Certificate Pop-up Message:- " + alert.getText());
        
        driver.switchTo().alert().accept();
        System.out.println("Certificate alert closed.");
      } 
      
      driver.manage().window().maximize();
    } 
  }

  
  public static boolean isAlertPresent(WebDriver driver) {
    try {
      driver.switchTo().alert();
      return true;
    }
    catch (NoAlertPresentException Ex) {
      return false;
    } 
  }
}
