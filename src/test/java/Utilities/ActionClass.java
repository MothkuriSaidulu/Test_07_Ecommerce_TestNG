package Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionClass extends BaseClass {

	public static WebDriver driver;
	public String randomString;

	@SuppressWarnings("static-access")
	public ActionClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//  Explicit waits for web elements
	public static WebDriverWait applyWebDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotInteractableException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public static void waitForElementToVisable(WebElement element, String elementDesc) {
		try {
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			Assert.fail(("WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO VISABLE ON THE SPECIFIED WEB ELEMENT"
					+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage()));
		}
	}

	public static void waitForElementToClickable(WebElement element, String elementDesc) {

		try {
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			org.testng.Assert.fail(
					"WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO CLICKABLE ON THE SPECIFIED WEB ELEMENT"
							+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- "
							+ e.getMessage());

		}

	}

	public void Click(WebElement element, String elementDesc) {
		try {
			waitForElementToVisable(element, elementDesc);
			element.click();

		} catch (Exception e) {

			org.testng.Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>"
					+ elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());

		}

	}

	public void Enter_Text(WebElement element, String elementDesc, String text) {

		try {
			waitForElementToClickable(element, elementDesc);
			element.clear();
			element.sendKeys(text);

		} catch (Exception e) {
			org.testng.Assert.fail("WebDriverException : WHILE TRYING TO ENTER TEXT INSIDE THE SPECIFIED WEB ELEMENT"
					+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());
		}
	}

	public void verifyText(WebElement element, String elementDesc, String expectedText) {

		try {

			waitForElementToVisable(element, elementDesc);
			String ActualTeext = element.getText().trim().toLowerCase();
			String ExpectedText = expectedText.trim().toLowerCase();
			org.testng.Assert.assertEquals(ExpectedText, ActualTeext);

		} catch (Exception e) {
			// TODO: handle exception
			org.testng.Assert.fail("Exception : WHILE TRYING TO VERIFY THE TEXT INSIDE A WEB ELEMENT : "
					+ "Actual and expected texts are not matching for: " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + e.getMessage());

		}

	}

	public String getProperty(String value) throws IOException {
		property = new Properties();
		property.load(file);

		getPropertyValue = property.getProperty(value);
		return getPropertyValue;
	}

	public String randomString() {
		randomString = RandomStringUtils.randomAlphabetic(6);
		return randomString;
	}

	public String randomNumeric() {
		randomString = RandomStringUtils.randomNumeric(10);

		return randomString;
	}

}
