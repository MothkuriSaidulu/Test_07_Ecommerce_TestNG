package PageObject;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utilities.ActionClass;

public class Page_02_RegisterPage extends ActionClass {

	public WebDriver driver;

	public Page_02_RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='login-title']")
	private WebElement register_text;

	@FindBy(id = "firstName")
	private WebElement First_Name;

	@FindBy(css = "input[id='lastName']")
	private WebElement Last_name;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement Email_text_box;

	@FindBy(id = "userMobile")
	private WebElement Phone_Text;

	@FindBy(xpath = "//select[@formcontrolname='occupation']")
	private WebElement Occupation_text;

	@FindBy(xpath = "//select[@formcontrolname='occupation'] //option")
	private List<WebElement> Occupation_List;

	@FindBy(xpath = "//input[@value='Male']")
	private WebElement Male_radio_button;

	@FindBy(xpath = "//input[@value='Female']")
	private WebElement Female_radio_button;

	@FindBy(id = "userPassword")
	private WebElement Password_text;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword_text;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement check_box;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement Register_btn;

	@FindBy(xpath = "//h1[contains(text(),'Account Created Successfully')]")
	private WebElement sucessfully_Created;

	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement invalid_Feedback;

// Action Implementation
	public void enterFirstName() {
		waitForElementToVisable(register_text, "Wait untill Register Text Visable");
		verifyText(register_text, "Register text verifying", "Register");
		System.out.println("User landed On : " + register_text.getText());

		String firstName = "Fname" + randomString();
		Enter_Text(First_Name, "First Name Text box", firstName);
		System.out.println("First Name : " + firstName);

	}

	public void enterLastName() {
		String lastName = "Lname" + randomString();
		Enter_Text(Last_name, "Last Name Text Box", lastName);
		System.out.println("Last Name : " + lastName);
	}

	public void enterEmailID() {

		String EmailID = "UserEmail" + randomString() + "@yopmail.com";
		Enter_Text(Email_text_box, "Email Text box", EmailID);
		System.out.println("Email ID : " + EmailID);

	}

	public void enterPhoneNumber() {
		String phoneNumber = randomNumeric();
		Enter_Text(Phone_Text, "Phone Text box", phoneNumber);
		System.out.println("Phone Number : " + phoneNumber);

	}

	public void selectOccupation() throws InterruptedException {
//		property = new Properties();
//		getPropertyValue = property.getProperty("Occupation");
//		System.out.println(getPropertyValue);

//		Thread.sleep(3000);
//
//		Click(Occupation_text, "click on occupation dropdown");
//
//		for (int i = 0; i <= Occupation_List.size(); i++) {
//			String ocumationName = Occupation_List.get(i).getText();
//			if (ocumationName.equalsIgnoreCase(getPropertyValue)) {
//				Occupation_List.get(i).click();
//				break;
//			}
//		}

		Select selectDropDown = new Select(Occupation_text);
//		selectDropDown.selectByVisibleText(getPropertyValue);
		selectDropDown.selectByIndex(2);

	}

	public void selectGenderType() {
//		property = new Properties(); 
//		getPropertyValue = property.getProperty("Gender");
//		System.out.println(getPropertyValue);
//		if (getPropertyValue.contains("Male")) {
//			Click(Male_radio_button, "Male Radio Button");
//		} else {
//			Click(Female_radio_button, "Click On Female Radio button");
//		}
		
		Male_radio_button.click();
	}

	public void enterPassword() {
		String password = randomString() + "@123";
		Enter_Text(Password_text, "Password Text Box", password);
		Enter_Text(confirmPassword_text, "Confirm Password Text box", password);
		System.out.println("Password : " + password);
		Click(check_box, "Click on Check box");
	}

	public void clickOnRegisterButton() throws Exception {
		takeScreenshotOfEachPage();
		Click(Register_btn, "Click On Register Button");

	}

	public void verfiySuccessfullyCreatedMessage() throws Exception {

//		Thread.sleep(5);

		verifyText(sucessfully_Created, " Sucessfully message ", sucessfully_Created.getText());
		takeScreenshotOfEachPage();

		System.out.println(sucessfully_Created.getText());

//		if (!invalid_Feedback.isDisplayed()) {
//			System.out.println(invalid_Feedback.getText());
//			
//
//		} else {
//			verifyText(sucessfully_Created, " Sucessfully message ", sucessfully_Created.getText());
//			System.out.println(sucessfully_Created.getText());
//		}

//		if (sucessfully_Created.isDisplayed()== false) {
//			verifyText(sucessfully_Created, " Sucessfully message ", sucessfully_Created.getText());
//			System.out.println(sucessfully_Created.getText());
//		} else {
//			System.out.println(invalid_Feedback.getText());
//
//		}

	}

}