package com.safc.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class Locators
{
  private static final Properties properties = new Properties(); static  {
    try {
      String fileName = (new File(".")).getCanonicalPath();
      properties.load(new FileInputStream(String.valueOf(fileName) + "\\conf\\locators.properties"));
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }

  
  public static String getProperty(String locatorName) { return properties.getProperty(locatorName); }
}
