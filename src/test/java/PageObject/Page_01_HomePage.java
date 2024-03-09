package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	private WebElement Email_Textl;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement Password_Text;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement LogIn_Btn;

	@FindBy(xpath = "//p[@class='login-wrapper-footer-text'] //a")
	private WebElement Register_Here;
	


// Actions
	public void clickOnRegisterNewUser() {
		verifyText(LogIn_Text, "LogIn Text Verifying", "Log in");
		System.out.println("User Landed on LogIn Page : " + LogIn_Text.getText());
		Click(Register_Here, "Click On Register Here");

	}

}