package ExcellDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataReader3 {


	@Test
	public static void GetExcelData() throws Exception {

//		ArrayList<String> array = new ArrayList<String>();

	
//			String sheetName = property.getProperty("SheetName");
			// 1. Create an Instance of the Workbook Class and Open the Excel File
			File file = new File("C:\\Users\\1003413\\eclipse-workspace\\Test_07_Ecommerce_TestNG\\ExcelData\\EcommerceTestDataSheet.xlsx");
			FileInputStream filePath = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workBook = new XSSFWorkbook(filePath);

			// 2. Get the Desired Sheet from the Workbook.
			int noOfSheets = workBook.getNumberOfSheets();
			for (int i = 0; i <= noOfSheets; i++) {
				if (workBook.getSheetAt(i).getSheetName().equalsIgnoreCase("SignUpTestData")) {
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
//								array.add(cellData);

							} else {
								String numberText = NumberToTextConverter.toText(cellValue.getNumericCellValue());
								System.out.println(numberText);
//								array.add(numberText);
							}

						}
					}

				}
				
			}
//		return array;

	}
}