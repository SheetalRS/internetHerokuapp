package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.DropdownPage;
import pages.LandPage;

public class DropDownTest extends Base{
	WebDriver driver;
	DropdownPage dropdown;
	public static final Logger LOG=LogManager.getLogger(DropDownTest.class);
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}
	@Test
	public void  veriySelectDropdown(){
		getUrl();
		LandPage lp=new LandPage(driver);
		dropdown=lp.Click_Dropdown();
		Assert.assertTrue(dropdown.selectDropdown());
		
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
