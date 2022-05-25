package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

import pages.HorizontalSliderPage;
import pages.LandPage;

public class HorizontalSliderTest extends Base{

	public static final Logger LOG=LogManager.getLogger(HorizontalSliderTest.class);
	public WebDriver driver;	
	public HorizontalSliderPage horizonsliderPg;
	
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		
		 
		
	}
	
	@Test
	public void checkScrollByKeys() {
		getUrl();
		LandPage lp=new LandPage(driver);
		horizonsliderPg=lp.ClickHorizontalSlider();
		Assert.assertEquals(horizonsliderPg.scrollByKeys(), "5");
		
		
	}
	@Test
	public void checkScrollByDrag() {
		getUrl();
		LandPage lp=new LandPage(driver);
		horizonsliderPg=lp.ClickHorizontalSlider();
		
		
		Assert.assertEquals(horizonsliderPg.ScrollByDrag(), "5");
		
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
