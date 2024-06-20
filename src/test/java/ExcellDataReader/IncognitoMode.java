package ExcellDataReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoMode {

	@Test
	public void name() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qac.moneymart.ca/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Sign In / Sign Up']")).click();
		WebElement ele = driver.findElement(By.name("email"));

		Actions act = new Actions(driver);
//		act.keyDown(ele, Keys.SHIFT).sendKeys("saidachary").build().perform();
		act.moveToElement(ele).keyDown(Keys.SHIFT).sendKeys("saidachary").keyUp(Keys.SHIFT).build().perform();

	}

}
