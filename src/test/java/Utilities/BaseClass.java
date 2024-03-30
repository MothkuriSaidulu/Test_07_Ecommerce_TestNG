package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ExcellDataReader.ExcellReader;
import PageObject.Page_01_HomePage;
import PageObject.Page_02_RegisterPage;

public class BaseClass {

	public WebDriver driver;
	public Page_01_HomePage homePageObject;
	public Page_02_RegisterPage registerPageObject;

	public static boolean webDriverInitialized = false; // initially it is false
	public static FileInputStream file;
	public static Properties property;
	public static String getPropertyValue;
	public static ExcellReader excellData;;
	public static Map<String, String> hashmapData;

	public WebDriver InitiateBrowser() throws IOException {

		property = new Properties();
		FileInputStream file = new FileInputStream("Config.properties");
		property.load(file);

		String browser = property.getProperty("Browser");

		if (browser.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.out.println(" ******* Chrome Browser Launched  ******* ");
			driver = new ChromeDriver(options);
		} else {
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.out.println(" ******* Edge Browser Launched  ******* ");
			driver = new EdgeDriver(options);

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		webDriverInitialized = true;
		return driver;
	}

	@BeforeMethod
	public void launchWebUrl() throws IOException {
		driver = InitiateBrowser();
		Properties property = new Properties();
		try {
			file = new FileInputStream("Config.properties");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			property.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

		getPropertyValue = property.getProperty("Url");
		System.out.println(getPropertyValue);
		driver.get(getPropertyValue);
	}

	public String getScreenshot(String TestCasesName, WebDriver driver) throws IOException {
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime); // Out put --> Sat Mar 30 11:54:52 IST 2024

		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png"; // Output -->//

		// convert driver to screenshot mode
		TakesScreenshot screenshot_mode = (TakesScreenshot) driver;

		// Screenshot file
		File screenshot_File = screenshot_mode.getScreenshotAs(OutputType.FILE);

		// File Path
		File location = new File(System.getProperty("user.dir") + "//Reports//screenshot.png");

		FileUtils.copyFile(screenshot_File, location);

		return System.getProperty("user.dir") + "//Reports//" + TestCasesName + ".png";

	}

	public String takeScreenshotOfEachPage(String TestCasesName, WebDriver driver) throws IOException {
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime); // Out put --> Sat Mar 30 11:54:52 IST 2024

		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png"; // Output -->//

		// convert driver to screenshot mode
		TakesScreenshot screenshot_mode = (TakesScreenshot) driver;

		// Screenshot file
		File screenshot_File = screenshot_mode.getScreenshotAs(OutputType.FILE);

		// File Path
		File location = new File(System.getProperty("user.dir") + "//Reports//" + screenshotName);

		FileUtils.copyFile(screenshot_File, location);

		return System.getProperty("user.dir") + "//Reports//" + TestCasesName;

	}
	/*
	 * public String takeScreenshotOfEachPage(String path, WebDriver driver) throws
	 * IOException { this.driver = driver; File filePath; String screenshotName =
	 * null; try { Date date = new Date(); String dateAndTime = date.toString();
	 * System.out.println(dateAndTime); // Out put --> Sat Mar 30 11:54:52 IST 2024
	 * 
	 * screenshotName = date.toString().replace(":", "_").replace(" ", "_") +
	 * ".png"; // Output -->// // Sat_Mar_30_11_54_52_IST_2024.png
	 * System.out.println(screenshotName); TakesScreenshot screenshot_mode =
	 * (TakesScreenshot) driver;
	 * 
	 * File scr = screenshot_mode.getScreenshotAs(OutputType.FILE);
	 * 
	 * // System.getProperty("user.dir") + "//Reports//screenshot.png
	 * 
	 * filePath = new File(System.getProperty("user.dir") + "\\Screenshots\\" +
	 * screenshotName);
	 * 
	 * // File filePath = new File(
	 * "C:\\Users\\1003413\\eclipse-workspace\\Test_07_Ecommerce_TestNG\\Screenshots\\"
	 * + screenshotName); FileUtils.copyFile(scr, filePath); } catch
	 * (WebDriverException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } return System.getProperty("user.dir") +
	 * "\\Screenshots\\" + screenshotName;
	 * 
	 * }
	 */
	
	
//	@AfterMethod
//	public void closeBrowser() 
//	{
//		driver.quit();
//		
//	}

}
