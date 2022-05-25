package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

import pages.FileUploadPage;
import pages.LandPage;
import testData.TestData;

public class FileUploadPageTest extends Base{

	public static final Logger LOG=LogManager.getLogger(FileUploadPageTest.class);
	public WebDriver driver;	
	Object[][] testData;
	
	public FileUploadPage fileuploadpg;
	
	@BeforeTest
	public void driverSetup() {
		this.driver=getWebdriver();
		
		 
		
	}
	
	//@Test(dataProvider= "fileUploaData")
	public void verifyuploadFile(String path,String filename) {
		getUrl();
		LandPage lp=new LandPage(driver);
		fileuploadpg=lp.ClickfileUpload();
		if (path==null || filename==null ) {
			Assert.assertNull(path);
		} else {
			Assert.assertEquals( fileuploadpg.uploadFile(path+filename), filename);
		}
		
		
		LOG.error("uploadFile  verified ");
		
	}
	@Test
	public void verifyuploadFileAutoIt() throws InterruptedException {
		getUrl();
		LandPage lp=new LandPage(driver);
		fileuploadpg=lp.ClickfileUpload();
		fileuploadpg.uploadFileAutoit();
	}
	@DataProvider
	public Object[][] fileUploaData(){
		
		Object[][] testData=TestData.getTestData("F:\\FinalFrameworks\\testngpro\\src\\test\\java\\testData\\herokuapp.xlsx", "FileUpload");
		return testData;
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
