package com.opc.locators;
/**
 * @author ashish
 * Use this file to keep all common locators used across the applications
 * How to use example: driver.findElement(UILocators.SIGNIN_BUTTON);
 */
import org.openqa.selenium.By;

public class UILocators {
	
	public static final By SIGNIN_BUTTON = By.xpath("//ul[@id='opcFullNav']/li[4]/a/span");
	
	

}
