package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.Base;

public class FileUploadPage extends Base{
	WebDriver driver;
	
	public FileUploadPage(WebDriver driver) {
		this.driver=driver;
	}

	By chooseFile=By.cssSelector("#file-upload");
	By upload=By.cssSelector("#file-submit");
	By Uploadedfilename=By.cssSelector("div#uploaded-files");
	By dragDropArea=By.cssSelector("#drag-drop-upload");
	By dragdropfilename=By.cssSelector(".dz-filename span");
	
	public String uploadFile(String path){
		
		driver.findElement(chooseFile).sendKeys(path);
		/*
		 * WaitTime(driver,360); try {
		 * Runtime.getRuntime().exec("F:\\AutoItFileUpload\\samplepdfupload.exe"); }
		 * catch (IOException e) { System.out.println("AutoIt Exe Error!");
		 * System.out.println(e.getMessage());
		 * 
		 * }
		 */
		 driver.findElement(upload).click();
		
		
		WaitElmTobevisible(driver,Uploadedfilename,60);
	    return driver.findElement(Uploadedfilename).getText();
		
		
	}
	public void uploadFileAutoit() throws InterruptedException {
		
		driver.findElement(dragDropArea).click();
		Thread.sleep(5000); 
		try {
			Runtime.getRuntime().exec("F:\\AutoItFileUpload\\samplepdfupload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		Thread.sleep(5000);
		
		
	}
}
