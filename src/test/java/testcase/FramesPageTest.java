package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

import pages.FramesPage;
import pages.LandPage;

public class FramesPageTest extends Base{
	
	public static final Logger LOG=LogManager.getLogger(FramesPageTest.class);
	public WebDriver driver;	
	public FramesPage framepg;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		
		
	}
	
	@Test
	public void verifyclick_nestedFrames() {
		getUrl();
		LandPage lp=new LandPage(driver);
		framepg=lp.ClickFrames();
		
		framepg.click_nestedFrames();

		
	}
	

	@Test
	public void verifyclick_iFrame() {
		getUrl();
		LandPage lp=new LandPage(driver);
		framepg=lp.ClickFrames();
		
		framepg.click_iFrame();

		
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}


}
