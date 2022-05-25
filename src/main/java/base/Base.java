package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver ;
	public static Properties prop;
	JavascriptExecutor js;
	
	public WebDriver getWebdriver() {
		
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config\\app.properties");
			 prop= new Properties();
			prop.load(fis);
			String browserName=prop.getProperty("browser");
			if (this.driver==null) {
				if (browserName.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					this.driver= new ChromeDriver();
					
				} else if(browserName.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					this.driver= new FirefoxDriver();
				}else if(browserName.equalsIgnoreCase("edge")) {
					System.setProperty("webdriver.edge.driver", "F:\\herokuapp\\cucumberTestNG\\src\\main\\resources\\drivers\\msedgedriver.exe");
					this.driver= new EdgeDriver();
				}
				driver.get(prop.getProperty("url"));
				return driver;
			}
		
		
		} catch (FileNotFoundException e) {
			System.out.println("app.properties file not found");
		} catch (IOException e) {
			System.out.println("app.properties file not found");
		}
		return driver;
		
	}
	public void getUrl() {
		driver.get(prop.getProperty("url"));
	}
 public String getScreenshotPath(String testCaseName,WebDriver driver){
	System.out.println("tstcasename "+testCaseName);
	 TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		try {
			  FileUtils.copyFile(src, new File(destinationFile));
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
		System.out.println(destinationFile);
		return destinationFile;
 }
 
 public void WaitElmToBeClickable(WebDriver driver,By elm,long time){
		System.out.println("WaitElmToBeClickable");
	 WebDriverWait wait= new WebDriverWait(driver, time);
	 wait.until(ExpectedConditions.elementToBeClickable(elm));
	 wait.withTimeout(Duration.ofSeconds(time));
	 //return driver;
	 
 }
 
 public void WaitElmTobeInvisible(WebDriver driver,By elm,long time){
	
	System.out.println("WaitElmTobeInVisible");
	 WebDriverWait wait= new WebDriverWait(driver,time);
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(elm));
	 wait.withTimeout(Duration.ofSeconds(time));
	 
 }
 
 public WebDriver WaitElmTobevisible(WebDriver driver,By elm,long time){
	System.out.println("WaitElmTobeVisible");
	 WebDriverWait wait= new WebDriverWait(driver,time);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
	 wait.withTimeout(Duration.ofSeconds(time));
	 return driver;
	 
 }
 public WebDriver WaitElmTobeDisable(WebDriver driver,By elm,long time){
	System.out.println("WaitElmTobeDisable");
	 WebDriverWait wait= new WebDriverWait(driver,time);
	 wait.until(ExpectedConditions.attributeContains(elm,"disabled","true"));
	 wait.withTimeout(Duration.ofSeconds(time));
	 return driver;
	 
 }
 
 public WebDriver WaitForPageLoad(WebDriver driver,long time){
	
		System.out.println("WaitForPageLoad");
		 WebDriverWait wait= new WebDriverWait(driver,time);
		 wait.until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				js=(JavascriptExecutor)driver;
				return js.executeScript("return document.readyState").equals("complete")||js.executeScript("return document.readyState").equals("loaded");
				
			}
			 
		 });
		
		 
		 
		 return driver;
		 
	 }
 
 public void WaitTime(WebDriver driver,long time){
	
	 WebDriverWait wait= new WebDriverWait(driver, time);
	
	 wait.withTimeout(Duration.ofSeconds(time));
	 
 }
 public void switchToWindow() {
	 Set<String>winhandles=driver.getWindowHandles();
	 System.out.println(winhandles.size());
	 Iterator<String>itr=winhandles.iterator();
	 String parentHandle=itr.next();
	 String childHandle=itr.next();
	 driver.switchTo().window(childHandle);
 }

}
