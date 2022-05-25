package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class DynamicLoadingPage extends Base{
	WebDriver driver;
	public DynamicLoadingPage(WebDriver driver) {
		this.driver=driver;
	}
	  
	By Example1=By.cssSelector("a[href $='1']");
	By Example2=By.cssSelector("a[href $='2']");
	By startBtn=By.cssSelector("div#start button");
	By helloWorld=By.cssSelector("div#finish h4");
	
	public String click_Example1() {
		driver.findElement(Example1).click();;
		String currUrl=driver.getCurrentUrl();
		System.out.println(currUrl);
		driver.navigate().to(currUrl);
		String navcurrUrl=driver.getCurrentUrl();
		System.out.println(navcurrUrl);
		driver.findElement(startBtn).click();
		WaitElmTobevisible(driver,helloWorld,10);
		return driver.findElement(helloWorld).getText();
		
	}
	
	public String click_Example2() {
		driver.findElement(Example2).click();;
		String currUrl=driver.getCurrentUrl();
		System.out.println(currUrl);
		driver.navigate().to(currUrl);
		String navcurrUrl=driver.getCurrentUrl();
		System.out.println(navcurrUrl);
		driver.findElement(startBtn).click();
		WaitElmTobevisible(driver,helloWorld,10);
		return driver.findElement(helloWorld).getText();
		
	}
	
	

}
