package StepDefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.BaseClass;

public class assertion extends BaseClass {

	public void assertion_Test() throws IOException, InterruptedException {
		// System.setProperty("webDriver.Chrome.driver", "path");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
//		String acualTitle = driver.getTitle();
		String expectedText = "Let's Shop";
//		System.out.println(acualTitle);
//		Assert.assertEquals(acualTitle, expectedText);
//		Assert.assertNotEquals(acualTitle, expectedText);
		boolean acualTitle = driver.getTitle().equalsIgnoreCase(expectedText);
//		Assert.assertTrue(acualTitle);
		Assert.assertFalse(acualTitle);

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("charym695@gamil.com");
//		Email_Text.sendKeys("charym695@gamil.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Chary@123");
//		Password_Text.sendKeys("Chary@123");ss

//		driver.quit();
	}

	@Test
	public void softAssertion_Test() throws IOException, InterruptedException {
		// System.setProperty("webDriver.Chrome.driver", "path");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");

		SoftAssert softaAsertion = new SoftAssert();

		String acualTitle = driver.getTitle();
		String expectedText = "Let's Sho";

		softaAsertion.assertEquals(acualTitle, expectedText);

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("charym695@gamil.com");
//		Email_Text.sendKeys("charym695@gamil.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Chary@123");
		softaAsertion.assertAll();

		// driver.quit();
	}

}
