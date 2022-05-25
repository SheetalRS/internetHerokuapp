package testcase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import base.Base;
import pages.ABTestPage;
import pages.AddRemoveElementsPage;
import pages.BrokenImagesPage;
import pages.ChallengingDOMPage;
import pages.CheckBoxesPage;
import pages.ContextMenuPage;

import pages.DisappearingElementsPage;
import pages.DragAndDropPage;
import pages.LandPage;

public class LandPageTest extends Base{
	
	public static final Logger LOG=LogManager.getLogger(LandPageTest.class);
		
	
	public WebDriver driver;
	public ABTestPage abtestpage;
	public AddRemoveElementsPage addremoveelepg;
	public BrokenImagesPage brokenimgpg;
	public String url;
	public CheckBoxesPage chkboxpg;
	public ContextMenuPage contextmenupg;
	public DisappearingElementsPage disappearelmpg;
	public DragAndDropPage draganddroppg;
	public ChallengingDOMPage challengingdompg;
	
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		LOG.info("browser launched");
	}
	
	
	  
	  public void verifyABTestClick() { getUrl(); LandPage lp=new
	  LandPage(driver); abtestpage=lp.Click_ABTesting();
	  LOG.info("ABTest Clicked");
	  Assert.assertEquals(abtestpage.getTextABTestControl(), "A/B Test Control");
	  
	  }
	  
	  
	  public void verifyAddRemoveElmClick() { getUrl(); LandPage lp=new
	  LandPage(driver); addremoveelepg=lp.Click_AddRemoveElements();
	  LOG.info("AddRemoveElmClick");
	  Assert.assertEquals(addremoveelepg.addElement_isDisplayed(), true);
	  
	  
	  }
	 
	
	public void verifyBasiAuthClick() {
		getUrl();
		LandPage lp=new LandPage(driver);
		String userName="admin";
		String password="admin";
		
		String basicUrl="https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/basic_auth";
		
		driver.get(basicUrl);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void verifyBrokenImagesClick(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		brokenimgpg=lp.Click_BrokenImages();
		
	}
	
	public void verifyClick_CheckBoxes(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		chkboxpg=lp.Click_CheckBoxes();
		
	}
	

	public void verifyClick_ContextMenu(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		contextmenupg=lp.Click_ContextMenu();
		
	}
	
	public void verifyClick_DisappearElm(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		disappearelmpg=lp.Click_DisappearElm();
		
	}
	
	public void verifyClick_DragAndDrop(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		draganddroppg=lp.Click_DragAndDrop();
		
	}
	
	@Test
	public void verifyClick_ChallengingDOM(){
		
		getUrl();
		LandPage lp=new LandPage(driver);
		challengingdompg=lp.Click_ChallengingDom();
		Assert.assertEquals(challengingdompg.challengingDomtext_isDisplayed(), true);
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
