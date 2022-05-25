package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.CheckBoxesPage;
import pages.LandPage;

public class CheckBoxesPageTest extends Base{
	public static final Logger LOG=LogManager.getLogger(CheckBoxesPageTest.class);
	public CheckBoxesPage chkboxpg;
	
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}
	
	@Test
	public void verifyclickCheckBox1(){
		getUrl();
		LandPage lp=new LandPage(driver);
		chkboxpg=lp.Click_CheckBoxes();
		
		Assert.assertEquals(chkboxpg.clickCheckBox1(), true);
		
	}
	
	@Test
	public void verifyclickCheckBox2(){
		getUrl();

		LandPage lp=new LandPage(driver);
		chkboxpg=lp.Click_CheckBoxes();
		
		Assert.assertEquals(chkboxpg.clickCheckBox2(), false);
		
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
