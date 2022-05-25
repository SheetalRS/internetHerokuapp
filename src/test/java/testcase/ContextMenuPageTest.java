package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.ContextMenuPage;
import pages.LandPage;

public class ContextMenuPageTest extends Base{
	
	public static final Logger LOG=LogManager.getLogger(ContextMenuPageTest.class);
	public ContextMenuPage contextmenupg;
	public WebDriver driver ;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}
	
	@Test
	public void verifycontextClickBox(){
		getUrl();
		LandPage lp=new LandPage(driver);
		contextmenupg=lp.Click_ContextMenu();
		
		String altmsg=contextmenupg.contextClickBox();
		Assert.assertEquals(altmsg, "You selected a context menu");
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
