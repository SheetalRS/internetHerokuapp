package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class BrokenImagesPage extends Base{
	
	public WebDriver driver;
	public Properties prop=Base.prop;
	
	public BrokenImagesPage(WebDriver driver){
		this.driver=driver;
	}
	
	By images=By.cssSelector(".example img");
	By pagebodyh1 =By.cssSelector("h1");
	
	public ArrayList<String> brokenImagescheck() {
		List<WebElement>imgList=driver.findElements(images);
		Iterator<WebElement> itr=imgList.iterator();
		ArrayList<String>brokenlinks= new ArrayList<String>();
		ArrayList<String>workinglinks= new ArrayList<String>();
		while (itr.hasNext()) {
			String src= itr.next().getAttribute("src");
		
			try {
				URL url= new URL(src);
				
				HttpURLConnection conn= (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int respcode=conn.getResponseCode();
				System.out.println(respcode);
				if (respcode>400) {
					brokenlinks.add(src);
				} else {
					workinglinks.add(src);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return brokenlinks;
		
	}
	
}
