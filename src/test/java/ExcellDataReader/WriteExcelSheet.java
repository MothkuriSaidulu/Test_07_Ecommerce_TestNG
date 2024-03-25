package ExcellDataReader;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelSheet {

	public void writeExcelSheet() 
	{
//1. Create an Instance of the Workbook Class and Create a New Excel File.
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		Row rows = sheet.createRow(0);
		Cell cell = rows.createCell(0);
		cell.setCellValue("Hello World");
		
		File file = new File("D:\\AutomationExcelFile\\WriteSheet.xlsx");
		
		
		
		
	}
	
}
