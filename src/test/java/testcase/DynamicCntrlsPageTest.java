package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.DynamicControlsPage;
import pages.LandPage;

public class DynamicCntrlsPageTest extends Base{
	public static final Logger LOG=LogManager.getLogger(DynamicCntrlsPageTest.class);
	public DynamicControlsPage dynamiccontrolspg;
		
		public WebDriver driver;
		@BeforeTest
		public void driverSetup() {
			this.driver=getWebdriver();
			
			 LOG.info("Landed on DynamicControlsPage ");
			 
			
		}
		
		
		@Test
		public void  Verifyclick_RemoveorAdd() {
			getUrl();
			LandPage lp=new LandPage(driver);
			dynamiccontrolspg=lp.ClickDynamicControls();
			//dynamiccontrolspg.click_Remove();
			Assert.assertTrue(dynamiccontrolspg.click_RemoveorAdd());
			
		}
		
		@Test
		public void  click_EnableDisable() {
			getUrl();
			LandPage lp=new LandPage(driver);
			dynamiccontrolspg=lp.ClickDynamicControls();
			
			Assert.assertFalse(dynamiccontrolspg.click_EnableDisable());
			
		}
		@AfterTest
		public void closeDriver() {
			driver.close();
		}
	

}
