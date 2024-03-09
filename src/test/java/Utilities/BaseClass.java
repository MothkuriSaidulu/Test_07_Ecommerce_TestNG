package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;

import PageObject.Page_01_HomePage;
import PageObject.Page_02_RegisterPage;

public class BaseClass {

	public WebDriver driver;
	public Page_01_HomePage homePageObject;
	public Page_02_RegisterPage registerPageObject;
	
	
	public static boolean webDriverInitialized = false; // initially it is false
	public static FileInputStream file;
	public static Properties property;
	public String getPropertyValue;

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
}
