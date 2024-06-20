package ExcellDataReader;

import org.testng.annotations.DataProvider;
public class DataProviderClass {


	
	
	
	@DataProvider(name = "login")
	public static Object[][] dataProvider() {
		Object[][] data = { { "username1", "password" }, { "username2", "password2" } };
		return data;

	}
	
	
	

}
