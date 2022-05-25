package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage {
	public WebDriver driver;
	public By AddElm=By.cssSelector("button[onclick='addElement()']");
	public By deleteElm=By.cssSelector("button[onclick='deleteElement()']");
	
	
	public AddRemoveElementsPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	public boolean addElement_isDisplayed() {
		return driver.findElement(AddElm).isDisplayed();
		 
		
	}
	public void AddElmClick(){
		driver.findElement(AddElm).click();
	}
	
	public boolean deleteElement_isDisplayed() {
		return driver.findElement(deleteElm).isDisplayed();
		 
		
	}
	
	public void deleteElmClick(){
		driver.findElement(deleteElm).click();
		
	}
	
}
