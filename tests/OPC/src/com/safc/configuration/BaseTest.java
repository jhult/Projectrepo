package com.safc.configuration;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;






public class BaseTest
{
	public BaseTest() {}
 // String operator = getOperator();
 // String SCREENSHOT_FOLDER = getScreenshotFolder();
  private final String SCREENSHOT_FORMAT = ".png";
  public WebDriver driver;
  public WebDriver driver1;
  String path1 = null;
  
  @BeforeSuite(alwaysRun = true)
  public void setup() {
    //TestRunner runner = (TestRunner)context;
    //runner.addListener(context);
  }
  
  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) throws Exception {
    Reporter.setCurrentTestResult(result);
    if (!result.isSuccess()) {
      this.path1 = takeScreenShot(this.driver, result.getMethod());

      
      Reporter.log("<a href=" + this.path1 + " target='_blank' >Screenshot</a>");
      Reporter.log("<img src=\"file:///" + this.path1 + "\" width=500 height=300" + "\" alt=\"\"/><br />");
    } 
  }



  
  public String takeScreenShot(WebDriver driver2, ITestNGMethod testMethod) throws Exception {
    String path = null;
    try {
      WebDriver augmentedDriver;
      if (driver2.getClass().getName().equals("org.openqa.selenium.remote.RemoteWebDriver")) {
        augmentedDriver = (new Augmenter()).augment(driver2);
      } else {
        augmentedDriver = driver2;
      } 
      
      File screenshot = (File)((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
      String nameScreenshot = String.valueOf(testMethod.getTestClass().getRealClass().getSimpleName()) + "_" + testMethod.getMethodName();
      
      path = getPath(nameScreenshot);
      System.out.println("Screenshot path " + path);
      FileHandler.copy(screenshot, new File(path));
      Reporter.log("<a href=" + path + " target='_blank' >" + getFileName(nameScreenshot) + "</a>");
    } catch (Exception e) {
      e.printStackTrace();
      Reporter.log("Couldn't create screenshot ");
      Reporter.log(e.getMessage());
    }  return path;
  }
  
  private String getFolderName() throws IOException {
    DateFormat dtFormat = new SimpleDateFormat("MM-dd-yyyy");
    Date date = new Date();
    
    return String.valueOf(dtFormat.format(date)) ;
  }
  private String getFileName(String nameTest) throws IOException {
    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
    Date date = new Date();
    return String.valueOf(dateFormat.format(date)) + "_" + nameTest + ".png";
  }
  
  private String getPath(String nameTest) throws IOException {
    File directory = new File(".");

    
    return String.valueOf(directory.getCanonicalPath()) + getScreenshotFolder() + getFolderName() + getFileName(nameTest);
  }



  
  public static String getOperator() throws IOException {
    String OS = System.getProperty("os.name").toLowerCase();
    String operator1 = "";
    
    if (OS.contains("win")) {
      operator1 = "\\";
    }
    else if (OS.contains("linux") || OS.contains("unix")) {
      operator1 = "/";
    }
    else if (OS.contains("mac")) {
      operator1 = "/";
    } 
    return operator1;
  }
  
  public static String getScreenshotFolder() throws IOException {
    String OS = System.getProperty("os.name").toLowerCase();
    String str = "";
    String operator = "";
    
    if (OS.contains("win")) {
      operator = "\\";
      str = String.valueOf(operator) + "test-output" + operator + "screenShots" + operator;
    }
    else if (OS.contains("linux") || OS.contains("unix")) {
      operator = "/";
      str = "test-output" + operator + "screenShots" + operator;
    }
    else if (OS.contains("mac")) {
      operator = "/";
      str = "test-output" + operator + "screenShots" + operator;
    } 
    return str;
  }
  
  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    System.out.println("Inside tearDown");
    Reporter.log("<p>*-----Environment Used for Testing------ *<br>app url:-  " + Config.APP_URL + "<br>" + "userid:-   " + Config.USERID + "<br>" + "password:- " + Config.PASSWORD + "<br>" + "domain:-   " + Config.DOMAIN + "<br>" + "*--------------------------------------- *" + "</p>");
  }
}
