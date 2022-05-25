package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

import pages.FormAuthentiCationPage;
import pages.LandPage;
import testData.TestData;

public class FormAuthPgTest extends Base{
	public static final Logger LOG=LogManager.getLogger(FormAuthPgTest.class);
	public WebDriver driver;	
	public FormAuthentiCationPage formAuthPg;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		
		 
		
	}
	@Test(dataProvider= "loginData",dataProviderClass=TestData.class)
	public void verifyLoginBtn(String userName,String password){
		getUrl();
		LandPage lp=new LandPage(driver);
		this.formAuthPg=lp.ClickFormAuthentication();
		 LOG.info("Landed on FormAuthPgTest Page");
		 formAuthPg.userNameSendData(userName);
		 formAuthPg.passwordSendData(password);
		 formAuthPg.loginBtnClick();
		 SoftAssert sassert=new SoftAssert();
		 if (formAuthPg.errorMsg_isDisplayed()) {
			 sassert.assertEquals(formAuthPg.errorMsg().substring(0,25),"Your username is invalid!");
		} else {
			sassert.assertTrue(true, "Login Successful");
		}
		 sassert.assertAll();
	}
	
	
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
