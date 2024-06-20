package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listners extends BaseClass implements ITestListener {
	// ExtentReports --> from dependency
	// ExtentReport --> From Utilities Class which we have Created

	ExtentReports extent = ExtentReport.getExtentReport();
	ExtentTest test;
//	ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();
	ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Saidachary")
				.assignCategory("Regression Test Case");
		extentThread.set(test);

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = extentThread.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		extentThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, "Test Cases Pass");
		try {
			extentThread.get().log(Status.PASS, "Test Case Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, "Test Case Failed");
		extentThread.get().fail(result.getThrowable()); // it will print the error in report

//		extentThread.get().log(Status.FAIL, "Test Cases Fail");
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			// getTestClass() --> This will refer class which is mentioned in .xml file.
			// getRealClass() --> This will refer actual class where methods present.
			// getField("driver") -->Test case driver we are getting here bcz driver is
			// class level not method level.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		extentThread.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Cases Skiped");
//		extentThread.get().log(Status.SKIP, "Test Case Skiped");

	}

	@Override
	public void onFinish(ITestContext result) {

		extent.flush();
	}

}