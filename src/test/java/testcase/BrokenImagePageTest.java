package testcase;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.BrokenImagesPage;
import pages.LandPage;

public class BrokenImagePageTest extends Base{
	public static final Logger LOG=LogManager.getLogger(BrokenImagePageTest.class);
	WebDriver driver;
	public BrokenImagesPage brokenimgpg;
	@BeforeTest
	public void driverSetup(){
		driver=getWebdriver();
		LandPage lp=new LandPage(driver);
		brokenimgpg=lp.Click_BrokenImages();
	}
	
	@Test
	public void verifyBrokenImages(){
		ArrayList<String>brokenlinks=brokenimgpg.brokenImagescheck();
		System.out.println("Number of broken Links "+brokenlinks.size());
		for (String string : brokenlinks) {
			System.out.println(string);
		}
		Assert.assertEquals(brokenlinks.size(), 0);
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
