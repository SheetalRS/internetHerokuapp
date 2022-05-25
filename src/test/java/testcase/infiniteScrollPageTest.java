package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.InfiniteScrollPage;
import pages.LandPage;

public class infiniteScrollPageTest extends Base{
	public WebDriver driver;	
	public InfiniteScrollPage infinitescrlpg;
	@BeforeTest	
	public void driverSetup() {
		driver=getWebdriver();
		
		
		 
		
	}
	
	@Test
	public void VerifyScrollTillEnd(){
		getUrl();
		LandPage lp= new LandPage(driver);
		infinitescrlpg=lp.ClickInfiniteScroll();
		
		
		infinitescrlpg.ScrolltoEnd();
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
