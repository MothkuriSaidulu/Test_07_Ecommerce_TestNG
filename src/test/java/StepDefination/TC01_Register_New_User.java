package StepDefination;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.Page_01_HomePage;
import PageObject.Page_02_RegisterPage;
import Utilities.BaseClass;

public class TC01_Register_New_User extends BaseClass {

	@Test
	public void Register_New_User() throws IOException {

		homePageObject = new Page_01_HomePage(driver);
		homePageObject.clickOnRegisterNewUser();

		registerPageObject = new Page_02_RegisterPage(driver);
		registerPageObject.enterFirstName();
		registerPageObject.enterLastName();
		registerPageObject.enterEmailID();
		registerPageObject.enterPhoneNumber();
		registerPageObject.selectOccupation();
		registerPageObject.selectGenderType();
		registerPageObject.enterPassword();
		registerPageObject.clickOnRegisterButton();
		registerPageObject.verfiySuccessfullyCreatedMessage();
	}
}
