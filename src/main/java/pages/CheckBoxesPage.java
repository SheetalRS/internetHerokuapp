package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckBoxesPage {
	WebDriver driver;
	By checkbox1=By.cssSelector("input:nth-child(1)");
	By checkbox2=By.cssSelector("input:nth-last-child(1)");
	
	public CheckBoxesPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public boolean clickCheckBox1(){
	
		driver.findElement(checkbox1).click();
		return driver.findElement(checkbox1).isSelected();
		
	}
	
	public boolean clickCheckBox2(){
		
		driver.findElement(checkbox2).click();
		return driver.findElement(checkbox2).isSelected();
		
	}
	

}
