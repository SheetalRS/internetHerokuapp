package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengingDOMPage {
	public WebDriver driver;
	
	public ChallengingDOMPage(WebDriver driver) {
		this.driver=driver;

		
}
	List<WebElement>tableheaders;
	List<WebElement>rowlist;
	By challengingDomtext=By.cssSelector("h3");
	By challengingDombtns=By.cssSelector("div[class*='large-2 columns'] a");
	By tablesheaders=By.cssSelector("div[class='large-10 columns'] table tr th");
	By tablesrows=By.cssSelector("div[class='large-10 columns'] table tbody tr");
	
	public boolean challengingDomtext_isDisplayed() {
		return driver.findElement(challengingDomtext).isDisplayed();
	}
	
	public List<WebElement> challengingDombtns_Click(){
		List<WebElement>btnlist= driver.findElements(challengingDombtns);
		System.out.println(btnlist.size());
		return btnlist;
		
	}
	
	public void ButtonClick(int btnNumber){
		WebElement elm = null;
		List<WebElement>btnlist=challengingDombtns_Click();
		Iterator<WebElement>itr= btnlist.iterator() ;
		if (btnNumber>btnlist.size() ||btnNumber<1) {
			System.out.println("Please enter valid button Number");
		} else {
			for (int i = 0; i < btnNumber; i++) {
				 elm=itr.next();
			}
			elm.click();
		}
		
			
	}

	public List<WebElement> getAllTableHeasers() {
		
		return tableheaders= driver.findElements(tablesheaders);
		
	}
	
	public List<WebElement> getAllRows() {
		
		return rowlist= driver.findElements(tablesrows);
		
	}
	
	public void getElement(int colNum,int rowNum){
		
		List<WebElement> headers=getAllTableHeasers();
	
		List<WebElement> rows=getAllRows();
		Object[][] obj= new Object[rows.size()][headers.size()];
		System.out.println(obj.length);
		System.out.println(obj[0].length);
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < headers.size(); j++) {
				obj[i][j]=headers.get(j).getText();
				//System.out.print(obj[i][j]);
			}
			//System.out.println();
			
		}
		
		for (int i = 1; i < rows.size(); i++) {
			
			for (int j = 0; j < headers.size(); j++) {
				obj[i][j]=rows.get(j).getText();
				//System.out.print(obj[i][j]);
			}
		//	System.out.println();
		}
		
		for (int i = 0; i < obj.length; i++) {
			
			for (int j = 0; j < obj[0].length; j++) {
				System.out.println(i);
				System.out.println(j);
				System.out.print(obj[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	
}
