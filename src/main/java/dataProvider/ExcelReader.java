package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;

	
	public static Object[][] getDataFromSheet(String sheetName) {
		System.out.println("*************Loading data from Excel**********************");
		Object[][] arr=null;
		try {
			// load excel
			wb = new XSSFWorkbook(
					new FileInputStream(new File(System.getProperty("user.dir") + "/testdata/TestData.xlsx")));
			// load sheet
			XSSFSheet sheet = wb.getSheet(sheetName);
			// get rows
			int row = sheet.getPhysicalNumberOfRows();
			// get columns
			int column = sheet.getRow(0).getPhysicalNumberOfCells();
			// create array based on row and column from excel

			//System.out.println("Row count" + row);
			//System.out.println("Column count:" + column);
			arr=new Object[row-1][column];

			for (int i = 1; i < row; i++) {
				//System.out.println("Ex Loop:" + i);
				for (int j = 0; j < column; j++) {
					//System.out.println("In Loop:" + j);
					arr[i-1][j] = getdata(sheetName, i, j);
					//System.out.println("Element:" + arr[i-1][j]);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not find a file" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not load the file" + e.getMessage());
		}

		return arr;

	}

	public static String getdata(String sheetname, int row, int column) {
		XSSFCell cell = wb.getSheet(sheetname).getRow(row).getCell(column);
		String data = "";

		if (cell.getCellType() == CellType.STRING) {
			data = cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			double dataInDouble = cell.getNumericCellValue();
			data = String.valueOf(dataInDouble);
		} else if (cell.getCellType() == CellType.BLANK) {
			data = "";
		}

		return data;

	}

}
