package ExcellDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataReader {

	@Test
	public void GetExcelData() throws Exception {

// 1. Create an Instance of the Workbook Class and Open the Excel File
		File file = new File("D:\\AutomationExcelFile\\EcommerceTestDataSheet.xlsx");
		FileInputStream filePath = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(filePath);

		ArrayList<String> arrayList = new ArrayList<String>();
// 2. Get the Desired Sheet from the Workbook.
//		XSSFSheet sheet= workBook.getSheet("SignUPTestData");
//		int noOfSheets = workBook.getNumberOfSheets();
//		System.out.println(noOfSheets);

		XSSFSheet sheet = workBook.getSheet("SignUPTestData");
		Iterator<Row> rowIterator = sheet.rowIterator();
		int i = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				Cell cellvalue = cellIterator.next();
				String cellData = cellvalue.getStringCellValue();
				System.out.println(cellData);
				arrayList.add(i, cellData);
				i++;
			}
		}

	}

}
