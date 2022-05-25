package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.DisappearingElementsPage;
import pages.LandPage;

public class DisappearingElmPageTest extends Base{

	public static final Logger LOG=LogManager.getLogger(DisappearingElmPageTest.class);
	public DisappearingElementsPage disappearelmpg;
	public WebDriver driver;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}
	
	
	
	
	@Test
	public void verifydisappearElm(){
		getUrl();
		LandPage lp=new LandPage(driver);
		disappearelmpg =lp.Click_DisappearElm();
		boolean flag=disappearelmpg.galleryIsDisplayed();
		Assert.assertEquals(flag, true);
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
