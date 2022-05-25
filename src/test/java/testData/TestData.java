package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	public static FileInputStream fis;
	public static XSSFWorkbook WkBook;
	public static  XSSFSheet sheet;
	public static XSSFRow row;
	public static Object[][] obj;
	
	@DataProvider
	public static Object[][]getTestData(String filePath,String sheetName){
		
		try {
			 fis= new FileInputStream(filePath);
			 WkBook = new XSSFWorkbook(fis);
			 sheet=WkBook.getSheet(sheetName);
			 sheet.setForceFormulaRecalculation(true);
			int rowCount= sheet.getLastRowNum();
			int colount=sheet.getRow(0).getLastCellNum();
			System.out.println(rowCount);
			System.out.println(colount);
			 obj=new Object[rowCount][colount];
			 
			for (int i =1; i <rowCount; i++) {
				 row=sheet.getRow(i);
				
				for (int j = 0; j < colount; j++) {
					
					 Cell cell = row.getCell(j);
					
					
						switch (cell.getCellType()) {
						case NUMERIC:
							obj[i][j]=cell.getNumericCellValue();
							System.out.println(obj[i][j]);
							break;
						case STRING:
							obj[i][j]=cell.getStringCellValue();
							System.out.println(obj[i][j]);
							break;
						case BLANK:
							obj[i][j]=cell.getStringCellValue();
							System.out.println(obj[i][j]);
							break;	
						default:
							break;
						}
					
					 
					 
					
					
				}
			}
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
		
	}
	
	@DataProvider
	public Object[][] loginData(){
		String FilePath=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\herokuapp.xlsx";
		return getTestData(FilePath,"LoginData");
	}
	
	

}
