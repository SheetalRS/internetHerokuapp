package pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class FileDownloadPage extends Base {
	WebDriver driver;
	List<WebElement> fileslist;
	ArrayList<String> filesnotdownloaded= new ArrayList<String>() ;
	ArrayList<String> filesnames;
	List<File> filesdownloaded;
	ArrayList<String> downloadnames;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
	}

	By files = By.cssSelector("div#content a");

	public List<WebElement> downloadFiles() {
		fileslist = driver.findElements(files);
		// System.out.println(fileslist.size());
		filesnames = new ArrayList<String>();
		Iterator<WebElement> itr = fileslist.iterator();

		while (itr.hasNext()) {
			itr.next().click();
			WaitTime(driver, 120);
			// filesnames.add(itr.next().getText());

		}
		return fileslist;

	}

	public ArrayList<String> isFilesDownloaded(List<WebElement> fileslist) {
		String home = System.getProperty("user.home");
		home = home + "\\Downloads";
		String downloadPath = home;
		System.out.println(downloadPath);
		File dir = new File(downloadPath);
		File[] downloadedFiles = dir.listFiles();
		System.out.println(fileslist.size());

		for (WebElement file : fileslist) { // System.out.println(file.getText());
			boolean flag = false;
			String reqdFile = file.getText();

			for (int i = 0; i < downloadedFiles.length; i++) {
				// System.out.println(downloadedFiles[i].getName());
				if ((reqdFile.equalsIgnoreCase(downloadedFiles[i].getName()))) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println(reqdFile);
				filesnotdownloaded.add(reqdFile);
			}
		}
		System.out.println(filesnotdownloaded.size());
		return filesnotdownloaded;
	}

}
