package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class ABTestPage {

	public WebDriver driver;
	public By ABTestControl = By.cssSelector("div h3");

	public String getTextABTestControl() {
		return driver.findElement(ABTestControl).getText();
	}

	public ABTestPage(WebDriver driver) {
		this.driver = driver;
	}
}
