package ExcellDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.BaseClass;

public class ExcellReader extends BaseClass {
	public static File filePath;
	public static FileInputStream file;
	public static Workbook workBook;
	public static Sheet getSheetName;
	public static Iterator<Row> rowIterator;
	public static Iterator<Cell> cellIterator;
	public static Row row;
	public static Cell cell;
	public static String keyvalue;
	public static String value;
	public static Map<String, String> mapTestData;

	public static Map<String, String> getExcelData() throws FileNotFoundException {

		try {
			mapTestData = new HashMap<String, String>();
//			property = new Properties();
			property = new Properties();
			file = new FileInputStream("Config.properties");
			property.load(file);
			getPropertyValue = property.getProperty("SheetName");
			System.out.println(getPropertyValue);

			filePath = new File(
					"C:\\Users\\1003413\\eclipse-workspace\\Test_07_Ecommerce_TestNG\\ExcelData\\EcommerceTestDataSheet.xlsx");
			file = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(file);
			int noOfSheets = workBook.getNumberOfSheets();

			for (int i = 0; i <= noOfSheets; i++) {
				if (workBook.getSheetAt(i).getSheetName().equalsIgnoreCase(getPropertyValue)) {
					getSheetName = workBook.getSheetAt(i);
					rowIterator = getSheetName.iterator();
					while (rowIterator.hasNext()) {
						row = rowIterator.next();
						cell = row.getCell(0);
						if (cell.getCellType() == CellType.STRING) {
							keyvalue = cell.getStringCellValue().trim();
							System.out.println(keyvalue);
						} else {
							keyvalue = NumberToTextConverter.toText(cell.getNumericCellValue());
							System.out.println(keyvalue);
						}
						cell = row.getCell(1);

						if (cell.getCellType() == CellType.STRING) {
							value = cell.getStringCellValue().trim();
							System.out.println(value);
						} else {
							value = NumberToTextConverter.toText(cell.getNumericCellValue());
							System.out.println(value);

						}

						mapTestData.put(keyvalue, value);

					}

				}
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return mapTestData;
	}

}
