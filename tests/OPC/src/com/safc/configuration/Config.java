package com.safc.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;












public class Config
{
  private static Properties properties = new Properties(); static  {
    try {
      String fileName = (new File(".")).getCanonicalPath();
      
      String OS = System.getProperty("os.name").toLowerCase();
      
      if (OS.contains("win")) {
        properties.load(new FileInputStream(String.valueOf(fileName) + "\\conf\\config.properties"));
      } else if (OS.contains("linux") || OS.contains("unix")) {
        properties.load(new FileInputStream("./conf/config.properties"));
      } else if (OS.contains("mac")) {
        properties.load(new FileInputStream(String.valueOf(fileName) + "/conf/config.properties"));





      
      }





    
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    } 

















    
    BROWSER_TYPE = getProperty("browser.type").trim();

    
    CHROME_DRIVER_PATH = getProperty("chrome.driver.path").trim();

    
    APP_URL = getProperty("app.url").trim();

    
    USERID = getProperty("userid").trim();
    PASSWORD = getProperty("password").trim();
    DOMAIN = getProperty("domain").trim();

    
    WAIT_FOR_SECONDS = Long.parseLong(getProperty("wait.for.seconds").trim());

    
    DATA_CENTER_NAME = getProperty("data.center.name").trim();


    
    ANDROID_LAUNCH_FLAG = Integer.parseInt(getProperty("android.launch.flag").trim());
  }
  
  public static File file;
  public static final String BROWSER_TYPE;
  public static final String CHROME_DRIVER_PATH;
  public static final String APP_URL;
  public static final String USERID;
  public static final String PASSWORD;
  public static final String DOMAIN;
  public static final long WAIT_FOR_SECONDS;
  public static final String DATA_CENTER_NAME;
  public static final int ANDROID_LAUNCH_FLAG;
  
  public Config(File locatorName) {
    file = locatorName;
    System.out.println(file);
  }
  
  public static String getProperty(String locatorName) { return properties.getProperty(locatorName); }
}
