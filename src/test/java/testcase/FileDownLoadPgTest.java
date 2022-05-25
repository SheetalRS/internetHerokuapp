package testcase;

import java.util.ArrayList;
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
import pages.ABTestPage;
import pages.FileDownloadPage;
import pages.LandPage;

public class FileDownLoadPgTest extends Base{

	public static final Logger LOG=LogManager.getLogger(FileDownLoadPgTest.class);
	public WebDriver driver;	
	public FileDownloadPage filedownloadpg;
	List<WebElement> fileslist;
	ArrayList<String> filesnotdownloaded= new ArrayList<String>() ;
	@BeforeTest
	public void driverSetup() {
		driver=getWebdriver();
		
		 LOG.info("Landed on FileDownLoadPgTest Page");
		 
		
	}
	
	
	public void verifydownloadFiles() {
		getUrl();
		LandPage lp=new LandPage(driver);
		filedownloadpg=lp.ClickFileDownload();
		fileslist=filedownloadpg.downloadFiles();
		
	}
	
	@Test()
	public void verifydownloadedFiles() {
		getUrl();
		LandPage lp=new LandPage(driver);
		filedownloadpg=lp.ClickFileDownload();
		fileslist=filedownloadpg.downloadFiles();
		
		filesnotdownloaded=	filedownloadpg.isFilesDownloaded(fileslist);
		Assert.assertEquals(filesnotdownloaded.size(), 0);
		
		
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
