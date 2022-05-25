package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
	WebDriver driver;
	String Name;
	String actual;
	public HoversPage(WebDriver driver) {
		this. driver=driver;
	}
	By figures=By.cssSelector("div[class='figure'] img");
	By user1Name=By.xpath("//a[contains(@href,'1')]/preceding-sibling::h5");
	By user1=By.xpath("//h5[text()='name: user1']/following-sibling::a");
	By user2Name=By.xpath("//a[contains(@href,'2')]/preceding-sibling::h5");
	By user2=By.xpath("//h5[text()='name: user2']/following-sibling::a");
	By user3Name=By.xpath("//a[contains(@href,'3')]/preceding-sibling::h5");
	By user3=By.xpath("//h5[text()='name: user3']/following-sibling::a");
	By viewProfile=By.cssSelector("div[class='figcaption'] a");
	
	public String imageHover(){
		List<WebElement>figuresList =driver.findElements(figures);
		Iterator<WebElement>itr=figuresList.iterator();
		int count=1;
		
		while (itr.hasNext()&& count<4) {
			
			Actions action = new Actions(driver);
			action.moveToElement(itr.next()).perform();;
			if (count==1) {
				this.Name= driver.findElement(user1Name).getText();
			}else if(count==2) {
				this.Name= driver.findElement(user2Name).getText();
			}else if(count==3) {
				this.Name= driver.findElement(user3Name).getText();
			}
			count++;
			if (actual==null) {
				actual=Name;
			} else {
				actual=actual+","+Name;
			}
			
			
		}
		System.out.println(actual);
		return actual;
		
	}
	
	
}
