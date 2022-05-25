package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class DynamicControlsPage extends Base{
	public WebDriver driver;

	By 	RemoveOrAdd=By.cssSelector("button[onclick*='swapCheckbox']");
	By 	Acheckbox=By.cssSelector("#checkbox");
	By 	message=By.cssSelector("p#message");
	By 	EnableDisable=By.cssSelector("button[onclick*='swapInput']");
	By 	Textbox=By.cssSelector("input[type='text']");
	
	public DynamicControlsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean click_RemoveorAdd(){
		WaitElmToBeClickable(driver,RemoveOrAdd,10);
		
		driver.findElement(RemoveOrAdd).click();
		
		WaitElmTobevisible(driver,message,10);
		boolean gonemsg=driver.findElement(message).isDisplayed();
		
		if (gonemsg) {
			driver.findElement(RemoveOrAdd).click();
			WaitElmTobevisible(driver,Acheckbox,10);
			return driver.findElement(Acheckbox).isDisplayed();
		} else {
			return false;
		}
		
	}
	

	

	public boolean click_EnableDisable(){
		WaitElmToBeClickable(driver,EnableDisable,10);
		driver.findElement(EnableDisable).click();

		WaitElmTobevisible(driver,message,10);
		boolean enabledmsg=driver.findElement(message).isDisplayed();
		System.out.println(enabledmsg);
		if (enabledmsg) {
			driver.findElement(Textbox).sendKeys("test");
			driver.findElement(EnableDisable).click();
			WaitElmTobeDisable(driver,Textbox,10);
			return driver.findElement(Textbox).isEnabled();
		} else {
			return true;
		}
		
		
	}

}
