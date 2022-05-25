package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
	WebDriver driver;
	public FramesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By nestedFrames= By.cssSelector("a[href*='nested_frames']");
	By nestedFrameBody= By.cssSelector("body");
	By iFrame= By.cssSelector("a[href*='iframe']");
	
	public void click_nestedFrames(){
		driver.findElement(nestedFrames).click();
		driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(nestedFrameBody).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(nestedFrameBody).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		System.out.println(driver.findElement(nestedFrameBody).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-bottom");
		System.out.println(driver.findElement(nestedFrameBody).getText());
		
	}
	
	public void click_iFrame(){
		driver.findElement(iFrame).click();
	}
	
}
