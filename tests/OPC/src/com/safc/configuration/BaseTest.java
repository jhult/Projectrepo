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

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseTest
{
	public BaseTest() {}
 // String operator = getOperator();
 // String SCREENSHOT_FOLDER = getScreenshotFolder();
  private final String SCREENSHOT_FORMAT = ".png";
  public WebDriver driver;
  public WebDriver driver1;
  String path1 = null;
  
//builds a new report using the html template 
  public ExtentHtmlReporter htmlReporter;
  
  public ExtentReports extent;
  //helps to generate the logs in test report.
  public ExtentTest test;
  
  @BeforeSuite(alwaysRun = true)
  public void setup() {
	  
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
      
      //initialize ExtentReports and attach the HtmlReporter
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
      String OS = System.getProperty("os.name").toLowerCase();
      //To add system or environment info by using the setSystemInfo method.
      extent.setSystemInfo("OS", OS);
      
      extent.setSystemInfo("Browser", Config.BROWSER_TYPE);
      
      //configuration items to change the look and feel
      //add content, manage tests etc
      htmlReporter.config().setChartVisibilityOnOpen(true);
      htmlReporter.config().setDocumentTitle("Extent Report Demo");
      htmlReporter.config().setReportName("Test Report");
      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
      htmlReporter.config().setTheme(Theme.STANDARD);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    //TestRunner runner = (TestRunner)context;
   // runner.addListener(context);
  }
  
  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) throws Exception {
	  
	  if(result.getStatus() == ITestResult.FAILURE) {
          test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
          test.fail(result.getThrowable());
      }
      else if(result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
      }
      else {
          test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
          test.skip(result.getThrowable());
      }
 //   Reporter.setCurrentTestResult(result);
  //  if (!result.isSuccess()) {
      this.path1 = takeScreenShot(this.driver, result.getMethod());

      
      Reporter.log("<a href=" + this.path1 + " target='_blank' >Screenshot</a>");
      Reporter.log("<img src=\"file:///" + this.path1 + "\" width=500 height=300" + "\" alt=\"\"/><br />");
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
    extent.flush();
    Reporter.log("<p>*-----Environment Used for Testing------ *<br>app url:-  " + Config.APP_URL + "<br>" + "userid:-   " + Config.USERID + "<br>" + "password:- " + Config.PASSWORD + "<br>" + "domain:-   " + Config.DOMAIN + "<br>" + "*--------------------------------------- *" + "</p>");
  }
}
