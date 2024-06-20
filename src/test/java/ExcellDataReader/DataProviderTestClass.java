package ExcellDataReader;

import org.testng.annotations.Test;

public class DataProviderTestClass {

	@Test(dataProvider = "login", dataProviderClass = DataProviderClass.class)
	public void testLogin(String username, String password) {
		System.out.println(" username  " + username + " Password " + password);
		
	}

}
