package com.opc.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opc.util.Utility;
import com.safc.configuration.Config;

public class Login {
//	public static WebDriver driver;

	public static void loginToMyService(WebDriver driver1, String username, String password, String domain) throws InterruptedException  {
		WebDriver driver = driver1;
		isLoged(driver);
//		String iderntityDomainFiled= "tenantName";
		String iderntityDomainFiled= "tenantDisplayName";
		
//		System.out.println( driver.findElement(By.xpath(".//*[@class='signin_form']/div[1]/label")).getText());
		
		if(driver.findElement(By.xpath(".//*[@class='infoTextDiv']/label")).getText().contains("Enter your Identity Domain")){
			driver.findElement(By.xpath("//input[@id='tenantDisplayName']")).clear();
//			driver.findElement(By.xpath("//input[@id='tenantName']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='tenantDisplayName']")).sendKeys(domain);
//			driver.findElement(By.xpath("//input[@id='tenantName']")).clear();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='signin']")).click();
			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(10000);
			
			 /* ----- Providing Login Credentials -----*/	
			driver.findElement(By.xpath("//input[@id='username']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='password']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);					
			driver.findElement(By.xpath("//button[@id='signin']")).click();
//			driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			Thread.sleep(20000);
			
		}else{
		
	    /* ----- Providing Login Credentials -----*/	
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='tenantName']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='tenantName']")).sendKeys(domain);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(5000);
				
		driver.findElement(By.xpath("//input[@id='signin']")).click();
		driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	
//		Assert.assertEquals("My Services", driver.findElement(By.xpath("//header[@id='myServicesHeader']/h1")).getText());
		}
	}
	
	private static void isLoged(WebDriver driver1) {
		WebDriver driver = driver1;
		if (driver.getTitle().contains("My Services") || driver.getTitle().contains("My Account")){
			((JavascriptExecutor) driver).executeScript("document.getElementById('pt1:header:h:logout').click();");
		}		
	}

	public static void ssoLogin(WebDriver driver1, String ssousername, String ssopassword) throws InterruptedException {
		WebDriver driver = driver1;
		 isLoged(driver);
		 
		 String brwsrstr = Utility.getBrowserName(driver);
//		 System.out.println("BrowserName  " + brwsrstr);
		 if (brwsrstr.equals("android") || brwsrstr.equals("iPhone") ) {
			    driver.findElement(By.xpath("//input[@id='Mssousername']")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//input[@id='Mssousername']")).sendKeys(ssousername);
			    driver.findElement(By.xpath("//input[@id='Mssopassword']")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//input[@id='Mssopassword']")).sendKeys(ssopassword);
			    driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
			    driver.findElement(By.xpath(".//*[@class='MbuttonBG']")).click();
//			    driver.findElement(By.xpath("//a [@class='MbuttonLinkText' and @href='javascript:doLogin(document.MLoginForm);']")).click();
			    driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS); 
		 }else{
				
	    /* ----- Provide login credentials -----*/
	    driver.findElement(By.xpath("//input[@id='sso_username']")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='sso_username']")).sendKeys(ssousername);
	    driver.findElement(By.xpath("//input[@id='ssopassword']")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='ssopassword']")).sendKeys(ssopassword);
	    driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
//	    driver.findElement(By.xpath("//a [@class='buttonLinkText' and @href='javascript:doLogin(document.LoginForm);']")).click();
	    driver.findElement(By.xpath("//a [@class='submit_btn' and @href='javascript:doLogin(document.LoginForm);']")).click();
	    driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	}
	 }
	
	public static void loginToApex(WebDriver driver1, String userid, String pwd, String worksapce) throws InterruptedException  {
		WebDriver driver = driver1;
		       
	    /* ----- Providing Login Credentials -----*/	
		   driver.findElement(By.xpath(".//*[@id='F4550_P1_USERNAME']")).clear();
		   driver.findElement(By.xpath(".//*[@id='F4550_P1_USERNAME']")).sendKeys(userid);
		   driver.findElement(By.xpath(".//*[@id='F4550_P1_PASSWORD']")).clear();
		   driver.findElement(By.xpath(".//*[@id='F4550_P1_PASSWORD']")).sendKeys(pwd);			   
		   driver.findElement(By.xpath(".//*[@id='F4550_P1_COMPANY']")).clear();
		   driver.findElement(By.xpath(".//*[@id='F4550_P1_COMPANY']")).sendKeys(worksapce);	
		   driver.findElement(By.xpath(".//*[@id='B232005500580944564']")).click();
		   driver.manage().timeouts().implicitlyWait(Config.WAIT_FOR_SECONDS, TimeUnit.SECONDS);
	
		   
	}

}