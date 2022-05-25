package testcase;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.AddRemoveElementsPage;
import pages.LandPage;

public class AddRemoveElmTest extends Base{
	public static final Logger LOG=LogManager.getLogger(AddRemoveElmTest.class);
	public WebDriver driver;	
	public AddRemoveElementsPage addremoveelepg;
	
	@BeforeTest
	public void driverSetup(){
		driver=getWebdriver();
		LandPage lp=new LandPage(driver);
		addremoveelepg=lp.Click_AddRemoveElements();
	}
	
	@Test
	public void verifyAddElmClick() {
		addremoveelepg.AddElmClick();
		Assert.assertEquals(addremoveelepg.deleteElement_isDisplayed(), true);
	}
	
	@Test
	public void verifydeleteElmClick() {
		
		addremoveelepg.AddElmClick();
		
		addremoveelepg.deleteElmClick();
		WaitElmToBeClickable(driver,addremoveelepg.deleteElm,100000);
		
		Assert.assertEquals(addremoveelepg.deleteElement_isDisplayed(), false);
		
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
		
	

}
