package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String readDataFromExcel(String path, String sheetname, int rows, int cols){
			String data = "";
			
			try {
					FileInputStream fis = new FileInputStream(path);
					XSSFWorkbook xsf = new XSSFWorkbook(fis);
					XSSFSheet sheet = xsf.getSheet(sheetname);
					data = data + sheet.getRow(rows).getCell(cols);
					xsf.close();
			} 
			catch (IOException e) {
					e.printStackTrace();
			}    
		
			return data;
		 
		}
}
