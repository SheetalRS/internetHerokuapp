package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

import pages.HoversPage;
import pages.LandPage;

public class HoversTest extends Base{

	public WebDriver driver;	
	String actual;
	public HoversPage hoversPg;
	@BeforeTest	
	public void driverSetup() {
		driver=getWebdriver();
		
		
		 
		
	}
	@Test
	public void verifyimageHover(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		hoversPg=lp.ClickHovers();
		actual=hoversPg.imageHover();
		String[] words=actual.split(",");
		SoftAssert sassert= new SoftAssert();
		for (int i = 0; i < words.length; i++) {
			if (i==0) {
				sassert.assertEquals(words[i], "name: user1");
			} else if(i==1){
				sassert.assertEquals(words[i], "name: user2");
			}else if(i==2){
				sassert.assertEquals(words[i], "name: user3");
			}
		}
		sassert.assertAll();
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
