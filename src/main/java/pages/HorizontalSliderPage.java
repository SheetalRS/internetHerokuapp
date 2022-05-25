package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {
	WebDriver driver;
	By scrollbar=By.cssSelector("input[type='range']");
	By finalRange=By.cssSelector("span[id='range']");
	
	public HorizontalSliderPage(WebDriver driver) {
		this.driver=driver;
		
		
	}
	public void  clickScrollBar(){
		driver.findElement(scrollbar).click();
	}
	
	public String  getScrollText(){
		return driver.findElement(finalRange).getText();
	}
	
	public String scrollByKeys(){
		clickScrollBar();
		for (float i = 0; i < 5; i+=0.5) {
			try {
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return getScrollText();
	}
	
	public String ScrollByDrag(){
	
		Actions action=new Actions(driver);
		action.dragAndDropBy(driver.findElement(scrollbar), 60, 0).perform();
		
		return getScrollText();
	}

}
