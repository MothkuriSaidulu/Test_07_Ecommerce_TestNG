package StepDefination;


import org.testng.annotations.Test;

import PageObject.Page_01_HomePage;
import Utilities.BaseClass;

public class TC02_Sign_With_Exsiting_Data extends BaseClass {

	@Test
	public void logIn_With_Exsiting_User() throws Exception {

		homePageObject = new Page_01_HomePage(driver);
		homePageObject.enter_EmaiID();
		homePageObject.enter_Password();
	}
}
