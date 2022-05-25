package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.DragAndDropPage;
import pages.LandPage;

public class DragDropPageTest extends Base{
	public static final Logger LOG=LogManager.getLogger(DragDropPageTest.class);
	WebDriver driver;
	public DragAndDropPage draganddroppg;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}
	
	@Test
	public void  verifydragDropElm() {
		getUrl();
		LandPage lp=new LandPage(driver);
		draganddroppg=lp.Click_DragAndDrop();
		
		Assert.assertEquals(draganddroppg.dragDropElm(), true);
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
