package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

	public static  ExtentReports getReport(String reportName) 
	{
		ExtentReports reports = new ExtentReports();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
		dateFormat.setTimeZone(istTimeZone);
		String timestamp = dateFormat.format(new Date());

		       
		String reportFilePath = System.getProperty("user.dir") + "/Report/";
		if (reportName == null || reportName.isEmpty()) {
		      reportName = "_Enter_Name_Application_Report";
		}
		reportFilePath += reportName + "_" + timestamp + ".html";

		File extentReportFile = new File(reportFilePath);
		       

		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportFile);
		reports.attachReporter(reporter);

		return reports;
	}
}
