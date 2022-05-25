package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base;

public class ContextMenuPage extends Base{
	WebDriver driver;
	
	public ContextMenuPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By box=By.cssSelector("#hot-spot");
	
	public String contextClickBox(){
		WebElement boxElm=driver.findElement(box);
		Actions action = new Actions(driver);
		
		action.contextClick(boxElm).release().perform();
		WaitTime(driver,10000);
		Alert alert= driver.switchTo().alert();
		String altmsg=alert.getText();
		System.out.println(altmsg);
		alert.accept();
		return altmsg;
	}
	
			
}
