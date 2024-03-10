package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports getExtentReport() {

		String reportPath = System.getProperty("user.dir") + "\\Reports\\report.html";
		ExtentSparkReporter makeReport = new ExtentSparkReporter(reportPath);
		makeReport.config().setDocumentTitle("Testing Results");
		makeReport.config().setReportName("Ecommerce Report");
		makeReport.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(makeReport);
		report.setSystemInfo("Saidachary", "Testing Engineer");
		
		return report;

	}
}
