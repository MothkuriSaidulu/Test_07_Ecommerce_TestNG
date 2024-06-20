package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import ExcellDataReader.ExcellReader;
import PageObject.Page_01_HomePage;
import PageObject.Page_02_RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Page_01_HomePage homePageObject;
	public static Page_02_RegisterPage registerPageObject;
	public static String randomString;
//	public static String getPropertyValue;
	public static boolean webDriverInitialized = false; // initially it is false
	public static FileInputStream fileInputstream;
//	public static Properties property;
	public static String screenshotName, browserName;
	public static ExcellReader excellData;;
	public static Map<String, String> hashmapData;
	public static String rootpath = System.getProperty("user.dir");
	public static File fileFolder, filePath;

	public WebDriver InitiateBrowser() throws IOException {

		Properties property = new Properties();
		FileInputStream file = new FileInputStream("Config.properties");
		property.load(file);

		browserName = property.getProperty("Browser");

		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			System.out.println(" ******* Chrome Browser Launched  ******* ");
			WebDriverManager.chromedriver().setup();
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
			fileInputstream = new FileInputStream("Config.properties");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			property.load(fileInputstream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		String prop = property.getProperty("Url");
		System.out.println(prop);
		driver.get(prop);
	}

	public String getScreenshot(String TestCasesName, WebDriver driver) throws IOException {
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime); // Out put --> Sat Mar 30 11:54:52 IST 2024

		screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png"; // Output -->//

		// convert driver to screenshot mode
		TakesScreenshot screenshot_mode = (TakesScreenshot) driver;

		// Screenshot file
		File screenshot_File = screenshot_mode.getScreenshotAs(OutputType.FILE);

		// File Path
		File location = new File(rootpath + "//Reports//screenshot.png");

		FileUtils.copyFile(screenshot_File, location);

		return System.getProperty("user.dir") + "//Reports//" + TestCasesName + ".png";

	}

	public static String getDate_ddmmyy() {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd_mm_yyyy");

		LocalDateTime date = LocalDateTime.now();

		String dateString = dateformatter.format(date);
		return dateString;

	}

	public File createFolder() {
		fileFolder = new File(rootpath + "\\Screenshots\\" + getDate_ddmmyy());
		if (!fileFolder.exists()) {
			fileFolder.mkdir();
			System.out.println("Report folder structure created : " + fileFolder);

		} else {
			System.out.println("Report folder structure already available : " + fileFolder);

		}
		return fileFolder;
	}

	public String takeScreenshot(String TestCasesName, WebDriver driver) throws IOException, InterruptedException {

		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime); // Out put --> Sat Mar 30 11:54:52 IST 2024

		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png"; // Output -->//

		// convert driver to screenshot mode
		Thread.sleep(3000);
		TakesScreenshot screenshot_mode = (TakesScreenshot) driver;

		// Screenshot file
		File screenshot_File = screenshot_mode.getScreenshotAs(OutputType.FILE);

		// File Path
		File location = new File(System.getProperty("user.dir") + "//Screenshots//" + screenshotName);

		FileUtils.copyFile(screenshot_File, location);

		return System.getProperty("user.dir") + "//Screenshots//" + TestCasesName;

	}

	public void takeScreenshotOfEachPage() throws IOException, InterruptedException {

		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime); // Out put --> Sat Mar 30 11:54:52 IST 2024

		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png"; // Output -->//

		// convert driver to screenshot mode
//		TakesScreenshot screenshot_mode = (TakesScreenshot) driver;
		Thread.sleep(3000);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Screenshot file
//		File screenshot_File = screenshot_mode.getScreenshotAs(OutputType.FILE);

		// File Path
		File location = new File(createFolder() + "//Screenshots//" + screenshotName);

		FileUtils.copyFile(scr, location);

//		return System.getProperty("user.dir") + "//Screenshots//" + TestCasesName;
	}

//	@AfterMethod
//	public void closeBrowser() 
//	{
//		driver.quit();
//		
//	}

}
