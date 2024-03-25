package ExcellDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class ExcelDataReader2 extends BaseClass{
	
	public WebDriver driver;
	public ExcelDataReader2(WebDriver driver)
	{
//		super(driver);
		driver = this.driver;
		
	}
	
	@Test
	public static ArrayList<String> GetExcelData() throws Exception {

		ArrayList<String> array = new ArrayList<String>();

		try {
			String sheetName = property.getProperty("SheetName");
			// 1. Create an Instance of the Workbook Class and Open the Excel File
			File file = new File("D:\\AutomationExcelFile\\EcommerceTestDataSheet.xlsx");
			FileInputStream filePath = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workBook = new XSSFWorkbook(filePath);

			// 2. Get the Desired Sheet from the Workbook.
			int noOfSheets = workBook.getNumberOfSheets();
			for (int i = 0; i <= noOfSheets; i++) {
				if (workBook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName)) {
					XSSFSheet sheet = workBook.getSheetAt(i);
					System.out.println(sheet.getSheetName());
					Iterator<Row> rowIterator = sheet.iterator();

					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						Iterator<Cell> cellIterator = row.iterator();

						while (cellIterator.hasNext()) {

							Cell cellValue = cellIterator.next();

							if (cellValue.getCellType() == CellType.STRING) {
								String cellData = cellValue.getStringCellValue();
								System.out.println(cellData);
								array.add(cellData);

							} else {
								String numberText = NumberToTextConverter.toText(cellValue.getNumericCellValue());
								System.out.println(numberText);
								array.add(numberText);
							}

						}
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;

	}
}