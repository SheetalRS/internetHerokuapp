package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

import pages.DynamicLoadingPage;
import pages.LandPage;

public class DynamicLoadingPgTest extends Base{
	public static final Logger LOG=LogManager.getLogger(DynamicLoadingPgTest.class);
	public DynamicLoadingPage dynaloadpg;
		
	public WebDriver driver;
	@BeforeTest
	public void driverSetup() {
		this.driver=getWebdriver();
		
		 LOG.info("Landed on DynamicControlsPage ");
		 
		
	}
	
	
	@Test
	public void  Verifyclick_Example1() {
		getUrl();
		LandPage lp=new LandPage(driver);
		dynaloadpg=lp.ClickDynamicLoading();
		
		Assert.assertEquals(dynaloadpg.click_Example1(), "Hello World!");
		
	}
	
	@Test
	public void  Verifyclick_Example2() {
		getUrl();
		LandPage lp=new LandPage(driver);
		dynaloadpg=lp.ClickDynamicLoading();
		
		Assert.assertEquals(dynaloadpg.click_Example2(), "Hello World!");
		
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
