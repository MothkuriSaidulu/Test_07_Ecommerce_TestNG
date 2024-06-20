package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	@org.testng.annotations.Test
	public void name() {

		WebDriver driver = new ChromeDriver();

// Type 1
//		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		// http://username:password@test.com
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//      wait alert present on web
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.
		
	}

}
