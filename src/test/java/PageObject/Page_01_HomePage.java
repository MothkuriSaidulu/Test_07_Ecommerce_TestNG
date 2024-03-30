package PageObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcellDataReader.ExcellReader;
import Utilities.ActionClass;

public class Page_01_HomePage extends ActionClass {

	public WebDriver driver;

	public Page_01_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='login-title']")
	private WebElement LogIn_Text;

	@FindBy(css = "input#userEmail")
	private WebElement Email_Text;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement Password_Text;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement LogIn_Btn;

	@FindBy(xpath = "//p[@class='login-wrapper-footer-text'] //a")
	private WebElement Register_Here;

// Actions
	public void clickOnRegisterNewUser() throws IOException {
		verifyText(LogIn_Text, "LogIn Text Verifying", "Log in");
		System.out.println("User Landed on LogIn Page : " + LogIn_Text.getText());
//		takeScreenshotOfEachPage();

		Click(Register_Here, "Click On Register Here");

	}

	@SuppressWarnings("static-access")
	public void enter_EmaiID() throws Exception {
		try {
//			waitForElementToVisable(Email_Text, "EmailID and Passord");
			Thread.sleep(5000);

			excellData = new ExcellReader();
			hashmapData = excellData.getExcelData();

			for (Entry<String, String> map : hashmapData.entrySet()) {
				System.out.println("Key = " + map.getKey() + ", value = " + map.getValue());
				if (map.getKey().equalsIgnoreCase("EmailID")) {
					String value = map.getValue();
					Enter_Text(Email_Text, "Enter EmailID", value);

				}
				break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enter_Password() throws FileNotFoundException, InterruptedException {

		try {
			int j = 0;
			for (Entry<String, String> map : hashmapData.entrySet()) {
				System.out.println("Key = " + map.getKey() + ", value = " + map.getValue());
				if (map.getKey().equalsIgnoreCase("Password")) {
					String value = map.getValue();
					Enter_Text(Password_Text, "Enter EmailID", value);

				}
				j++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}