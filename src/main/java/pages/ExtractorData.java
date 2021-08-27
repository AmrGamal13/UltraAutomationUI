package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractorData {

	 String fileName = "Test_Data_Trivago.xlsx";
	 ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	 File src = new File(classLoader.getResource(fileName).getFile());

	public String[] CredentialsLoader() throws Exception {
		String[] elementCssSelectors = new String[2];
		int count = 1;
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet0 = wb.getSheetAt(0);
		elementCssSelectors[0] = sheet0.getRow(count).getCell(0).getStringCellValue();
		elementCssSelectors[1] = sheet0.getRow(count).getCell(1).getStringCellValue();
		return elementCssSelectors;
	}

	//used to get the elements from the excel sheet by the sheet name and row number
	public  String Locaters(String sheetName, int RowNumber) throws Exception {
		//System.out.println("Sheet Number: "+sheetNumber+",  Row Number: "+RowNumber);
		//String[] ColorsCSS = new String[10];
		String CellValue = null;
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet(sheetName);
		int i;
		// System.out.println(sheet1.getRow(RowNumber).getLastCellNum());
		for (i = 0; i < sheet1.getRow(RowNumber).getLastCellNum() - 1; i++) {
			String value = sheet1.getRow(RowNumber).getCell(i+1).getStringCellValue();
			if(value.equals(""))
				break;
			else
				CellValue = value;
		}
		return CellValue;
	}
}
