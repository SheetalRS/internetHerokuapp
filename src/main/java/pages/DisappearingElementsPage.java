package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisappearingElementsPage {
	WebDriver driver;
	LandPage lp;
	public DisappearingElementsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Home =By.cssSelector("a[href='/']");
	By btnList=By.cssSelector("ul li");
	By gallery =By.cssSelector("ul li:nth-last-child(2)");
	
	
	
	public LandPage HomeBtnClick() {
		driver.findElement(Home).click();
		LandPage lp=new LandPage(driver);
		return lp;
	}
	
	public boolean disappearElm() {
		List<WebElement>listbefore=driver.findElements(btnList);
		System.out.println(listbefore.size());
		lp=HomeBtnClick();
		lp.Click_DisappearElm();
		List<WebElement>listafter=driver.findElements(btnList);
		System.out.println(listafter.size());
		if (listbefore.size()!=listafter.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean galleryIsDisplayed(){
		List<WebElement>listbefore=driver.findElements(btnList);
		if (listbefore.size()==5) {
			return driver.findElement(gallery).isDisplayed();
		} else {
			lp=HomeBtnClick();
			lp.Click_DisappearElm();
			return driver.findElement(gallery).isDisplayed();
		}
	}

}
