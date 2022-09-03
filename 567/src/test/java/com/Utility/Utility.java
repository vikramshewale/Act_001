package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void getScreenShot(WebDriver driver) throws IOException {
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File e = new File("D:/VS Java/ScreenShot/newvs.jpg");
		
		FileHandler.copy(s, e);
	}
	
	public static String getExcelData(int row, int cell) throws EncryptedDocumentException, IOException {
		
		String userName;
		
		FileInputStream excel = new FileInputStream("C:/Users/Sakal/eclipse-workspace/567/TestingData/data.xlsx");
		Sheet a = WorkbookFactory.create(excel).getSheet("Sheet1");
//		try {
			userName = a.getRow(row).getCell(cell).getStringCellValue();
//		} 
//		catch(Exception e) {
//			long data = (long) a.getRow(row).getCell(cell).getNumericCellValue();
//			userName = (""+data);
//		}
		return userName;
		
		}

}
