package testcase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import base.Base;
import pages.ABTestPage;
import pages.LandPage;

public class AbTestPageTest extends Base{
	public static final Logger LOG=LogManager.getLogger(AbTestPageTest.class);
	public WebDriver driver;	
	public ABTestPage abtestpage;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LandPage lp=new LandPage(driver);
		 abtestpage=lp.Click_ABTesting();
		 LOG.info("Landed on ABTest Page");
		 
		
	}
	
	@Test
	public void verifyABTestControlText() {
		Assert.assertEquals(abtestpage.getTextABTestControl(), "A/B Test Control");
		LOG.error("ABTestControl Text verified ");
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
