package testcase;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.ChallengingDOMPage;
import pages.LandPage;

public class ChallengingDOMTest extends Base{
	
	public static Logger LOG=LogManager.getLogger(ChallengingDOMTest.class);
	WebDriver driver;
	public ChallengingDOMPage challengingdompg;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}

	public void verifyButtonClick(){
		getUrl();
		LandPage lp=new LandPage(driver);
		challengingdompg=lp.Click_ChallengingDom();
		challengingdompg.ButtonClick(3);
	 
	}

	public void verifygetTableHeasers(){
		getUrl();
		LandPage lp=new LandPage(driver);
		challengingdompg=lp.Click_ChallengingDom();
		List<WebElement> headers=challengingdompg.getAllTableHeasers();
	}
	
	public void verifygetTableRows(){
		getUrl();
		LandPage lp=new LandPage(driver);
		challengingdompg=lp.Click_ChallengingDom();
		List<WebElement> rows=challengingdompg.getAllRows();
		Assert.assertEquals(10, rows.size());
	}
	
	public void verifygetElement(){
		getUrl();
		LandPage lp=new LandPage(driver);
		challengingdompg=lp.Click_ChallengingDom();
		challengingdompg.getElement(1, 1);
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
