package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
	WebDriver driver;
	
	By Option1=By.cssSelector("select[id=dropdown] option:nth-child(2)");
	By Option2=By.cssSelector("select[id=dropdown] option:nth-child(3)");
	By selectdrpdwn=By.cssSelector("#dropdown");
	public DropdownPage(WebDriver driver) {
		this.driver= driver;
	}

	public boolean selectDropdown(){
		Select select= new Select(driver.findElement(selectdrpdwn));
		select.selectByValue("1");
		String opt1attr= driver.findElement(Option1).getAttribute("selected");
		String opt2attr=driver.findElement(Option2).getAttribute("selected");
		System.out.println(opt1attr);
		System.out.println(opt2attr);
		if (opt1attr.equals("true")) {
			return true;
		} else {
			return false;
		}
		
	}
}
