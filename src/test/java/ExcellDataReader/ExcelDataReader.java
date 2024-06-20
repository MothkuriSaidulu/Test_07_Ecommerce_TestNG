package ExcellDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataReader {

	public void name() {

		try {
			
//			File Path.
//			Find Number Of sheets.
//			get the sheet name.
//			iterate rows 
//			column iterator
			
			
			File filePath = new File("");
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook wordBook = new XSSFWorkbook(file);
			
			int numberOfSheets = wordBook.getNumberOfSheets();
			
			for( int i = 0 ; i <= numberOfSheets ; i++)
			{
				if (wordBook.getSheetAt(i).getSheetName().equalsIgnoreCase("signData"))
				{
					XSSFSheet sheetName = wordBook.getSheetAt(i);
					Iterator<Row> rows = sheetName.iterator();
					while(rows.hasNext())
					{
					 	Row singleRow = rows.next();
					 	Cell cellKeyValue = singleRow.getCell(0);
					 	
					 	
					 	Cell cellRowValue = singleRow.getCell(1);

					 	
						
					}
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
