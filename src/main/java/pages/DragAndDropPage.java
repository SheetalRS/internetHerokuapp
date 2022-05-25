package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
	WebDriver driver;
	public DragAndDropPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By  ElmA=By.cssSelector("#column-a");
	By  ElmAHeader=By.cssSelector("#column-a header");
	By  ElmB=By.cssSelector("#column-b");
	By  ElmBHeader=By.cssSelector("#column-b header");
	
	
	public boolean dragDropElm(){
		WebElement aElement=driver.findElement(ElmA);
		WebElement bElement=driver.findElement(ElmB);
		
		Actions action = new Actions(driver);
		
		//action.clickAndHold(aElement).moveToElement(bElement).release().build().perform();
		action.dragAndDrop(aElement, bElement).build().perform();
		String aHeader=driver.findElement(ElmAHeader).getText();
	
		//String bHeader=driver.findElement(ElmBHeader).getText();
		
		if (aHeader.equals("B")) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
