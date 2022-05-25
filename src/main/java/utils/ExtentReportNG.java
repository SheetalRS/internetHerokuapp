package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports extent ;
	public static ExtentReports getInstance() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		
		System.out.println(path);
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Result");
		reporter.config().setReportName("herokuapp Automation Result");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		
		return extent;
		
	}

}
