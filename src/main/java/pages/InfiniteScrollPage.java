package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.Base;

public class InfiniteScrollPage extends Base{
	WebDriver driver;
	JavascriptExecutor js;
	
	public By ElementalSelenium=By.xpath("//a[contains(text(),'Elemental Selenium')]");
	public InfiniteScrollPage(WebDriver driver) {
		this.driver=driver;
	}

	public void ScrolltoEnd(){
		WaitTime(driver,1200);
		WaitForPageLoad(driver,1200);
		this.js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1500)");
	}
}
