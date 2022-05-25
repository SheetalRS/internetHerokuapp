package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthentiCationPage {
	WebDriver driver;
	public FormAuthentiCationPage(WebDriver driver) {
		this.driver=driver;
	}

	By userName= By.cssSelector("#username");

	By password= By.cssSelector("#password");
	
	By loginBtn=By.cssSelector("button[type='submit']");
	
	By errorMsg= By.cssSelector("#flash");
	
	
	public void userNameSendData(String userNameData){
		driver.findElement(userName).sendKeys(userNameData);
	}
	
	public void passwordSendData(String passwordData){
		driver.findElement(password).sendKeys(passwordData);
	}
	
	public void loginBtnClick(){
		driver.findElement(loginBtn).click();
	}
	
	public boolean errorMsg_isDisplayed(){
		return driver.findElement(errorMsg).isDisplayed();
	}
	public String errorMsg(){
		return driver.findElement(errorMsg).getText();
	}
	
}
