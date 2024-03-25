package ExcellDataReader;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class test {

	
	
	@Test
	public void callMapdata() throws FileNotFoundException 
	{
		try {
			Map<String, String> hashmapData= ExcellReader.getExcelData();
			
			for (Entry<String, String> map : hashmapData.entrySet()) 
			{
				System.out.println("Key = " + map.getKey() + ", value = " + map.getValue() );
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
