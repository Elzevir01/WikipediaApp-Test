package com.wikipediafoundation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.WebDriver;

import driver.BrowserFactory;
import driver.DriverFactory;
import pageModel.WikipediaAppBase;

public class WikipediaAppTest {
	WebDriver driver;
	BrowserFactory bf = new BrowserFactory();
	WikipediaAppBase wb = new WikipediaAppBase();
	
  @Test
  public void f() {
	  wb.tapSaltar();
	  
  }
  
  @BeforeTest
  @Parameters({"browser", "nodeUrl"})
  public void SetUp(String nodeUrl) {
		try {
			bf = new BrowserFactory();
			DriverFactory.getInstance().setDriver(bf.setDriver(nodeUrl));
			driver = DriverFactory.getInstance().getDriver();
			}catch(Exception exc){
//				Log.error("Causa : "+exc.getCause());
//				Log.error("Mensaje : "+exc.getMessage());
				exc.printStackTrace();
			}
		bf.installApp("Wikipedia_2.7.50508-r-2024-11-06_APKPure");
	}
  
  @AfterTest
  public void TearDown() {
	  bf.removeDriver();
	}

}
